package com.tsm.redpacket.service.impl;

import com.tsm.redpacket.entity.TRedPacket;
import com.tsm.redpacket.entity.TUserRedPacket;
import com.tsm.redpacket.model.redPacket.GrabPacketRequest;
import com.tsm.redpacket.model.redPacket.SetRedPacketRequest;
import com.tsm.redpacket.repository.TRedPacketRepository;
import com.tsm.redpacket.repository.TUserRedPacketRepository;
import com.tsm.redpacket.service.RedPacketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.tsm.redpacket.constants.RedisLuaScriptConstants.redPacketDecreaseLuaScript;
import static com.tsm.redpacket.constants.SystemConstants.FAILURE;
import static com.tsm.redpacket.constants.SystemConstants.SUCCESS;

@Service
@Slf4j
public class RedPacketServiceImpl implements RedPacketService {
    @Autowired
    private TRedPacketRepository tRedPacketRepository;
    @Autowired
    private TUserRedPacketRepository tUserRedPacketRepository;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private String redisLuaSha = null;

    private String redPacketPrefix = "red_packet_";

    @Override
    public void setRedPacket(SetRedPacketRequest setRedPacketRequest) {
        log.info("设置红包开始, setRedPacketRequest = {} ", setRedPacketRequest.toString());
        TRedPacket tRedPacket = new TRedPacket();
        tRedPacket.setUserId(setRedPacketRequest.getUserId());
        tRedPacket.setAmount(setRedPacketRequest.getAmount());
        tRedPacket.setTotal(setRedPacketRequest.getTotal());
        // TODO lambda表达式使用失败
        /*tRedPacket.setStock((setRedPacketRequest.getAmount(),setRedPacketRequest.getTotal()) -> {
            return divideRedPacketStock(setRedPacketRequest.getAmount(),setRedPacketRequest.getTotal());
        });*/
        tRedPacket.setStock(divideRedPacketStock(tRedPacket.getAmount(), tRedPacket.getTotal()));
        tRedPacket.setUnitAmount(divideRedPacketUnitAmount(tRedPacket.getAmount(), tRedPacket.getStock()));
        tRedPacket.setVersion(0);
        tRedPacketRepository.save(tRedPacket);

        stringRedisTemplate.opsForHash().put(redPacketPrefix+setRedPacketRequest.getUserId(),"stock",setRedPacketRequest.getTotal());
    }

    @Override
    @Transactional
    public int grabRedPacket(GrabPacketRequest grabPacketRequest) {
        //获取红包信息
        TRedPacket tRedPacket = tRedPacketRepository.getOne(grabPacketRequest.getRedPacketId());
        // 当前小红包库存大于0
        if (tRedPacket.getStock() > 0) {
            tRedPacketRepository.decreaseRedPacket(grabPacketRequest.getRedPacketId());
            // 生成抢红包信息
            TUserRedPacket userRedPacket = new TUserRedPacket();
            userRedPacket.setRedPacketId(grabPacketRequest.getRedPacketId());
            userRedPacket.setUserId(grabPacketRequest.getUserId());
            userRedPacket.setAmount(tRedPacket.getUnitAmount());
            userRedPacket.setNote("抢红包 " + grabPacketRequest.getRedPacketId());
            // 插入抢红包信息
            tUserRedPacketRepository.save(userRedPacket);
            return SUCCESS;
        }
        // 失败返回
        return FAILURE;
    }

    @Override
    @Transactional
    public int grabRedPacketPessimisticLock(GrabPacketRequest grabPacketRequest) {
        //获取红包信息
        TRedPacket tRedPacket = tRedPacketRepository.getById(grabPacketRequest.getRedPacketId());
        // 当前小红包库存大于0
        if (tRedPacket.getStock() > 0) {
            tRedPacketRepository.decreaseRedPacket(grabPacketRequest.getRedPacketId());
            // 生成抢红包信息
            TUserRedPacket userRedPacket = new TUserRedPacket();
            userRedPacket.setRedPacketId(grabPacketRequest.getRedPacketId());
            userRedPacket.setUserId(grabPacketRequest.getUserId());
            userRedPacket.setAmount(tRedPacket.getUnitAmount());
            userRedPacket.setNote("抢红包 " + grabPacketRequest.getRedPacketId());
            // 插入抢红包信息
            tUserRedPacketRepository.save(userRedPacket);
            return SUCCESS;
        }
        // 失败返回
        return FAILURE;
    }

    @Override
    public int grabRedPacketOptimisticLock(GrabPacketRequest grabPacketRequest) {
        //获取红包信息
        TRedPacket tRedPacket = tRedPacketRepository.getOne(grabPacketRequest.getRedPacketId());
        // 当前小红包库存大于0
        if (tRedPacket.getStock() > 0) {
            /*int rows = tRedPacketRepository.decreaseRedPacketByPessimisticLock(tRedPacket.getId(), tRedPacket.getVersion());
            if (rows == 0) {
                // 失败返回
                return FAILURE;
            }*/
            tRedPacket.setStock(tRedPacket.getStock() - 1);
            try {
                tRedPacket = tRedPacketRepository.save(tRedPacket);
            } catch (ObjectOptimisticLockingFailureException e) {
                log.info("抢红包失败,grabPacketRequest = {}", grabPacketRequest);
                return FAILURE;
            }
            // 生成抢红包信息
            TUserRedPacket userRedPacket = new TUserRedPacket();
            userRedPacket.setRedPacketId(grabPacketRequest.getRedPacketId());
            userRedPacket.setUserId(grabPacketRequest.getUserId());
            userRedPacket.setAmount(tRedPacket.getUnitAmount());
            userRedPacket.setNote("抢红包 " + grabPacketRequest.getRedPacketId());
            // 插入抢红包信息
            tUserRedPacketRepository.save(userRedPacket);
            return SUCCESS;
        }

        return FAILURE;
    }

