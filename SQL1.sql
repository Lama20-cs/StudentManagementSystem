CREATE DATABASE najd_delights;
show databases;

USE najd_delights;

 CREATE TABLE Staff ( 
Staff_ID int,
Fname VARCHAR(60),
Lname VARCHAR(60),
phone VARCHAR(20),
role ENUM('Chef','Waiter','Cashier')
);
describe Staff;


CREATE TABLE Orders ( 
Order_ID int,
Customer_ID INT ,
Staff_ID int,
Order_Date DATETIME,
Order_Type ENUM('Dine_in','Takeaway'),
Payment_Method ENUM('cash','card'),
Total_Amount DECIMAL(8,2)
);
describe Orders;

CREATE TABLE Dish (
    Dish_ID INT,
    Dish_Name VARCHAR(100),
    Category ENUM('Appetizer', 'Drink'),
    Price DECIMAL(6 , 2 )
);
describe Dish;


CREATE TABLE Order_Details (
Order_ID INT,
Dish_ID INT,
Quantity INT
);

describe Order_Details;

CREATE TABLE Customer (
Customer_ID INT,
Fname VARCHAR(60),
Lname VARCHAR(60),
Phone VARCHAR(20)
);
describe Customer;

show tables;

alter table Customer
ADD Email  VARCHAR(100);

alter table Customer
rename column phone to phone_number;

alter table Customer
modify column phone_number VARCHAR(10);

describe Customer;

alter table Customer
drop column Email;

INSERT INTO Customer (Customer_ID, Fname, Lname,
Phone_Number) VALUES (1, 'Sara',  'Ahmad'
,'0551234567');

INSERT INTO Customer VALUES (2, 'Khalid', 'Ali',
'0569876543');

INSERT INTO Customer VALUES (3, 'Mona', 'Hassan','0571122334'),
(4, 'Omar', 'Saleh','0589988776');


drop table Staff;
CREATE TABLE Staff ( 
Staff_ID int,
Fname VARCHAR(60),
Lname VARCHAR(60),
phone VARCHAR(20),
role ENUM('Chef','Waiter','Cashier')
);

INSERT INTO Staff VALUES
(1, 'Saleh', 'Yasser','0555551234','Chef'),
(2, 'Omar','Majed','0562223344','Chef'),
(3,'Yuosuf', 'Ahmad','0573334455', 'Waiter'),
(4, 'Salem', 'Abdullah','0584445566', 'Cashier') ;


INSERT INTO Dish VALUES
(1, 'Kabsa', 'Appetizer', 25.00),
(2, 'Samboosa', 'Appetizer', 10.00),
(3, 'Basboosa', 'Drink', 15.00),
(4, 'Saudi Cocktail', 'Drink', 5.00);


INSERT INTO Orders VALUES
(1, 1, 3, '2025-09-25 13:30:00', 'Dine_in', 'Cash',60.00),
(2, 2, 3, '2025-09-25 14:00:00', 'Takeaway','Card', 35.00),
(3, 3, 4, '2025-09-26 12:15:00','Dine_in', 'Cash', 25.00),
(4, 4, 2, '2025-09-26 15:45:00', 'Takeaway', 'Cash', 0.00);

INSERT INTO Order_Details VALUES
(1, 1, 2), 
(1, 3, 1), 
(2, 2, 1), 
(2, 4, 2),
(3, 1, 1),
(3, 2, 1), 
(4, 3, 2); 

SELECT * FROM Customer;

SELECT Fname, Lname, Role
FROM Staff;

SELECT Dish_Name, Price FROM Dish
WHERE Price < 15;

UPDATE Customer
SET phone_number = '050000111'
WHERE Customer_ID = 3;

select Fname ,phone_number FROM Customer
WHERE Customer_ID = 3;

DELETE FROM Staff
 WHERE Staff_ID =2;
 
 SELECT * FROM Staff;
 
  SELECT * FROM Order_Details;

 DELETE FROM Dish;
 SELECT * FROM Dish;
 
 DELETE FROM Staff;
DELETE FROM Customer;


ALTER TABLE Customer
ADD PRIMARY KEY (Customer_ID);
describe Customer;

ALTER TABLE Staff
ADD PRIMARY KEY (Staff_ID);
describe Staff;

ALTER TABLE Orders
ADD FOREIGN KEY (Customer_ID) REFERENCES
Customer(Customer_ID);
describe Orders;

ALTER TABLE Customer
MODIFY COLUMN Fname VARCHAR(100) NOT NULL,
MODIFY COLUMN Lname VARCHAR(100) NOT NULL,
MODIFY COLUMN Phone_Number VARCHAR(10) NOT NULL;

ALTER TABLE Staff
MODIFY COLUMN Fname VARCHAR(60) NOT NULL,
MODIFY COLUMN Lname VARCHAR(60) NOT NULL,
MODIFY COLUMN phone VARCHAR(20) NOT NULL;

ALTER TABLE Customer
ADD UNIQUE (Phone_number);

ALTER TABLE Dish
ADD CHECK (Price > 0);
INSERT INTO Dish VALUES (1, 'Kabsa', 'Appetizer', 0);

describe Dish;

ALTER TABLE Orders
Alter Payment_Method SET DEFAULT 'Card';

SELECT MIN(Total_Amount) AS min_order
FROM Orders WHERE Order_Type = 'Dine_in';


SELECT MAX(Total_Amount) AS max_order
FROM Orders;


SELECT COUNT(*) AS total_orders
FROM Orders;

SELECT COUNT(Order_Type) AS takeaway_orders
FROM Orders
WHERE Order_Type = 'takeaway';

SELECT COUNT(DISTINCT Customer_ID) AS customers
FROM Orders;

SELECT SUM(Quantity) AS total_dishes_sold
FROM Order_Details;

describe Order_Details;

SELECT AVG(Total_Amount) AS avg_order_value
FROM Orders;

SELECT Role, COUNT(*) AS total_staff
FROM Staff
GROUP BY Role;




