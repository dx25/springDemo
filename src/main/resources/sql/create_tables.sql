create table table_user
(
	id int auto_increment
		primary key,
	name varchar(10) null,
	age int null
)
;
---mysql version must be above then 5.5
create table message
(
	id int auto_increment
		primary key,
	name varchar(50) not null,
	description varchar(500) null,
	createdAt timestamp default CURRENT_TIMESTAMP not null,
	updatedAt timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP not null,
	endAt timestamp default '0000-00-00 00:00:00' not null,
	source varchar(100) null
)
;

CREATE TABLE user_token(
	id BIGINT auto_increment
		primary key,
	user_id BIGINT NOT NULL ,
	token varchar(64) not null,
	createdAt timestamp default CURRENT_TIMESTAMP not null
);
CREATE UNIQUE INDEX UNQ_TOKEN_TOKEN ON user_token(token);
CREATE UNIQUE INDEX UNQ_TOKEN_USER ON user_token(user_id);



