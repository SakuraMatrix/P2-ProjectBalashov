CREATE KEYSPACE IF NOT EXISTS scifi WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE scifi;

<<<<<<< HEAD
CREATE TABLE IF NOT EXISTS scifi.customer (
=======
CREATE TABLE IF NOT EXISTS customers (
>>>>>>> 2800e13e0c49df3a448c54addc78368f36229003
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

