

Feature: Find Available WorkStations
  
 @Functional
 Scenario Outline: Serach Available WorkStations 
 Given User Launch Chrome Browser and opens Workspace Reservation url
    And User click on sign in button
    And User enter <username> in user name field
    Then User click on next button
    And User entered <password> in password field
    And User click on signin
    And Click on Stay signed in alert
    Then User <username> is navigated to the home page of Create Reservation
    And Select start date and end date for reservations 
    And User click on clear button
    And User select start date and end date for reservations 
    Then User Click on Search button
    And User clicked on pod options dropdown and selected available pod
    And User clciked on workstation options dropdown and selected available work station
    And User selected preferrable date and time
    And click on reserve button
    And User verify the upcoming Reservation details
    And User close the reservation confirmation window
    And User click on My Reservations tab
    And User click on Edit Reservation button
    And User click on Edit Options dropdown and selected change reservation date
    And entered new reservation date and click on submit button
    And User verified reservation complete details
    And User close the new reservation confirmation window
    And User click on Edit Reservation button
    And User click on Edit Options dropdown and selected change workstation
    And User click on the pod options and selected the available Pod
    And User click on Workstation options and selected available workstation
    And User click on Submit button
    And User verified reservation complete details
    And User close the new reservation confirmation window
    And User click on Edit Reservation button
    And User click on Edit Options dropdown and selected change Time Slot
    And User selected new time slot
    And User click on Submit button
    And User verified reservation complete details
    And User close the new reservation confirmation window
    And User cancel the upcoming reservation
    And User verify the reservation cancelled details
    And User close the reservation cancellation window
    Then User click on signout button to logout from workspace reservations page
    
    Examples:  
        |username                         | password    |ScenarioId|FeatureName|
        |ET3_guest_user@concorddevlabs.com| Concord2021!|				   |	         |
        