package com.tsm.redpacket.utils;

import com.tsm.redpacket.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.*;

@Slf4j
public class TransientTest {

    /**
     * 测试关于transient关键字的用法
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testForTransient() throws IOException, ClassNotFoundException {
        serializeUser(); //添加了关键字transient： age= 8
        deserializeUser(); //读取了关键字transient： age= null  user = User(userName=名字, age=null, idCardNum=4555)
    }


    private void serializeUser() throws IOException {
        User user = new User();
        user.setUserName("名字");
        user.setAge(8);
        user.setIdCardNum("4555");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D://Test/template"));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        log.info("添加了关键字transient： age= {}",user.getAge());
    }

    private void deserializeUser() throws IOException, ClassNotFoundException {
        File file = new File("D://Test/template");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        User user = (User)objectInputStream.readObject();
        log.info("读取了关键字transient： age= {}",user.getAge());
        log.info("user = {}",user.toString());
    }

}
