-- select
select * from employees;
select EmployeeID, LastName, FirstName from employees;
select * from employees where EmployeeID <= 5 AND EmployeeID != 3;
select * from employees where EmployeeID <= 5 order by LastName;

-- between
select ProductName, UnitsInStock from products where UnitsInStock between 10 and 20;
select ProductName, UnitsInStock from products where UnitsInStock not between 10 and 20;

-- alias
select EmployeeID as ID, FirstName as 'first name', LastName family from employees;

-- concatenation
select EmployeeID, concat(FirstName, ' ', LastName) as fullName  from employees;

-- aritmetic operations
select ProductName, UnitPrice, UnitPrice * 0.90 as DiscountPrice from products;

select *  from orders;

-- all employyes who took orders - 9 results
select distinct EmployeeID from orders; 

 -- all customers who made orders - 89 results
select distinct CustomerID from orders; 

-- all orders uniqe to employee-cusomers
select distinct EmployeeID, CustomerID from orders order by EmployeeID; 

-- instead of OR
select * from employees where city='Seattle' OR city='Tacoma'OR city='Kirkland';
--  we can use IN
select * from employees where city IN('Seattle', 'Tacoma', 'Kirkland');

-- like
-- A
-- % one or many characters
-- _ a single character
select * from customers where ContactName like 'A%'; -- starts with A
select * from customers where ContactName like '_a%'; -- second letter A
select * from customers where ContactName like 'a%a'; -- starts with A ends with a

-- IS NULL
select CustomerID, CompanyName, Region from customers;
select CustomerID, CompanyName, Region from customers where Region is null;
select CustomerID, CompanyName, Region from customers where Region is not null;

-- order by
select * from products;
select * from products order by ProductName asc;  -- ascending is default
select * from products order by ProductName desc; -- descending
select * from products order by 1; -- index
select * from products order by 2; 
select ProductID, ProductName as `name` from products order by `name`; -- alias

-- limit
select * from products;
select * from products limit 10;
select ProductName, CategoryID from products order by ProductName limit 10;

-- join
select * from products;
select * from categories;

select p.ProductID, p.ProductName, p.CategoryID, c.CategoryID, c.CategoryName
from products as p 
join categories as c
on p.CategoryID = c.CategoryID;






