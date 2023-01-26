package selectors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {
    @Test
    public void findElements() {
//        Konfigurowanie, otwieranie przeglądarki i pobranie strony
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

//        Wyszukanie elementów za pomocą pełnej ścieżki xpath
        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElements(fullPath);
//        Wyszukanie elementów za pomocą skróconej ścieżki xpath
        By shortPath = By.xpath("//ul");
        driver.findElements(shortPath);
//        Wyszukanie elementu na stronie przy pomocy atrybutu id
        By buttonId = By.xpath("//button[@id='clickOnMe']");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        Assert.assertEquals(clickOnMeButton.getText(), "Kliknij mnie!");
//        Wyszukanie elementu na stronie przy pomocy atrybutu name
        By firstName = By.xpath("//input[@name='fname']");
        driver.findElement(firstName);// alternatywny zapis driver.findElement(By.xpath("//input[@name='fname']"))
//        Wyszukanie elementu na stronie przy pomocy atrybutu class
        WebElement paraHidden = driver.findElement(By.xpath("//p[@class='topSecret']"));
        Assert.assertFalse(paraHidden.isDisplayed());
//        Wyszukanie elementu na stronie przy pomocy tagu html (zwracanie listy)
        By inputLocator = By.xpath("//input");
        WebElement input = driver.findElement(inputLocator);//input'ów jest więcej na stronie zostanie zwrócony pierwszy
        input.sendKeys("Pierwszy znaleziony");
        List<WebElement> inputs = driver.findElements(inputLocator);//zwrócone zostaną wszystkie elementy z tagiem o nazwie input
        System.out.println("Ilość input'ów na stronie: " + inputs.size());
//        Wyszukanie elementu na stronie, który jest linkiem
//        Całość tekstu
        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement schoolLink = driver.findElement(linkText);
        Assert.assertEquals(schoolLink.getText(), "Visit W3Schools.com!");
//        Część tekstu
        By partialLink = By.xpath("//a[contains(text(),'Visit')]");
        WebElement schoolPartial = driver.findElement(partialLink);
        Assert.assertEquals(schoolPartial.getText(), "Visit W3Schools.com!");
//        Znalezienie wszystkich elementów na stronie
        By all = By.xpath("//*");
        driver.findElements(all);

        By secondInputElement = By.xpath("(//input)[2]");
        driver.findElement(secondInputElement);

        By lastInputElement = By.xpath("(//input)[last()]");
        driver.findElement(lastInputElement);

        By elementsWithAttribute = By.xpath("//*[@name]");
        driver.findElements(elementsWithAttribute);

        By attrEq = By.xpath("//button[@id='clickOnMe']");
        By attrNotEq = By.xpath("//button[@id!='clickOnMe']");
        By attrCont = By.xpath("//*[contains(@name,'ame')]");
        By startsWith = By.xpath("//*[starts-with(@name,'user')]");
        By endsWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('ame')+1)='ame']");
        driver.findElement(attrEq);
        driver.findElement(attrNotEq);
        driver.findElement(attrCont);
        driver.findElement(startsWith);
        driver.findElement(endsWith);

        By child = By.xpath("//div/child::ul");
        By desc = By.xpath("//div/descendant::*");// "//div/descendant::ul"
        By parent = By.xpath("//div/..");
        By grandParent = By.xpath("//div/../..");
        By asc = By.xpath("//div/ancestor::*");// "//div/ancestor::body"
        By foll = By.xpath("//img/following::*");
        By follSibling = By.xpath("//img/following-sibling::*");
        By prec = By.xpath("//img/preceding::*");
        By precSibling = By.xpath("//img/preceding-sibling::*");
        driver.findElement(child);
        driver.findElement(desc);
        driver.findElement(parent);
        driver.findElement(grandParent);
        driver.findElement(asc);
        driver.findElement(foll);
        driver.findElement(follSibling);
        driver.findElement(prec);
        driver.findElement(precSibling);

        By linksAndDivs = By.xpath("//a | //div");
        By andOperator = By.xpath("//input[@name='fname' and @id='fname']");
        By orOperator = By.xpath("//input[@name='fname' or @id='fname']");
        driver.findElement(linksAndDivs);
        driver.findElement(andOperator);
        driver.findElement(orOperator);


    }
}
