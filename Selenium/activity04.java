import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity04 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/input-events");

        // 2.Get title of the page
        String title=driver.getTitle();
        System.out.println(title);

//        WebElement leftClick = driver.findElement(By.id("wrapD3Cube"));
//        Actions actions = new Actions(driver);
//        actions.click(leftClick).build().perform();
//        WebElement sc = driver.findElement(By.className("active"));
//        String vsc=sc.getText();
//        System.out.println(vsc);
        WebElement leftClick = driver.findElement(By.id("wrapD3Cube"));
        new Actions(driver)
                .click(leftClick)
                .perform();
        WebElement sc = driver.findElement(By.className("active"));
        String vsc=sc.getText();
        System.out.println(vsc);

        WebElement doubleClick = driver.findElement(By.id("wrapD3Cube"));
        new Actions(driver)
                .doubleClick(doubleClick)
                .perform();
        WebElement dc = driver.findElement(By.className("active"));
        String vdc=dc.getText();
        System.out.println(vdc);

        WebElement clickable = driver.findElement(By.id("wrapD3Cube"));
        new Actions(driver)
                .contextClick(clickable)
                .perform();
        WebElement rc = driver.findElement(By.className("active"));
        String vrc=rc.getText();
        System.out.println(vrc);

        //6.Close the browser
        //driver.quit();
    }


}