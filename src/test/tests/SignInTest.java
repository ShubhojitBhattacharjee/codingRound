package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SignInTest extends BaseTest {

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        reportLogger( "Launched Flight/Hotel booking website" );

        reportLogger( "Sign In without entering any credentials" );
        String errorMessage = homePage.invalidSignIn();

        reportLogger( "Verify correct error is displayed when attempting to sign in with blank creadentials" );
        Assert.assertTrue(errorMessage.contains("There were errors in your submission"),
                "Error message do not match");
    }

}
