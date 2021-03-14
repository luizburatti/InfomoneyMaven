use infomoney;
create table cotation(
id int primary key auto_increment,
name varchar(255)
);

create table values_cotation(
id int primary key auto_increment,
price float,
buying float,
selling float,
variation_low float,
variation_high float,
date date, 
cotation_id int,
foreign key (cotation_id) references cotation(id)
);

create table user(
id int primary key auto_increment,
name varchar(255),
email varchar(255),
password varchar(255)
);

create table wallet(
id int primary key auto_increment,
amount float,
user_id int,
foreign key (user_id) references user(id)
);

create table values_cotation_user(
id int primary key auto_increment,
user_id int,
foreign key (user_id) references user(id),
values_cotation_id int,
foreign key (values_cotation_id) references values_cotation(id), 
amount float,
date date
)
