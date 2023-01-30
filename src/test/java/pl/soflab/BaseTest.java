package pl.soflab;

import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite // Uruchamia się przed całym zestawem testów
    public void beforeSuite() {
        System.out.println("Before suite");
    }
    @BeforeClass // Uruchamia się przed klasą testową
    public void beforeClass() {
        System.out.println("Before class");
    }
    @AfterSuite //  Uruchamia się po całym zestawie testów
    public void afterSuite() {
        System.out.println("After suite");
    }
    @AfterClass // Uruchamia się po klasie testowej
    public void AfterClass() {
        System.out.println("After class");
    }
    @BeforeTest // Uruchamia się jednokrotnie przed testami znajdującymi się w danej paczce
    public void beforeTest() {
        System.out.println("I am running before test");
    }
    @BeforeMethod // Uruchamia się przed każdą z metod testowych
    public void beforeMethod() {
        System.out.println("I am running before method");
    }
    @AfterTest // Uruchamia się jednokrotnie po testach znajdującymi się w danej paczce
    public void afterTest() {
        System.out.println("I am running after test");
    }
    @AfterMethod // Uruchamia się po każdej z metod testowych
    public void afterMethod() {
        System.out.println("I am running after method");
    }
}
