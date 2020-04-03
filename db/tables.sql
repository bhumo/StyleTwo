create table city
(
   code int primary key generated always as identity (start with 1,increment by 1),
   name char(50) not null unique
) ;

create table student
(
 roll_number int primary key,
 name char(50) not null,
 address varchar(300) not null,
 city_code int not null,
 gender char(1) not null,
 indian  boolean not null,
 date_of_birth date not null
) ;