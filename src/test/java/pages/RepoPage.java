package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RepoPage {

    WebDriver driver;

    public RepoPage(WebDriver driver) {
        this.driver = driver;
    }

    By repoButton = By.cssSelector("svg.octicon-repo");
    By newRepoButton = By.linkText("New repository");

    // 3. To Click: Use Actions class for better stability with SVG shapes
//    Actions actions = new Actions(driver);
//    actions.moveToElement(svgElement).click().build().perform();

    public void clickRepositoriesButton() {
        driver.findElement(repoButton).click();
    }

    public void clickNewRepoButton(){
        driver.findElement(newRepoButton).click();
    }

}

