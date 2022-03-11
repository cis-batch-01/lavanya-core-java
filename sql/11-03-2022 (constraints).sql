create database course;
show databases;
use course;
create table Trainer_Info(trainer_id varchar(20) primary key 
,salutation varchar(7) not null,trainer_name varchar(30) not null,trainer_location varchar(30)not null
,trainer_track varchar(15)not null,trainer_qualification varchar(100)not null,trainer_experience integer(11)
,trainer_email varchar(100)not null,trainer_password varchar(20)not null,check (trainer_id like 'F%')); 

/*create table trainer_info(
trainer_id varchar(20),salutation varchar(7),trainer_name varchar(30),trainer_location varchar(30),
trainer_track varchar(15),trainer_qualification varchar(100),trainer_experience integer(11),trainer_email varchar(100),
trainer_password varchar(20),constraint pk_trainer primary key (trainer_id),constraint ck_trainer check(trainer_id like 'F%')); */

insert into Trainer_Info values('F001','Mr.','PANKAJ GHOSH','Pune','Java','Bachelor of Technology',12,'Pankaj.Ghosh@alliance.com','fac1@123');
insert into Trainer_Info values('F002','Mr.','SANJAY RADHAKRISHNAN','Bangalore','DotNet','Bachelor of Technology',12,'Sanjay.Radhakrishnan@alliance.com','fac2@123');
insert into Trainer_Info values('F003','Mr.','VIJAY MATHUR','Chennai','Mainframe','Bachelor of Technology',10,'Vijay.Mathur@alliance.com','fac3@123');
insert into Trainer_Info values('F004','Mrs.','NANDINI NAIR','Kolkata','Java','Master of Computer Applications',null,'Nandini.Nair@alliance.com','fac4@123');

select * from Trainer_Info;

create table batch_info(batch_id varchar(20)primary key,batch_owner varchar(30)not null,batch_bu_name varchar(30)not null);
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B001','MRS.SWATI ROY','MSP');
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B002','MRS.ARURNA K','HEALTHCARE');
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B003','MR.RAJESH KRISHNAN','LIFE SCIENCES');
insert into Batch_Info(Batch_Id,Batch_Owner,Batch_BU_Name) values('B004','MR.SACHIN SHETTY','BFS');
select * from batch_info;
/*missed check in batch_info)*/
alter table batch_info add constraint b_batch check(batch_id like 'B%');

create table module_info(module_id varchar(20),module_name varchar(40)not null,module_duration integer(11)not null,constraint pk_module primary key(module_id));
insert into Module_Info(Module_Id,Module_Name,Module_Duration) values ('O10SQL',null,16),
('O10PLSQL','Oracle 10g PL/ SQL',16),('J2SE','Core Java SE 1.6',288),('J2EE','Advanced Java EE 1.6',80);
select * from module_info;
insert into Module_Info (Module_Id,Module_Name,Module_Duration) values ('O10SQL1',null,16);


create table associate_info(associate_id varchar(20),salutation varchar(7)not null,associate_name varchar(30)not null,associate_location varchar(30)not null,
associate_track varchar(15)not null,associate_qualification varchar(200)not null,associate_email varchar(100)not null,
associate_password varchar(20)not null,constraint pk_associate primary key(associate_id),constraint ck_associate check(associate_id like '%A'));
insert into Associate_Info(Associate_Id,Salutation,Associate_Name,Associate_Location,Associate_Track,Associate_Qualification,Associate_Email,Associate_Password) values 
('A001','Miss.','GAYATHRI NARAYANAN','Gurgaon','Java','Bachelor of Technology','Gayathri.Narayanan@hp.com','tne1@123');
insert into Associate_Info(Associate_Id,Salutation,Associate_Name,Associate_Location,Associate_Track,Associate_Qualification,Associate_Email,Associate_Password) values
('A002','Mrs.','RADHIKA MOHAN','Kerala','Java','Bachelor of Engineering In Information Technology','Radhika.Mohan@cognizant.com','tne2@123');
insert into Associate_Info(Associate_Id,Salutation,Associate_Name,Associate_Location,Associate_Track,Associate_Qualification,Associate_Email,Associate_Password) values
('A003','Mr.','KISHORE SRINIVAS','Chennai','Java','Bachelor of Engineering In Computers','Kishore.Srinivas@ibm.com','tne3@123');
insert into Associate_Info(Associate_Id,Salutation,Associate_Name,Associate_Location,Associate_Track,Associate_Qualification,Associate_Email,Associate_Password) values
('A004','Mr.','ANAND RANGANATHAN','Mumbai','DotNet','Master of Computer Applications','Anand.Ranganathan@finolex.com','tne4@123');
/* to change %A into A% in check constraints*/
alter table associate_info drop constraint ck_associate;
alter table associate_info modify associate_id varchar(20) constraint ck_associate check(associate_id like 'A%');
select * from associate_info;
desc module_info;
create table questions(question_id varchar(20),module_id varchar(20) references module_info.module_id,question_text varchar(900)not null,constraint pk_question primary key(question_id));
insert into Questions(Question_Id,Module_Id,Question_Text) values ('Q001','EM001','Instructor knowledgeable and able to handle all your queries'),
('Q002','EM001','All the topics in a particular course handled by the trainer without any gaps or slippages'),
('Q003','EM002','The course materials presentation, handson,  etc. refered during the training are relevant and useful.'),
('Q004','EM002','The Hands on session adequate enough to grasp the understanding of the topic.');
select * from questions;
desc questions;

create table associate_status(associate_id varchar(20)not null references associate_info.associate_id,module_id varchar(20)not null references module_info.module_id,batch_id varchar(20)not null references batch_info.batch_id,trainer_id varchar(20)not null references trainer_info.trainer_id,start_date varchar(20),end_date varchar(20),afeedbackgiven varchar(20),tfeedbackgiven varchar(20));
insert into Associate_Status(Associate_Id,Module_Id,Batch_Id,Trainer_Id,Start_Date,End_Date) values
 ('A001','O10SQL','B001','F001','2000-12-15','2000-12-25'),
('A002','O10SQL','B001','F001','2000-12-15','2000-12-25'),
('A003','O10SQL','B001','F001','2000-12-15','2000-12-25'),
('A001','O10PLSQL','B002','F002','2001-2-1','2001-2-12'),
('A002','O10PLSQL','B002','F002','2001-2-1','2001-2-12');
select * from associate_status;

create table trainer_feedback(trainer_id varchar(20)not null references trainer_info.trainer_id,question_id varchar(20)not null references question_info.question_id,batch_id varchar(20)not null references batch_info.batch_id,module_id varchar(20)not null references module_info.module_id,trainer_rating integer not null);
insert into trainer_feedback(trainer_id,question_id,batch_id,module_id,trainer_rating) values (null,'Q001','B001','O10SQL',4);
insert into trainer_feedback(trainer_id,question_id,batch_id,module_id,trainer_rating) values ('F002','Q002','B002','O10PLSQL',4.5);
desc trainer_feedback;
select * from trainer_feedback;
select * from trainer_feedback where trainer_id='f002';

/*to add values for afeedbackgiven and tfeedbackgiven)*/
set sql_safe_updates=0;
update associate_status set afeedbackgiven='good', tfeedbackgiven='good'  where Associate_Id='A001';
update associate_status set afeedbackgiven='fair', tfeedbackgiven='fair'  where Associate_Id='A002';
update associate_status set afeedbackgiven='good', tfeedbackgiven='average' where Associate_Id='A003';

/* select  columns and attributes
from    table name
where    condition
group by    collection of datas
having       group by related group by's conditions
order by     asc or desc*/