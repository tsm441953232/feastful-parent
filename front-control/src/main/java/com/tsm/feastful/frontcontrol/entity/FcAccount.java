package com.tsm.feastful.frontcontrol.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "fc_account")
public class FcAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;//客户号
    private String phoneNum; //手机号
    private String businessType;//业务类型
    private String channelCode;//渠道号
    private String childChannelCode;//子渠道号
    private String accountPassword;//密码  DBA建议不要用mysql关键字
    private String accountStatus;//状态 DBA建议不要用mysql关键字
    private Timestamp dateInvalid;//冻结时间
    private String wechatSource;//公众号唯一标识
    private String openId;//用户唯一标识
    private String createdBy;//创建人
    private Timestamp dateCreate;//创建时间
    private String updatedBy;//更新人
    private Timestamp dateUpdate;//更新时间
    private String delFlag;//删除标记
}
