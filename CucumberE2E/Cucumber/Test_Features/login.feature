Feature: feature to test login functionality

  @Login
  Scenario Outline: Check login is successful with valid credentials
    Given User Launch Chrome Browser and opens Workspace Reservation url
    And User click on sign in button
    And User enter <username> in user name field
    Then User click on next button
    And User entered <password> in password field
    And User click on signin
    And Click on Stay signed in alert
    Then User <username> is navigated to the home page of Create Reservation
    
      Examples:  
        | username                          | password     |ScenarioId|FeatureName|
        | ET3_guest_user@concorddevlabs.com | Concord2021! |					|						|
        