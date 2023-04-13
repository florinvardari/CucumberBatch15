package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeSearch extends CommonMethods {
    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
          sendText(employeeSearchPage.empIdBox, ConfigReader.getPropertyValue("employeeId"));
    }
    @When("clicks on search button")
    public void clicks_on_search_button() {
       doClick(employeeSearchPage.searchButton);
    }
    @When("user see employee information displayed")
    public void user_see_employee_information_displayed() {
        System.out.println("The employee is displayed");
    }
    @When("user select Job Title")
    public void user_select_job_title() {
        selectByOptions(employeeSearchPage.jobTittleDdl,"Singer");
        selectByOptions(employeeSearchPage.EmpStatusDdl,"Active");
        selectByOptions(employeeSearchPage.includeDdl, "Current and Past Employees");
    }


}
