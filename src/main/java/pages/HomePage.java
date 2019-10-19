package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class HomePage extends BasePage {

    @FindBy(linkText = "Hotels")
    public WebElement hotelLink;

    @FindBy(linkText = "Your trips")
    public WebElement trips;

    @FindBy(id = "SignIn")
    public WebElement signIn;

//    @FindBy(id = "signInButton")
    @FindBy(xpath = "//div[@id='Wrapper']//*[@id='signInButton']")
    public WebElement signInBtn;

    @FindBy(id = "errors1")
    public WebElement signInError;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
        webDriver.get("https://www.cleartrip.com/");
        webDriver.manage().window().maximize();
    }

    public HotelBookingPage goToHotels() {

        hotelLink.click();
        return new HotelBookingPage(driver);
    }

    public String invalidSignIn() {

        trips.click();
        signIn.click();

        driver.switchTo().frame("modal_window");

        wait.until( ExpectedConditions.elementToBeClickable(signInBtn) );
        signInBtn.click();
        return signInError.getText();
    }
}
