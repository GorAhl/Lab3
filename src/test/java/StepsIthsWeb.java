import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StepsIthsWeb {

    Duration durationFive = Duration.ofSeconds(5);
    ChromeOptions options = new ChromeOptions()
            .addArguments("--incognito")
            .addArguments("--headless=new");
    WebDriver driver;
    Actions actions;

    @Before
    public void setUp(){
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(durationFive);
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @Given("Iths WebPage is availible")
    public void iths_web_page_is_availible() {
        driver.get("https://www.iths.se/");
        //Click Allow all cookies
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
    }

    @Then("the title should be {string}")
    public void the_title_should_be_correct(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Then("start page should show three buttons with text {string}, {string} och {string}")
    public void start_page_should_show_buttons(String firstButton, String secondButton, String thirdButton) {
        WebElement buttonDivElement = driver.findElement(By.className("hero__cta-row"));
        List<WebElement> buttons = buttonDivElement.findElements(By.className("btn--dark"));
        List<String> buttonsText = new ArrayList<>();
        for (WebElement element : buttons) {
            buttonsText.add(element.getText());
        }

        int expectedNumberOfButtons = 3;
        int actualNumberOfButtons = buttonsText.size();

        assertEquals(expectedNumberOfButtons, actualNumberOfButtons, "Wrong number of buttons");
        assertTrue(buttonsText.contains(firstButton), "The button text " + firstButton + " is missing");
        assertTrue(buttonsText.contains(secondButton), "The button text " + secondButton + " is missing");
        assertTrue(buttonsText.contains(thirdButton), "The button text " + thirdButton + " is missing");
    }

    @When("user clicks Common questions button in header")
    public void user_clicks_common_questions_button_in_header() {
        WebElement headerElement = driver.findElement(By.id("menu-primary-navigation"));
        WebElement headerButton = headerElement.findElement(By.id("nav-hurduansker"));
        actions.moveToElement(headerButton).perform();
        WebElement headerSubButton = headerElement.findElement(By.id("nav-vanligafrgor"));
        headerSubButton.click();
    }

    @Then("user should see a heading {string}")
    public void user_should_see_a_heading(String expectedHeading) {
        String actualHeadingText = driver.findElement(By.tagName("h1")).getText();
        assertEquals(expectedHeading, actualHeadingText);
    }

    @When("user clicks about us button in header")
    public void user_clicks_about_us_button_in_header() {
        WebElement headerElement = driver.findElement(By.id("menu-primary-navigation"));
        WebElement headerButton = headerElement.findElement(By.id("nav-kontakt"));
        actions.moveToElement(headerButton).perform();
        WebElement headerSubButton = headerElement.findElement(By.id("nav-omoss"));
        headerSubButton.click();
    }
    @When("user clicks show {string} employees")
    public void user_clicks_show_all_employees(String filterText) {
        WebElement sectionElement = driver.findElement(By.id("course-filter-bar"));
        WebElement filterButton = sectionElement.findElement(By.xpath("//a[text()='" + filterText + "']"));
        filterButton.click();
    }
    @Then("it should be {int} employees in {string}")
    public void it_should_be_employees(Integer expectedNumberEmployees, String filter) {
        WebElement employees = driver.findElement(By.className("employees"));
        List<WebElement> employeesCards = employees.findElements(By.className("card-employees"));
        int actualNumberEmployees = employeesCards.size();
        assertEquals(expectedNumberEmployees, actualNumberEmployees, "Wrong number of employees in " + filter);
    }

    @When("user clicks on iths logo in header")
    public void user_clicks_one_iths_logo_in_header() {
        WebElement logoElement = driver.findElement(By.className("brand"));
        logoElement.click();
    }

    @When("user clicks on Hem in breadcrumbs")
    public void user_clicks_one_hem_in_breadcrumbs() {
            WebElement breadcrumbs = driver.findElement(By.className("breadcrumbs"));
            WebElement hemCrumbs = breadcrumbs.findElement(By.xpath("//a[text()='Hem']"));
            hemCrumbs.click();
    }

    @Then("the last breadcrumbs should be {string}")
    public void the_last_breadcrumbs_should_be(String expectedCrumbsText) {
        WebElement breadcrumbs = driver.findElement(By.className("breadcrumbs"));
        WebElement currentCrumbs = breadcrumbs.findElement(By.className("current"));
        String actualCurrentCrumbsText = currentCrumbs.getText();
        assertEquals(expectedCrumbsText, actualCurrentCrumbsText);
    }

    @When("user clicks openHouse button in header")
    public void user_clicks_openHouse_button_in_header() {
        WebElement headerElement = driver.findElement(By.id("menu-primary-navigation"));
        WebElement headerButton = headerElement.findElement(By.id("nav-frstuderande"));
        actions.moveToElement(headerButton).perform();
        WebElement subHeaderElement = headerElement.findElement(By.id("nav-ppethus"));
        subHeaderElement.click();
    }


    @Then("it will be successful")
    public void it_will_be_successful() {
        Assertions.assertTrue(false);
    }

    @After
    public void quitDriver(){
        if(driver != null) {
            driver.quit();
        }
    }
}
