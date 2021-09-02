CREATE KEYSPACE IF NOT EXISTS scifi WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE scifi;

CREATE TABLE IF NOT EXISTS customers (
    customerId int,
    balance double,
    PRIMARY KEY (customerId)
);

CREATE TABLE IF NOT EXISTS items (
    item_id INT,
    name TEXT,
    price DOUBLE,
    category SET<TEXT>,
    PRIMARY KEY (item_id)
);

CREATE TABLE IF NOT EXISTS orders(
    orderId INT,
    customer_id INT,
    item_id INT,
    price double,
    PRIMARY KEY(orderId, customer_id)
);