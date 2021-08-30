CREATE KEYSPACE IF NOT EXISTS scifi WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE scifi;

CREATE TABLE IF NOT EXISTS customers (
    customerId int,
    balance double,
    PRIMARY KEY (customerId)
);

CREATE TABLE IF NOT EXISTS items (
    itemId INT,
    itemName TEXT,
    price DOUBLE,
    category SET<TEXT>,
    PRIMARY KEY (itemId)
);

