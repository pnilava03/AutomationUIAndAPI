Feature: OpenCart My Account Page
  As a logged-in user
  I want to access my account dashboard
  So that I can manage my profile, orders, and settings

  Background:
    Given I am logged into OpenCart with valid credentials
      | UserName                | Password |
      | palnilava1930@gmail.com | admin    |

  # -------------------- Smoke Tests --------------------
   @smoke @account
  Scenario: Verify My Account page is displayed successfully
    Then I should see the "My Account" page title

  # -------------------- Functional Tests --------------------
  @account
  Scenario: Verify available sections on My Account page
    Then I should see "My Account" header section
    Then I should see "Edit your account information" link
    And I should see "Change your password" link
    And I should see "Modify your address book entries" link
    And I should see "Modify your wish list" link

#
#  @regression @account
#  Scenario: Navigate to Order History page from My Account
#    When I click on "View your order history"
#    Then I should be navigated to "Order History" page
#
#  @regression @account
#  Scenario: Navigate to Edit Account Information page
#    When I click on "Edit your account information"
#    Then I should be navigated to "My Account Information" page
#
#  @regression @account
#  Scenario: Navigate to Change Password page
#    When I click on "Change your password"
#    Then I should be navigated to "Change Password" page
#
#  # -------------------- Logout --------------------
#  @smoke @logout
#  Scenario: Logout from My Account successfully
#    When I click on Logout link
#    Then I should be logged out successfully
#    #And I should see the "Account Logout" page
