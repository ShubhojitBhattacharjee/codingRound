package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPage extends BasePage {

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    public HotelBookingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void searchForHotelsByLocationRoomType(String location, String roomType) {

        wait.until( ExpectedConditions.visibilityOf(localityTextBox) );
        localityTextBox.sendKeys(location);

        new Select(travellerSelection).selectByVisibleText(roomType);
        searchButton.click();
    }
}
