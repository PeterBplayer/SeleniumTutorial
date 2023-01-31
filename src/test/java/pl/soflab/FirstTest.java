package pl.soflab;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

@Listeners(value = {SampleTestListener.class})
public class FirstTest extends BaseTest {

    WebDriver driver;

    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("Element is visible");
                return true;
            } else {
                System.out.println("There is no such element");
                return false;
            }

        });
    }

    @Test
    public void firstTest() {
        driver = DriverFactory.getDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        waitForElementToExist(By.cssSelector("p"));
        WebElement para = driver.findElement(By.cssSelector("p"));
        //Asercje twarde- jak failują to przerywają wykonywanie kodu
        Assert.assertTrue(para.isDisplayed(), "Element się nie wyświetla");
        Assert.assertTrue(para.getText().startsWith("Dopiero"));
        Assert.assertFalse(para.getText().startsWith("Pojawiłem"));
        Assert.assertEquals(para.getText(), "Dopiero się pojawiłem!", "Teksty są różne");
        driver.quit();
    }

    @Test
    @Ignore
    public void secondTest() {
        driver = DriverFactory.getDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        waitForElementToExist(By.cssSelector("p"));
        WebElement para = driver.findElement(By.cssSelector("p"));

//        Soft Assert- pozwala na dalsze wykonanie kodu mimo failu danej asercji
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(para.isDisplayed(), "Element się nie wyświetla");
        softAssert.assertTrue(para.getText().startsWith("Dopiero"));
        softAssert.assertFalse(para.getText().startsWith("Pojawiłem"));
        softAssert.assertEquals(para.getText(), "Dopiero się pojawiłem", "Teksty są różne");

        driver.quit();
        softAssert.assertAll();
    }


}
