create database mydb;
use mydb;
create table user(
    id int primary key auto_increment,
    name varchar(255),
    age int
);
insert into user(name,age) values('aaa',19);
insert into user values(null,'bbb',20);
insert into user values(null,'ccc',50);
select * from user;