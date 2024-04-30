import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class activity16 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/selects");

        // 2.Get title of the page
        String title = driver.getTitle();
        System.out.println(title);

        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select select = new Select(dropdown);
        //Select using visible text
        select.selectByVisibleText("Option 2");
        // Select using index
        select.selectByIndex(3);
        //Select using value
        select.selectByValue("4");

        List<WebElement> options = select.getOptions();
        for(WebElement option : options){
            System.out.println(option.getText());
        }

        //driver.quit();

    }
}
