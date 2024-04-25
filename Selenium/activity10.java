import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity10 {
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
        boolean checkboxes = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/input")).isSelected();
        System.out.println(checkboxes);

        WebElement toggle = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/input"));
        toggle.click();
        boolean checkboxes1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/input")).isSelected();
        System.out.println(checkboxes1);

        driver.quit();

    }
}
