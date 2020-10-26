create table rms_config_route
(
   pk_id BIGINT unsigned  NOT NULL  AUTO_INCREMENT COMMENT '物理主键' ,
   business_type       varchar(64)  NOT NULL COMMENT '物理主键',
   route_code           varchar(48) COMMENT '物理主键',
   route_name           varchar(48) COMMENT '物理主键',
   route_rule           text COMMENT '物理主键',
   status               int COMMENT '0-生效,1-未生效',
  created_by varchar(32) COMMENT '创建人',
  date_create       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  updated_by varchar(32) COMMENT  '修改人',
  date_update       datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  del_flag             TINYINT(4) DEFAULT '0' COMMENT '逻辑删除',
   PRIMARY KEY(pk_id),
   KEY idx_inserttime (date_create),
  KEY idx_updatetime (date_update)
)  COMMENT '系统路由表';

insert into rms_config_route values (NULL, 'COMMON', 'JDE-ROUTE1', '产品路由规则', 'function process_route(obj){return ''PRD-JDE''}', 0, 'system', now(), 'system', now(), 0);



create table rms_thread_pool_config
(
  pk_id BIGINT unsigned  NOT NULL  AUTO_INCREMENT COMMENT '物理主键',
  business_type      varchar(64) NOT NULL COMMENT '业务类型',
   pool_id              varchar(64) COMMENT '线程池id',
   pool_name            varchar(64) COMMENT '线程池名称',
   priority             int COMMENT '优先级',
   created_by varchar(32) COMMENT '创建人',
  date_create       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  updated_by varchar(32) COMMENT  '修改人',
  date_update       datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  del_flag             TINYINT(4) DEFAULT '0' COMMENT '逻辑删除',
   PRIMARY KEY (pk_id),
   KEY idx_inserttime (date_create),
  KEY idx_updatetime (date_update),
  KEY idx_pool_id (pool_id)
)  COMMENT '线程池配置表';

insert into rms_thread_pool_config values (null, 'PRD-JDE', 'ThreadPool-01', '线程池1', 1, 'system', now(), 'system', now(), 0);
insert into rms_thread_pool_config values (null, 'PRD-JDE', 'ThreadPool-02', '线程池2', 2, 'system', now(), 'system', now(), 0);
insert into rms_thread_pool_config values (null, 'PRD-JDE', 'ThreadPool-03', '线程池3', 3, 'system', now(), 'system', now(), 0);
insert into rms_thread_pool_config values (null, 'PRD-JDE', 'ThreadPool-04', '线程池4', 4, 'system', now(), 'system', now(), 0);
insert into rms_thread_pool_config values (null, 'PRD-JDE', 'ThreadPool-05', '线程池5', 5, 'system', now(), 'system', now(), 0);

