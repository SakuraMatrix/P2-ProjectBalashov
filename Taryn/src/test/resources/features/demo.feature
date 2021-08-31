Feature: demo

Scenario: Testing valid GET endpoint
  Given url 'http://localhost:8097/user/get'
  When method GET
  Then status 200

Scenario: Testing the exact response of a GET endpoint
  Given url 'http://localhost:8097/user/get'
  When method GET
  Then status 200
  And match $ == {id:"1234",name:"John Smith"}
  And match $.id == "1234"

Scenario: Testing that GET response contains specific field
  Given url 'http://localhost:8097/user/get'
  When method GET
  Then status 200
  And match $ contains {id:"1234"}

Scenario: Test GET request exact response
  Given url 'http://localhost:8097/user/get'
  When method GET
  Then status 200
  And match $ == {id:"#notnull",name:"John Smith"}

Scenario: Testing a POST endpoint with request body
  Given url 'http://localhost:8097/user/create'
  And request { id: '1234' , name: 'John Smith'}
  When method POST
  Then status 200
  And match $ contains {id:"#notnull"}