
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testNG04 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void pageTitleTest() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals("Target Practice", title);
        //Assert.assertEquals(driver.getTitle(), "Target Practice");
    }

    @Test (groups = {"HeaderTests"})
    public void testCase2() {
        WebElement third = driver.findElement(By.id("third-header"));
        Assert.assertEquals("Third header",third.getText());
        WebElement fifth = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        Assert.assertEquals("rgb(33, 186, 69)",fifth.getCssValue("Color"));
    }

    @Test (groups = {"ButtonTests"})
    public void testCase3() {
        WebElement third = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/button[4]"));
        Assert.assertEquals("Olive",third.getText());
        WebElement fifth = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[1]"));
        //Assert.assertEquals("ui brown button",fifth.getAttribute("class"));
        Assert.assertEquals("rgb(255, 255, 255)",fifth.getCssValue("Color"));
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}