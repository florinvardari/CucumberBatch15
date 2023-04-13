package Pages;

import StepDefinitions.EmployeeSearch;
import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  EmployeeSearchPage extends CommonMethods {
    public EmployeeSearchPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='empsearch_id']")
    public WebElement empIdBox;
    @FindBy(xpath = "//input[@id='searchBtn']")
    public WebElement searchButton;
    @FindBy(id = "empsearch_job_title")
    public WebElement jobTittleDdl;
    @FindBy(id = "empsearch_employee_status")
    public WebElement EmpStatusDdl;
    @FindBy(id = "empsearch_termination")
    public WebElement includeDdl;

}
