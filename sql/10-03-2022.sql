create database d_name;
show databases;
use d_name;
create table table_name(id int(10),name varchar(50));
select * from table_name;
insert into table_name(id,name)
values(1,'lavanya'),
(2,'karthik');
show tables;
drop table table_name;

create table trainer_info(trainer_id varchar(20),salutation varchar(7),trainer_name varchar(30),trainer_location varchar(30),trainer_track varchar(15),trainer_qualification varchar(100),trainer_experience integer(11),trainer_email varchar(100),trainer_password varchar(20));
create table batch_info(batch_id varchar(20),batch_owner varchar(30),batch_bu_name varchar(30));
create table module_info(module_id varchar(20),module_name varchar(40),module_duration integer(11));
create table associate_info(associate_id varchar(20),salutation varchar(7),associate_name varchar(30),associate_location varchar(30),associate_track varchar(15),associate_qualification varchar(200),associate_email varchar(100),associate_password varchar(20));
create table questions(question_id varchar(20),module_id varchar(20),question_text varchar(900));
create table associate_status(associate_id varchar(20),module_id varchar(20),start_date varchar(20),end_date varchar(20),afeedbackgiven varchar(20),tfeedbackgiven varchar(20));
create table trainer_feedback(trainer_id varchar(20),question_id varchar(20),batch_id varchar(20),module_id varchar(20),trainer_rating integer(11));
create table associate_feedback(associate_id varchar(20),question_id varchar(20),module_id varchar(20),associate_rating integer(11));
create table login_details(user_id varchar(20),user_password varchar(20));

alter table Associate_Status add Batch_Id varchar(20), add Trainer_Id varchar(20);
select * from associate_status;
select * from end_date;
desc Associate_Status;
alter table Associate_Status modify start_date date,modify end_date date;
desc trainer_info;
desc login_details;
select * from login_details;
alter table login_details add(user_name varchar(20));
alter table login_details drop column user_name;
alter table login_details modify user_name int(3);
alter table login_details rename column user_name to name;

alter table login_details add column user_age int(2) after user_id;

insert into Trainer_Info values('F001','Mr.','PANKAJ GHOSH','Pune','Java','Bachelor of Technology',12,'Pankaj.Ghosh@alliance.com','fac1@123');
insert into Trainer_Info values('F002','Mr.','SANJAY RADHAKRISHNAN','Bangalore','DotNet','Bachelor of Technology',12,'Sanjay.Radhakrishnan@alliance.com','fac2@123');
insert into Trainer_Info values('F003','Mr.','VIJAY MATHUR','Chennai','Mainframe','Bachelor of Technology',10,'Vijay.Mathur@alliance.com','fac3@123');
insert into Trainer_Info values('F004','Mrs.','NANDINI NAIR','Kolkata','Java','Master of Computer Applications',9,'Nandini.Nair@alliance.com','fac4@123');
insert into Trainer_Info values('F005','Miss.','ANITHA PAREKH','Hyderabad','Testing','Master of Computer Applications',6,'Anitha.Parekh@alliance.com','fac5@123');
insert into Trainer_Info values('F006','Mr.','MANOJ AGRAWAL','Mumbai','Mainframe','Bachelor of Technology',9,'Manoj.Agrawal@alliance.com','fac6@123');
insert into Trainer_Info values('F007','Ms.','MEENA KULKARNI','Coimbatore','Testing','Bachelor of Technology',5,'Meena.Kulkarni@alliance.com','fac7@123');
insert into Trainer_Info values('F009','Mr.','SAGAR MENON','Mumbai','Java','Master of Science In Information Technology',12,'Sagar.Menon@alliance.com','fac8@123');

select * from Trainer_Info where trainer_id='F001';  /* to select particular detail from table */
delete from Trainer_Info where trainer_id='F001'; 		
set sql_safe_updates=0;
select * from Trainer_Info; 
select * from associate_info;

insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B001','MRS.SWATI ROY','MSP');
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B002','MRS.ARURNA K','HEALTHCARE');
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B003','MR.RAJESH KRISHNAN','LIFE SCIENCES');
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B004','MR.SACHIN SHETTY','BFS');
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B005','MR.RAMESH PATEL','COMMUNICATIONS');
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B006','MRS.SUSAN CHERIAN','RETAIL & HOSPITALITY');
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B007','MRS.SAMPADA JAIN','MSP');
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B008','MRS.KAVITA REGE','BPO');
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B009','MR.RAVI SEJPAL','MSP');
select * from Batch_Info;
select * from Batch_Info where Batch_Id='B001';
delete from Batch_Info where Batch_Id='B001';
update batch_info set batch_owner='mr.harish' where batch_id='b009';

insert into Module_Info(Module_Id,Module_Name,Module_Duration) values ('O10SQL','Oracle 10g SQL',16),('O10PLSQL','Oracle 10g PL/ SQL',16);

select * from module_info;

insert into Questions(Question_Id,Module_Id,Question_Text) values ('Q001','EM001','Instructor knowledgeable and able to handle all your queries');
