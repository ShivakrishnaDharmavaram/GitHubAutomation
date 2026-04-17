package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewRepoPage {
    WebDriver driver;

    public NewRepoPage(WebDriver driver){
        this.driver = driver;
    }

    By repository_name = By.id("repository-name-input");
    By repo_description = By.cssSelector("input[data-component='input'][name='Description']");
    By submitButton = By.xpath("//span[normalize-space()='Create repository']");
//
    public void enter_new_repo_details(String repo_name, String description){
        driver.findElement(repository_name).sendKeys(repo_name);
        driver.findElement(repo_description).sendKeys(description);
    }

    public void submit_details(){
        driver.findElement(submitButton).click();
    }
;}