create table rms_policy_selection
(
  pk_id BIGINT unsigned  NOT NULL  AUTO_INCREMENT COMMENT '物理主键',
  business_type      varchar(64) NOT NULL COMMENT '业务类型',
   node_code            varchar(48) not null COMMENT '环节编码',
   rule_set_code        varchar(64) not null COMMENT '规则集编码',
   sequence             int COMMENT '执行顺序',
   created_by varchar(32) COMMENT '创建人',
  date_create       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  updated_by varchar(32) COMMENT  '修改人',
  date_update       datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  del_flag             TINYINT(4) DEFAULT '0' COMMENT '逻辑删除',
   PRIMARY KEY (pk_id),
   KEY idx_inserttime (date_create),
  KEY idx_updatetime (date_update),
  KEY idx_node_code (node_code),
  KEY idx_rule_set_code (rule_set_code)
)  COMMENT '环节策略映射表';
-- ----------------------------
-- Records of rms_policy_selection
-- ----------------------------
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'SA-DFT', 'RISK01-A1', '1', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'SA-DFT', 'RISK01-A2', '2', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'SA-DFT', 'RISK01-A3', '3', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'RNA-DFT', 'RISK02-B1', '1', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'RNA-DFT', 'RISK02-B2', '2', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-C1', '1', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-C2', '2', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-C3', '3', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-C4', '4', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-C5', '5', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-C6', '6', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-C7', '7', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-C8', '8', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-C9', '9', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-C10', '10','system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-FACE', '11', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK03-HDZX', '12', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK05-E1', '13', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RISK05-E2', '14', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-CMT', 'RJ-LIMIT-01', '15', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-SPA', 'WORM01-Summary', '1', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-SPA', 'RISK04', '2', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-SPA', 'CustScoreSet', '3', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-SPA', 'RJ-LIMIT-01', '4', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-AIA', 'WORM03-policyCar-EY', '1', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-AIA', 'pyTimesCheck', '2', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-AIA', 'pyDataCheck', '3', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-AIA', 'WORM03-policyCar', '4', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-AIA', 'RJ-LIMIT-01', '5', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-LIA', 'WORM02-PolicyLife', '1', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-LIA', 'RJ-LIMIT-01', '2', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'IC-TOA', 'WORM04-Operator', '1', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'ML-DFT', 'RISK07-completeness', '1', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-MOD', 'WORM03-policyCar', '1', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-MOD', 'WORM02-PolicyLife', '2', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-MOD', 'WORM04-Operator', '3', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'APV-MOD', 'RJ-LIMIT-01', '4', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_selection` VALUES (null, 'PRD-JDE', 'testNode', 'testRuleSet', '1', 'system', now(), 'system', now(), 0);





create table rms_policy_actuator
(
   pk_id BIGINT unsigned  NOT NULL  AUTO_INCREMENT COMMENT '物理主键',
   business_type      varchar(64) NOT NULL COMMENT '业务类型',
   rule_set_code        varchar(64) COMMENT '策略集编码',
   service_id           varchar(64) not null COMMENT '服务id',
   pool_id              varchar(64) not null COMMENT '线程池id',
   created_by varchar(32) COMMENT '创建人',
   date_create       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
   updated_by varchar(32) COMMENT  '修改人',
   date_update       datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   del_flag             TINYINT(4) DEFAULT '0' COMMENT '逻辑删除',
   PRIMARY KEY (pk_id),
   KEY idx_inserttime (date_create),
  KEY idx_updatetime (date_update),
  KEY idx_pool_id (pool_id),
  KEY idx_service_id (service_id),
  KEY idx_rule_set_code (rule_set_code)
)  COMMENT '风控执行器配置';

-- ----------------------------
-- Records of rms_policy_actuator
-- ----------------------------
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK01-A1', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK01-A1', 'QueryJdhcByPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK01-A1', 'QueryApplyInfoByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK01-A1', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK01-A2', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK01-A2', 'QueryInnerBlacklistByPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK01-A2', 'QueryTdCloudByPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK01-A2', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK01-A3', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK01-A3', 'QueryDianHuaBangDByPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK01-A3', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B1', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B1', 'QueryApplyInfoByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B1', 'QueryJdhcByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B1', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B2', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B2', 'QueryTdCloudByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B2', 'QueryInnerBlacklistByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B2', 'QueryNifaBlacklistByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B2', 'QueryQhzxBlacklistByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B2', 'QueryZcafCreditService', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B2', 'QueryZcafRiskService', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B2', 'QueryTdCloudByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK02-B2', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C1', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C1', 'QueryApplyInfoByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C1', 'QueryAppCrawler', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C1', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C2', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C2', 'QueryInnerBlacklistByCPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C2', 'ContactTempHandleService', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C2', 'CallEngine', 'ThreadPool-04', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C3', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C3', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C4', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C4', 'QueryDianHuaBangDByPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C4', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C5', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C5', 'QueryGeoB7', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C5', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C6', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C6', 'QueryGeoA4', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C6', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C7', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C7', 'QueryGeoA3', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C7', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C8', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C8', 'QueryTanZhi', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C8', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C9', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C9', 'QueryDianHuaBangC', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C9', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C10', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C10', 'QueryXinYan', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-C10', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-FACE', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK03-FACE', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK04', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK04', 'QuerySimplePboc', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK04', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK05-E1', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK05-E1', 'QueryTdCloudByPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK05-E1', 'QueryTdCloudByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK05-E1', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK05-E2', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK05-E2', 'CallInstinct', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK05-E2', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK07-completeness', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RISK07-completeness', 'QueryCompleteness', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'Risk07-completeness', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM01-Summary', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM01-Summary', 'QuerySimplePboc', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM01-Summary', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM02-policyLife', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM02-policyLife', 'QueryPolicyLife', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM02-policyLife', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM04-Operator', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM04-Operator', 'QueryTelecom', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM04-Operator', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'CustScoreSet', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'CustScoreSet', 'QuerySimplePboc', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'CustScoreSet', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RJ-LIMIT-01', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RJ-LIMIT-01', 'QuerySimplePboc', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RJ-LIMIT-01', 'QueryPolicyLife', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RJ-LIMIT-01', 'QueryPolicyCar', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'RJ-LIMIT-01', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM03-policyCar-EY', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM03-policyCar-EY', 'QueryPolicyCar', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM03-policyCar-EY', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'pyTimesCheck', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'pyTimesCheck', 'QueryPyCarCallNumber', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'pyTimesCheck', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'pyDataCheck', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'pyDataCheck', 'QueryPolicyCar', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'pyDataCheck', 'QueryPyCar', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'pyDataCheck', 'CallEngine', 'ThreadPool-04', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM03-policyCar', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM03-policyCar', 'QueryPolicyCar', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM03-policyCar', 'QueryCreditTone', 'ThreadPool-03', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM03-policyCar', 'QueryJzg', 'ThreadPool-04', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'WORM03-policyCar', 'CallEngine', 'ThreadPool-05', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryApplication', 'ThreadPool-01', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryJdhcByPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryInnerBlacklistByPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryTdCloudByPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryDianHuaBangDByPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryApplyInfoByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryJdhcByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryTdCloudByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryInnerBlacklistByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryNifaBlacklistByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryQhzxBlacklistByIdCard', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryZcafCreditService', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryZcafRiskService', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryInnerBlacklistByCPhone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryGeoB7', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryGeoA4', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryGeoA3', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryTanZhi', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryDianHuaBangC', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryXinYan', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QuerySimplePboc', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'CallInstinct', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryCompleteness', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryPolicyLife', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryPolicyCar', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryCreditTone', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryJzg', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryTelecom', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'QueryAppCrawler', 'ThreadPool-02', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_actuator` VALUES (null, 'PRD-JDE', 'testRuleSet', 'CallEngine', 'ThreadPool-03', 'system', now(), 'system', now(), 0);



