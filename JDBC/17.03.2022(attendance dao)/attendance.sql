create database Attendence;
use Attendence;

create table attendence(id int primary key auto_increment,username varchar(20) not null,status varchar(20) not null,date date not null);
drop table attendence;
select * from attendence;

create database attendance_detail;
use attendance_detail;
drop database attendance;

create table attendance(id int primary key auto_increment,username varchar(20) not null,status varchar(20) not null,date date not null);