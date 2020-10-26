package com.tsm.feastful.rmsmain.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "rms_config_route")
public class RmsConfigRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String businessType;//业务类型
    private String routeCode;//
    private String routeName;//
    private String routeRule;//
    @Column(name = "status")
    private String routeStatus;//状态 DBA建议不要用mysql关键字
    private String createdBy;//创建人
    @CreationTimestamp
    private Timestamp dateCreate;//创建时间
    private String updatedBy;//更新人
    @UpdateTimestamp
    private Timestamp dateUpdate;//更新时间
    private String delFlag;//删除标记
}
