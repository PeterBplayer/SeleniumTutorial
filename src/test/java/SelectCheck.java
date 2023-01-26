import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

// Napisz metodę, która przyjmuje String jako parametr i zwraca typ boolean.
// Metoda sprawdza, czy parametr String jest jedną z opcji w Select.
public class SelectCheck {
    public boolean checkOption(String optionText, WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
           if(option.getText().equals(optionText))
               return true;
        }
        return false;
    }
}
