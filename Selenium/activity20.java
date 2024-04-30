import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class activity20 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/tab-opener");

        // 2.Get title of the page
        String title = driver.getTitle();
        System.out.println(title);

        WebElement tab =  driver.findElement(By.id("launcher"));
        tab.click();

        Set<String> handles = driver.getWindowHandles();
        System.out.println("Window handles : ");
        for(String handle : handles){
            System.out.println(handle);
        }

        driver.get("https://v1.training-support.net/selenium/newtab");
        String title2= driver.getTitle();
        System.out.println(title2);
        WebElement tab2 =  driver.findElement(By.id("actionButton"));
        tab2.click();

        driver.get("https://v1.training-support.net/selenium/newtab2");
        String title3= driver.getTitle();
        System.out.println(title3);

        //driver.quit();

    }
}
