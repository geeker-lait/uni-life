create table `user_master`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'账号_i_d/用户_i_d/会员_i_d/商户_i_d',
	`nick`	varchar(64)	NOT NULL	comment	'用户昵称可随机生成',
	`icon`	varchar(64)	DEFAULT 	'11'	comment	'头像',
	`source`	varchar(64)	NOT NULL	comment	'来源，推广统计用',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户表';

create table `user_org`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`group_id`	bigint(12)	NOT NULL	comment	'组_i_d',
	`post_id`	bigint(12)	NOT NULL	comment	'职位_i_d',
	`group_name`	varchar(64)	NOT NULL	comment	'组名',
	`post_name`	varchar(32)	NOT NULL	comment	'职位名',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户组织架构表';

create table `user_ticket`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`operator_typ`	()	NOT NULL	comment	'操作类型(会员充值/)',
	`operator_time`	()	NOT NULL	comment	'操作时间',
	`record_val`	()	NOT NULL	comment	'记录的值',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户券';

create table `user_operator_log`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`operator_typ`	()	NOT NULL	comment	'操作类型(会员充值/)',
	`operator_time`	()	NOT NULL	comment	'操作时间',
	`record_val`	()	NOT NULL	comment	'记录的值',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户操作记录';

create table `user_relationship`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`pid`	bigint(12)	NOT NULL	comment	'父节点_i_d',
	`org`	int(11)	NOT NULL	comment	'组',
	`deep`	int(11)	NOT NULL	comment	'深度',
	`seq`	int(11)	NOT NULL	comment	'顺序',
	`from_uid`	bigint(12)	NOT NULL	comment	'推荐人_i_d',
	`from_user_name`	varchar(32)	NOT NULL	comment	'推荐人姓名',
	`from_user_phone`	varchar(12)	NOT NULL	comment	'推荐人手机',
	`to_uid`	bigint(12)	NOT NULL	comment	'账号_i_d',
	`to_user_phone`	varchar(12)	NOT NULL	comment	'用户手机',
	`to_user_name`	varchar(32)	NOT NULL	comment	'用户名',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户关系表';

create table `user_member`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`member_level_id`	()	NOT NULL	comment	'会员级别_i_d',
	`start_time`	()	NOT NULL	comment	'开始时间',
	`end_time`	()	NOT NULL	comment	'结束时间',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户会员';

create table `user_identifier`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`identifier`	varchar(32)	NOT NULL	comment	'识别标识:身份唯一标识，如：登录账号、邮箱地址、手机号码、_q_q号码、微信号、微博号；',
	`credential`	varchar(32)	NOT NULL	comment	'授权凭证【_c_r_e_d_e_n_t_i_a_l】：站内账号是密码、第三方登录是_token；',
	`chanel_type`	varchar(32)	NOT NULL	comment	'登录类型【_i_d_e_n_t_i_t_y_t_y_p_e】：登录类别，如：系统用户、邮箱、手机，或者第三方的_q_q、微信、微博；',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份标识表';

create table `user_role`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`role_id`	bigint(12)	NOT NULL	comment	'角色_i_d',
	`role_name`	varchar(32)	NOT NULL	comment	'角色名',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户角色表';

create table `user_idcard`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`idcard`	varchar(24)	NOT NULL	comment	'身份证号',
	`name`	varchar(32)	NOT NULL	comment	'名字',
	`age`	int(2)	NOT NULL	comment	'年龄',
	`sex`	int(1)	NOT NULL	comment	'性别',
	`birthday`	varchar(16)	NOT NULL	comment	'生日',
	`nation`	varchar(32)	NOT NULL	comment	'名族',
	`domicile`	varchar(32)	NOT NULL	comment	'居住地',
	`sign_org`	varchar(64)	DEFAULT 	'11'	comment	'颁发机构',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份证表';

