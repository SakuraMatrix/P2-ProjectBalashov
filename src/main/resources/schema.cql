CREATE KEYSPACE IF NOT EXISTS sample WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE sample;

CREATE TABLE IF NOT EXISTS sample(
    name text,
    price double,
    category text,
    stock int,
    PRIMARY KEY (name, stock)
);

