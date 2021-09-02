Feature: fetching Item Details
 
Scenario: testing the get call for all items
 
Given url 'https://localhost:9000/items'
When method GET
Then status 200

Scenario: Testing the exact response of a GET endpoint
Given url 'http://localhost:9000/items/byId/1'
When method GET
Then status 200
And match $ == {item_id:"1",name:"Darth Maul", category: {'figurine', 'art'}, price: 25.00}

Scenario: Testing a POST endpoint with request body
Given url 'http://localhost:9000/items/create'
And request { item_id: '10' , name: 'Samus', category: {'game'}, price: 35.00}
When method POST
Then status 200
And match $ contains {id:"#notnull"}

Scenario: create and retrieve an item by its id
Given url 'http://localhost:9000/items/create'
And request { item_id: '11' , name: 'Space Opera', category: {'book'}, price: 12.00}
When method POST
Then status 201
And match == {item_id:"#notnull", name: 'Space Opera', category: {'book'}, price: 12.00}

Given path response.id
When method get
Then status 200

****************************************************************
CUSTOMER TESTS

Scenario: testing the get call for all customers
Given url 'https://localhost:9000/customers'
When method GET
Then status 200

Scenario: create and retrieve a customer by id
Given url 'http://localhost:9000/customers'
And request { customerId: '6' , balance: 5000.00}
When method POST
Then status 201
And match == {customerId:"#notnull", balance: 5000.00}

Given path response.id
When method get
Then status 200
