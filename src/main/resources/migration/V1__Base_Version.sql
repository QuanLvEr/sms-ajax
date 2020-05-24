USE `ssm`;


DROP TABLE IF EXISTS `tb_emp`;

CREATE TABLE `tb_emp` (
  `emp_no` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `birthday` date NOT NULL,
  `pic_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`emp_no`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;


insert  into `tb_emp`(`emp_no`,`emp_name`,`age`,`birthday`,`pic_path`) values (3,'张小飞',41,'2019-12-01','http://localhost:8080/uploadFile/4c992dd5-df27-4e59-847f-9ab47e0461b6.jpg'),(4,'赵云',34,'2019-12-01',NULL),(5,'曹操',52,'2019-12-02',NULL),(6,'孙策',56,'2019-12-06',NULL),(7,'孙权',43,'2019-12-27',NULL),(8,'小明',11,'2019-12-16',NULL),(10,'小宏',10,'2019-12-16',NULL),(17,'小明',23,'2019-12-11',''),(20,'小宏明',24,'2019-12-03','http://localhost:8080/uploadFile/c3676939-cd81-4825-bbf1-fac94bfa0fa2.jpg');


DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


insert  into `tb_user`(`user_id`,`login_name`,`password`) values (1,'tom','1234'),(2,'admin','1234');