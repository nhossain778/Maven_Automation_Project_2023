package Action_item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Action_Item3 {
    public static void main(String[] args) throws InterruptedException {

        // Set up Chrome driver with maximize and incognito options
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //maximize
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        // Wait for page to load and navigate to Weight Watchers workshop page
        driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

        // Create an ArrayList to store 3 different real zip codes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11217");
        zipCode.add("11223");
        zipCode.add("11209");


        // Loop through each zip code
        for (int i = 0; i < zipCode.size(); i++) {
            //click search and iterate through the zipcode variables
            driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipCode.get(i));

            //click enter
            driver.findElement(By.xpath("//*[@id='location-search-cta']")).submit();
            Thread.sleep(2000);
            //creating webelement
            ArrayList<WebElement> studio = new ArrayList<>(driver.findElements(By.xpath("//*[contains(text(),'WW Studio @ ')]")));
            ArrayList<WebElement> Address = new ArrayList<>(driver.findElements(By.className("address-3-YC0")));
            //create Conditonal statements
            if (i==0){
                System.out.println("First address: " + Address.get(0).getText());
                studio.get(1).click();
            } else if (i==1){
                System.out.println("second address: " + Address.get(0).getText());
                studio.get(2).click();
            } else if (i==2){
                System.out.println("Third address: " + Address.get(0).getText());
                studio.get(0).click();
            }//end of statements
                Thread.sleep(2000);

            // create webElement to go to scedhule
            WebElement inPerson =driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));

           //set up the java script executor to scroll
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            // scroll to see the schedule
            jse.executeScript("arguments[0].scrollIntoView(true);" , inPerson);

            System.out.println(driver.findElement(By.className("scheduleContainerMobile-1RfmF")).getText());

            driver.navigate().back();

            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id='location-search']")).clear();

        }// end of for loop

        // Quit the driver
        driver.quit();
    }//emd of main
}// end of class
