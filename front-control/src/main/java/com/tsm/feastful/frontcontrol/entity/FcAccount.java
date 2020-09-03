package com.tsm.feastful.frontcontrol.entity;

import com.tsm.feastful.frontcontrol.model.register.RegisterRequest;
import com.tsm.feastful.frontcontrol.utils.MD5Utils;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

import static com.tsm.feastful.frontcontrol.constants.CommonConstants.SYS_USER_ID;
import static com.tsm.feastful.frontcontrol.constants.CommonConstants.SYS_USER_STATUS_NORMAL;

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
    @CreationTimestamp
    private Timestamp dateCreate;//创建时间
    private String updatedBy;//更新人
    @UpdateTimestamp
    private Timestamp dateUpdate;//更新时间
    private String delFlag;//删除标记

    public static FcAccount newFcAccount(RegisterRequest registerRequest) throws Exception {
        FcAccount fcAccount = new FcAccount();
        fcAccount.setPhoneNum(registerRequest.getPhoneNum());
        fcAccount.setAccountPassword(MD5Utils.encrypt(registerRequest.getAccountPassword()));
        fcAccount.setBusinessType(registerRequest.getBusinessType());
        fcAccount.setChannelCode(registerRequest.getChannelCode());
        fcAccount.setChildChannelCode(registerRequest.getChildChannelCode());
        fcAccount.setAccountStatus(SYS_USER_STATUS_NORMAL);
        fcAccount.setCreatedBy(SYS_USER_ID);
        return fcAccount;
    }
}
