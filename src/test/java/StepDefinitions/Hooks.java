package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends CommonMethods {

    @Before // make sure its from  io.cucumber.java.Before;
    public void preCondition(){
        openBrowserAndLaunchApplication();
    }

    @After  // make sure its from  io.cucumber.java.After;
    public void postCondition(){
        closeBrowser();
    }
}
