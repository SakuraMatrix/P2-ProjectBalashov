# Cassandra Microservice

This is the Item Database Service. In charge of anything item related.

## Endpoints
- GET "/item": Returns all items
- GET "/item/filter/byId/{id}": Returns the item with corresponding ID
- GET "/item/filter/byCategory/{category}": Returns all items with the specified category
- GET "/item/filter/byName/{name}": Returns all items with the specified name
- POST "/item/create": Creates an item from the passed JSON string
