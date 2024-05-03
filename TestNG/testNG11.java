import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class testNG11 {
    WebDriver driver;

    @BeforeTest
    public void beforeClass() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.switchTo().defaultContent();
    }

    @Test
    public void simple() {
        driver.findElement(By.id("simple")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Reporter.log("Accepting Simple");
    }

    @Test
    public void confirm() {
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Reporter.log("Accepting Confirm");
    }

    @Test
    public void prompt() {
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Hello!");
        Reporter.log("Typing in Hello!");
        alert.accept();
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}