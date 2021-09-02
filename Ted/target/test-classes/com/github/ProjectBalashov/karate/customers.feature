Feature: CustomersTest

  Scenario: Get all customers
    Given url 'http://localhost:8080'
    When method GET
    Then status 200

  Scenario: Get customer by id
    Given url 'http://localhost:8086/{id}'
    When method GET
    Then status 200

  Scenario: Create customer
    Given url 'http://localhost:8086'
    When method POST
    Then status 200

  Scenario: Deposit
    Given url 'http://localhost:8086/deposit/{customer}'
    When method PUT
    Then status 200

  Scenario: Withdraw
    Given url 'http://localhost:8086/withdraw/{customer}'
    When method PUT
    Then status 200