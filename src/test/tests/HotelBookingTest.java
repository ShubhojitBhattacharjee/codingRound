package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelBookingPage;

public class HotelBookingTest extends BaseTest {

    public HotelBookingTest() {
        super();
    }

    @Test
    public void shouldBeAbleToSearchForHotels() {

        HomePage homePage = new HomePage(driver);
        HotelBookingPage hotelBookingPage  = homePage.goToHotels();
        hotelBookingPage.searchForHotelsByLocationRoomType("Indiranagar, Bangalore", "1 room, 2 adults");
    }

}
