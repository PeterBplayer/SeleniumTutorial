// WebDriverManager pozwala na pominięcie ręcznego ściągnięcia WebDriverów,
// zostają one wykryte i pobrane automatycznie.
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverManagerTest {
    @Test
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://bonigarcia.dev/webdrivermanager/");
    }
}
