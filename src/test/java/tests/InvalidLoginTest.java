package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {
        HomePage home = new HomePage(driver);
        home.clickSignIn();

        LoginPage login = new LoginPage(driver);
        login.login("ShivakrishnaDharmavaram", "Dhar1234");

//        Assert.assertTrue(login.getErrorMessage()
//                .contains("Incorrect username or password"));
    }
}