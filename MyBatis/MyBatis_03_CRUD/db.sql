create database mydb;
use mydb;
drop table user;
create table user(
    id int primary key auto_increment,
    name varchar(255),
    age int
);
insert into user(name,age) values('aaa',19);
insert into user values(null,'bbb',20);
insert into user values(null,'ccc',50);
select * from user;

select * from user where age>=10 and age<=25;
select * from user where age between 10 and 25;

select * from user where id=1;

select * from user limit 0,4;

update user set age=25 where id=2;
insert into user(name) values("tt");
insert into user(age) values(100);
insert into user(id,age) values(10,60);



