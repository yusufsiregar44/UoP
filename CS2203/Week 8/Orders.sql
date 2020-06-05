-- default database creation

CREATE TABLE tblCustomers (
    CustomerID varchar(5) NOT NULL PRIMARY KEY,
    CompanyName varchar(40) NOT NULL,
    ContactName varchar(30)  NULL,
    ContactTitle varchar(30) NULL,
    Address varchar(60) NULL,
    City  varchar(15) NULL,
    Region varchar(15) NULL,
    PostalCode varchar(10) NULL,
    Country varchar(15) NULL DEFAULT 'CANADA',
    Phone varchar(24) NULL,
    Fax varchar(10) NULL
);

CREATE TABLE tblSupplier (
    SupplierID int NOT NULL PRIMARY KEY,
    Name varchar(50) NULL,
    Address varchar(50) NULL,
    City varchar(50) NULL,
    Province varchar(50) NULL
);

CREATE TABLE tblShippers (
    ShipperID int NOT NULL PRIMARY KEY UNIQUE,
    CompanyName varchar(50) NOT NULL
);

CREATE TABLE tblProducts (
    ProductID int NOT NULL PRIMARY KEY,
    SupplierID int NULL,
    CategoryID int NULL,
    ProductName varchar(40) NOT NULL,
    EnglishName varchar(40) NULL,
    QuantityPerUnit varchar(20) NULL,
    UnitPrice money NULL,
    UnitsInStock smallint NULL,
    UnitsOnOrder smallint NULL,
    ReorderLevel smallint NULL,
    Discontinued bit NOT NULL,
    FOREIGN KEY (SupplierID) REFERENCES tblSupplier
);

CREATE TABLE tblOrders (
    OrderID int NOT NULL PRIMARY KEY,
    CustomerID varchar(5) NOT NULL,
    EmployeeID int NULL,
    ShipName varchar(40) NULL,
    ShipCity varchar(60) NULL,
    ShipRegion varchar(60) NULL,
    ShipPostalCode varchar(10) NULL,
    ShipCountry varchar(15) NULL,
    ShipVia int NULL,
    OrderDate date NULL,
    RequiredDate date NULL,
    ShippedDate date NULL,
    Freight money NULL,
    FOREIGN KEY (CustomerID) REFERENCES tblCustomers,
    FOREIGN KEY (ShipVia) REFERENCES tblShippers,
    CONSTRAINT valid_ShipDate CHECK (ShippedDate > OrderDate)
);

CREATE TABLE tblOrderDetails (
  OrderID int NOT NULL,
  ProductID int NOT NULL,
  UnitPrice money NOT NULL,
  Quantity smallint NOT NULL,
  Discount real NOT NULL,
  PRIMARY KEY (OrderID, ProductID),
  FOREIGN KEY (OrderID) REFERENCES tblOrders,
  FOREIGN KEY (ProductID) REFERENCES tblProducts,
  CONSTRAINT Valid_Qty Check (Quantity > 0)
);

-- Create tblEmployee and tblCategory relations to maintain referential integrity

CREATE TABLE tblEmployee (
    EmployeeID int PRIMARY KEY NOT NULL,
    Name varchar(50) NOT NULL
);

CREATE TABLE tblCategory (
    CategoryID int PRIMARY KEY NOT NULL,
    Name varchar(50) NOT NULL
);

-- Alter tblProducts and tblOrders to create foreign key

ALTER TABLE tblOrders ADD FOREIGN KEY (EmployeeID) REFERENCES tblEmployee;

ALTER TABLE tblProducts ADD FOREIGN KEY (CategoryID) REFERENCES tblCategory;

-- Create tblShippingAddresses to achieve BCNF third normal form

CREATE TABLE tblShippingAddresses(
    ShippingAddressID int NOT NULL,
    CustomerID varchar(5) NOT NULL,
    ShipName varchar(40) NOT NULL,
    ShipCity varchar(60) NOT NULL,
    ShipRegion varchar(60) NOT NULL,
    ShipPostalCode varchar(10) NOT NULL,
    ShipCountry varchar(15) NOT NULL,
    PRIMARY KEY (ShippingAddressID, CustomerID)
);

