package elements_exist;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class ElementExistTest {

    WebDriver driver;

    @Test
    public void elementExistTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println("If exist:");
        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        System.out.println("If exist(second method):");
        System.out.println(elementExistSecond(By.tagName("p")));
        System.out.println(elementExistSecond(By.id("topSecret")));

        System.out.println("If is displayed:");
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());

        System.out.println("If is displayed and enabled:");
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("button")).isEnabled());

        System.out.println("Checkbox status:");
        WebElement checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());
    }

    public boolean elementExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean elementExistSecond(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
