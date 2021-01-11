create table customers(
customerId int,
customerName varchar(45),
primary key(customerId)
);

create table orders(
orderId int,
theCustomerId int,
orderPrice float,
primary key(orderId),
foreign key(theCustomerId) references customers(customerId)
);

-- insert data to customers
insert into customers values(101,'Dan');
insert into customers values(102,'Ben');


-- insert data to orders
insert into orders values(1, 101, 30);
insert into orders values(2, 101, 30);
insert into orders values(3, null, 30);

select * from customers;
select * from orders;

-- (full outer join)
select * from orders join customers;

-- inner join (requires ON)
select * from orders inner join customers on orders.theCustomerId = customers.customerId;
select * from orders o inner join customers c on o.theCustomerId = c.customerId;

-- outer join
-- left
select * from orders o left outer join customers c on o.theCustomerId = c.customerId;
-- right
select * from orders o right outer join customers c on o.theCustomerId = c.customerId;
-- הפסקה עד 15:45
-- לקראת השלב הבא עדכנו מחירים. עשיתי את כולם אותו דבר אז זה פחות טוב לנו
update orders set orderPrice = 30 where orderId = 1;
update orders set orderPrice = 70 where orderId = 2;
update orders set orderPrice = 40 where orderId = 3;

select * from orders;

-- join + on + where
select * from orders o inner join customers c on o.theCustomerId = c.customerId
where o.orderPrice < 50;

-- join on 3 tables
select c.CategoryName, p.ProductName, s.CompanyName as suplier 
from categories c 
join products p
on c.CategoryID = p.CategoryID
join suppliers s
on s.SupplierID = p.SupplierID;

-- group functions
select * from products;
-- avg unitPrice of all products
select avg(UnitPrice) as `unitPriceAvg` from products;
select avg(UnitPrice) as `unitPriceAvgCat2` from products where CategoryID=2;

-- sum
select sum(UnitPrice) as `unitPriceSum` from products;
select sum(UnitPrice) as `unitPriceSumCat2` from products where CategoryID=2;
select '1' as `category`, sum(UnitPrice) as `price sum` from products where CategoryID=1;
select '2' as `category`, sum(UnitPrice) as `price sum` from products where CategoryID=2;

-- min/max
select min(UnitPrice) from products;
select max(UnitPrice) from products;

-- count - number of non null results of rows
select * from orders;
select count(*) from orders;
select count(ShipRegion) from orders;
select count(ShipRegion), count(ShipPostalCode) from orders;

-- all orders for London
select * from orders where ShipCity = 'London';
-- number of all orders for London
select count(*) from orders where ShipCity = 'London';





