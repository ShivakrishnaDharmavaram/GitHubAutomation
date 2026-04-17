package tests;

import base.BaseTest;
import pages.HomePage;
import pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchRepositoryTest() {
        HomePage home = new HomePage(driver);
        home.searchRepository("TestNGDemo");

        SearchPage search = new SearchPage(driver);
        Assert.assertTrue(search.isSearchResultDisplayed("TestNGDemo"));
    }
}