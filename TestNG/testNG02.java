import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testNG02 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void exampleTestCase1() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals("Target Practice", title);
        //Assert.assertEquals(driver.getTitle(), "Target Practice");
    }

    @Test
    public void exampleTestCase2() {
        WebElement black = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));
        Assert.assertTrue(black.isSelected());
    }

    @Test
    public void exampleTestCase3() {
        WebElement black = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));
        Assert.assertTrue(black.isDisplayed());
        //Assert.assertEquals(driver.getTitle(), "Target Practice");
    }

    @Test(enabled = false)
    public void exampleTestCase4() {
        WebElement blackText = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));
        Assert.assertEquals(blackText.getText(),"Black");
        //Assert.assertEquals(driver.getTitle(), "Target Practice");
    }

    @Test
    public void SkipTest() throws SkipException {
            throw new SkipException("Skipping - This is not ready for testing ");
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}