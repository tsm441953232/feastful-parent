package com.tsm.feastful.rmsmain.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "rms_policy_actuator")
public class RmsPolicyActuator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String businessType;//业务类型
    private String ruleSetCode;//
    private String serviceId;//
    private String poolId;//
    private String createdBy;//创建人
    @CreationTimestamp
    private Timestamp dateCreate;//创建时间
    private String updatedBy;//更新人
    @UpdateTimestamp
    private Timestamp dateUpdate;//更新时间
    private String delFlag;//删除标记
}
