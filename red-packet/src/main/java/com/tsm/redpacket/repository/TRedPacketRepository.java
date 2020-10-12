package com.tsm.redpacket.repository;

import com.tsm.redpacket.entity.TRedPacket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;

public interface TRedPacketRepository extends JpaRepository<TRedPacket, Integer> {

    @Modifying
    @Query(nativeQuery = true, value = "update T_RED_PACKET set stock = stock - 1 where id =:id")
    int decreaseRedPacket(@Param("id") Integer id);

    @Modifying
    @Query(nativeQuery = true, value = "update T_RED_PACKET set stock = stock - 1 , version = version + 1 " +
            "where id =:id and version = :version")
    int decreaseRedPacketByOptimisticLock(@Param("id") Integer id , @Param("version") Integer version);

    /**
     * JPA行级锁 请只对主键加锁，否则为表级锁 极大程度影响性能
     * @param id
     * @return
     */
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query(nativeQuery = true, value = "select id , userId, amount ," +
            "sendDate, total, unitAmount," +
            "stock , version ,note " +
            "from  T_RED_PACKET  where id = :id")
    TRedPacket selectRedPacketByIdForUpdate(@Param("id") Integer id);


    /*@Query(nativeQuery = true , value = "update T_RED_PACKET set stock = stock - 1 where id = :id")
    int decreaseRedPacket(@Param("id") Integer id);*/
}
