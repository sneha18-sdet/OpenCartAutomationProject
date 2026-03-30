package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features",
        glue = {"stepdefinitions","hooks"},

        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/failed.txt"
        },

        monochrome = true
        //tags = "@login or @register"
)

public class TestRunnerClass extends AbstractTestNGCucumberTests {

}