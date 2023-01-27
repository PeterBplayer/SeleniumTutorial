package actions_on_elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class HoverTest {
    @Test
    public void actions() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

//        Najechanie na element
        Actions actions = new Actions(driver);
        WebElement header = driver.findElement(By.tagName("h1"));
        actions.moveToElement(header).perform();

    }
}
