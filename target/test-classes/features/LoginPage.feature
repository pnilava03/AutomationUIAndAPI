Feature: OpenCart Login As a registered user
  I want to log in to OpenCart
  So that I can access my account dashboard

  Background:
    Given I am on Opencart application

  # -------------------- Happy Path --------------------
  @smoke @happy
  Scenario: Login with valid email and valid password
    When I enter email "palnilava1930@gmail.com"
    And I enter password "admin"
    And I click on the Login button
    And I should see the "My Account" page

#  # -------------------- Negative Tests --------------------
  @negative
  Scenario: Login with valid email and invalid password
    When I enter email "palnilava1930@gmail.com"
    And I enter password "Tester@01"
    And I click on the Login button
    Then I should see an alert message "Warning: No match for E-Mail Address and/or Password."

  @negative
  Scenario: Login with invalid email and valid password
    When I enter email "palnilava@gmail.com"
    And I enter password "admin"
    And I click on the Login button
    Then I should see an alert message "Warning: No match for E-Mail Address and/or Password."

  @negative
  Scenario: Login with invalid email and invalid password
    When I enter email "palnilava@gmail.com"
    And I enter password "Tester@01"
    And I click on the Login button
    Then I should see an alert message "Warning: No match for E-Mail Address and/or Password."

  @negative
  Scenario: Login with empty email and empty password
    When I enter email ""
    And I enter password ""
    And I click on the Login button
    Then I should see an alert message "Warning: No match for E-Mail Address and/or Password."

  @negative
  Scenario: Login with empty email and valid password
    When I enter email ""
    And I enter password "admin"
    And I click on the Login button
    Then I should see an alert message "Warning: No match for E-Mail Address and/or Password."

  @negative
  Scenario: Login with valid email and empty password
    When I enter email "palnilava1930@gmail.com"
    And I enter password ""
    And I click on the Login button
    Then I should see an alert message "Warning: No match for E-Mail Address and/or Password."
