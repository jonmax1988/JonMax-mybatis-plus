CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
                        `user_name` varchar(20) NOT NULL COMMENT '用户名',
                        `password` varchar(20) NOT NULL COMMENT '密码',
                        `name` varchar(30) DEFAULT NULL COMMENT '姓名',
                        `age` int(11) DEFAULT NULL COMMENT '年龄',
                        `address` varchar(100) DEFAULT NULL COMMENT '地址',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert  into `user`(`id`,`user_name`,`password`,`name`,`age`,`address`) values
                                                                            (1,'ruiwen','123','瑞文',12,'山东'),
                                                                            (2,'gailun','1332','盖伦',13,'平顶山'),
                                                                            (3,'timu','123','提姆',22,'蘑菇石'),
                                                                            (4,'daji','1222','妲己',221,'狐山');

CREATE TABLE `tb_orders` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `price` int(11) DEFAULT NULL COMMENT '价格',
                          `remark` varchar(100) DEFAULT NULL COMMENT '备注',
                          `user_id` int(11) DEFAULT NULL COMMENT '用户id',
                          `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                          `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                          `version` int(11) DEFAULT '1' COMMENT '版本',
                          `del_flag` int(1) DEFAULT '0' COMMENT '逻辑删除标识,0-未删除,1-已删除',
                          `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
                          `update_by` varchar(100) DEFAULT NULL COMMENT '更新人',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `tb_orders`(`id`,`price`,`remark`,`user_id`,`update_time`,`create_time`,`version`,`del_flag`,`create_by`,`update_by`) values (1,2000,'无',2,'2021-08-24 21:02:43','2021-08-24 21:02:46',1,0,NULL,NULL),(2,3000,'无',3,'2021-08-24 21:03:32','2021-08-24 21:03:35',1,0,NULL,NULL),(3,4000,'无',2,'2021-08-24 21:03:39','2021-08-24 21:03:41',1,0,NULL,NULL);

select o.*,u.user_name from  tb_orders o,tb_user u where o.user_id = u.id;
