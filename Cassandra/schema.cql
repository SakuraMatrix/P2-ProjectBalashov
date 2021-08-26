CREATE KEYSPACE IF NOT EXISTS scifi WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE scifi;

CREATE TABLE IF NOT EXISTS customers (
    id int,
    balance double,
    PRIMARY KEY (id)
);