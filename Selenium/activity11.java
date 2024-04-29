import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity11 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        // 2.Get title of the page
        String title = driver.getTitle();
        System.out.println(title);

        List<WebElement> check = driver.findElements(By.id("dynamicText"));
        System.out.println(check.size());
        boolean textEnabled = driver.findElement(By.id("input-text")).isEnabled();
        System.out.println(textEnabled);

        WebElement toggle = driver.findElement(By.id("toggleInput"));
        toggle.click();
        boolean textEnabled2 = driver.findElement(By.id("input-text")).isEnabled();
        System.out.println(textEnabled2);

        //driver.quit();

    }
}
