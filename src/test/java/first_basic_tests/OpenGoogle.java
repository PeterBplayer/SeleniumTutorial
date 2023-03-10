package first_basic_tests;// Stworzenie metody getDriver w której zadaje się nazwę przeglądarki
// W metododzie main wywołanie metody, otwarcie wybraną przeglądarką strony google.com

import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenGoogle {


    public WebDriver getDriver(String browser) throws InvalidArgumentException {
//        Metoda z tutoriala:
        switch (browser) {
            case "chrome":
//                Wskazówka: dodanie pełnej ścieżki to zmienny środowiskowych systemowych Path
//                niweluje potrzebę użycia System.setProperty
//                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                return new ChromeDriver();
            case "firefox":
//                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                return new FirefoxDriver();
            case "edge":
//                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
                return new EdgeDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name.");
        }
//        Moja metoda:
        /*if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            return new FirefoxDriver();
        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
            return new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser name.");
        }*/
    }

    @Test
    public void openGooglePage() {
/*        String[] browserNames = new String[3];
        browserNames[0] = "chrome";
        browserNames[1] = "firefox";
        browserNames[2] = "edge";

        for (int i = 0; i < browserNames.length; i++) {
            WebDriver driver = getDriver(browserNames[i]);
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
        }*/
        WebDriver driver = getDriver("chrome");
        Dimension windowSize = new Dimension(200, 200);
        driver.manage().window().setSize(windowSize);
//        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        // Rożnica między driver.quit() a driver.close(), pokazanie przy pomcy Javascript Executor
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.testeroprogramowania.pl/','blank','height=200,width=200')");
        driver.close(); // zamyka tylko pierwotne okno te otwarte z google.com
        driver.quit(); // zamyka wszystkie okna

    }

}
