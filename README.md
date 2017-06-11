# springboot
springboot 脚手架搭建
整合 mybatis、duird数据源、junit、swagger
实现基础增删改查、分页查询、aop事物、swagger-ui 接口调试

--swagger-ui 访问地址
http://localhost:8080/springboot/swagger-ui.html

--db
新建数据库 springbootdb

新建表
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` bigint(20) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

---更新日期 2017-06-11 18:56
