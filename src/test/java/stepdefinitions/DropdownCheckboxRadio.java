package stepdefinitions;

import driver.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownCheckboxRadio {
    WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverManager.getDriver();
    }

    @After
    public void Teardown() {
        WebDriverManager.quitDriver();
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
