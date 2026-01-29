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
  @account  @regression
  Scenario: Verify available Links on My Account Header
    Then I should see "My Account" header section
    Then I should see "Edit your account information" link
    And I should see "Change your password" link
    And I should see "Modify your address book entries" link
    And I should see "Modify your wish list" link
    And I should see "Subscribe / unsubscribe to newsletter" link


  @regression @account
  Scenario: Verify available Links on My Orders Header
    Then I should see "My Orders" header section
    Then I should see "View your order history" link
    And I should see "Downloads" link
    And I should see "Your Reward Points" link
    And I should see "View your return requests" link
    And I should see "Your Transactions" link
    And I should see "Recurring payments" link

  @regression @account
  Scenario: Verify available Links on My Affiliate Account Header
    Then I should see "My Affiliate Account" header section
    Then I should see "Register for an affiliate account1" link



  @regression @account
  Scenario: Verify All links Account Page right hand side
    Then I should see All links
      | My Account         |
      | Edit Account       |
      | Password           |
      | Address Book       |
      | Wish List          |
      |Notification        |
      | Order History      |
      | Downloads          |
      | Recurring payments |
      | Reward Points      |
      | Returns            |
      | Transactions       |
      | Newsletter         |
      | Logout             |
#
#  # -------------------- Logout --------------------
#  @smoke @logout
#  Scenario: Logout from My Account successfully
#    When I click on Logout link
#    Then I should be logged out successfully
#    #And I should see the "Account Logout" page
