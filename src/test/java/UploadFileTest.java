import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadFileTest {
    @Test
    public void uploadFile() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        driver.findElement(By.id("myFile"))
                .sendKeys("C:\\Users\\piotr.keppel\\OneDrive - Soflab Technology Sp. z o.o\\Pulpit\\page\\index.html");
//        Alternatywą może być SykuliX File Upload (http://olyv-qa.blogspot.com/2016/11/using-sikulix-to-handle-file-upload.html)

//        Robienie zrzutu ekranu
        int randomNumber = (int) (Math.random()*1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "Result" + randomNumber + ".png";
        FileUtils.copyFile(srcFile, new File("src/test/screenshots/" + fileName));
    }
}
