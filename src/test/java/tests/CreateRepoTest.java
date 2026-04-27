package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

import java.util.UUID;

public class CreateRepoTest extends BaseTest {

    @Test
    public void repository_creation_and_rename_test() throws InterruptedException {
        HomePage home = new HomePage(driver);

        // Read credentials from environment variables
        String username = System.getenv("GITHUB_USERNAME");
        String password = System.getenv("GITHUB_PASSWORD");

//        System.out.println("Username: " + username);
//        System.out.println("Password: " + password);


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
        CreateRepository CreateRepo = new CreateRepository(driver);
        String repoName = "Selenium_Automation_" + System.currentTimeMillis();
        String repoRename = "demo-repo-" + UUID.randomUUID().toString().substring(0, 6);
        CreateRepo.createPublicRepo(repoName, false);
//        newRepoPage.submit_details();
        Assert.assertTrue(
                CreateRepo.isRepoCreated(repoName),
                "Public repository with README enabled was not created"
        );

        CreateRepo.renameRepositoryfillDetails(repoRename);
        CreateRepo.renameRepo();

        Assert.assertTrue(
                CreateRepo.isRepoRenamed(repoRename),
                "Repository was not renamed"
        );
    }

    @Test
    public void repository_creation_with_readme_file_on_test() throws InterruptedException {
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
        CreateRepository CreateRepo = new CreateRepository(driver);
        String repoName = "Selenium_Automation_" + System.currentTimeMillis();
        CreateRepo.createPublicRepo(repoName, true);
//        newRepoPage.submit_details();
        Assert.assertTrue(
                CreateRepo.isRepoCreated(repoName),
                "Public repository with README enabled was not created"
        );
    }
}