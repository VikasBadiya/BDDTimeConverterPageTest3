package stepsdefintions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TimeConversionFunctionalitySteps {
    WebDriver driver;

    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void TearDown(){
        driver.close();
    }


    @Given("I am on the time converter page with the Empty field")
    public void i_am_on_the_time_converter_page_with_the_empty_field() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://qatimeconverter.ccbp.tech/");

    }
    @When("I click the 'Convert to Seconds' button")
    public void i_click_the_button() {
        // Write code here that turns the phrase above into concrete actions

        WebElement ConvertToSecond = driver.findElement(By.id("convertBtn"));
        ConvertToSecond.click();


    }
    @Then("the Converter page should show the Error Message")
    public void the_converter_page_should_show_the_error_message() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMsg")));

        WebElement ErrorMessageText = driver.findElement(By.id("errorMsg"));
        String actualErrorMessage = ErrorMessageText.getText();

        String expectErrorMessage ="Please enter a valid number of hours.";

        Assert.assertEquals(actualErrorMessage,expectErrorMessage,"Error Message Text Mismatch");

    }

    //Test the time converter functionality with empty minutes field

    @Given("I am on the time converter page with Enter the hours")
    public void i_am_on_the_time_converter_page_with_enter_the_hours() {
        driver.get("https://qatimeconverter.ccbp.tech/");
    }
    @When("I am give a hours on input field two")
    public void i_am_give_a_hours_on_input_field_two() {
        WebElement HourInputField = driver.findElement(By.id("inputHours"));
        HourInputField.sendKeys("2");
    }
    @When("After given value I click the 'Convert to Seconds' button")
    public void after_given_value_i_click_the_button() {
        WebElement ConvertToSecond = driver.findElement(By.id("convertBtn"));
        ConvertToSecond.click();

    }
    @Then("the Converter page should show the Error Message two")
    public void the_converter_page_should_show_the_error_message_two() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMsg")));

        WebElement ErrorMessageText = driver.findElement(By.id("errorMsg"));
        String actualErrorMessage = ErrorMessageText.getText();

        String expectErrorMessage ="Please enter a valid number of minutes.";

        Assert.assertEquals(actualErrorMessage,expectErrorMessage,"Error Message Text Mismatch");


    }

    //Test the time converter functionality with valid hours and minutes


    @Given("I am on the time converter page with valid hours and minutes")
    public void i_am_on_the_time_converter_page_with_valid_hours_and_minutes() {
        driver.get("https://qatimeconverter.ccbp.tech/");

    }
    @When("I am give a hours on input field two and minutes on input field as thirty")
    public void i_am_give_a_hours_on_input_field_two_and_minutes_on_input_field_as_thirty() {
        WebElement HourInputField = driver.findElement(By.id("inputHours"));
        HourInputField.sendKeys("2");
        WebElement MinutesInputField = driver.findElement(By.id("inputMinutes"));
        MinutesInputField.sendKeys("30");


    }
    @When("After given two value I click the 'Convert to Seconds' button")
    public void after_given_two_value_i_click_the_button() {
        WebElement ConvertToSecond = driver.findElement(By.id("convertBtn"));
        ConvertToSecond.click();


    }
    @Then("the Converter page should show the Result Text")
    public void the_converter_page_should_show_the_result_text() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timeInSeconds")));

        WebElement ResultText = driver.findElement(By.id("timeInSeconds"));

        String actualResultText = ResultText.getText();
        String expectedResultText ="9000s";

        Assert.assertEquals(actualResultText,expectedResultText,"Result Text  was Mismatch");

    }



}