create table `user_address`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`province`	varchar(32)	NOT NULL	comment	'省',
	`city`	varchar(32)	NOT NULL	comment	'市',
	`district`	varchar(32)	NOT NULL	comment	'区',
	`street`	varchar(32)	NOT NULL	comment	'街道',
	`typ`	int(1)	NOT NULL	comment	'地址类型：工作地址/家庭地址/收货地址...',
	`indx`	int(2)	NOT NULL	comment	'顺序',
	`contacts`	varchar(32)	NOT NULL	comment	'联系人',
	`phone_num`	varchar(11)	NOT NULL	comment	'手机号',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户地址表';

create table `user_tag`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`tag_name`	()	NOT NULL	comment	'标签名',
	`tag_color`	()	NOT NULL	comment	'标签色',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户标签';

create table `user_master`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'账号_i_d/用户_i_d/会员_i_d/商户_i_d',
	`nick`	varchar(64)	NOT NULL	comment	'用户昵称可随机生成',
	`icon`	varchar(64)	DEFAULT 	'11'	comment	'头像',
	`source`	varchar(64)	NOT NULL	comment	'来源，推广统计用',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户表';

create table `user_operator_log`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`operator_typ`	()	NOT NULL	comment	'操作类型(会员充值/)',
	`operator_time`	()	NOT NULL	comment	'操作时间',
	`record_val`	()	NOT NULL	comment	'记录的值',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户操作记录';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户操作记录';

create table `rbac_role_permission`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`role_id`	bigint(12)	NOT NULL	comment	'角色_i_d',
	`permission_id`	bigint(12)	NOT NULL	comment	'权限_i_d',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色权限表';

create table `rbac_post`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`post_pid`	bigint(12)	NOT NULL	comment	'父id',
	`post_name`	varchar(32)	NOT NULL	comment	'岗位名',
	`post_code`	varchar(32)	NOT NULL	comment	'岗位code',
	`post_icon`	varchar(32)	NOT NULL	comment	'icon',
	`salary`	varchar(32)	NOT NULL	comment	'薪资',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '岗位表';

create table `rbac_role_group`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`role_id`	bigint(12)	NOT NULL	comment	'角色_i_d',
	`group_id`	bigint(12)	NOT NULL	comment	'组织_i_d',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色组织或机构表';

create table `user_role`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`role_id`	bigint(12)	NOT NULL	comment	'角色_i_d',
	`role_name`	varchar(32)	NOT NULL	comment	'角色名',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户角色表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户角色表';

create table `user_idcard`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`idcard`	varchar(24)	NOT NULL	comment	'身份证号',
	`name`	varchar(32)	NOT NULL	comment	'名字',
	`age`	int(2)	NOT NULL	comment	'年龄',
	`sex`	int(1)	NOT NULL	comment	'性别',
	`birthday`	varchar(16)	NOT NULL	comment	'生日',
	`nation`	varchar(32)	NOT NULL	comment	'名族',
	`domicile`	varchar(32)	NOT NULL	comment	'居住地',
	`sign_org`	varchar(64)	DEFAULT 	'11'	comment	'颁发机构',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份证表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份证表';

create table `user_address`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`province`	varchar(32)	NOT NULL	comment	'省',
	`city`	varchar(32)	NOT NULL	comment	'市',
	`district`	varchar(32)	NOT NULL	comment	'区',
	`street`	varchar(32)	NOT NULL	comment	'街道',
	`typ`	int(1)	NOT NULL	comment	'地址类型：工作地址/家庭地址/收货地址...',
	`indx`	int(2)	NOT NULL	comment	'顺序',
	`contacts`	varchar(32)	NOT NULL	comment	'联系人',
	`phone_num`	varchar(11)	NOT NULL	comment	'手机号',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户地址表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户地址表';

create table `user_tag`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`tag_name`	()	NOT NULL	comment	'标签名',
	`tag_color`	()	NOT NULL	comment	'标签色',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户标签';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户标签';

