package actions_on_elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {
    @Test
    public void performAction() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

//        Przejście na stronę "Podstawowa strona testowa"
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText());
        basicPageLink.click();

//        Znajdowanie przycisku "Kliknij mnie!" i obsługa wyskakującego okienka vel alertu
        driver.findElement(By.id("clickOnMe")).click();
        driver.switchTo().alert().accept();

//        Znajdowanie elementu input i wpisanie swojego imienia
        driver.findElement(By.id("fname")).sendKeys("Piotrek");

//        Znajdowanie elementu input wyczyszczenie zawartości i wpisanie słowa admin,
//        a następnie pobranie wpisanej zawartości i kliknięcie ENTER
        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.clear();
        userNameInput.sendKeys("admin");
        System.out.println(userNameInput.getAttribute("value"));
        userNameInput.sendKeys(Keys.ENTER);
//        Obsługa pierwszego alertu po naciśnięcie ENTER
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
//        Obsługa drugiego alertu
        driver.switchTo().alert().accept();


//        Znajdowanie checkbox'a i zaznaczenie go
        driver.findElement(By.cssSelector("[type='checkbox']")).click();
//        Znajdowanie radiobutton'a i zaznaczenie go
        driver.findElement(By.cssSelector("[value='male']")).click();


//        Znajdowanie listy, a następnie wybranie opcji z listy
        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
//        Wybranie za pomocą nr indeksu na liście
        cars.selectByIndex(0);
//        Wybranie za pomocą widocznej zawartości na liście
        cars.selectByVisibleText("Saab");
//        Wybranie za pomocą wartości atrybutu znacznika html
        cars.selectByValue("mercedes");
//        Pobranie listy, a następnie przeiterowanie jej zawartości
        List<WebElement> carsOptions = cars.getOptions();
        for (WebElement option : carsOptions) {
            System.out.println(option.getText());
        }
//        Pobranie zawartości listy, a następnie sprawdzenie, czy dany element znajduje się na liście
        SelectCheck selectCheck = new SelectCheck();
        System.out.println(selectCheck.checkOption("Audi", selectCar));
        System.out.println(selectCheck.checkOption("Jeep", selectCar));

//        Pobieranie wartości z ukrytego elementu
        WebElement para = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By attribute text content" + para.getAttribute("textContent"));

    }
}
