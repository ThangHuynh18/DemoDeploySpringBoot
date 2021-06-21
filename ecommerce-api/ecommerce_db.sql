drop database ecommercedb;
drop user ecomerce;
create user ecommerce with password 'password';
create databse ecommercedb with template=template0 owner=ecommerce;
\connect ecommercedb;
alter default privileges grant all on table to ecommerce;
alter default privileges grant all on sequence to ecommerce;

create table e_users(
    user_id integer primary key not null ,
    first_name varchar(20) not null ,
    last_name varchar(20) not null ,
    email varchar(50) not null,
    password text not null
);

create table e_categories(
category_id integer primary key not null ,
user_id integer not null,
title varchar(20) not null,
description varchar(50) not null
);
alter table e_categories add constraint cat_users_fk
foreign key (user_id) references e_users(user_id);

create table e_transactions(
transaction_id integer primary key not null ,
category_id integer not null,
user_id integer not null,
amount numeric(10,2) not null,
note varchar(50) not null,
transaction_date bigint not null
);
alter table e_transactions add constraint trans_cat_fk
foreign key (category_id) references e_categories(category_id);
alter table e_transactions add constraint trans_users_fk
foreign key (user_id) references e_users(user_id);

create sequence e_users_seq increment 1 start 1;
create sequence e_categories_seq increment 1 start 1;
create sequence e_transactions_seq increment 1 start 1000;
