CREATE KEYSPACE IF NOT EXIST scifi WITH REPLICATION={'class':'SimpleStrategy','replication_factor'=1};
  USE scifi;
CREATE TABLE IF NOT EXIST orders(
  customer_id int PRIMARY KEY,
  item_id int,
  price double,
 );