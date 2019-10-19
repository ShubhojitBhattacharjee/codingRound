package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import webdriver.WebDriverSetup;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    protected void setUp(String browser) {

        driver = WebDriverSetup.getWebDriver(browser);
    }

    @AfterMethod(alwaysRun = true)
    protected void cleanUp() {
        driver.quit();
        driver = null;
    }
}
