create database lms;
use lms;
CREATE TABLE `category` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `slug` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `parent_id` varchar(36) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_parent_id_index` (`parent_id`),
  CONSTRAINT `category_parent_id_foreign` FOREIGN KEY (`parent_id`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `image` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `organization` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `logo_id` varchar(36) DEFAULT NULL,
  `license` enum('INTERNAL','EXTERNAL','FULL','TRIAL') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `organization_logo_id_unique` (`logo_id`),
  KEY `organization_logo_id_index` (`logo_id`),
  CONSTRAINT `organization_logo_id_foreign` FOREIGN KEY (`logo_id`) REFERENCES `image` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `address` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL CHECK (json_valid(`address`)),
  `display_picture_id` varchar(36) DEFAULT NULL,
  `organization_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_display_picture_id_unique` (`display_picture_id`),
  KEY `user_display_picture_id_index` (`display_picture_id`),
  KEY `user_organization_id_index` (`organization_id`),
  CONSTRAINT `user_display_picture_id_foreign` FOREIGN KEY (`display_picture_id`) REFERENCES `image` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_organization_id_foreign` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `instructor` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `tagline` varchar(255) DEFAULT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `instructor_user_id_unique` (`user_id`),
  KEY `instructor_user_id_index` (`user_id`),
  CONSTRAINT `instructor_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `course` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `status` enum('DRAFT','PUBLISHED','ARCHIVED','DELETED') NOT NULL,
  `duration` varchar(255) NOT NULL,
  `level` enum('BEGINNER','INTERMEDIATE','ADVANCED') NOT NULL,
  `price` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `rating_count` int(11) NOT NULL,
  `instructor_id` varchar(36) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `banner_id` varchar(36) DEFAULT NULL,
  `cover_id` varchar(36) DEFAULT NULL,
  `curriculum` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL CHECK (json_valid(`curriculum`)),
  `visibility` enum('PUBLIC','INTERNAL') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_banner_id_unique` (`banner_id`),
  UNIQUE KEY `course_cover_id_unique` (`cover_id`),
  KEY `course_instructor_id_index` (`instructor_id`),
  KEY `course_banner_id_index` (`banner_id`),
  KEY `course_cover_id_index` (`cover_id`),
  CONSTRAINT `course_banner_id_foreign` FOREIGN KEY (`banner_id`) REFERENCES `image` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `course_cover_id_foreign` FOREIGN KEY (`cover_id`) REFERENCES `image` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `course_instructor_id_foreign` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `category_courses` (
  `category_id` varchar(36) NOT NULL,
  `course_id` varchar(36) NOT NULL,
  PRIMARY KEY (`category_id`,`course_id`),
  KEY `category_courses_category_id_index` (`category_id`),
  KEY `category_courses_course_id_index` (`course_id`),
  CONSTRAINT `category_courses_category_id_foreign` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `category_courses_course_id_foreign` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `course` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `status` enum('DRAFT','PUBLISHED','ARCHIVED','DELETED') NOT NULL,
  `duration` varchar(255) NOT NULL,
  `level` enum('BEGINNER','INTERMEDIATE','ADVANCED') NOT NULL,
  `price` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `rating_count` int(11) NOT NULL,
  `instructor_id` varchar(36) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `banner_id` varchar(36) DEFAULT NULL,
  `cover_id` varchar(36) DEFAULT NULL,
  `curriculum` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL CHECK (json_valid(`curriculum`)),
  `visibility` enum('PUBLIC','INTERNAL') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_banner_id_unique` (`banner_id`),
  UNIQUE KEY `course_cover_id_unique` (`cover_id`),
  KEY `course_instructor_id_index` (`instructor_id`),
  KEY `course_banner_id_index` (`banner_id`),
  KEY `course_cover_id_index` (`cover_id`),
  CONSTRAINT `course_banner_id_foreign` FOREIGN KEY (`banner_id`) REFERENCES `image` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `course_cover_id_foreign` FOREIGN KEY (`cover_id`) REFERENCES `image` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `course_instructor_id_foreign` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `course_pre_requisites` (
  `course_1_id` varchar(36) NOT NULL,
  `course_2_id` varchar(36) NOT NULL,
  PRIMARY KEY (`course_1_id`,`course_2_id`),
  KEY `course_pre_requisites_course_1_id_index` (`course_1_id`),
  KEY `course_pre_requisites_course_2_id_index` (`course_2_id`),
  CONSTRAINT `course_pre_requisites_course_1_id_foreign` FOREIGN KEY (`course_1_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_pre_requisites_course_2_id_foreign` FOREIGN KEY (`course_2_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `course_students` (
  `course_id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`course_id`,`user_id`),
  KEY `course_students_course_id_index` (`course_id`),
  KEY `course_students_user_id_index` (`user_id`),
  CONSTRAINT `course_students_course_id_foreign` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_students_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `migrations` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `executed_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;



CREATE TABLE `payment` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `provider` varchar(255) NOT NULL,
  `ref` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `role` (
  `id` varchar(36) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `default` tinyint(1) NOT NULL,
  `organization_id` varchar(36) DEFAULT NULL,
  `key` varchar(255) NOT NULL,
  `permissions` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_organization_id_index` (`organization_id`),
  CONSTRAINT `role_organization_id_foreign` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user_roles` (
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `user_roles_user_id_index` (`user_id`),
  KEY `user_roles_role_id_index` (`role_id`),
  CONSTRAINT `user_roles_role_id_foreign` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_roles_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

show tables;
insert into category(id,created_at,updated_at,title,slug,description,enabled) values('cat01','2020-02-22','2020-02-23','front-end','fe','designing a page',1);
insert into category(id,created_at,updated_at,title,slug,description,enabled) values('cat02','2020-03-22','2020-03-23','back-end','be','development area',0);
insert into category(id,created_at,updated_at,title,slug,description,enabled) values('cat03','2020-04-22','2020-04-23','middleware','mw','connecting fe and be',1);
insert into category(id,created_at,updated_at,title,slug,description,parent_id,enabled) values('cat04','2020-04-12','2020-04-13','UI','ui','adding designs','cat01',1);
insert into category(id,created_at,updated_at,title,slug,description,parent_id,enabled) values('cat05','2020-04-10','2020-04-11','mysql','db','storage','cat02',1);

insert into image(id,created_at,updated_at,url) values ('img01','2020-04-09','2020-04-10',
'https://www.google.com/url?sa=i&url=https%3A%2F%2Fgvtechnolab.in%2Fhtml-introduction%2F&psig=AOvVaw2WwGLRdYRUpphS40WTHpPg&ust=1648636009539000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLDn8fGN6_YCFQAAAAAdAAAAABAK');
insert into image(id,created_at,updated_at,url) values ('img02','2020-04-09','2020-04-10',
'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwebandcrafts.com%2Fblog%2Fart-drafting-best-uiux-design%2F&psig=AOvVaw1n_PFM33TIK-o9cg05ntrS&ust=1648636165567000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLivgL2O6_YCFQAAAAAdAAAAABAD');
insert into image(id,created_at,updated_at,url) values ('img02','2020-04-09','2020-04-10',
'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwebandcrafts.com%2Fblog%2Fart-drafting-best-uiux-design%2F&psig=AOvVaw1n_PFM33TIK-o9cg05ntrS&ust=1648636165567000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLivgL2O6_YCFQAAAAAdAAAAABAD');
insert into image(id,created_at,updated_at,url) values ('img04','2020-05-09','2020-05-10',
'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.oracle.com%2Fapac%2Fnews%2Fannouncement%2Foracle-announces-java-16-2021-03-16%2F&psig=AOvVaw1YzuuiVGEzu5JVDIR-40Bv&ust=1648636672740000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCPCgga2Q6_YCFQAAAAAdAAAAABAT');
insert into image(id,created_at,updated_at,url) values ('img03','2020-05-09','2020-05-10',
'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.liveagent.com%2Fintegrations%2Fmysql%2F&psig=AOvVaw16F7q9thGKin1EpYc8qkb_&ust=1648636773714000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLjO1N2Q6_YCFQAAAAAdAAAAABAD');
select * from image;
DELETE from image;
insert into image(id,created_at,updated_at,url) values ('img01','2020-04-09','2020-04-10','C:\Users\Laalu\Pictures\LMS\HTML');
insert into image(id,created_at,updated_at,url) values ('img02','2020-04-09','2020-04-10','C:\Users\Laalu\Pictures\LMS\NODE-JS');
insert into image(id,created_at,updated_at,url) values ('img03','2020-05-09','2020-05-10','C:\Users\Laalu\Pictures\LMS\UI-UX');
insert into image(id,created_at,updated_at,url) values ('img04','2020-06-09','2020-06-10','C:\Users\Laalu\Pictures\LMS\MySQL-Logo');
insert into image(id,created_at,updated_at,url) values ('img05','2020-07-02','2020-07-03','C:\Users\Laalu\Pictures\LMS\Java');
delete from organization;
select * from organization;
insert into organization values('org01','2000-02-20','2005-03-25','tcs','www.tcs.com','tcs.in','img01','full') ;
insert into organization values('org02','2002-02-22','2003-03-25','wipro','www.wipro.com','wipro.in','img02','EXTERNAL') ;
insert into organization values('org03','2003-02-25','2004-03-20','hcl','www.hcl.com','hcl.in','img03','TRIAL') ;
insert into organization values('org04','2004-04-20','2005-03-25','vitech','www.vitech.com','vitech.in','img04','INTERNAL') ;
insert into organization values('org05','2005-02-20','2006-03-25','intel','www.intel.com','intel.in','img05','full') ;
select * from organization;
select * from user;
insert into user(id,created_at,updated_at,first_name,last_name,email,mobile,password,date_of_birth,address,display_picture_id,organization_id)
values('user01','2020-04-09','2020-04-10','lavanya','k','klavanya@gmail.com',9845318551,
'lavanya@123','1997-04-09','{"door_no":10,"street":"2nd street","city":"arakkonam","state":"tamilNadu"}'
,'img01','org01');  /*org01 is org id*/

insert into user(id,created_at,updated_at,first_name,last_name,email,mobile,password,date_of_birth,address,display_picture_id,organization_id)
values('user02','2020-05-09','2020-05-10','arun','kumar','arun1996@gmail.com',8778804219,
'arun@123','1996-05-09','{"door_no":11,"street":"3rd street","city":"kumpinipet","state":"tamilNadu"}'
,'img02','org02');
 insert into user(id,created_at,updated_at,first_name,last_name,email,mobile,password,date_of_birth,address,display_picture_id,organization_id)
values('user03','2020-09-20','2020-09-21','karthik','k','karthik@gmail.com',8778804219,
'karthik@123','2003-09-20','{"door_no":12,"street":"3rd street","city":"arakkonam","state":"tamilNadu"}'
,'img03','org03');
 insert into user(id,created_at,updated_at,first_name,last_name,email,mobile,password,date_of_birth,address,display_picture_id,organization_id)
values('user04','2020-12-31','2020-12-31','divya','k','divya@gmail.com',9035003500,
'divya@123','1992-12-31','{"door_no":5,"street":"3rd street","city":"arakkonam","state":"tamilNadu"}'
,'img04','org04');
 insert into user(id,created_at,updated_at,first_name,last_name,email,mobile,password,date_of_birth,address,display_picture_id,organization_id)
values('user05','2020-01-10','2020-01-11','sandhiya','N','sandhiya@gmail.com',9035003500,
'divya@123','2000-01-10','{"door_no":7,"street":"4th street","city":"arakkonam","state":"tamilNadu"}'
,'img05','org05');

insert into instructor (id,created_at,updated_at,bio,tagline,user_id)values('ins1','2019-09-06','2019-06-07','User','user_01','user01');
insert into instructor (id,created_at,updated_at,bio,tagline,user_id)values('ins2','2019-09-08','2019-06-09','User','user_02','user02');
insert into instructor (id,created_at,updated_at,bio,tagline,user_id)values('ins3','2019-09-02','2019-06-03','User','user_01','user03');
insert into instructor (id,created_at,updated_at,bio,tagline,user_id)values('ins4','2019-03-06','2019-03-07','User','user_01','user04');
insert into instructor (id,created_at,updated_at,bio,tagline,user_id)values('ins5','2019-09-01','2019-06-02','User','user_01','user05');
select * from instructor;

insert into role values('r001','2000-02-20','2005-03-25','student',' recent learning ','1','1','org01','k001','accept') ;
insert into role values('r002','2000-02-23','2005-03-20','alumni',' already learned student ','0','0','org02','k002','accept') ;
insert into role values('r003','2000-02-24','2005-03-25','admin',' office work ','1','1','org03','k003','accept') ;
insert into role values('r004','2000-02-21','2005-03-24','student',' recent learning ','1','1','org04','k004','accept') ;
insert into role values('r005','2000-02-23','2005-03-27','alumni',' office work ','1','1','org05','k005','accept') ;
select * from role;

insert into user_roles(`user_id`,`role_id`)values('user01','r001');
insert into user_roles(`user_id`,`role_id`)values('user02','r002');
insert into user_roles(`user_id`,`role_id`)values('user03','r003');
insert into user_roles(`user_id`,`role_id`)values('user04','r004');
insert into user_roles(`user_id`,`role_id`)values('user05','r005');
select * from user_roles;






















