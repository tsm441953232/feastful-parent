package com.tsm.redpacket;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String userName;
    private transient Integer age;
    private String idCardNum;
}
