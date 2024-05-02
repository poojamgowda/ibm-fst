import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class testNG08 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        // Set implicit wait to 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://v1.training-support.net/selenium/simple-form");
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "admin1", "k" , "admink@gmail.com", "8798767897"},
                { "admin2", "m" , "adminm@gmail.com", "8798367897"},
                { "admin3", "p" , "adminp@gmail.com", "8798167897"},
        };
    }

    @Test(dataProvider = "Authentication")
    public void testMethod(String firstName, String lastName, String email, String phone) {
        // Statements using parameters from dataProvider
        WebElement text = driver.findElement(By.id("firstName"));
        WebElement text2 = driver.findElement(By.id("lastName"));
        WebElement text3 = driver.findElement(By.id("email"));
        WebElement ph = driver.findElement(By.id("number"));

        text.clear();
        text2.clear();
        text3.clear();
        ph.clear();

        text.sendKeys(firstName);
        text2.sendKeys(lastName);
        text3.sendKeys(email);
        ph.sendKeys(phone);

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[6]/div[1]/input"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @AfterMethod
    public void afterMethod() {
        // Close the browser
        driver.quit();
    }
}