create table `user_org`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`group_id`	bigint(12)	NOT NULL	comment	'组_i_d',
	`post_id`	bigint(12)	NOT NULL	comment	'职位_i_d',
	`group_name`	varchar(64)	NOT NULL	comment	'组名',
	`post_name`	varchar(32)	NOT NULL	comment	'职位名',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户组织架构表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户组织架构表';

create table `user_ticket`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`operator_typ`	()	NOT NULL	comment	'操作类型(会员充值/)',
	`operator_time`	()	NOT NULL	comment	'操作时间',
	`record_val`	()	NOT NULL	comment	'记录的值',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户券';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户券';

create table `rbac_role_menu`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`role_id`	bigint(12)	NOT NULL	comment	'角色_i_d',
	`menu_id`	bigint(12)	NOT NULL	comment	'菜单_i_d',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色菜单表';

create table `user_relationship`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`pid`	bigint(12)	NOT NULL	comment	'父节点_i_d',
	`org`	int(11)	NOT NULL	comment	'组',
	`deep`	int(11)	NOT NULL	comment	'深度',
	`seq`	int(11)	NOT NULL	comment	'顺序',
	`from_uid`	bigint(12)	NOT NULL	comment	'推荐人_i_d',
	`from_user_name`	varchar(32)	NOT NULL	comment	'推荐人姓名',
	`from_user_phone`	varchar(12)	NOT NULL	comment	'推荐人手机',
	`to_uid`	bigint(12)	NOT NULL	comment	'账号_i_d',
	`to_user_phone`	varchar(12)	NOT NULL	comment	'用户手机',
	`to_user_name`	varchar(32)	NOT NULL	comment	'用户名',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户关系表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户关系表';

create table `rbac_permission`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`permission_code`	varchar(64)	NOT NULL	comment	'权限码query/creat/update/delete',
	`permission_name`	varchar(64)	NOT NULL	comment	'权限名称',
	`permission_val`	varchar(64)	NOT NULL	comment	'权限值',
	`permission_uri`	varchar(64)	NOT NULL	comment	'url',
	`permission_typ`	varchar(64)	NOT NULL	comment	'权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
	`sorted`	int(3)	NOT NULL	comment	'排序',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '权限表';

create table `user_member`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`member_level_id`	()	NOT NULL	comment	'会员级别_i_d',
	`start_time`	()	NOT NULL	comment	'开始时间',
	`end_time`	()	NOT NULL	comment	'结束时间',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户会员';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户会员';

create table `user_identifier`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`identifier`	varchar(32)	NOT NULL	comment	'识别标识:身份唯一标识，如：登录账号、邮箱地址、手机号码、_q_q号码、微信号、微博号；',
	`credential`	varchar(32)	NOT NULL	comment	'授权凭证【_c_r_e_d_e_n_t_i_a_l】：站内账号是密码、第三方登录是_token；',
	`chanel_type`	varchar(32)	NOT NULL	comment	'登录类型【_i_d_e_n_t_i_t_y_t_y_p_e】：登录类别，如：系统用户、邮箱、手机，或者第三方的_q_q、微信、微博；',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份标识表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份标识表';

create table `rbac_role`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`role_name`	varchar(32)	NOT NULL	comment	'角色名',
	`role_code`	varchar(32)	NOT NULL	comment	'角色码',
	`icon`	varchar(32)	NOT NULL	comment	'角色图标',
	`descr`	varchar(32)	NOT NULL	comment	'角色描述',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色表';

create table `rbac_category`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`pid`	bigint(12)	NOT NULL	comment	'父节点_i_d',
	`category_name`	varchar(64)	NOT NULL	comment	'资源类目名',
	`sorted`	int(2)	NOT NULL	comment	'排序',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '资源类目表';

create table `rbac_group`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`group_pid`	bigint(12)	NOT NULL	comment	'父id',
	`group_code`	varchar(32)	NOT NULL	comment	'组code',
	`group_name`	varchar(32)	NOT NULL	comment	'组织架构名',
	`group_icon`	varchar(32)	NOT NULL	comment	'组织架构_i_c_o_n',
	`sorted`	int(2)	NOT NULL	comment	'排序',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '组织机构表';

