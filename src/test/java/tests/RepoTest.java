package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewRepoPage;
import pages.RepoPage;

public class RepoTest extends BaseTest {

    @Test
    public void repositoryTest() throws InterruptedException {
        HomePage home = new HomePage(driver);

        // Read credentials from environment variables
        String username = System.getenv("GITHUB_USERNAME");
        String password = System.getenv("GITHUB_PASSWORD");

        if (username == null || password == null) {
            Assert.fail("GitHub credentials are not set in environment variables");
        }

        // Navigate to Login page
        home.clickSignIn();

        // Perform Login
        LoginPage login = new LoginPage(driver);
        login.login(username, password);

        // Validation: Profile avatar or dashboard element
        Assert.assertTrue(
                login.isLoginSuccessful(),
                "Valid login failed – profile icon not visible"
        );

        RepoPage repo = new RepoPage(driver);
        repo.clickRepositoriesButton();
        repo.clickNewRepoButton();
        NewRepoPage newRepo = new NewRepoPage(driver);
        String repoName = "Selenium_Auto_" + System.currentTimeMillis();
        newRepo.createPrivateRepo(repoName, true);
//      newRepoPage.submit_details();
        Assert.assertTrue(
                newRepo.isRepoCreated(repoName),
                "Private repository with README enabled was not created"
        );
    }
}