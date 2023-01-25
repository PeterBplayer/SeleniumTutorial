import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {
    @Test
    public void findElements() {
//        Konfigurowanie, otwieranie przeglądarki i pobranie strony
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

//        Wyszukanie elementu na stronie przy pomocy atrybutu id
        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        Assert.assertEquals(clickOnMeButton.getText(), "Kliknij mnie!");
//        Wyszukanie elementu na stronie przy pomocy atrybutu name
        By firstName = By.name("fname");
        driver.findElement(firstName);// alternatywny zapis driver.findElement(By.name("fname"))
//        Wyszukanie elementu na stronie przy pomocy atrybutu class
        WebElement paraHidden = driver.findElement(By.className("topSecret"));
        Assert.assertFalse(paraHidden.isDisplayed());
//        Wyszukanie elementu na stronie przy pomocy tagu html (zwracanie listy)
        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);//input'ów jest więcej na stronie zostanie zwrócony pierwszy
        input.sendKeys("Pierwszy znaleziony");
        List<WebElement> inputs = driver.findElements(inputLocator);//zwrócone zostaną wszystkie elementy z tagiem o nazwie input
        System.out.println("Ilość input'ów na stronie: " + inputs.size());
//        Wyszukanie elementu na stronie, który jest linkiem
//        Całość tekstu
        By linkText = By.linkText("Visit W3Schools.com!");
        WebElement schoolLink = driver.findElement(linkText);
        Assert.assertEquals(schoolLink.getText(), "Visit W3Schools.com!");
//        Część tekstu
        By partialLink = By.partialLinkText("Visit");
        WebElement schoolPartial = driver.findElement(partialLink);
        Assert.assertEquals(schoolPartial.getText(), "Visit W3Schools.com!");

    }
}
