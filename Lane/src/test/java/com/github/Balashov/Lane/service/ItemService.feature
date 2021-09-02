Feature: LaneMsApplicationTest

  Background:
    * url 'http://localhost:8080'
    * def service = response[0]

  Scenario: Find All
    When method GET
    Then status 200
    And match $ == {id:"#notnull",name:#string,price:#notnull,category:#string}

  Scenario: Find Id
    Given path 'byId', service.id
    When method GET
    Then status 200

  Scenario: Find by Category
    Given path 'byCategory', service.category
    When method GET
    Then status 200

  Scenario: Find by Name
    Given path 'byName', service.name
    When method GET
    Then status 200

  Scenario: Update
    Given path 'update', service.id
    When method PUT
    Then status 200
