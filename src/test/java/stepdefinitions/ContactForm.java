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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactForm {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        driver = WebDriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void Teardown() {
        WebDriverManager.quitDriver();
    }

    @Given("User is on the contactform page")
    public void user_is_on_the_contactform_page() {
        driver.get("https://automationtesting.co.uk/contactForm.html");
        String homepageTitle = driver.getTitle();
        Assert.assertEquals("Contact Form", homepageTitle);
    }


    @When("User enters name {string}")
    public void userEntersName(String name) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(name);
    }

    @And("User enters lastname {string}")
    public void userEntersLastname(String lastname) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastname);
    }

    @And("User enters email {string}")
    public void userEntersEmail(String email) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }

    @And("User enters comments {string}")
    public void userEntersComments(String comments) {
        driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(comments);
    }

    @And("User clicks on submit")
    public void userClicksOnSubmit() {
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='SUBMIT']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
    submitButton.click();
    }

    @Then("A thank you message should be displayed")
    public void aThankYouMessageShouldBeDisplayed() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[contains(text(), 'Thank you')]")));
        assert confirmationMessage.isDisplayed();


    }
}
