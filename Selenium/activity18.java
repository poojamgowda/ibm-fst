import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity18 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        // 2.Get title of the page
        String title = driver.getTitle();
        System.out.println(title);

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        alert.dismiss();

        driver.quit();

    }
}
