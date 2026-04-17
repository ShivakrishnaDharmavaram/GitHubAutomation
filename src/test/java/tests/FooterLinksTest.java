package tests;

import base.BaseTest;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterLinksTest extends BaseTest {

    @Test
    public void verifyFooterLinks() {
        HomePage home = new HomePage(driver);

        home.clickTerms();
        Assert.assertTrue(driver.getTitle().contains("Terms"));

        driver.navigate().back();

        home.clickPrivacy();
        Assert.assertTrue(driver.getTitle().contains("Privacy"));
    }
}