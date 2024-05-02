import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testNG03 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    public void exampleTestCase1() {
        WebElement text=driver.findElement(By.name("Username"));
        WebElement password=driver.findElement(By.name("Password"));
        Assert.assertTrue(text.isEnabled());
        Assert.assertTrue(password.isEnabled());

        text.sendKeys("admin");
        password.sendKeys("password");
    }

    @Test
    public void exampleTestCase2() {
        WebElement loginButton = driver.findElement(By.cssSelector("button.ui.button[type='submit']"));
        loginButton.click();
        WebElement msg = driver.findElement(By.id("action-confirmation"));
        Assert.assertEquals("Welcome Back, admin",msg.getText());
    }



    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}