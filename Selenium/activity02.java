import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity02 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");

        // 2.Get title of the page
        String title=driver.getTitle();
        System.out.println(title);

        // 3.Locate user and input username as admin
        WebElement text=driver.findElement(By.name("Username"));
        text.clear();
        String username="admin";
        text.sendKeys(username);

        // 4.Locate Password and input password
        WebElement password=driver.findElement(By.name("Password"));
        password.clear();
        String ip="Pooja123";
        password.sendKeys(ip);

        // 5.Locate button and perform click action
        WebElement loginButton = driver.findElement(By.cssSelector("button.ui.button[type='submit']"));
        System.out.println(loginButton);
        loginButton.click();

        //6.Close the browser
        driver.quit();
    }
}