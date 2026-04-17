package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchResultDisplayed(String text) {
        return driver.findElement(By.tagName("body"))
                .getText()
                .contains(text);
    }
}