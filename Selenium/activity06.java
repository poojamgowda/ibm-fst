import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity06 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        String title= driver.getTitle();
        System.out.println(title);
        // Create an Actions object
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();
        String dropped=droppable.getText();
        System.out.println(dropped);

        WebElement draggable2 = driver.findElement(By.id("droppable"));
        WebElement droppable2 = driver.findElement(By.id("dropzone2"));
        new Actions(driver)
                .dragAndDrop(draggable2, droppable2)
                .perform();
        String dropped2=droppable2.getText();
        System.out.println(dropped2);
        //driver.quit();
    }
}

