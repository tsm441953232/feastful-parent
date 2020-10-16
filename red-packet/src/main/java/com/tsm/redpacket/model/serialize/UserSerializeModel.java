package com.tsm.redpacket.model.serialize;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSerializeModel implements Serializable {
    private String name;
    private int age;
    private transient String idCardNum;
}
