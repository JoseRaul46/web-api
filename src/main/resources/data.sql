-- create table course
-- (
--     id bigint auto_increment,
--     name varchar(255) not null,
--     author varchar(100) not null,
--     primary key (id)
-- );
--
-- insert into course(name, author) values ('caca', 'Marco');
-- insert into course(name, author) values ('caca1', 'Marco1');
--
--
-- create table user_ex
-- (
--     id bigint auto_increment,
--     name_col varchar(255) not null,
--     birthdate_col date not null,
--     primary key (id)
-- );
--
insert into user_ex(name_col, birthdate_col) values ('Marco', '2018-04-01');

insert into post( description, user_id) values ( 'call me by my name', 1);
insert into post( description, user_id) values ( 'call me by my mame 1', 1);
insert into post( description, user_id) values ( 'call me by my mame 2', 1);