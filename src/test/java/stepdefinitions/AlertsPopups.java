package stepdefinitions;

import driver.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class AlertsPopups {
    WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverManager.getDriver();
    }

    @After
    public void Teardown() {
        WebDriverManager.quitDriver();
    }

    @Given("user is on the popups page")
    public void userIsOnThePopupsPage() {
        driver.get("https://automationtesting.co.uk/popups.html");
    }

    @When("user triggers a popup")
    public void userTriggersAPopup() {
        driver.findElement(By.cssSelector("button[onclick='alertTrigger()']")).click();

    }

    @And("user clicks on ok to accept alert")
    public void userClicksOnOkToAcceptAlert() {
        driver.switchTo().alert().accept();
    }

    @And("user can trigger popup")
    public void userCanTriggerPopup() {
        driver.findElement(By.cssSelector("button[onclick='popup()']")).click();
    }

    @And("user can close popup window")
    public void userCanClosePopupWindow() {
String Mainwindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator <String> iterate = handles.iterator();
        while(iterate.hasNext()){
            String child = iterate.next();
            if(!Mainwindow.equalsIgnoreCase(child)){
                driver.switchTo().window(child);
                driver.close();
            }
        }
        driver.switchTo().window(Mainwindow);
    }

    @Then("user returns to the Alert")
    public void userReturnsToTheAlert() {
        String title = driver.getTitle();
        Assert.assertEquals("Pop Ups", title);

    }
}
