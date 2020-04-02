drop database if exists bugReportTest;

create database if not exists bugReportTest;
use bugReportTest;

create table if not exists product(
id int not null primary key auto_increment,
name varchar(45) unique,
description varchar(250)
);

create table if not exists employee(
id int not null primary key auto_increment,
name varchar(45),
role varchar(100)
);

create table if not exists bug(
id int not null primary key auto_increment,
productId int,
employeeId int,
name varchar(45) unique,
description varchar(250),
tag varchar(20),
screenshot varchar(70),

index fk_productId_idx(productId asc),
constraint fk_productId
	foreign key (productId)
    references product (id)
    on delete no action
    on update no action,

index fk_employeeId_idx1(employeeId asc),
constraint fk_employeeId1
	foreign key (employeeId)
    references employee (id)
    on delete no action
    on update no action

);


create table if not exists bug_thread(
id int not null primary key auto_increment,
employeeId int,
bugId int,
message varchar(400),

index fk_employeeId_idx2(employeeId asc),
constraint fk_employeeId2
	foreign key (employeeId)
    references employee (id)
    on delete no action
    on update no action,

index fk_bugId_idx(bugId asc),
constraint fk_bugId
	foreign key (bugId)
    references bug (id)
    on delete no action
    on update no action
);