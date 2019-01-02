Spring Cloud OAuth2 优雅集成登录认证
https://segmentfault.com/a/1190000016527822


创建数据库colue-auth,执行SQL语句
数据库名:cloud-auth

CREATE TABLE `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `name` varchar(100) NOT NULL COMMENT '昵称',
    `mobile` varchar(100) NOT NULL COMMENT '手机号',
    `mail` varchar(100) NOT NULL COMMENT '邮箱',
    `pwd` varchar(100) NOT NULL COMMENT '密码',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO user VALUES(NULL,'root','13555555555','10086@qq.com','$2a$10$hcMi5tIUGGGim/Xe0Z7q4e5Zz3QlK.EAek3an3nZf0B.ZdN0GJgSe')
username:root
password:123456


http://localhost:8080/oauth/token
    client_id:client
    client_secret:server
    scope:all
    grant_type:password
    name:lxd
    pwd:lxd

http://localhost:8080/oauth/token
    client_id:client
    client_secret:server
    scope:all
    grant_type:password
    name:lxd
    pwd:lxd
    auth_type:sms
    mobile:15876345263
    code:1234
