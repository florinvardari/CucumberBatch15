package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeSearch extends CommonMethods {
    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
          WebElement empIdBox=driver.findElement(By.xpath("//input[@id='empsearch_id']"));
          sendText(empIdBox, ConfigReader.getPropertyValue("employeeId"));
    }
    @When("clicks on search button")
    public void clicks_on_search_button() {
       WebElement searchButton=driver.findElement(By.xpath("//input[@id='searchBtn']"));
       doClick(searchButton);
    }
    @When("user see employee information displayed")
    public void user_see_employee_information_displayed() {
        System.out.println("The employee is displayed");
    }
    @When("user select Job Title")
    public void user_select_job_title() {
      WebElement jobTittleDdl=  driver.findElement(By.id("empsearch_job_title"));
        selectByOptions(jobTittleDdl,"Singer");

        WebElement EmpStatusDdl=driver.findElement(By.id("empsearch_employee_status"));
        selectByOptions(EmpStatusDdl,"Active");

        WebElement includeDdl= driver.findElement(By.id("empsearch_termination"));
        selectByOptions(includeDdl, "Current and Past Employees");
    }


}
