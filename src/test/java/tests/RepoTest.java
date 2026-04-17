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
    public void repositoryTest() {
        HomePage home = new HomePage(driver);
        home.clickSignIn();
        LoginPage login = new LoginPage(driver);
        login.login("ShivakrishnaDharmavaram", "Dharmavaram@316");
        RepoPage repo = new RepoPage(driver);
        repo.clickRepositoriesButton();
        repo.clickNewRepoButton();
        NewRepoPage newRepoPage = new NewRepoPage(driver);
        newRepoPage.enter_new_repo_details("Selenium_Automation_Test", "test");
        newRepoPage.submit_details();
    }
}