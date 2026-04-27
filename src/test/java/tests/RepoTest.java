package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewRepoPage;
import pages.RepoPage;
import utils.ConfigReader;

public class RepoTest extends BaseTest {

    @Test
    public void repositoryTest() throws InterruptedException {
        HomePage home = new HomePage(driver);

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

        RepoPage repo = new RepoPage(driver);
        repo.clickRepositoriesButton();
        repo.clickNewRepoButton();
        NewRepoPage newRepoPage = new NewRepoPage(driver);
        String repoName = "Selenium_Auto_" + System.currentTimeMillis();
        newRepoPage.createPrivateRepo(repoName, true);
//        newRepoPage.submit_details();
        Assert.assertTrue(
                newRepoPage.isRepoCreated(repoName),
                "Private repository with README enabled was not created"
        );

    }
}