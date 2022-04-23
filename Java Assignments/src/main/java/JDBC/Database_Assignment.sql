create database smoothstack;
use smoothstack;

create table School (
	id integer,
    name varchar(25),
    primary key (id)
    );
    
create table Student (
	id integer not null auto_increment,
    name varchar (25),
    school_id integer,
    primary key (id),
    foreign key (school_id) references School(id)
    );
    


