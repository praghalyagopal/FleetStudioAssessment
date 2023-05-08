package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {
    private static Helper Helper;
    private static WebDriver driver;
    public final static int TIMEOUT = 10;

    private Helper(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();

    }
    public static void openPage(String url) {
        driver.get(url);
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public static void setUpDriver() {
        if (Helper==null) {
            Helper = new Helper();
        }
    }
    public static String getTitle() {
        return driver.getTitle();
    }
    public static void tearDown() {
        if(driver!=null) {
            driver.close();
            driver.quit();
        }
        Helper = null;
    }
}