
package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class ValidLoginTest extends BaseTest {

    /**
     * NOTE:
     * - Disabled by default due to CAPTCHA / 2FA on GitHub
     */
    @Test(enabled = true)
    public void validLoginTest() {

        // Read credentials from environment variables
        String username = ConfigReader.getProperty("github.username");
        String password = ConfigReader.getProperty("github.password");


        if (username == null || password == null) {
            Assert.fail("GitHub credentials are not set in environment variables");
        }

        // Navigate to Login page
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();

        // Perform Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Validation: Profile avatar or dashboard element


        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Valid login failed – profile icon not visible"
        );

//        Assert.assertTrue(loginPage.isLoginSuccessful(), "Valid login failed – profile icon not visible");

    }
}
 