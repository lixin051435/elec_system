drop database if exists `elec_system`;
create database elec_system;
use elec_system;
drop table if exists `user`;
create table `user`(
	`user_id` int(11) primary key AUTO_INCREMENT,
	`name` varchar(255) unique,
	`password` varchar(255) default null,
	`department` varchar(255) default null,
	`emp` varchar(255) default null,
	`tel` varchar(255) default null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) unique,
  `password` varchar(255) DEFAULT NULL,
  `emp` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user values(1,'后裔','123','供电','职工','15732116589');
insert into user values(2,'狄仁杰','123','供电','职工','15732116589');
insert into user values(3,'孙尚香','123','供电','职工','15732116589');
insert into user values(4,'黄忠','123','配电','职工','15732116589');
insert into user values(5,'百里守约','123','供电','职工','15732116589');
insert into user values(6,'李元芳','123','发电','职工','15732116589');
insert into user values(7,'马可波罗','123','发电','职工','15732116589');
insert into user values(8,'成吉思汗','123','供电','职工','15732116589');
insert into user values(9,'虞姬','123','供电','职工','15732116589');

insert into admin values(1,'root','123456','供电局局长','15732116589');
insert into admin values(2,'admin','123456','供电局局长','15732116589');

CREATE TABLE `elec_info` (
  `date` datetime NOT NULL,
  `ia1` double(255,2) DEFAULT NULL,
  `ia2` double(255,2) DEFAULT NULL,
  `ib1` double(255,2) DEFAULT NULL,
  `ib2` double(255,2) DEFAULT NULL,
  `ic1` double(255,2) DEFAULT NULL,
  `ic2` double(255,2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `elec_info` VALUES ('2018-05-01 00:00:00', '10', '-10', '10', '-10', '10', '-10', '无短路故障');
INSERT INTO `elec_info` VALUES ('2018-05-01 15:12:44', '12', '-12', '12', '-12', '12', '-12', '无短路故障');
INSERT INTO `elec_info` VALUES ('2018-05-01 15:22:44', '10', '-10', '11', '-11', '10.9', '-10.9', '无短路故障');