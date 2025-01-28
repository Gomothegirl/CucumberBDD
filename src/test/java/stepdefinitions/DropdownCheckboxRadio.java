package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownCheckboxRadio {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void Teardown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Error during teardown: " + e.getMessage());
        }
    }

    @Given("user is on the home page")
    public void userIsOnTheHomePage() {
        driver.get("https://automationtesting.co.uk/");
        String homepageTitle = driver.getTitle();
        Assert.assertEquals("Homepage", homepageTitle);
    }

    @When("user clicks on Dropdown Checkbox Radio on the menu")
    public void userClicksOnDropdownCheckboxRadioOnTheMenu() {
        driver.findElement(By.xpath("//a[normalize-space()='DropDown Checkbox Radio']")).click();
        String title = driver.getTitle();
        Assert.assertEquals("Dropdown Menus", title);
    }

    @And("user clicks on a radio button")
    public void userClicksOnARadioButton(){
        driver.findElement(By.cssSelector("label[for='demo-priority-low']")).click();
        driver.findElement(By.cssSelector("label[for='demo-priority-normal']")).click();
        driver.findElement(By.cssSelector("label[for='demo-priority-high']")).click();
    }

    @And("user clicks on check boxes")
    public void userClicksOnCheckBoxes(){
        driver.findElement(By.cssSelector("label[for='cb_red']")).isSelected();
        driver.findElement(By.cssSelector("label[for='cb_green']")).isSelected();
        driver.findElement(By.cssSelector("label[for='cb_blue']")).isSelected();
    }

    @And("user can select an item from the dropdown menu")
    public void userCanSelectAnItemFromTheDropdownMenu() {
        Select menuitem = new Select(driver.findElement(By.cssSelector("#cars")));
        menuitem.selectByValue("jeep");
        menuitem.selectByVisibleText("Mercedes");
    }
}
