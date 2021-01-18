-- distinct
select distinct * from orders;
select EmployeeID from orders;
select distinct EmployeeID from orders;

-- avg
select * from products;
select avg(UnitPrice) from products;

select CategoryID, avg(UnitPrice) from products group by CategoryID;
-- show the total units in stock per supplier
select SupplierID, sum(UnitsInStock) as `number of units` from products group by SupplierID;

-- minimum unit price
select min(UnitPrice) from products;
-- minimum unit price per product category
select CategoryID, min(UnitPrice) `minimum price` from products group by CategoryID;
-- maximum unit price per product category
select CategoryID, max(UnitPrice) `maximum price` from products group by CategoryID;


select * from products;
-- number of products per category
select CategoryID,  count(*) from products group by CategoryID;
-- number of products per category and supplier
select CategoryID, SupplierID, count(*) from products 
group by CategoryID, SupplierID
order by CategoryID;

-- show from employees the number of employees from each city
select * from employees having EmployeeID < 4;
select city, count(*) from employees group by city;

-- show from employees the number of employees from each city
-- where there are at least 2 employees
select city, count(*) as total from employees where total >= 2 group by city  ;
select city, count(*) as total from employees group by city  having total >= 2;


select * from orders order by CustomerID;

-- טבלת orders
-- נציג את ה ID של כל הלקוחות שביצעו יותר מחמש הזמנות משנת 1995 ואילך
-- + מספר ההזמנות שבוצעו

-- show the id of all customers that made more than 5 orders from 1995 forward
-- show the number of orders
select CustomerID, count(*) as `number of orders`, max(OrderDate) as `last`
from orders 
where OrderDate > '1995-1-1'
group by CustomerID
having `number of orders` > 5
order by `number of orders`
;

-- sub queries
select * from products order by UnitPrice;
select min(UnitPrice) from products;
-- display detailes  for product with lowest price

-- instead of doing this
select * from products where UnitPrice=(2.5);
-- do this (use a sub query)
select * from products where UnitPrice=(select min(UnitPrice) from products);

select * from products;
-- display all products that costs more than Chai
select UnitPrice from products where ProductName='chai';
select * from products where UnitPrice > (select UnitPrice from products where ProductName='chai');

-- using the result of sub-query inside a result set is posible
select ProductID, ProductName, (select UnitPrice from products where ProductName='chai') as chaiPrice from products;
select ProductID, ProductName, 18 as chaiPrice from products;

-- display the price and name of products taht cost mpre than product id 2
select UnitPrice from products where ProductID=2;

select UnitPrice, ProductName from products where UnitPrice > 
(select UnitPrice from products where ProductID=2);

-- display the id and name of products with more than 20 units 

select * from products ;
select * from `order details`;

select ProductID from `order details` group by ProductID having sum(Quantity) > 1200;

select ProductID, ProductName from products where ProductID in 
(select ProductID from `order details` group by ProductID having sum(Quantity) > 1200) ;



