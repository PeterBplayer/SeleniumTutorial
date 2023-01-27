package actions_on_elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BasicsFinalTest {

    @Test
    public void pageElementsTest() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        driver.findElement(By.linkText("Podstawowa strona testowa")).click();

        // Najechanie na element
        Actions actions = new Actions(driver);
        WebElement header = driver.findElement(By.tagName("h1"));
        actions.moveToElement(header).perform();

        // Znajdowanie przycisku "Kliknij mnie!" i obsługa wyskakującego okienka vel alertu
        driver.findElement(By.id("clickOnMe")).click();
        driver.switchTo().alert().accept();

        // Znajdowanie elementu input i wpisanie swojego imienia
        driver.findElement(By.id("fname")).sendKeys("Piotrek");

        // Znajdowanie linku i pobranie opisu linku
        System.out.println(driver.findElement(By.linkText("IamWeirdLink")).getText());

        // Znajdowanie w tabeli wartości: miesiąc i oszczędności
        System.out.println(driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).getText());
        System.out.println(driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText());

        // Znajdowanie listy, a następnie wybranie opcji z listy
        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        cars.selectByVisibleText("Volvo");

        // Znajdowanie checkbox'a i zaznaczenie go
        driver.findElement(By.cssSelector("[type='checkbox']")).click();

        // Znajdowanie radiobutton'a i zaznaczenie go
        driver.findElement(By.cssSelector("[value='other']")).click();
        // Znajdowanie elementu input, wyczyszczenie go i wprowadzenie string
        // następnie kliknięcie ENTER i obsługa wyskakujących alertów
        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.clear();
        userNameInput.sendKeys("admin");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.clear();
        passwordInput.sendKeys("password123");
        System.out.println(userNameInput.getAttribute("value"));
        System.out.println(passwordInput.getAttribute("value"));
        passwordInput.sendKeys(Keys.ENTER);
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        // Pobieranie wartości z ukrytego elementu
        WebElement para = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By attribute text content" + para.getAttribute("textContent"));
        // Otwieranie nowego okna i wyszukanie tam zawartości następnie przełączenie do starego
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();
        Set<String> windowNames = driver.getWindowHandles();
        for (String window : windowNames) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']")).click();
        System.out.println(driver.getCurrentUrl());
        WebElement googleInput = driver.findElement(By.name("q"));
        googleInput.sendKeys("Selenium");
        googleInput.sendKeys(Keys.ENTER);

        // Zrzut ekranu
        int randomNumber = (int) (Math.random() * 1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String firstFileName = "Result" + randomNumber + ".png";
        FileUtils.copyFile(srcFile, new File("src/test/screenshots/" + firstFileName));
        // Powrót na stronę pierwotną
        driver.switchTo().window(currentWindow);
        driver.quit();


    }

}
