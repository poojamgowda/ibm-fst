package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GooglesearchSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Google Home Page$")
    public void googlePage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.google.com/");
    }

    @When("^User types in Cheese and hits ENTER$")
    public void main() {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        search.sendKeys("cheese");
        WebElement btn = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        btn.click();
    }


    @Then("^Show how many search results were shown$")
    public void showHowManySearchResultsWereShown() {
        WebElement result = driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
        System.out.println(result.getText());
    }

    @And("^Close the browser$")
    public void closeTheBrowser() {
        driver.quit();
    }


}