package Day11_040123;

import ReusabkeLibray.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T1_GoogleSeachTESTNG {
    // to make a variable global you need to declare outside of annotation methods
    WebDriver driver;
    //create befor suite
    @BeforeSuite
    public void setupdriver(){
        driver= ReusableMethods.defineChromeDriver();
    }// end of before suite method

    //@Test is a replacement for the main method
    @Test
    public void GoogleSearchNumber(){
        //naviaget to google gome page
        driver.navigate().to("https://google.com");
        // enter on search field
        ReusableMethods.sendKeysMethod(driver,"//*[@name='q']","BMW","Search Field");
        // submit om google search field
        ReusableMethods.submitmethod(driver,"//*[@name='btnK']","Google Search");
        //capture and print out result and number
        String result = ReusableMethods.captureTextMethod(driver,"//*[@id='result-stats']","Serach Results");
        String[] arrayResult =result.split(" ");
        System.out.println("Search number for bmw:" + arrayResult[1]);
    }// end of test

    //quit the driver
    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite



}// End of class
