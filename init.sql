create database  mybatis;
use mybatis;
create table user(
    id int(10) not null ,
    name varchar(30) default null,
    pwd varchar(30) default null,
    PRIMARY KEY (`id`)
)engine=INNODB default charset =UTF8;

INSERT into user(id, name, pwd) values
    (1, "狂神", "123456"),
    (2, "张三", "123456"),
    (3, "李四", "123456");


create table mybatis.teacher(
                                id int(10) not null ,
                                name varchar(30) default null,
                                PRIMARY KEY (`id`)
)ENGINE = INNODB default charset =utf8;

insert into teacher(id,name) value (1, "秦老师");

create table student(
                        id int(10) not null ,
                        name varchar(30) default null,
                        tid int(10) default null,
                        PRIMARY KEY (`id`),
                        KEY `fktid`  (`tid`),
                        CONSTRAINT `fktid` FOREIGN KEY (`tid`) references teacher (`id`)
)ENGINE = INNODB default charset =utf8;

INSERT into `student` (id, name, tid) values (1, "小明", 1);
INSERT into `student` (id, name, tid) values (2, "小红", 1);
INSERT into `student` (id, name, tid) values (3, "小张", 1);
INSERT into `student` (id, name, tid) values (4, "小李", 1);
INSERT into `student` (id, name, tid) values (5, "小王", 1);


create table blog(
                     id varchar(50) not null comment '博客id',
                     title varchar(100) not null comment '博客标题',
                     author varchar(30) not null comment '博客作者',
                     create_time datetime not null comment '创建时间',
                     views int(30) not null comment '浏览量'
)ENGINE = INNODB default charset = utf8;
