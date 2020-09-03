package com.tsm.feastful.frontcontrol.entity;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "fc_sys_param")
public class FcSysParam {
    @Id
    private String paramIndex;//参数索引
    private String paramValue; //参数值
    private String description;//参数描述 此处踩坑 desc为关键字
    @UpdateTimestamp
    private Timestamp modifyDate;//最后修改日期
    private String modifierId;//操作者ID
}
