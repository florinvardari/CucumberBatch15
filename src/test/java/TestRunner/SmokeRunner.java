package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "src/test/resources/Features",
        glue = "StepDefinitions",
        //when you set dry run to true, it stops actual execution
        //it will quickly scan all the gherkin steps whether they are implemented or not
        //when we set dry run to false, it starts execution again
        dryRun = false,
        tags = "@testcase2",
        //pretty keywords prints the steps in the console to increase readability
        //to generate the reports we need plugin of runner class
         plugin = {"pretty","html:target/Cucumber.html","json:target/Cucumber.json"}

     )

public class SmokeRunner {
}


//target folder is mostly used for storing the test case execution reports generated using Cucumber