CREATE KEYSPACE IF NOT EXISTS scifi WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE IF NOT EXISTS scifi.customer (
    id int,
    balance double,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS scifi.item (
    item_id INT,
    name TEXT,
    price DOUBLE,
    category SET<TEXT>,
    PRIMARY KEY (item_id)
);

INSERT INTO scifi.items (item_id, name, price, category)
VALUES (0001, 'Millennium Falcon', 2000.00, {'Star Wars', 'Spaceship', 'Figurine'});


