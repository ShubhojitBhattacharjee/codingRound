package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HomePage;
import reports.Logs;
import webdriver.WebDriverSetup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    protected void setUp(@Optional("CH") String browser) {

        driver = WebDriverSetup.setWebDriver(browser);

        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    protected void cleanUp(ITestResult iResult) {

        if (iResult.getStatus() == iResult.FAILURE) {
            String testName = iResult.getName().trim();
            Logs.info("The method which caused the failure is: " + testName);
            captureScreenshot(driver);
        }

        driver.quit();
        driver = null;
    }

    private void captureScreenshot(WebDriver driver) {

        String timestamp = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss").format(new Date());
//        System.out.println(timestamp + " | " + result.getMethod());
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs( OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") +  File.separator + "test-output" + File.separator
                + "Screenshots" + File.separator + timestamp + ".png";
        System.out.println("Screenshot path = " + screenshotPath);
        File destination = new File(screenshotPath);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void reportLogger(String message) {
        Logs.info(message);
        Reporter.log(message);
    }

}
