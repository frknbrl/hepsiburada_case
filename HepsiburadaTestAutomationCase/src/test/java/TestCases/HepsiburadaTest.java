package TestCases;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.nashorn.internal.codegen.ApplySpecialization;
import jdk.nashorn.internal.lookup.MethodHandleFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static java.util.concurrent.TimeUnit.SECONDS;

public class HepsiburadaTest {

    public static WebDriver driver;
    public static String productName;
    public static String quantity;
    public static String price;

    @Given("Go to the {string} url")
    public void openHomePage(String arg0) {
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200, SECONDS);
        driver.manage().window().maximize();
        driver.get(arg0);
        Assert.assertEquals("My Store", driver.getTitle());
    }

    @When("Write to {string} on {string} field")
    public void writeToOnField(String arg0, String arg1) {
        driver.findElement(By.id(arg1)).sendKeys(arg0);
    }

    @When("Click to {string} with xpath")
    public void clickWithXpath(String arg0) {
        driver.findElement(By.xpath(arg0)).click();
    }

    @When("Click to {string} with id")
    public void clickWithId(String arg0) {
        driver.findElement(By.id(arg0)).click();
    }

    @When("Select to {string} from {string} with id")
    public void selectDropDownWithId(String arg0, String arg1) {
        Select dropdown = new Select(driver.findElement(By.id(arg1)));
        dropdown.selectByVisibleText(arg0);
    }

    @When("Select to {string} from {string} with hover")
    public void selectFromDropDownWithHover(String arg0, String arg1) {
        Actions actions = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.xpath(arg1));
        actions.moveToElement(mainMenu);

        WebElement subMenu = driver.findElement(By.xpath(arg0));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }

    @When("Get product name {string}, quantity {string} and price {string}")
    public void getProductDetails(String arg0, String arg1, String arg2) {
        if(!driver.findElements(By.xpath(arg0)).isEmpty()){
            productName = driver.findElement(By.xpath(arg0)).getText();
            quantity = driver.findElement(By.id(arg1)).getAttribute("value");;
            price = driver.findElement(By.id(arg2)).getText();
        }else{ }
    }

    @Then("Check {string} current value and {string} reference value with xpath")
    public void checkCurrentAndReference(String arg0, String arg1) {
        String currentValue = driver.findElement(By.xpath(arg0)).getText();
        Assert.assertEquals(arg1, currentValue);
    }

    @Then("Check {string} actual page title is true")
    public void checkPageTitle(String arg0) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(arg0, actualTitle);
    }

//    @Then("Check product name {string}, quantity {string} and price {string}")
//    public void checkProductDetails(String arg0, String arg1, String arg2) {
    @Then("Check price {string}")
    public void checkProductDetails(String arg0) {
        if(!driver.findElements(By.id("order-detail-content")).isEmpty()){
//            String orderedProductName = driver.findElement(By.xpath(arg0)).getText();
//            String orderedQuantity = driver.findElement(By.xpath(arg1)).getAttribute("value");;
            String orderedPrice = driver.findElement(By.id(arg0)).getText();

//            Assert.assertEquals(productName, orderedProductName);
//            Assert.assertEquals(quantity, orderedQuantity);
            Assert.assertEquals(price, orderedPrice);
        }else{ }
    }

    @Then("Test closure activities")
    public void testClosureActivities() {
        driver.quit();
    }
}
