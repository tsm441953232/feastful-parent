-- ----------------------------
-- Table structure for fc_account
-- ----------------------------
CREATE TABLE fc_account (
  id bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '物理主键',
  customer_id varchar(64) COMMENT '客户号',
  phone_num varchar(16) COMMENT '手机号码',
  business_type varchar(64) NOT NULL COMMENT '业务类型',
  channel_code varchar(24) COMMENT '渠道号',
  child_channel_code varchar(24) COMMENT '子渠道号',
  account_password varchar(48) COMMENT '密码',
  account_status tinyint(1) COMMENT '0-正常,1-冻结',
  date_invalid datetime COMMENT '冻结时间',
  created_by varchar(32) COMMENT '创建者',
  wechat_source varchar(48) COMMENT '公众号唯一标识',
  open_id varchar(48) COMMENT '用户唯一标识',
  date_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_by varchar(32) COMMENT '更新人',
  date_update datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  del_flag tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (id),
  UNIQUE KEY uniq_key_1 (phone_num)
) COMMENT='用户表';

CREATE TABLE `fc_sys_param` (
  `param_index` varchar(4) NOT NULL COMMENT '参数索引',
  `param_value` varchar(200)  COMMENT '参数值',
  `description` varchar(200)  COMMENT '参数描述',
  `modify_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改日期',
  `modifier_id` varchar(32)  COMMENT '操作者ID',
  PRIMARY KEY (`param_index`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';


