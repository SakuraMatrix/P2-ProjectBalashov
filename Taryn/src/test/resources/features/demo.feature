Feature: demo

Scenario: Testing valid GET endpoint
  Given url 'http://localhost:8097/user/get'
  When method GET
  Then status 200