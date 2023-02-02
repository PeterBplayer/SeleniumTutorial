package actions_on_elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class AnnotationsTest {
    @FindBys({ // UWAGA: Kolejność ma znaczenie! To zwróci dwa elementy "th", bo najpierw szuka znacznika "table",
            // a następnie w nim wszystkich "th" zawartych w "table"
            @FindBy(tagName = "table"),
            @FindBy(tagName = "th"),
    })
    List<WebElement> elements;
    @FindAll({ //  UWAGA: Znajduje i zwraca wszystkie elementy
            @FindBy(tagName = "table"),
            @FindBy(tagName = "th"),
    })
    List<WebElement> elements1;


    @Test
    public void performAction() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://testeroprogramowania.github.io/selenium/");

//        Przejście na stronę "Podstawowa strona testowa"
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText());
        basicPageLink.click();
        System.out.println(elements.size());
        System.out.println(elements1.size());




    }
}
