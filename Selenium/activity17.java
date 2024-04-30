import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class activity17 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/selects");

        // 2.Get title of the page
        String title = driver.getTitle();
        System.out.println(title);

        WebElement dropdown = driver.findElement(By.id("multi-select"));
        Select select = new Select(dropdown);
        //Select using visible text
        select.selectByVisibleText("Javascript");
        // Select using index
        select.selectByIndex(4);
        select.selectByIndex(5);
        select.selectByIndex(6);
        //Select using value
        select.selectByValue("node");

        //deselect
        select.deselectByIndex(5);

        List<WebElement> options = select.getAllSelectedOptions();
        for(WebElement option:options) {
            System.out.println("SELECTED OPTIONS ARE : "+ option.getText());
        }

        //driver.quit();

    }
}
