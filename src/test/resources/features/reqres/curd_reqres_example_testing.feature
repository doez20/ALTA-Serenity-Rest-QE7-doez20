Feature: Reqres Feature
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with parameter page <page>
    When Send get list user request
    Then Status code should be 200 OK
    And Response body should be <page>
  Examples:
    | page |
    | 1    |
    | 2    |

  Scenario: Post create new user with valid json
    Given Post create new user with valid json
    When Send post create user request
    Then Status code should be 201 Created
    And Response body should contain name "Amigos" and job "Quality Engineer"

  Scenario Outline: Update data with valid json
    Given Update data user with valid <id> and json
    When Send update user request
    Then Status code should be 200 OK
    And Response body should contain name "Amigos" and job "CEO"
    Examples:
      | id |
      | 2  |

  Scenario Outline: Delete with valid json
    Given Delete user with <id>
    When Send delete user request
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |

