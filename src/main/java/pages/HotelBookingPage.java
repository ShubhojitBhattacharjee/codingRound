package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HotelBookingPage extends BasePage {

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @FindBy(id = "CheckInDate")
    private WebElement checkInDate;

    @FindBy(id = "CheckOutDate")
    private WebElement checkOutDate;

    @FindBy(xpath = "//ul[@class='autoComplete' and @id='ui-id-1']/li[@class='list']")
    private List<WebElement> localitySuggestions;

    @FindBy(className = "searchSummary")
    private WebElement hotelSearchResult;


    public HotelBookingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterHotelLocation(String location) {

        wait.until( ExpectedConditions.visibilityOf(localityTextBox) );
        localityTextBox.sendKeys(location);

        wait.until( ExpectedConditions.visibilityOfAllElements( localitySuggestions ));
        localitySuggestions.get( 0 ).click();
    }

    public void enterCheckInCheckOutDate() {

        checkInDate.click();
        wait.until( ExpectedConditions.visibilityOf( driver.findElement(
                By.cssSelector( "#ui-datepicker-div .monthBlock.first .calendar tr:nth-child(4) td:nth-child(7)" ) )) ).click();

        checkOutDate.click();
        wait.until( ExpectedConditions.visibilityOf( driver.findElement(
                By.cssSelector( "#ui-datepicker-div .monthBlock.first .calendar tr:nth-child(5) td:nth-child(1)" ) )) ).click();

    }

    public void enterRoomTypeAndSearch(String roomTypeValue) {
        new Select(travellerSelection).selectByVisibleText(roomTypeValue);
        searchButton.click();
    }

    public boolean searchSummaryPresent() {

        wait.until( ExpectedConditions.visibilityOf( hotelSearchResult ) );
        return isElementPresent( hotelSearchResult );
    }
}
