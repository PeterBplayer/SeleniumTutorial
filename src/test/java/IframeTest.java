import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {

    @Test
    public void testIframe() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");

        // Przejście do iframe'a
        // za pomocą indeksu iframe'a, numerowanego od 0
//        driver.switchTo().frame(0);
        // za pomocą lokalizowania iframe'a na stronie tj. traktowanie go jako Web Element
        WebElement iFrame = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iFrame);
        //za pomocą wartości String UWAGA: iframe musi posiadać atrybut name lub id, który trzeba wprowadzić
        driver.findElement(By.id("fname")).sendKeys("Buba");
        // Cofnięcie do pierwotnego okna
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());


    }
}
