package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;
    Wait<WebDriver> wait;

    public BasePage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements( driver, this );

        wait = new FluentWait<WebDriver>( driver )
                .withTimeout( 10, TimeUnit.SECONDS )
                .pollingEvery( 500, TimeUnit.MILLISECONDS )
                .ignoring( Exception.class )
                .withMessage( "Couldn't get the element" );
    }
}
