package pl.soflab;

import org.testng.annotations.Test;

public class ThirdTest extends BaseTest{
    @Test(priority = 0)
    public void firstTest() {
        System.out.println("I am 1st test");
    }
    @Test(priority = 2)
    public void secondTest() {
        System.out.println("I am 2nd test");
    }
    @Test(priority = 1)
    public void thirdTest() {
        System.out.println("I am 3rd test");
    }
}
