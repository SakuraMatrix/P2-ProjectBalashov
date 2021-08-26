# Cassandra Microservice

This is the Item Database Service. In charge of anything item related.

## Endpoints
- GET "/item": Returns all items
  ![Alt text](/img/get%20all.PNG)
- GET "/item/filter/byId/{id}": Returns the item with corresponding ID
  ![Alt text](/img/get%20by%20id.PNG)
- GET "/item/filter/byCategory/{category}": Returns all items with the specified category
  ![Alt text](https://i.imgur.com/qSuPQob.PNG)
- GET "/item/filter/byName/{name}": Returns all items with the specified name
  ![Alt text](/img/ge%20by%20name.PNG)
- POST "/item/create": Creates an item from the passed JSON string
  ![Alt text](/img/post%20new%20item.PNG)