create table `rbac_menu`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`pid`	bigint(12)	NOT NULL	comment	'父节点_i_d',
	`menu_code`	varchar(64)	NOT NULL	comment	'英文码',
	`menu_name`	varchar(64)	NOT NULL	comment	'名称',
	`menu_val`	varchar(64)	NOT NULL	comment	'值',
	`level`	int(12)	NOT NULL	comment	'层级',
	`sorted`	int(12)	NOT NULL	comment	'排序',
	`is_frame`	int(1)	NOT NULL	comment	'是否iframe',
	`icon`	varchar(64)	NOT NULL	comment	'图标',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '权限表';

create table `rbac_resource`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`category_id`	bigint(12)	NOT NULL	comment	'类目id',
	`resource_name`	varchar(64)	NOT NULL	comment	'资源名',
	`resource_code`	varchar(64)	NOT NULL	comment	'资源码',
	`resource_typ`	varchar(64)	NOT NULL	comment	'类型:1目录、2菜单、3按钮、4链接',
	`resource_val`	varchar(64)	NOT NULL	comment	'资源值',
	`resource_path`	varchar(64)	NOT NULL	comment	'资源路径',
	`resource_icon`	varchar(64)	NOT NULL	comment	'资源图标',
	`resource_descr`	varchar(64)	NOT NULL	comment	'资源描述',
	`visible`	int(1)	NOT NULL	comment	'是否隐藏',
	`level`	int(2)	NOT NULL	comment	'层级',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '资源表';

create table `rbac_role_resource`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`role_id`	bigint(12)	NOT NULL	comment	'角色_i_d',
	`resource_id`	bigint(12)	NOT NULL	comment	'资源_i_d',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色资源表';

create table `user_operator_log`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`operator_typ`	()	NOT NULL	comment	'操作类型(会员充值/)',
	`operator_time`	()	NOT NULL	comment	'操作时间',
	`record_val`	()	NOT NULL	comment	'记录的值',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户操作记录';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户操作记录';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户操作记录';

create table `product_album`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`album_name`	varchar(11)	NOT NULL	comment	'相册名称',
	`descr`	varchar(11)	NOT NULL	comment	'相册描述',
	`album_pic`	int(11)	NOT NULL	comment	'相册封面',
	`sorted`	bigint(11)	NOT NULL	comment	'排序',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '产品相册';

create table `rbac_post`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`post_pid`	bigint(12)	NOT NULL	comment	'父id',
	`post_name`	varchar(32)	NOT NULL	comment	'岗位名',
	`post_code`	varchar(32)	NOT NULL	comment	'岗位code',
	`post_icon`	varchar(32)	NOT NULL	comment	'icon',
	`salary`	varchar(32)	NOT NULL	comment	'薪资',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '岗位表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '岗位表';

create table `product_sku`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`product_id`	varchar(11)	NOT NULL	comment	'产品id',
	`sku_code`	bigint(11)	NOT NULL	comment	'sku编码',
	`price`	bigint(11)	NOT NULL	comment	'价格',
	`promotion_price`	bigint(11)	NOT NULL	comment	'促销价格',
	`pic`	bigint(11)	NOT NULL	comment	'图片',
	`sale`	bigint(11)	NOT NULL	comment	'销量',
	`stock`	bigint(11)	NOT NULL	comment	'库存',
	`low_stock`	bigint(11)	NOT NULL	comment	'最低库存',
	`lock_stock`	bigint(11)	NOT NULL	comment	'锁定库存',
	`sp_data`	varchar(11)	NOT NULL	comment	'规格参数',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '产品SKU';

create table `rbac_role_group`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`role_id`	bigint(12)	NOT NULL	comment	'角色_i_d',
	`group_id`	bigint(12)	NOT NULL	comment	'组织_i_d',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色组织或机构表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色组织或机构表';

create table `user_role`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`role_id`	bigint(12)	NOT NULL	comment	'角色_i_d',
	`role_name`	varchar(32)	NOT NULL	comment	'角色名',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户角色表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户角色表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户角色表';

