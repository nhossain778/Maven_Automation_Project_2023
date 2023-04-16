package Action_item;

import ReusabkeLibray.ReusableAnnotations;
import ReusabkeLibray.ReusableMethods;
import ReusabkeLibray.ReusableMethods_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Final_AI extends ReusableAnnotations {
    //use case is i should be able to book s flight to take a trip
    //steps 1.naviagte to ameircan airlones website
    //2.click on plan travel section//click om flights
    //3.type in info for travel destination and dates.
    @Test(priority = 1)
    public void searchForflights() throws InterruptedException {
        logger.log(LogStatus.INFO, "Navigate to american airlines home page");
        //navigate to staples home page
        driver.navigate().to("https://www.americanairlines.com");
        // click on plan travel
        ReusableMethods_Logger.clickMethod(driver, "//*[@id='plan-travel-expander']", logger, "plan travel");
        //clicking on flights
        Thread.sleep(2000);
        ReusableMethods_Logger.clickMethod(driver, "//*[text()='Flights']", logger, "flights");
        // clear in city on from box
        driver.findElement(By.xpath("//*[@name='segments[0].origin']")).clear();
        //type in Florida on from box
        ReusableMethods_Logger.sendKeysMethod(driver, "//*[@name='segments[0].origin']", "Fll", logger, "From box");
        //Type in destintzatopn on the to go box
        Thread.sleep(1000);
        ReusableMethods_Logger.sendKeysMethod(driver, "//*[@name='segments[0].destination']", "LAX", logger, "Destination box");
        //choose the travel date
        ReusableMethods_Logger.clickMethod(driver,"//*[@name='segments[0].travelDate']",logger,"Date");
        //choose april 14th
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@name='segments[0].travelDate']","04/14/2023",logger,"depart date");
        //choose may 1 as return date
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@name='segments[1].travelDate']","05/01/2023",logger,"return date");
        //click on the search butteon
        ReusableMethods_Logger.clickMethod(driver,"//*[@class='btn']",logger,"search");
        Thread.sleep(2000);
        //capture flighgt info message
        String result =ReusableMethods_Logger.captureTextMethod(driver,"//*[@class='city-pair']",logger,"flights ");
        System.out.println(result);
    }//end of test 1
    //@Test(priority = 2)
   // public void findFlightsACT2() throws InterruptedException {
        //ReusableMethods_Logger.clickMethodByIndex(driver,"//*[text()='Your account']",1,logger,"your account");
    }//end of test 2
