package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import factory.DriverManager;

public class Hooks {

    @Before
    public void setUp() {

        DriverManager.getDriver();

    }

    @AfterStep
    public void afterStep(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failed Step");
        }
    }

    @After
    public void tearDown() {

        DriverManager.quitDriver();

    }
}