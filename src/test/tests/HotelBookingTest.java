package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelBookingPage;

public class HotelBookingTest extends BaseTest {

    @Test
    public void shouldBeAbleToSearchForHotels() {

        HomePage homePage = new HomePage(driver);
        HotelBookingPage hotelBookingPage  = homePage.goToHotels();
        hotelBookingPage.enterHotelLocation("Indiranagar, Bangalore");
        hotelBookingPage.enterCheckInCheckOutDate();
        hotelBookingPage.enterRoomTypeAndSearch("1 room, 2 adults");

        Assert.assertTrue(hotelBookingPage.searchSummaryPresent(),
                "Search Summary Page for Hotels does not display");
    }

}
