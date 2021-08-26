CREATE KEYSPACE IF NOT EXIST scifi WITH REPLICATION={'class':'SimpleStrategy','replication_factor'=1};
  USE scifi;
CREATE TABLE IF NOT EXIST customers(
  customerId int PRIMARY KEY,
  itemId int,
  itemName text,
  itemPrice double,
  itemCategory text );