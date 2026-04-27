package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateRepository {

    private WebDriver driver;
    private WebDriverWait wait;

    private By repoName = By.id("repository-name-input");
    private By visibility = By.xpath("//h3[text()='Choose visibility ']/parent::div/following-sibling::div/button");
    private By publicRepo = By.xpath("//span[text()='Public']");
    private By readMeCheckbox = By.xpath("//h3[text()='Add README']/parent::div/following-sibling::div/div[contains(@class,'ToggleSwitch')]");
    private By createRepoBtn = By.xpath("//span[contains(text(),'Create repository')]");

    private By repoTitle = By.xpath("//strong[@itemprop='name']/a");

    private By repoSettings = By.xpath("//a[@data-tab-item='settings']");

    private By repoRename = By.xpath("//input[@id='rename-field']");

    private By repoRenameButton = By.xpath("//button[normalize-space()='Rename']");
    public CreateRepository(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void createPublicRepo(String name, boolean includeReadMe) {
        driver.findElement(repoName).sendKeys(name);
        driver.findElement(visibility).click();
        driver.findElement(publicRepo).click();

        if (includeReadMe) {
            driver.findElement(readMeCheckbox).click();
        }

        driver.findElement(createRepoBtn).click();
    }



    public boolean isRepoCreated(String expectedRepoName) {
        try {
            String actualRepoName =
                    wait.until(ExpectedConditions
                                    .visibilityOfElementLocated(repoTitle))
                            .getText().trim();

            return actualRepoName.equalsIgnoreCase(expectedRepoName);

        } catch (Exception e) {
            return false;
        }

    }

    public void renameRepositoryfillDetails(String name) throws InterruptedException {
        driver.findElement(repoSettings).click();
        driver.findElement(repoRename).clear();
        driver.findElement(repoRename).sendKeys(name);
        driver.findElement(repoRenameButton).click();
        Thread.sleep(4000);
    }

    public void renameRepo(){
        driver.findElement(repoRenameButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isRepoRenamed(String expectedRepoName) {
        try {
            String actualRepoName =
                    wait.until(ExpectedConditions
                                    .visibilityOfElementLocated(repoTitle))
                            .getText().trim();

            return actualRepoName.equalsIgnoreCase(expectedRepoName);

        } catch (Exception e) {
            return false;
        }

    }
}