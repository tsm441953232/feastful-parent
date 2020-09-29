package com.tsm.redpacket.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "t_user_red_packet")
public class TUserRedPacket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer userId;//客户号
    private BigDecimal amount;
    @CreationTimestamp
    private Timestamp grabTime;//
    private String note;//备注

}
