package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(linkText = "Your trips")
    private WebElement trips;

    @FindBy(id = "SignIn")
    private WebElement signIn;

    @FindBy(id = "signInButton")
    private WebElement signInBtn;

    @FindBy(id = "errors1")
    private WebElement signInError;

    @FindBy(id = "OneWay")
    private WebElement oneWay;

    @FindBy(id = "FromTag")
    private WebElement origin;

    @FindBy(id = "ToTag")
    private WebElement destination;

    @FindBy(xpath = "//ul[@class='autoComplete' and @id='ui-id-1']/li")
    private List<WebElement> originSuggestions;

    @FindBy(xpath = "//ul[@class='autoComplete' and @id='ui-id-2']/li")
    private List<WebElement> destinationSuggestions;

    @FindBy(id = "DepartDate")
    private WebElement departureDate;

    @FindBy(id = "SearchBtn")
    private WebElement searchFlightsBtn;

    @FindBy(className = "searchSummary")
    private WebElement searchResult;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
        webDriver.get("https://www.cleartrip.com/");
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

    public void selectRouteOption() {
        oneWay.click();
    }

    public void enterOriginPlace(String originText) {

        origin.clear();
        origin.sendKeys( originText );
        wait.until( ExpectedConditions.visibilityOfAllElements( originSuggestions ));
        originSuggestions.get( 0 ).click();

    }

    public void enterDestination(String destinationText) {

        destination.clear();
        destination.sendKeys( destinationText );
        wait.until( ExpectedConditions.visibilityOfAllElements( destinationSuggestions ));
        destinationSuggestions.get( 0 ).click();
    }

    public void departOn(String date) {
        departureDate.sendKeys( date );

    }

    public void searchFlights() {
        searchFlightsBtn.click();
    }

    public boolean searchSummaryPresent() {
        wait.until( ExpectedConditions.visibilityOf( searchResult ) );
        return isElementPresent( searchResult );
    }
}