    @Override
    public int grabRedPacketOptimisticLockRetry(GrabPacketRequest grabPacketRequest) {
        for (int i = 0; i < 3; i++) {
            //获取红包信息
            TRedPacket tRedPacket = tRedPacketRepository.getOne(grabPacketRequest.getRedPacketId());
            // 当前小红包库存大于0
            if (tRedPacket.getStock() > 0) {
                /*int rows = tRedPacketRepository.decreaseRedPacketByPessimisticLock(tRedPacket.getId(), tRedPacket.getVersion());
                if (rows == 0) {
                    // 失败返回
                    continue;
                }*/
                tRedPacket.setStock(tRedPacket.getStock() - 1);
                try {
                    tRedPacket = tRedPacketRepository.save(tRedPacket);
                } catch (ObjectOptimisticLockingFailureException e) {
                    log.info("抢红包失败,grabPacketRequest = {}", grabPacketRequest);
                    return FAILURE;
                }

                // 生成抢红包信息
                TUserRedPacket userRedPacket = new TUserRedPacket();
                userRedPacket.setRedPacketId(grabPacketRequest.getRedPacketId());
                userRedPacket.setUserId(grabPacketRequest.getUserId());
                userRedPacket.setAmount(tRedPacket.getUnitAmount());
                userRedPacket.setNote("抢红包 " + grabPacketRequest.getRedPacketId());
                // 插入抢红包信息
                tUserRedPacketRepository.save(userRedPacket);
                return SUCCESS;
            }
        }
        return FAILURE;
    }

    @Override
    public int grabRedPacketRedisScript(GrabPacketRequest grabPacketRequest) {
        log.info("接收到使用redis-script脚本进行抢红包的请求, grabPacketRequest= {}", grabPacketRequest.toString());
        // 当前抢红包用户和日期信息
        String userInfo = grabPacketRequest.getUserId() + "_" + System.currentTimeMillis();
        RedisScript<Integer> redisScript = new DefaultRedisScript<Integer>(redPacketDecreaseLuaScript, Integer.TYPE);
        List<String> keys = new ArrayList<String>();
        keys.add(grabPacketRequest.getRedPacketId().toString());

        List<String> args = new ArrayList<String>();
        args.add(userInfo);

        Integer execute = stringRedisTemplate.execute(redisScript, keys, args);
        if (execute == 1) {
            //抢红包成功
            return SUCCESS;
        }
        if (execute == 2) {
            //TODO 要保存数据到数据库
            return SUCCESS;
        }
        return FAILURE;
    }

    @Override
    public int grabRedPacketRedisMulti(GrabPacketRequest grabPacketRequest) {
        log.info("接收到使用redis-script脚本进行抢红包的请求, grabPacketRequest= {}", grabPacketRequest.toString());

        SessionCallback sessionCallback = new SessionCallback() {
            @Override
            public List execute(RedisOperations ops) throws DataAccessException {
                ops.watch("red_packet_" + grabPacketRequest.getRedPacketId());
                int _stock = (int) ops.opsForHash().get("red_packet_" + grabPacketRequest.getRedPacketId(), "stock");
                if (_stock == -1) {
                    ops.unwatch();
                    return null;
                } else {
                    _stock = _stock - 1; //减一个红包
                    ops.multi();
                    ops.opsForHash().put("red_packet_" + grabPacketRequest.getRedPacketId(), "stock", _stock);
                    List list = ops.exec();
                    return list;
                }
            }
        };

        List list = (List) stringRedisTemplate.execute(sessionCallback);
        if(null != list){
            return SUCCESS;
        }
        return FAILURE;
    }

    //TODO lambda表达式需强化练习
/*    @Override
    public int grabRedPacketRedisMulti(GrabPacketRequest grabPacketRequest) {
        log.info("接收到使用redis-script脚本进行抢红包的请求, grabPacketRequest= {}",grabPacketRequest.toString());

        SessionCallback sessionCallback = (SessionCallback)(RedisOperations ops)-> {
            ops.watch("red_packet_" + grabPacketRequest.getRedPacketId());
            int _stock = (int) ops.opsForHash().get("red_packet_" + grabPacketRequest.getRedPacketId(), "stock");
            if (_stock == -1) {
                ops.unwatch();
                return null;
            } else {
                _stock = _stock - 1; //减一个红包
                ops.multi();
                ops.opsForHash().put("red_packet_" + grabPacketRequest.getRedPacketId(), "stock", _stock);
                ops.exec();
            }
            return null;
        };

        return FAILURE;
    }*/


    private Integer divideRedPacketStock(BigDecimal amount, Integer total) {
        BigDecimal divided = new BigDecimal(total);
        return amount.divide(divided).intValue();
    }

    private BigDecimal divideRedPacketUnitAmount(BigDecimal amount, Integer stock) {
        BigDecimal divided = new BigDecimal(stock);
        return amount.divide(divided);
    }
}
