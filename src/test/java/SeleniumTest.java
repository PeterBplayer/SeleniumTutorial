import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage() {
//        Otwieranie strony google.com za pomocą Chrome'a
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com/");
        chromeDriver.close();

//        Otwieranie strony google.com za pomocą Firefox'a
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.google.com/");
        firefoxDriver.close();

//        Otwieranie strony google.com za pomocą Edge'a
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://www.google.com/");
        edgeDriver.close();

    }

}
