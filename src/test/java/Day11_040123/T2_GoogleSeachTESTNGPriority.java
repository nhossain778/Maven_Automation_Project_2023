package Day11_040123;

import ReusabkeLibray.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_GoogleSeachTESTNGPriority {

    //to make variable global, you must declare it outside of the annotation methods
    WebDriver driver;

    //@Test is a replacement of the main method to execute your code
    @Test (priority = 1)
    public void GoogleSearchNumber() {
        //navigate to google home
        driver.navigate().to("https://www.google.com");
        //enter bmw on the search field
        ReusableMethods.sendKeysMethod(driver, "//*[@name='q']", "BMW", "Search Field");
        //submit of google search
        ReusableMethods.submitmethod(driver, "//*[@name='btnK']", "Google Search");
    }//end of test 1

    @Test(priority = 2)
    public void captureSearchNumberForBMW() {
        //capture the text and print out the number
        String result = ReusableMethods.captureTextMethod(driver, "//*[@id='result-stats']", "Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Search for BMW:" + arrayResult[1]);
    }//end of test 2
    //quit the driver
    @BeforeSuite
    public void setUpDriver(){
        driver = ReusableMethods.defineChromeDriver();
    }//end of before suite

    @AfterSuite
    public void quitSession(){
        driver.quit();

    }//end of after suite


}// end of class