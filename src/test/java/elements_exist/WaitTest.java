package elements_exist;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitTest {

    WebDriver driver;

    @Test
    public void waitForElement() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        zastosowanie dla całego skryptu, odpytuje o element zadaną ilość czasu
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

//        Thread.sleep(5000);
//        najmniej fajna metoda, mało elastyczna, to jest po prostu zatrzymanie wykonywania kodu na określony czas

        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));*/

        FluentWait<WebDriver> wait = new FluentWait<>(driver);// FluentWait domyślnie nie ignoruje żadnego wyjątku,
        // WebDriverWait już tak
        wait.ignoring(NoSuchElementException.class); // ignorowanie wyjątku przez zadany czas
        wait.withTimeout(Duration.ofSeconds(10)); // zadany czas oczekiwania
        wait.pollingEvery(Duration.ofSeconds(1)); //  zadany interwał, odpytywanie co określony czas
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p"))); // lepiej przekazywać lokator, a nie WebElement


        waitForElementToExist(By.cssSelector("p"));
    }

    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        /*wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> elements = driver.findElements(locator);
                if (elements.size() > 0) {
                    System.out.println("Element is visible");
                    return true;
                } else {
                    System.out.println("There is no such element");
                    return false;
                }
            }
        });*/

//        Alternatywny zapisy przy pomocy wyrażenia lambda
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
}
