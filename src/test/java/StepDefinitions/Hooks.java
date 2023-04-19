package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before // make sure its from  io.cucumber.java.Before;
    public void preCondition(){
        openBrowserAndLaunchApplication();
    }

    //Scenario class holds the complete information of your tests execution in Cucumber framework
    @After  // make sure its from  io.cucumber.java.After;
    public void postCondition(Scenario scenario){
        byte[] pic;
        if (scenario.isFailed()){
          pic = takeScreenshot("failed/"+ scenario.getName());
        }else {
           pic =takeScreenshot("passed/"+scenario.getName());
        }

        // attach the screenshot in my report
        scenario.attach(pic,"image/png",scenario.getName());

        closeBrowser();
    }
}
