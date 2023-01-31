package pl.soflab;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// UWAGA: zależności nie są dobrą praktyką, każdy test powinien być niezależny.
public class FourthTest extends BaseTest {
    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][]{{"I am first test"}, {"I am second test"}, {"I am third test"}};
    }

    @Test(dependsOnMethods = {"thirdTest"})
    public void firstTest() {
        System.out.println("I am 1st test");
    }

    @Test(dependsOnMethods = {"firstTest"})
    public void secondTest() {
        System.out.println("I am 2nd test");
    }

    @Test
    public void thirdTest() {
        System.out.println("I am 3rd test");
    }

    @Test(dataProvider = "data")
    public void dataProviderTest(String value) {
        System.out.println(value);
    }
}
