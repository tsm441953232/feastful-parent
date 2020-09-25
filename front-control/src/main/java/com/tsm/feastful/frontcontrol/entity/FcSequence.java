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
@Table(name = "fc_sequence")
public class FcSequence {
    @Id
    private String sequenceName;
    private String maxValue;
    @UpdateTimestamp
    private Timestamp dateUpdate;

}
