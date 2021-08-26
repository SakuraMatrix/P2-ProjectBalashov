CREATE KEYSPACE IF NOT EXISTS scifi WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE scifi;

CREATE TABLE IF NOT EXISTS scifi.customer (
    id int,
    balance double,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS scifi.customer (
    item_id INT,
    name TEXT,
    price DOUBLE,
    category SET<TEXT>,
    PRIMARY KEY (item_id)
);