create table `product_category`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`pid`	varchar(11)	NOT NULL	comment	'父节点',
	`icon`	varchar(11)	NOT NULL	comment	'类目图标',
	`category_name`	varchar(11)	NOT NULL	comment	'类目名',
	`category_code`	varchar(11)	NOT NULL	comment	'类目码',
	`category_typ`	bigint(11)	NOT NULL	comment	'类目类型',
	`product_count`	varchar(11)	NOT NULL	comment	'产品数量',
	`nav_status`	int(11)	NOT NULL	comment	'是否显示在导航栏：0->不显示；1->显示',
	`keywords`	bigint(11)	NOT NULL	comment	'关键字',
	`level`	varchar(11)	NOT NULL	comment	'分类级别：0->1级；1->2级',
	`descr`	varchar(11)	NOT NULL	comment	'描述',
	`attrbute_count`	varchar(11)	NOT NULL	comment	'自定义属性时控制该产品属性的数量',
	`params_count`	varchar(11)	NOT NULL	comment	'自定属性时控制该产品分类下属性参数的数量',
	`product_unit`	varchar(11)	NOT NULL	comment	'单位',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '产品分类';

create table `product_attribute`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`product_category_id`	varchar(11)	NOT NULL	comment	'产品类目id',
	`attrbute_name`	varchar(11)	NOT NULL	comment	'属性名',
	`attrbute_type`	int(11)	NOT NULL	comment	'属性的类型；0->属性，1->规格；',
	`select_type`	int(11)	NOT NULL	comment	'属性选择的类型:0->唯一，1->单选，2->多选',
	`input_type`	bigint(11)	NOT NULL	comment	'属性录入方式:0->手工录入，1->从列表中选取',
	`filter_type`	varchar(11)	NOT NULL	comment	'分类筛选样式',
	`search_type`	varchar(11)	NOT NULL	comment	'检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
	`related_status`	varchar(11)	NOT NULL	comment	'相同属性产品是否关联；0->不关联；1->关联',
	`hand_add_status`	int(11)	NOT NULL	comment	'是否支持手动新增；0->不支持；1->支持',
	`value_list`	int(11)	NOT NULL	comment	'可选值列表(","号分割)',
	`sorted`	int(11)	NOT NULL	comment	'排序',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '产品属性名';

create table `user_org`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`group_id`	bigint(12)	NOT NULL	comment	'组_i_d',
	`post_id`	bigint(12)	NOT NULL	comment	'职位_i_d',
	`group_name`	varchar(64)	NOT NULL	comment	'组名',
	`post_name`	varchar(32)	NOT NULL	comment	'职位名',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户组织架构表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户组织架构表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户组织架构表';

create table `user_ticket`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`operator_typ`	()	NOT NULL	comment	'操作类型(会员充值/)',
	`operator_time`	()	NOT NULL	comment	'操作时间',
	`record_val`	()	NOT NULL	comment	'记录的值',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户券';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户券';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户券';

create table `rbac_role_menu`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`role_id`	bigint(12)	NOT NULL	comment	'角色_i_d',
	`menu_id`	bigint(12)	NOT NULL	comment	'菜单_i_d',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色菜单表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色菜单表';

create table `user_relationship`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`pid`	bigint(12)	NOT NULL	comment	'父节点_i_d',
	`org`	int(11)	NOT NULL	comment	'组',
	`deep`	int(11)	NOT NULL	comment	'深度',
	`seq`	int(11)	NOT NULL	comment	'顺序',
	`from_uid`	bigint(12)	NOT NULL	comment	'推荐人_i_d',
	`from_user_name`	varchar(32)	NOT NULL	comment	'推荐人姓名',
	`from_user_phone`	varchar(12)	NOT NULL	comment	'推荐人手机',
	`to_uid`	bigint(12)	NOT NULL	comment	'账号_i_d',
	`to_user_phone`	varchar(12)	NOT NULL	comment	'用户手机',
	`to_user_name`	varchar(32)	NOT NULL	comment	'用户名',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户关系表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户关系表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户关系表';

