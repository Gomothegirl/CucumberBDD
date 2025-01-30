package stepdefinitions;

import driver.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Accordion {
    WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverManager.getDriver();
    }

    @After
    public void Teardown() {
        WebDriverManager.quitDriver();
    }

    @Given("user is on the accordion page")
    public void userIsOnTheAccordionPage() {
        driver.get("https://automationtesting.co.uk/accordion.html");
    }

    @When("user clicks on the accordion items")
    public void userClicksOnTheAccordionItems() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.xpath("//div[normalize-space()='Platform Portability']")).click();
            driver.findElement(By.xpath("//div[normalize-space()='Language Support']")).click();
            driver.findElement(By.xpath("//div[normalize-space()='Selenium Grid']")).click();

        }
    }

    @Then("accordion items should display")
    public void accordionItemsShouldDisplay() {
        driver.findElement(By.cssSelector("#content")).isDisplayed();
    }
}
