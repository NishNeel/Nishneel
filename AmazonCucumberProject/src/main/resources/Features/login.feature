Feature: Login feature


Scenario: User logs in successfully
    Given user is on the login page
    When user enters the valid username and password
    Then user should be redirected to the homepage
   
      