create table `user_member`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`member_level_id`	()	NOT NULL	comment	'会员级别_i_d',
	`start_time`	()	NOT NULL	comment	'开始时间',
	`end_time`	()	NOT NULL	comment	'结束时间',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户会员';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户会员';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户会员';

create table `rbac_role`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`role_name`	varchar(32)	NOT NULL	comment	'角色名',
	`role_code`	varchar(32)	NOT NULL	comment	'角色码',
	`icon`	varchar(32)	NOT NULL	comment	'角色图标',
	`descr`	varchar(32)	NOT NULL	comment	'角色描述',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色表';

create table `rbac_category`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`pid`	bigint(12)	NOT NULL	comment	'父节点_i_d',
	`category_name`	varchar(64)	NOT NULL	comment	'资源类目名',
	`sorted`	int(2)	NOT NULL	comment	'排序',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '资源类目表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '资源类目表';

create table `product_album_pic`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`album_id`	varchar(11)	NOT NULL	comment	'相册id',
	`pic_uri`	varchar(11)	NOT NULL	comment	'图片url',
	`pic_name`	varchar(11)	NOT NULL	comment	'图片名称',
	`sorted`	int(11)	NOT NULL	comment	'排序',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '产品相册图片';

create table `user_master`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'账号_i_d/用户_i_d/会员_i_d/商户_i_d',
	`nick`	varchar(64)	NOT NULL	comment	'用户昵称可随机生成',
	`icon`	varchar(64)	DEFAULT 	'11'	comment	'头像',
	`source`	varchar(64)	NOT NULL	comment	'来源，推广统计用',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户表';

create table `rbac_role_permission`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`role_id`	bigint(12)	NOT NULL	comment	'角色_i_d',
	`permission_id`	bigint(12)	NOT NULL	comment	'权限_i_d',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色权限表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色权限表';

create table `product_marketing`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`product_id`	varchar(11)	NOT NULL	comment	'产品id',
	`marketing_id`	varchar(11)	NOT NULL	comment	'营销id',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '产品营销';

create table `user_idcard`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`idcard`	varchar(24)	NOT NULL	comment	'身份证号',
	`name`	varchar(32)	NOT NULL	comment	'名字',
	`age`	int(2)	NOT NULL	comment	'年龄',
	`sex`	int(1)	NOT NULL	comment	'性别',
	`birthday`	varchar(16)	NOT NULL	comment	'生日',
	`nation`	varchar(32)	NOT NULL	comment	'名族',
	`domicile`	varchar(32)	NOT NULL	comment	'居住地',
	`sign_org`	varchar(64)	DEFAULT 	'11'	comment	'颁发机构',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份证表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份证表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份证表';

create table `user_address`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`province`	varchar(32)	NOT NULL	comment	'省',
	`city`	varchar(32)	NOT NULL	comment	'市',
	`district`	varchar(32)	NOT NULL	comment	'区',
	`street`	varchar(32)	NOT NULL	comment	'街道',
	`typ`	int(1)	NOT NULL	comment	'地址类型：工作地址/家庭地址/收货地址...',
	`indx`	int(2)	NOT NULL	comment	'顺序',
	`contacts`	varchar(32)	NOT NULL	comment	'联系人',
	`phone_num`	varchar(11)	NOT NULL	comment	'手机号',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户地址表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户地址表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户地址表';

create table `user_tag`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`tag_name`	()	NOT NULL	comment	'标签名',
	`tag_color`	()	NOT NULL	comment	'标签色',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户标签';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户标签';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户标签';

