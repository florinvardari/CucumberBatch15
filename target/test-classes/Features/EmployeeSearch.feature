Feature: Searching the employee

  Background:
    When user enters valid email and valid password
    And  click on login button
    When user clicks on PIM option

@smoke
Scenario: Search Employee by id
#Given open the browser and launch HRMS application
 #When user enters valid email and valid password
 #And  click on login button
 #When user clicks on PIM option
  When user enters valid employee id
  And clicks on search button
  And  user see employee information displayed
 # And Close the browser

  @smoke
  Scenario: Search employee by job title
    #Given open the browser and launch HRMS application
    # When user enters valid email and valid password
   #  And click on login button
   #  When user clicks on PIM option
    When user select Job Title
    And clicks on search button
    And  user see employee information displayed
   # And Close the browser


  # Background: This is used to define all the common steps that multiple
  #             scenarios have in the same feature file, till the time flow is not broken