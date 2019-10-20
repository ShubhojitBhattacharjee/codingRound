package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class FlightBookingTest extends BaseTest {

    @Test
    public void testThatResultsAppearForAOneWayJourney() {


        HomePage homePage = new HomePage( driver );

        homePage.selectRouteOption();
        homePage.enterOriginPlace("Bangalore");
        homePage.enterDestination("Delhi");
        homePage.departOn("Sun, 27 Oct, 2019");
        homePage.searchFlights();

        Assert.assertTrue(homePage.searchSummaryPresent(),
                "Search Summary Page not displayed");

    }
}