create table rms_service_config
(
    pk_id  bigint unsigned NOT NULL  AUTO_INCREMENT COMMENT '物理主键',
   business_type      varchar(64) NOT NULL COMMENT '业务类型',
   service_id varchar(64) COMMENT '服务id',
   service_name         varchar(32) COMMENT '服务名称',
   description          varchar(128) COMMENT '服务说明',
   bean_id              varchar(64) COMMENT '服务的beanId',
   mode                 varchar(8) comment 'A-异步调用,S-同步调用,M-消息中间件,T-轮循',
   enable_cache         varchar(8) comment 'E-开启缓存,D-关闭缓存',
   valid_duration       int comment '毫秒计算, 0-永久有效',
   created_by varchar(32) COMMENT '创建人',
   date_create       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
   updated_by varchar(32) COMMENT  '修改人',
   date_update       datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   del_flag             TINYINT(4) DEFAULT '0' COMMENT '逻辑删除',
   PRIMARY KEY (pk_id),
   KEY idx_inserttime (date_create),
  KEY idx_updatetime (date_update),
  KEY idx_bean_id (bean_id)
)  COMMENT '服务配置表';


-- ----------------------------
-- Records of rms_service_config
-- ----------------------------
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryInnerBlacklistByCPhone', '自有黑名单-联系人手机号', '调用大数据网关获取联系人自有黑名单数据', 'QueryInnerBlacklistByCPhoneService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryDianHuaBangDByCPhone', '电话邦独立邦-联系人手机号', '通过联系人手机号调用大数据网关获取联系人电话邦独立邦数据', 'QueryDianHuaBangDByCPhoneService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryJdhcByCPhone', '小额互斥-联系人手机号', '通过联系人手机号调用大数据网关获取联系人小额互斥数据', 'QueryJdhcByCPhoneService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryApplyInfoByCPhone', '大额-联系人手机号', '通过联系人手机号调用大数据网关获取联系人大额数据', 'QueryApplyInfoByCPhoneService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryTanZhi', '探知多头', '调用大数据网关获取探知多头数据', 'QueryTanZhiService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryXinYan', '新颜雷达', '调用大数据网关获取新颜雷达数据', 'QueryXinYanService', 'S', 'D', '0','system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryGeoA3', '集奥手机A3', '调用大数据网关获取GEO手机A3相关数据', 'QueryGeoA3Service', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryGeoA4', '集奥手机A4', '调用大数据网关获取GEO手机A4相关数据', 'QueryGeoA4Service', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryGeoB7', '集奥手机B7', '调用大数据网关获取GEO手机B7相关数据', 'QueryGeoB7Service', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryCustomer', '客户', '查询FC客户信息', 'QueryCustomerService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryPolicyLife', '寿险', '调用大数据网关获取寿险数据', 'QueryPolicyLifeService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryTelecom', '运营商', '调用大数据网关获取运营商数据', 'QueryTelecomService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QuerySimplePboc', '简版人行', '调用大数据网关获取简版人行数据', 'QuerySimplePbocService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryTxsk', '天行数科工商', '调用大数据网关获取数科工商数据', 'QueryTxskService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'CallInstinct', '反欺诈', '调用反欺诈平台（instinct）', 'CallInstinctService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryInnerBlacklistByIdCard', '自有黑名单-客户身份证', '通过客户身份证调用大数据网关获取自有黑名单数据', 'QueryInnerBlacklistByIdCardService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryNifaBlacklistByIdCard', '互金黑名单-客户身份证', '通过客户身份证调用大数据网关获取互金黑名单数据', 'QueryNifaBlacklistByIdCardService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryQhzxBlacklistByIdCard', '前海征信黑名单-客户身份证', '通过客户身份证调用大数据网关获取前海征信黑名单数据', 'QueryQhzxBlacklistByIdCardService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryZcafBlacklistByIdCard', '致诚阿福黑名单-客户身份证', '通过客户身份证调用大数据网关获取致诚阿福黑名单数据', 'QueryZcafBlacklistByIdCardService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryTdCloudByIdCard', '同盾云-客户身份证', '通过客户身份证调用大数据网关获取同盾云数据', 'QueryTdCloudByIdCardService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryApplyInfoByIdCard', '大额-客户身份证', '通过客户身份证调用大数据网关获取大额数据', 'QueryApplyInfoByIdCardService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryJdhcByIdCard', '小额互斥-客户身份证', '通过客户身份证调用大数据网关获取小额互斥数据', 'QueryJdhcByIdCardService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryInnerBlacklistByPhone', '自有黑名单-客户手机号', '通过客户手机号调用大数据网关获取自有黑名单数据', 'QueryInnerBlacklistByPhoneService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryTdCloudByPhone', '同盾云-客户手机号', '通过客户手机号调用大数据网关获取同盾云数据', 'QueryTdCloudByPhoneService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryDianHuaBangDByPhone', '电话邦独立邦-客户手机号', '通过客户手机号调用大数据网关获取电话邦独立邦数据', 'QueryDianHuaBangDByPhoneService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryApplication', '申请', '查询APS申请信息', 'QueryApplicationService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryJzg', 'QueryJzg', '快速估值', 'QueryJzgService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryApplyInfoByPhone', '大额-客户手机号', '通过客户手机号调用大数据网关获取大额数据', 'QueryApplyInfoByPhoneService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryJdhcByPhone', '小额互斥-客户手机号', '通过客户手机号调用大数据网关获取小额互斥数据', 'QueryJdhcByPhoneService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryPysr', '鹏元收入', '查询鹏元收入数据', 'QueryPysrService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'CallEngine', '规则引擎', '调用自研的规则引擎', 'CallInnerEngineService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryDianHuaBangC', '电话邦催收帮-客户手机号', '通过运营商返回的通话详单调用大数据网关获取电话邦独立邦数据', 'QueryDianHuaBangCService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryCompleteness', '完整性查询', '查询已执行的风控规则', 'QueryCompletenessService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryCreditTone', '增信通', '查询车辆增信通数据', 'QueryCreditToneService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryPyCar', '鹏元车', '调用大数据网关获取鹏元车数据', 'QueryPyCarService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryPolicyCar', '车险', '调用大数据网关获取车险数据', 'QueryPolicyCarService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryPyCarCallNumber', '鹏元车接口调用次数', '鹏元车接口调用次数', 'QueryPyCarCallNumber', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryZcafCreditService', '至诚阿福共享数据', '至诚阿福共享数据', 'QueryZcafCreditService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryZcafRiskService', '至诚阿福风险分析', '至诚阿福风险分析', 'QueryZcafRiskService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'QueryAppCrawler', '获取手机爬虫数据', '获取手机爬虫数据', 'QueryAppCrawlerService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_service_config` VALUES (null, 'PRD-JDE', 'ContactTempHandleService', '整理联系人数据', '整理联系人数据', 'ContactTempHandleService', 'S', 'D', '0', 'system', now(), 'system', now(), 0);



