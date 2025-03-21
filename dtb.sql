CREATE DATABASE MyStock;

USE MyStock;

CREATE TABLE Cars (
    CarID INT PRIMARY KEY IDENTITY(1,1),
    CarName VARCHAR(100),
    Manufacturer VARCHAR(100),
    Price DECIMAL(10, 2),
    ReleasedYear INT
);