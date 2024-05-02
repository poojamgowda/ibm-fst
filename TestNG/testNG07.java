import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.DataProvider;


public class testNG07 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "admin", "password" },
                { "admin2", "Test@456" }
        };
    }

    // Here we are calling the Data Provider object with its name
    @Test(dataProvider = "Authentication")
    public void testMethod(String username, String password) {
        //Statements using parameters from dataProvider
        WebElement text=driver.findElement(By.name("Username"));
        WebElement pass=driver.findElement(By.name("Password"));
        Assert.assertTrue(text.isEnabled());
        Assert.assertTrue(pass.isEnabled());

        text.clear();
        pass.clear();

        text.sendKeys(username);
        pass.sendKeys(password);
        WebElement loginButton = driver.findElement(By.cssSelector("button.ui.button[type='submit']"));
        loginButton.click();

    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        //driver.quit();
    }

}