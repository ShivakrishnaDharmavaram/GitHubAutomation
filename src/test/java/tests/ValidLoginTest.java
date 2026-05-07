
package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidLoginTest extends BaseTest {

    /**
     * NOTE:
     * - Disabled by default due to CAPTCHA / 2FA on GitHub
     */
    @Test(enabled = true)
    public void validLoginTest() {

        // Read credentials from environment variables
        String username = System.getenv("GITHUB_USERNAME");
        String password = System.getenv("GITHUB_PASSWORD");


        if (username == null || password == null) {
            Assert.fail("GitHub credentials are not set in environment variables");
        }

        // Navigate to Login page
        HomePage home = new HomePage(driver);
        home.clickSignIn();

        // Perform Login
        LoginPage login = new LoginPage(driver);
        login.login(username, password);

        // Validation: Profile avatar or dashboard element


        Assert.assertTrue(
                login.isLoginSuccessful(),
                "Valid login failed – profile icon not visible"
        );

//        Assert.assertTrue(loginPage.isLoginSuccessful(), "Valid login failed – profile icon not visible");

    }
}
 