Feature: CustomersTest

  Background:
    * url 'http://localhost:8086'
    * def first = response[0]

  Scenario: Get all customers
    When method GET
    Then status 200

  Scenario: Get customer by id
    Given path first.id
    When method GET
    Then status 200

  Scenario: Create customer
    When method POST
    Then status 200

  Scenario: Deposit
    Given path 'deposit', first.customer
    When method PUT
    Then status 200

  Scenario: Withdraw
    Given path 'withdraw', first.customer
    When method PUT
    Then status 200