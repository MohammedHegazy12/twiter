drop database if exists twiter;
CREATE database twiter;
use twiter;
 
drop table if exists users ;
drop table if exists post; 

CREATE table users (
id int NOT NULL auto_increment ,
first_name varchar(50) NOT NULL,
last_name  varchar(70) NOT NULL,
password varchar(80) NOT null,
PRIMARY KEY (id,first_name)
);



CREATE table posts(
id int NOT NULL auto_increment ,
title varchar(500) NOT NULL,
post_initialized_at datetime DEFAULT current_timestamp(),
user_id int NOT NULL    ,
FOREIGN KEY (user_id) REFERENCES users(id),
PRIMARY key(id,user_id)
);
CREATE TABLE comments(
id int NOT NULL auto_increment,
content varchar(500),
post_id int NOT NULL ,
comment_initialized_at  datetime DEFAULT current_timestamp(),
FOREIGN KEY (post_id) REFERENCES posts(id),
PRIMARY KEY (id,post_id)
);

INSERT INTO users (first_name,last_name,password) values("mohammed","hegazy","1234");
INSERT INTO users (first_name,last_name,password) values("mohammed","Helmy","123");
INSERT INTO users (first_name,last_name,password) values("Alaa","mostafa","123");

 insert into posts (title,user_id) values('how to master spring boot',1);
 insert into posts (title,user_id) values('how to become full stack',2);
 insert into posts (title,user_id) values('how to support plastinian',3);


 insert into comments (post_id,content) values(1,'you should first start to learn spring mvc');
 insert into comments(post_id,content) values(1,'you should lean dependency injection');
 

 
