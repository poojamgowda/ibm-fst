package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class JavaScriptAlert {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Javascript page$")
    public void javaScript() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @When("^Simple Alert$")
    public void simpleAlert() {
        driver.findElement(By.id("simple")).click();
    }

    @When("^Confirm Alert$")
    public void confirmAlert() {
        driver.findElement(By.id("confirm")).click();
    }

    @When("^Prompt Alert$")
    public void promptAlert() {
        WebElement input = driver.findElement(By.id("prompt"));
        input.click();
    }


    @Then("^To switch Focus to the Alert$")
    public void readConfirm() {
        driver.switchTo().alert();
    }

    @And("^Get Text$")
    public void getText() {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

    }

    @And("^Send Keys$")
    public void sendKeys(){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello!");
    }

    @And("^Accept the Alert$")
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @And("^Closing the JS Browser")
    public void close(){
        driver.quit();
    }
}
