import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity13 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        // 1.Open the browser
        driver.get("https://v1.training-support.net/selenium/tables");

        // 2.Get title of the page
        String title = driver.getTitle();
        System.out.println(title);

        WebElement table1=driver.findElement(By.id("sortableTable"));
        List<WebElement> rows = table1.findElements(By.xpath(".//tbody/tr"));
        System.out.println(rows.size());

        List<WebElement> cols = table1.findElements(By.xpath(".//thead/tr/th"));
        System.out.println("Columns in header : "+cols.size());

        List<WebElement> firstRowCols = table1.findElements(By.xpath(".//tbody/tr[1]/td"));
        System.out.println("Columns in body : "+firstRowCols.size());

        List<WebElement> cols22 = table1.findElements(By.xpath(".//tbody/tr[2]/td[2]"));
        for (WebElement element : cols22) {
            System.out.println(element.getText());
        }

        WebElement toggle = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/thead/tr/th[1]"));
        toggle.click();
        List<WebElement> cols2 = table1.findElements(By.xpath(".//tbody/tr[2]/td[2]"));
        for (WebElement element : cols2) {
            System.out.println(element.getText());
        }

        List<WebElement> footer = table1.findElements(By.xpath(".//tfoot/tr/th"));
        for (WebElement element : footer) {
            System.out.println(element.getText());
        }

        //driver.quit();

    }
}
