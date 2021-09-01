Feature: fetching Item Details
 
Scenario: testing the get call for Item Details
 
Given url 'https://localhost:3000/items'
When method GET
Then status 200

Scenario: Testing the exact response of a GET endpoint
Given url 'http://localhost:3000/items/1'
When method GET
Then status 200
And match $ == {itemId:"1",itemName:"Darth Maul", category: {'figurine', 'art'}, price: 25.00}

Scenario: Testing a POST endpoint with request body
Given url 'http://localhost:3000/items/create'
And request { itemId: '2' , itemName: 'Samus', category: {'game'}, price: 35.00}
When method POST
Then status 200
And match $ contains {id:"#notnull"}

Scenario: create and retrieve an itemId
Given url 'http://localhost:3000/items/create'
And request { itemId: '3' , itemName: 'Space Opera', category: {'book'}, price: 12.00}
When method POST
Then status 201
And match == {itemId:"#notnull", itemName: 'Space Opera', category: {'book'}, price: 12.00}

Given path response.id
When method get
Then status 200
