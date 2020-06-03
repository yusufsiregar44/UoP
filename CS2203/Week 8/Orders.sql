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


