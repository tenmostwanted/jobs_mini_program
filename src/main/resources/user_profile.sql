SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `user_profile` (
                                `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `user_id` INT(10) NOT NULL COMMENT '用户表主键',
                                `nickname` VARCHAR(255) DEFAULT NULL COMMENT '用户昵称',
                                `avatar_url` VARCHAR(500) DEFAULT NULL COMMENT '头像链接',
                                `gender` TINYINT(1) DEFAULT NULL COMMENT '性别（0: 未知, 1: 男, 2: 女）',
                                `region` VARCHAR(255) DEFAULT NULL COMMENT '地区',
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `unique_user_id` (`user_id`),
                                CONSTRAINT `fk_user_profile_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


Alter  table   `user_profile`
    change COLUMN  avatar_url avatar VARCHAR(500) DEFAULT NULL COMMENT '头像链接';

