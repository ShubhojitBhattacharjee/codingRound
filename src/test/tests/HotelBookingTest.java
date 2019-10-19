package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelBookingPage;

public class HotelBookingTest extends BaseTest {

    /*@FindBy(linkText = "Hotels")
    private WebElement hotelLink;*/

    public HotelBookingTest() {
        super();
    }

    @Test
    public void shouldBeAbleToSearchForHotels() {

        HomePage homePage = new HomePage(driver);

        HotelBookingPage hotelBookingPage  = homePage.goToHotels();
//        homePage.hotelLink.click();

        hotelBookingPage.searchForHotelsByLocationRoomType("Indiranagar, Bangalore", "1 room, 2 adults");

        /*homePage.localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(homePage.travellerSelection).selectByVisibleText("1 room, 2 adults");
        homePage.searchButton.click();*/

    }

}
