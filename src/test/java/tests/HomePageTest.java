package tests;

import base.BaseTest;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageTitle() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.getTitle().contains("GitHub"));

    }
}