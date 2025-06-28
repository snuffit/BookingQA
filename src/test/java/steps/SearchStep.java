package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchStep {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Given("booking search page is opened")
    public void bookingSearchPageIsOpened() throws InterruptedException {
        driver.get("https://www.booking.com/searchresults.en-gb.html");
        Thread.sleep(5000);
    }

    @When("user searches for {string}")
    public void userSearchesFor(String hotel) throws InterruptedException {
        driver.findElement(By.name("ss")).sendKeys(hotel);
        driver.findElement(By.xpath(String.format("//ul//*[contains(text(), '%s')]", hotel))).click();
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(5000);
    }

    @Then("{string} hotel is shown")
    public void hotelIsSown(String expectedResult) {
        List<WebElement> titles = driver.findElements(By.cssSelector("[data-testid='title']"));
        boolean isHotelFound = false;
        for (WebElement title : titles) {
            if (title.getText().equals(expectedResult)) {
                isHotelFound = true;
                break;
            }
        }
        assertTrue(isHotelFound);
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
