create database course_management;
use course_management;

create table topic(id int primary key auto_increment,name varchar(20),description varchar(100)not null,content varchar(100)not null);
select * from topic;
create table question(id int primary key auto_increment,topicId int not null,content varchar(100)not null,answer varchar(100)not null);
select * from question;