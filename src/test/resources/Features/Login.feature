Feature: Login Functionalities

  @smoke1
  Scenario: Valid Admin login
   # Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And  click on login button
    Then user is logged in successfully
  #  And Close the browser

  @smoke2
  Scenario: Valid Admin login
   # Given open the browser and launch HRMS application
    When user enters valid "admin" and valid "Hum@nhrm123"
    And  click on login button
    Then user is logged in successfully
  #  And Close the browser



          #coment
         #HOOKS : For defining pre and Post Steps in any Cucumber framework
        #  : This always created in StepDefintions fiolder
       #  : This class can not be inherited