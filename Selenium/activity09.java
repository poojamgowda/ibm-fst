import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class activity09 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        // 2.Get title of the page
        String title = driver.getTitle();
        System.out.println(title);

        List<WebElement> check = driver.findElements(By.id("dynamicCheckbox"));
        System.out.println(check.size());
        boolean checkboxes = driver.findElement(By.id("dynamicCheckbox")).isDisplayed();
        System.out.println(checkboxes);

        WebElement toggle = driver.findElement(By.id("toggleCheckbox"));
        toggle.click();
        boolean checkboxes1 = driver.findElement(By.id("dynamicCheckbox")).isDisplayed();
        System.out.println(checkboxes1);

        driver.quit();

    }
}