create table `rbac_permission`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`permission_code`	varchar(64)	NOT NULL	comment	'权限码query/creat/update/delete',
	`permission_name`	varchar(64)	NOT NULL	comment	'权限名称',
	`permission_val`	varchar(64)	NOT NULL	comment	'权限值',
	`permission_uri`	varchar(64)	NOT NULL	comment	'url',
	`permission_typ`	varchar(64)	NOT NULL	comment	'权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
	`sorted`	int(3)	NOT NULL	comment	'排序',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '权限表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '权限表';

create table `user_identifier`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	bigint(12)	NOT NULL	comment	'用户_i_d',
	`identifier`	varchar(32)	NOT NULL	comment	'识别标识:身份唯一标识，如：登录账号、邮箱地址、手机号码、_q_q号码、微信号、微博号；',
	`credential`	varchar(32)	NOT NULL	comment	'授权凭证【_c_r_e_d_e_n_t_i_a_l】：站内账号是密码、第三方登录是_token；',
	`chanel_type`	varchar(32)	NOT NULL	comment	'登录类型【_i_d_e_n_t_i_t_y_t_y_p_e】：登录类别，如：系统用户、邮箱、手机，或者第三方的_q_q、微信、微博；',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份标识表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份标识表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户身份标识表';

create table `product_attribute_val`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`product_id`	varchar(11)	NOT NULL	comment	'产品id',
	`product_attribute_id`	varchar(11)	NOT NULL	comment	'属性名',
	`attrbute__val`	varchar(11)	NOT NULL	comment	'属性值',
	`sorted`	varchar(11)	NOT NULL	comment	'顺序',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '产品属性值';

create table `rbac_group`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`group_pid`	bigint(12)	NOT NULL	comment	'父id',
	`group_code`	varchar(32)	NOT NULL	comment	'组code',
	`group_name`	varchar(32)	NOT NULL	comment	'组织架构名',
	`group_icon`	varchar(32)	NOT NULL	comment	'组织架构_i_c_o_n',
	`sorted`	int(2)	NOT NULL	comment	'排序',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '组织机构表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '组织机构表';

create table `rbac_menu`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`pid`	bigint(12)	NOT NULL	comment	'父节点_i_d',
	`menu_code`	varchar(64)	NOT NULL	comment	'英文码',
	`menu_name`	varchar(64)	NOT NULL	comment	'名称',
	`menu_val`	varchar(64)	NOT NULL	comment	'值',
	`level`	int(12)	NOT NULL	comment	'层级',
	`sorted`	int(12)	NOT NULL	comment	'排序',
	`is_frame`	int(1)	NOT NULL	comment	'是否iframe',
	`icon`	varchar(64)	NOT NULL	comment	'图标',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '权限表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '权限表';

create table `product_brand`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`category_id`	bigint(11)	NOT NULL	comment	'类目id',
	`brand_name`	varchar(11)	NOT NULL	comment	'品牌名称',
	`brand_logo`	varchar(11)	NOT NULL	comment	'品牌logo',
	`descr`	varchar(11)	NOT NULL	comment	'描述',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '产品品牌';

create table `rbac_resource`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`category_id`	bigint(12)	NOT NULL	comment	'类目id',
	`resource_name`	varchar(64)	NOT NULL	comment	'资源名',
	`resource_code`	varchar(64)	NOT NULL	comment	'资源码',
	`resource_typ`	varchar(64)	NOT NULL	comment	'类型:1目录、2菜单、3按钮、4链接',
	`resource_val`	varchar(64)	NOT NULL	comment	'资源值',
	`resource_path`	varchar(64)	NOT NULL	comment	'资源路径',
	`resource_icon`	varchar(64)	NOT NULL	comment	'资源图标',
	`resource_descr`	varchar(64)	NOT NULL	comment	'资源描述',
	`visible`	int(1)	NOT NULL	comment	'是否隐藏',
	`level`	int(2)	NOT NULL	comment	'层级',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '资源表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '资源表';

create table `rbac_role_resource`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`role_id`	bigint(12)	NOT NULL	comment	'角色_i_d',
	`resource_id`	bigint(12)	NOT NULL	comment	'资源_i_d',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色资源表';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '角色资源表';

