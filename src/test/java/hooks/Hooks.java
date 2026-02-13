package hooks;

import factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    private DriverFactory driverFactory;

    public Hooks(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }

    @Before
    public void setUp() {
        driverFactory.initDriver();
    }

    @After
    public void tearDown() {
        driverFactory.quitDriver();
    }
}
