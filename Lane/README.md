# Cassandra Microservice

This is the Item Database Service. In charge of anything item related.

## Endpoints
- GET "/item": Returns all items </br> ![Alt Text](img/get%20all.PNG)
- GET "/item/filter/byId/{id}": Returns the item with corresponding ID </br> ![Alt text](img/get%20by%20id.PNG)
- GET "/item/filter/byCategory/{category}": Returns all items with the specified category </br> ![Alt text](img/get%20by%20category.PNG)
- GET "/item/filter/byName/{name}": Returns all items with the specified name </br> ![Alt text](img/get%20by%20name.PNG)
- POST "/item/create": Creates an item from the passed JSON string </br> ![Alt text](img/post%20new%20item.PNG)
