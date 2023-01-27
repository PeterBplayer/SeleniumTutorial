import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

// Obsługa nowo otwartego okna
public class NewWindowTest {
    @Test
    public void testNewWindow() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        driver.findElement(By.linkText("Podstawowa strona testowa")).click();
//        Pobranie nazwy obecnego okna
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();
//        Pobranie zbioru wszystkich okien
        Set<String> windowNames = driver.getWindowHandles();
//        Przejście po zbiorze i znalezienie nowego okna poprzez
//        warunek (if), gdy element zbioru nie jest równy obecnemu oknu (currentWindow) to przełączenie na nowe
        for (String window : windowNames) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
//        Akceptacja wyskakującego komunikatu i wpisanie w wyszukiwarkę hasła "Selenium"
        driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']")).click();
        driver.findElement(By.name("q")).sendKeys("Selenium");
//        Przełączenie do pierwotnego okna
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Harry");

    }
}
