create database library_manager;
use library_manager;

create table Librarian(id int primary key auto_increment,name varchar(20) not null,phoneNo Long not null,email varchar(20) not null,
password varchar(20) not null,joinDate Date not null,Address varchar(100) not null,areaOfInterest varchar(20)not null);

select * from Librarian;