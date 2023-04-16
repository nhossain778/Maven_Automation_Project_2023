package Action_item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AI3 {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

//set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");


//add incognito mode to option
        options.addArguments("incognito");
        //define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver(options);
        // create arraylist for zipcode
        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11219");
        zipcode.add("11220");
        zipcode.add("11232");
        // create a for loop
        for (int i = 0; i < zipcode.size(); i++){
            //navigate to Weight watchers home page
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            Thread.sleep(2000);
            // create webelemenr that will click on search
            WebElement search = driver.findElement(By.xpath("//*[@id='location-search']"));
            search.clear();
            search.sendKeys(zipcode.get(i));

        }// end of for loop



//clear the auto-populated data from purchase price

//click on calculate
        //driver.findElement(By.xpath("//*[@value='Calculate']")).click();

        //Thread.sleep(1500);

//if you want you use findElements as a webelement variable, you need to store it as an Array List
//capture the monthly payment & total 360
        //ArrayList<WebElement> paymentList = new ArrayList<>(driver.findElements((By.xpath("//*[@style='font-size: 32px']"))));
//print monthly payment
        //String mntPayment = paymentList.get(0).getText();
        //System.out.println("Monthly Payment: " + mntPayment);
//print total 360  payment
        //String total360Pay = paymentList.get(1).getText();
        //System.out.println("Total 360 Payment: " + total360Pay);

    }//end of main
}//end of class

