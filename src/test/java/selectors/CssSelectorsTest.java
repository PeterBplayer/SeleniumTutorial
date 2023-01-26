package selectors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class CssSelectorsTest {

    @Test
    public void findElements() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        List<WebElement> inputs = driver.findElements(cssTag);
        System.out.println("Number of inputs: " + inputs);

        By cssName = By.cssSelector("[name='fname']");// [class='topSecret']
        driver.findElement(cssName);

        By all = By.cssSelector("*"); // znalezienie wszystkich elementów html na stronie
        driver.findElements(all);

        By ulInDiv = By.cssSelector("div ul"); // znajdzie dwie listy znajdujące się wewnątrz tagu div
        By trInTable = By.cssSelector("table tr"); // znajdzie wszystkie wiersze wewnątrz tagu table
        By trInBody = By.cssSelector("tbody tr"); // znajdzie wszystkie elementy wewnątrz tagu tbody
        driver.findElements(ulInDiv);
        driver.findElements(trInTable);
        driver.findElements(trInBody);

        By firstChildUlInDiv = By.cssSelector("div > ul");
        By firstChildTrInTbody = By.cssSelector("tbody > tr");
        driver.findElement(firstChildUlInDiv);
        driver.findElement(firstChildTrInTbody);

        By firstFormAfterLabel = By.cssSelector("label + form");
        By allFormsAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(firstFormAfterLabel);
        driver.findElements(allFormsAfterLabel);

        By attrTag = By.cssSelector("input[name='fname']");
        By attrContains = By.cssSelector("name*='name'");
        By attrStarts = By.cssSelector("[name^='f']");
        By attrEnds = By.cssSelector("name$='me'");
        driver.findElement(attrTag);
        driver.findElements(attrContains);
        driver.findElements(attrStarts);
        driver.findElements(attrEnds);

        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By secondChild = By.cssSelector("li:nth-child(2)");
        By thirdChild = By.cssSelector("li:nth-child(3)");
        driver.findElements(firstChild);
        driver.findElements(lastChild);
        driver.findElement(secondChild);
        driver.findElement(thirdChild);

    }
}
