package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class AlertsPopups {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @After
    public void Teardown(){
        driver.quit();

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
    public void userCanClosePopupWindow() throws InterruptedException {
String Mainwindow = driver.getWindowHandle();;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterate = handles.iterator();
        while(iterate.hasNext()){
            String child = iterate.next();
            if(!Mainwindow.equalsIgnoreCase(child)){
                driver.switchTo().window(child);
                Thread.sleep(3000);
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
