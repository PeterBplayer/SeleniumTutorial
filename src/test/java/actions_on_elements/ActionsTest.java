package actions_on_elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class ActionsTest {
    @Test
    public void actions() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

//        Kliknięcie prawym przyciskiem myszy
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();
//        Podwójne kliknięcie
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");
        actions.doubleClick(driver.findElement(By.id("bottom"))).perform();

    }
}
