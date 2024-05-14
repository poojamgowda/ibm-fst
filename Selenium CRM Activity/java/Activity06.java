import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity06 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");
        WebElement username= driver.findElement(By.id("user_name"));
        username.sendKeys("admin");
        WebElement password=driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");
        WebElement button= driver.findElement(By.id("bigbutton"));
        button.click();
        // Close the browser
        wait.until(ExpectedConditions.urlContains("index.php?module=Home&action=index"));

        driver.findElement(By.id("grouptab_3")).click();

        WebElement dropdownMenu = driver.findElement(By.className("dropdown-menu"));
        List<WebElement> dropdownOptions = dropdownMenu.findElements(By.xpath("//a[starts-with(@id, 'moduleTab')]"));
        for (WebElement option : dropdownOptions) {
            System.out.println(option.getText());
        }

        driver.findElement(By.id("moduleTab_9_Calendar")).click();

        driver.quit();
    }
}