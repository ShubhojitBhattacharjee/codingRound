package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelBookingPage;

public class HotelBookingTest extends BaseTest {

    @Test
    public void shouldBeAbleToSearchForHotels() {

        reportLogger( "Launched Flight/Hotel booking website" );

        reportLogger( "Click on Hotels Menu" );
        HotelBookingPage hotelBookingPage  = homePage.goToHotels();

        reportLogger( "Enter location of Hotels" );
        hotelBookingPage.enterHotelLocation("Indiranagar, Bangalore");

        reportLogger( "Enter Check In Date as '27-Oct'" );
        reportLogger( "Enter Check Out Date as '28-Oct'" );
        hotelBookingPage.enterCheckInCheckOutDate();

        reportLogger( "Enter rooms and number of travellers" );
        hotelBookingPage.enterRoomTypeAndSearch("1 room, 2 adults");

        reportLogger( "Verify Search Summary Page for Hotels is displayed" );
        Assert.assertTrue(hotelBookingPage.searchSummaryPresent(),
                "Search Summary Page for Hotels is not displayed");
    }

}
