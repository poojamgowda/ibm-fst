import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class testNG05 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before Groups");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @BeforeGroups
    public void beforeGroup(){
        System.out.println("Before group");
    }

    @Test
    public void pageTitleTest() {
        System.out.println("Test");
    }

    @AfterClass
    public void afterMethod() {
        System.out.println("After Class");
    }

}