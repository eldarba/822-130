-- select
-- DML - Data Manipulation Language (insert, update, delete)
-- DDL - Data Definition Language (create, drop)

-- constraints - אילוצים
-- not null
-- unique
-- check
-- PK 
-- FK

create database x;
drop database x;

CREATE TABLE x.product (
  id INT AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  price FLOAT NOT NULL check(price <= 100),
  unique(`name`, `description`),
  PRIMARY KEY(id)
);

select * from x.product;
drop table x.product;

insert into product values(0, 'braed','food', 5.90);
insert into product values(0, 'milk','food', 8.90);
insert into product values(0, 'milk','food', 8.90);
insert into product values(0, 'milk', 10.90);
insert into product values(0, 'eggs', 14.80);
insert into product values(null, 'aaa', 14.80);
insert into product values(100, 'bbb', 14.80);
insert into `x`.`product` (`name`, `price`) values('eee', 4);
insert into product (`name`, price) values('ddd', 10);

create table `order`(
id int auto_increment,
product_id int, 
amount int,
primary key(id),
foreign key(product_id) references product(id)
);

select * from `order`;
select * from `product`;
insert into `order` values(0, 1, 5);
insert into `order` values(0, 1, 7);
insert into `order` values(0, 2, 100);
insert into `order`(product_id, amount) values(2, 200);

delete from `order` where id = 2;
delete from `order` where id = 3;
delete from `product` where id = 1;



-- coupons project
create table customers (id int primary key auto_increment, `name` varchar(25));
create table coupons (id int primary key auto_increment, `title` varchar(25));

-- join table
create table customer_coupon(
customer_id int , 
coupon_id int, 
primary key(customer_id, coupon_id),
foreign key (customer_id) references customers(id),
foreign key (coupon_id) references coupons(id)
);
drop table customer_coupon;







