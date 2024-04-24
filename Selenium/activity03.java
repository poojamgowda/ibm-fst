import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity03 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/target-practice");

        // 2.Get title of the page
        String title=driver.getTitle();
        System.out.println(title);

        //3.Using xpath find 3rd and 5th header on the path and print its text
        WebElement h3= driver.findElement(By.xpath("//*[@id=\"third-header\"]"));
        String thirdHeader= h3.getText();
        System.out.println(thirdHeader);

        WebElement h5= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        String fifthHeader= h5.getCssValue("color");
        System.out.println(fifthHeader);
        String hexColor = rgbToHex(fifthHeader);
        System.out.println("Hexadecimal representation: " + hexColor);

        // 4.Find violet button and its classes
        WebElement violetButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/button[3]"));
        String classes = violetButton.getAttribute("class");
        System.out.println(classes);

        // 5.Find text grey
        WebElement greyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        String textDisplay = greyButton.getText();
        System.out.println(textDisplay);

        //6.Close the browser
        //driver.quit();
    }

    public static String rgbToHex(String rgb) {
        String[] parts = rgb.replace("rgb(", "").replace(")", "").split(",");
        int r = Integer.parseInt(parts[0].trim());
        int g = Integer.parseInt(parts[1].trim());
        int b = Integer.parseInt(parts[2].trim());

        String hex = String.format("#%02x%02x%02x", r, g, b);
        return hex.toUpperCase();
    }
}