create table rms_policy_config
(
  pk_id BIGINT unsigned  NOT NULL  AUTO_INCREMENT COMMENT '物理主键',
  business_type      varchar(64) NOT NULL COMMENT '业务类型',
   rule_set_code        varchar(64) COMMENT '策略集编码',
   rule_set_name        varchar(128) COMMENT '策略集名称',
   description          varchar(256) COMMENT '策略集说明',
  created_by varchar(32) COMMENT  '创建人',
   date_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
   updated_by varchar(32) COMMENT  '修改人',
   date_update datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   del_flag TINYINT(4) DEFAULT '0' COMMENT '逻辑删除',
   PRIMARY KEY (pk_id),
   KEY idx_inserttime (date_create),
  KEY idx_updatetime (date_update),
  KEY idx_rule_set_code (rule_set_code)
)  COMMENT '策略集配置';

-- ----------------------------
-- Records of rms_policy_config
-- ----------------------------
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RJ-LIMIT-01', '额度', '额度', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK01-A1', '风控模块一批次A1', '验证客户手机号的大额、小额数据', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK01-A2', '风控模块一批次A2', '验证客户手机号的自有黑名单、同盾多头', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK01-A4', '风控模块一批次A4', '验证客户手机号的电话邦独立邦', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK02-B1', '风控模块二批次B1', '验证客户身份证的大额、小额以及客户年龄、户籍高风险', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK02-B2', '风控模块二批次B2', '验证客户身份证的同盾多头黑名单', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK02-B3', '风控模块二批次B3', '验证客户身份证的自有、互金、前海、至诚', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-C1', '风控模块3批次C1', '验证客户绑卡鉴权手机号、手机设备信息、手机爬虫和社会身份以及联系人大额和小额', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-C2', '风控模块3批次C2', '验证客户联系人手机号的自有黑名单', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-C3', '风控模块3批次C3', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-C4', '风控模块3批次C4', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-C5', '风控模块3批次C5', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-C6', '风控模块3批次C6', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-C7', '风控模块3批次C7', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-C8', '风控模块3批次C8', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-C9', '风控模块3批次C9', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-C10', '风控模块3批次C10', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-FACE', '风控模块3批次FACE', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK03-HDZX', '风控模块3批次HDZX', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK04', '风控模块4', '人行', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK05-E1', '风控模块5批次E1', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK05-E2', '风控模块5批次E2', '审批APV-CMT', 'system', now(), 'system', now(), 0);
INSERT INTO `rms_policy_config` VALUES (null, 'PRD-JDE', 'RISK07-completeness', '风控模块7', '确认要款', 'system', now(), 'system', now(), 0);

