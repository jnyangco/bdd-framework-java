Feature: Todo Application Testing
  As a user
  I want to manage my tasks
  So that I can stay organized

  @smoke @todo
  Scenario: Add a single task
    Given I am on the "todoApp" application
    When I add a task "Learn Selenium BDD"
    Then I should see task "Learn Selenium BDD" in the list
    And I should see 1 tasks in total

  @regression @todo
  Scenario: Add multiple tasks
    Given I am on the "todoApp" application
    When I add a task "Buy groceries"
    And I add a task "Walk the dog"
    And I add a task "Read a book"
    Then I should see task "Buy groceries" in the list
    And I should see task "Walk the dog" in the list
    And I should see task "Read a book" in the list
    And I should see 3 tasks in total

  @todo
  Scenario: Complete a task
    Given I am on the "todoApp" application
    When I add a task "Complete homework"
    And I complete task "Complete homework"
    Then I should see task "Complete homework" in the list