-- remove shipping address attributes from tblOrders and add ShippingAddresssID attribute

ALTER TABLE tblOrders
    DROP COLUMN shipname,
    DROP COLUMN shipcity,
    DROP COLUMN shipregion,
    DROP COLUMN shippostalcode,
    DROP COLUMN shipcountry;

ALTER TABLE tblOrders
    ADD COLUMN ShippingAddressID int NULL,
    ADD FOREIGN KEY (ShippingAddressID, CustomerID) REFERENCES tblShippingAddresses;


-- revert back to original database schema

-- QUESTION ONE
-- Get all the orders placed by a specific customer. CustomerID for this customer is MAGAA

SELECT * FROM tblOrders WHERE CustomerID = 'MAGAA';

-- QUESTION TWO
-- Show customers whose ContactTitle is not Sales Associate.
-- Display CustomerID, CompanyName, Contact Name, and ContactTitle

SELECT CustomerID, CompanyName, ContactName, ContactTitle FROM tblCustomers WHERE ContactTitle != 'Sales Associate';

-- QUESTION THREE
-- Show customers who bought products where the EnglishName includes the string “chocolate”.
-- Display CustomerID, CompanyName, ProductID, ProductName, and EnglishName

SELECT t.CustomerID, t.CompanyName, tP.ProductID, tP.ProductName, tP.EnglishName FROM tblCustomers t
    JOIN tblOrders O on t.CustomerID = O.CustomerID
    JOIN tblOrderDetails tOD on O.OrderID = tOD.OrderID
    JOIN tblProducts tP on tOD.ProductID = tP.ProductID
    WHERE EnglishName LIKE '%chocolate%';

-- QUESTION FOUR
-- Show products which were bought by customers from Italy or USA.
-- Display CustomerID, CompanyName, ShipCountry, ProductID, ProductName, and EnglishName

SELECT t.CustomerID, t.CompanyName, O.shipcountry, tP.ProductID, tP.ProductName, tP.EnglishName FROM tblCustomers t
    JOIN tblOrders O on t.CustomerID = O.CustomerID
    JOIN tblOrderDetails tOD on O.OrderID = tOD.OrderID
    JOIN tblProducts tP on tOD.ProductID = tP.ProductID
    WHERE t.Country = 'ITALY' OR t.Country = 'USA';

-- QUESTION FIVE
-- Show total price of each product in each order. Note that there is not a column named as total price.
-- You should calculate it and create a column named as TotalPrice.
-- Display OrderID, ProductID, ProductName, UnitPrice, Quantity, Discount, and TotalPrice

SELECT tO2.OrderID,
       tOD.ProductID,
       tP.ProductName,
       tOD.UnitPrice,
       tOD.Quantity,
       tOD.Discount,
       ((tOD.UnitPrice * tOD.Quantity) * (1 - tOD.Discount)) TotalPrice
FROM tblOrders tO2
    JOIN tblOrderDetails tOD on tO2.OrderID = tOD.OrderID
    JOIN tblProducts tP on tOD.ProductID = tP.ProductID;

-- QUESTION SIX
-- Show how many products there are in each category
-- and show the results in ascending order by the total number of products.
-- Display CategoryName, and TotalProducts

SELECT CategoryID AS CategoryName, count(ProductID) AS TotalProducts FROM tblProducts tP
GROUP BY CategoryID
ORDER BY TotalProducts;

-- QUESTION SEVEN
-- Show the total number of customers in each City. Display Country, City, TotalCustomers

SELECT Country, City, count(CustomerID) AS TotalCustomers FROM tblCustomers tC
GROUP BY City, Country;

-- QUESTION EIGHT
-- Show the orders which were shipped late than the actual required date.
-- Display OrderID, OrderDate, RequiredDate, and ShippedDate

SELECT OrderID, OrderDate, RequiredDate, ShippedDate FROM tblOrders
WHERE ShippedDate > RequiredDate;

