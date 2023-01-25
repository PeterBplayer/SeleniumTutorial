package first_basic_tests;// WebDriverManager pozwala na pominięcie ręcznego ściągnięcia WebDriverów,
// zostają one wykryte i pobrane automatycznie.
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverManagerTest {
    @Test
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT); // Akceptowanie wyskakujących okienek
        WebDriver driver = new ChromeDriver(chromeOptions);
//        Dodane wyskakującego do symulacji za pomocą JavaScript Executor
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("alert('Hello')");
        driver.get("https://bonigarcia.dev/webdrivermanager/");
    }
}
