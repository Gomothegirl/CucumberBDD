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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactForm {
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
        driver.quit();
    }

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        driver.get("https://automationtesting.co.uk/");
        String homepageTitle = driver.getTitle();
        Assert.assertEquals("Homepage", homepageTitle);
    }

    @When("User clicks on Contact Form from the menu")
    public void user_clicks_on_contact_form_from_the_menu() {
        driver.findElement(By.cssSelector("a[href='contactForm.html']")).click();
        String contactformTitle = driver.getTitle();
        Assert.assertEquals("Contact Form", contactformTitle);

    }


    @And("User enters name {string}")
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
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("A thank you message should be displayed")
    public void aThankYouMessageShouldBeDisplayed() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[contains(text(), 'Thank you')]")));
        assert confirmationMessage.isDisplayed();


    }
}
