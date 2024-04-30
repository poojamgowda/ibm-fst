import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity14 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        // 2.Get title of the page
        String title = driver.getTitle();
        System.out.println(title);

        // 3. Dynamic attributes for username and password
        WebElement text = driver.findElement(By.cssSelector("input[type='text'][class^='username-']"));
        text.clear();
        String username = "admin";
        text.sendKeys(username);

        WebElement password1 = driver.findElement(By.cssSelector("input[type='password'][class^='password-']"));
        password1.clear();
        String ip = "password";
        password1.sendKeys(ip);

        // 4. Click on login button
        WebElement loginButton = driver.findElement(By.cssSelector("button.ui.button[type='submit']"));
        //System.out.println(loginButton);
        loginButton.click();
        WebElement msg = driver.findElement(By.id("action-confirmation"));
        System.out.println(msg.getText());

        //driver.quit();

    }
}
