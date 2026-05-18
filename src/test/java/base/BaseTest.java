package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

//    @BeforeMethod
//    public void setup() {
////        ChromeOptions options = new ChromeOptions();
////
////        // ✅ Required for Jenkins / CI
////        options.addArguments("--headless=new");
////        options.addArguments("--no-sandbox");
////        options.addArguments("--disable-dev-shm-usage");
//
////        driver = new ChromeDriver(options);
//
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://github.com/");
//    }

@BeforeMethod
public void setup() {

    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();

//    options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

    options.addArguments("--start-maximized");
    options.addArguments("--disable-blink-features=AutomationControlled");

    driver = new ChromeDriver(options);
    Capabilities caps = ((ChromeDriver) driver).getCapabilities();

    System.out.println(caps.getBrowserVersion());
    System.out.println(caps.getBrowserName());

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://github.com/");
}


    @AfterMethod
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
        driver.quit();
    }
}