create table `product_master`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`category_id`	varchar(11)	NOT NULL	comment	'类目id',
	`category_name`	bigint(11)	NOT NULL	comment	'类目名称',
	`attribute_id`	varchar(11)	NOT NULL	comment	'属性id',
	`brand_id`	int(11)	NOT NULL	comment	'品牌id',
	`brand_name`	bigint(11)	NOT NULL	comment	'品牌名称',
	`product_sn`	varchar(11)	NOT NULL	comment	'产品序列号',
	`name`	varchar(11)	NOT NULL	comment	'名称',
	`pic`	varchar(11)	NOT NULL	comment	'图片',
	`sort`	varchar(11)	NOT NULL	comment	'排序',
	`sale`	varchar(11)	NOT NULL	comment	'售价',
	`price`	varchar(11)	NOT NULL	comment	'价格',
	`weight`	varchar(11)	NOT NULL	comment	'重量',
	`stock`	int(11)	NOT NULL	comment	'库存',
	`unit`	int(11)	NOT NULL	comment	'单位',
	`original_price`	bigint(11)	NOT NULL	comment	'价格',
	`low_stock`	varchar(11)	NOT NULL	comment	'最低库存',
	`sub_title`	varchar(11)	NOT NULL	comment	'子标题',
	`descr`	varchar(11)	NOT NULL	comment	'ad',
	`gift_growth`	int(11)	NOT NULL	comment	'ad',
	`gift_point`	int(11)	NOT NULL	comment	'ad',
	`use_point_limit`	int(11)	NOT NULL	comment	'ad',
	`service_ids`	varchar(11)	NOT NULL	comment	'ad',
	`keywords`	varchar(11)	NOT NULL	comment	'关键字',
	`note`	varchar(11)	NOT NULL	comment	'ss',
	`album_pics`	varchar(11)	NOT NULL	comment	'ss',
	`detail_title`	varchar(11)	NOT NULL	comment	'ss',
	`detail_desc`	varchar(11)	NOT NULL	comment	'ss',
	`detail_html`	int(11)	NOT NULL	comment	'ss',
	`detail_mobile_html`	bigint(11)	NOT NULL	comment	'ss',
	`promotion_start_time`	varchar(11)	NOT NULL	comment	'ss',
	`promotion_end_time`	varchar(11)	NOT NULL	comment	'ss',
	`promotion_per_limit`	varchar(11)	NOT NULL	comment	'ss',
	`promotion_type`	int(11)	NOT NULL	comment	'ss',
	`promotion_price`	bigint(11)	NOT NULL	comment	'ss',
	`feight_template_id`	varchar(11)	NOT NULL	comment	'ss',
	`delete_status`	varchar(11)	NOT NULL	comment	'删除状态',
	`publish_status`	varchar(11)	NOT NULL	comment	'发布状态',
	`new_status`	varchar(11)	NOT NULL	comment	'最新状态',
	`recommand_status`	bigint(11)	NOT NULL	comment	'推荐状态',
	`verify_status`	bigint(11)	NOT NULL	comment	'ss',
	`preview_status`	bigint(11)	NOT NULL	comment	'dd',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '产品表';

create table `user_operator_log`(
	`id`	bigint(12)	NOT NULL	AUTO_INCREMENT	comment	'ID',
	`uid`	()	NOT NULL	comment	'用户id',
	`operator_typ`	()	NOT NULL	comment	'操作类型(会员充值/)',
	`operator_time`	()	NOT NULL	comment	'操作时间',
	`record_val`	()	NOT NULL	comment	'记录的值',
	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户操作记录';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户操作记录';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户操作记录';

	`app_id`	varchar(50)	DEFAULT NULL 	comment	'应用ID',
	`tenant_id`	varchar(14)	DEFAULT NULL	comment	'租户ID',
	`is_active`	int(1)	NOT NULL	comment	'',
	`created_by`	varchar(30)	NOT NULL	comment	'',
	`created_date`	datetime	NOT NULL	comment	'',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户操作记录';

