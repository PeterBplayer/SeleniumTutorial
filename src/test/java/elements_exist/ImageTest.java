package elements_exist;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageTest {

    WebDriver driver;

    @Test
    public void imageTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        driver.get("https://testeroprogramowania.github.io/selenium/image.html");
        WebElement imageSecond = driver.findElement(By.tagName("img"));
        String height = imageSecond.getAttribute("naturalHeight");
        Assert.assertEquals(height, "0");

    }
}
