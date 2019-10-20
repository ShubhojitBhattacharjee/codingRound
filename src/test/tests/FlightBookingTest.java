package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class FlightBookingTest extends BaseTest {

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        reportLogger( "Launched Flight/Hotel booking website" );

        reportLogger( "Select route Option" );
        homePage.selectRouteOption();

        reportLogger( "Enter Origin Place" );
        homePage.enterOriginPlace("Bangalore");

        reportLogger( "Enter Destination" );
        homePage.enterDestination("Delhi");

        reportLogger( "Select Departure Date" );
        homePage.departOn("Sun, 27 Oct, 2019");

        reportLogger( "Search for flights w.r.t entered Origin, Destination and Departure Date" );
        homePage.searchFlights();

        reportLogger( "Verify Search Summary Page for Flights is displayed" );
        Assert.assertTrue(homePage.searchSummaryPresent(),
                "Search Summary Page not displayed");

    }
}
