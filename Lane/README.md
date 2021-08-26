# Cassandra Microservice

This is the Item Database Service. In charge of anything item related.

## Endpoints
- GET "/item": Returns all items
  ![Alt text](../img/get%20all.png)
- GET "/item/filter/byId/{id}": Returns the item with corresponding ID
  ![Alt text](../img/get by id.png)
- GET "/item/filter/byCategory/{category}": Returns all items with the specified category
  ![Alt text](https://i.imgur.com/qSuPQob.png)
- GET "/item/filter/byName/{name}": Returns all items with the specified name
  ![Alt text](../img/get by name.png)
- POST "/item/create": Creates an item from the passed JSON string
  ![Alt text](../img/post new item.png)
