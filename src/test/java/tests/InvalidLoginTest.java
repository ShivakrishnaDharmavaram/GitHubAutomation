package tests;

import base.BaseTest;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {
        HomePage home = new HomePage(driver);
        home.clickSignIn();

        LoginPage login = new LoginPage(driver);
        String username = System.getenv("GITHUB_USERNAME");
        String password = System.getenv("GITHUB_PASSWORD_TWO");
        login.login(username, password);

        Assert.assertTrue(login.getErrorMessage()
                .contains("Incorrect username or password"));
    }
}
