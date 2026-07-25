Feature: Flight Booking scenarios

  @StepWithDataTable
 # Data-Driven Pattern
  Scenario: Flight booking with multiple items
    When User navigate to flight booking home
    And Book below flights:
      | From Location   | To Location    | Choose Result |
      | Boston              | London          |  3                    |
      | Portland            | Berlin            |  4                    |
      | Paris                 | Rome            |  1                    |
    Then Flight booking should be successful
