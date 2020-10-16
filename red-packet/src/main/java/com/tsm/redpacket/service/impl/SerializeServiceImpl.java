package com.tsm.redpacket.service.impl;

import com.tsm.redpacket.model.serialize.UserSerializeModel;
import com.tsm.redpacket.service.SerializeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@Slf4j
public class SerializeServiceImpl implements SerializeService {
    @Override
    public void serialize() throws IOException {
        UserSerializeModel user = new UserSerializeModel();
        user.setName("名字");
        user.setAge(8);
        user.setIdCardNum("4555");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D://Test/template"));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        log.info("添加了关键字transient： age= {}", user.getAge());
    }


    @Override
    public void deserialize() throws IOException, ClassNotFoundException {
        File file = new File("D://Test/template");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        UserSerializeModel user = (UserSerializeModel)objectInputStream.readObject();
        log.info("读取了关键字transient： age= {}",user.getAge());
        log.info("user = {}",user.toString());
    }
}
