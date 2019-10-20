package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SignInTest extends BaseTest {

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        HomePage homePage = new HomePage(driver);

        String errorMessage = homePage.invalidSignIn();

        Assert.assertTrue(errorMessage.contains("There were errors in your submission"),
                "Error message do not match");
    }

}
