Feature: Calculator Application Testing
#  As a user
#  I want to perform calculations
#  So that I can solve math problems

  @smoke @calculator
  Scenario: Simple addition
    Given I am on the "calculatorApp" application
    When I perform calculation "5 + 3"
#    Then I should see result "8"

  #@calculator
  #Scenario: Simple subtraction
    #Given I am on the "calculatorApp" application
    #When I perform calculation "10 - 4"
    #Then I should see result "6"
#
  #@regression @calculator
  #Scenario: Step by step calculation
    #Given I am on the "calculatorApp" application
    #When I click number "7"
    #And I click operator "+"
    #And I click number "3"
    #And I click equals
    #Then I should see result "10"
#
  #@calculator
  #Scenario: Multiple operations
    #Given I am on the "calculatorApp" application
    #When I perform calculation "2 * 5"
    #Then I should see result "10"