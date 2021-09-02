Feature: ScifiTests

  Background:
    * url 'http://localhost:8080'

  Scenario: Welcome

    When method GET
    Then status 200
    And match $ == "Experimenting with Eureka for Project 2!"