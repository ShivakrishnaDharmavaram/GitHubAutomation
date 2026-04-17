package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By signInLink = By.linkText("Sign in");
    By searchBox = By.name("q");
    By termsLink = By.linkText("Terms");
    By privacyLink = By.linkText("Privacy");
//    By repoLink = By.

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickSignIn() {
        driver.findElement(signInLink).click();
    }

    public void searchRepository(String repoName) {
        driver.findElement(searchBox)
                .sendKeys(repoName + Keys.ENTER);
    }

    public void clickTerms() {
        driver.findElement(termsLink).click();
    }

    public void clickPrivacy() {
        driver.findElement(privacyLink).click();
    }
}
