package com.tsm.redpacket.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "t_red_packet")
public class TRedPacket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;//客户号
    private BigDecimal amount;
    @CreationTimestamp
    private Timestamp sendDate;//创建时间
    private Integer total;
    private BigDecimal unitAmount;
    private Integer stock;
    private Integer version;
    private String note;//备注

}
