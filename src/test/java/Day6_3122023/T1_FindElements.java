package Day6_3122023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_FindElements {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

//set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
//add maximize for windows
//options.addArguments("start-maximized");
//add --kiosk for mac
//options.addArguments("--kiosk");
//add incognito mode to option
        options.addArguments("incognito");
//add options to run your driver on the background(headless)
        //options.addArguments("headless");

//define the chrome driver that you will use for automation test
//option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

//navigate to yahoo home page
        driver.navigate().to("https://www.mlcalc.com");

        Thread.sleep(2000);

        //clear the autopopulated data from purchase price
        driver.findElement(By.xpath("//*[@name='ma']")).clear();
        //enter new price
        driver.findElement(By.xpath("//*[@name='ma']")).sendKeys("250000");

        //click om element
        driver.findElement(By.xpath("//*[@Value='Calculate']")).click();

        Thread.sleep(1500);

        //capture the montly payment using find elemenetes by index of 0
        String result = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();
        System.out.println("montly payment" + result);

        // capture the 360 pay,ent using fnd elements
        String result2 = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(1).getText();
        System.out.println("total 360 payment" + result2);
        //capture the down payment
        //driver.findElement(By.xpath("//*[@name='dp']")).clear();

        // enter the down payment price
        //driver.findElement(By.xpath("//*[@name='dp']")).sendKeys("20000");

        //driver.findElement(By.xpath("//*[@Value='Calculate']")).click();
        //String result3 = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();
        //System.out.println("montly payment" + result3);
        //String result4= driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(1).getText();
        //System.out.println("total payment after apr" + result4);
        //String result5= driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(2).getText();
        //System.out.println("total 360 payment" + result5);

        //driver.quit();


        //driver.findElements(By.xpath("//*[style='font-size: 32px']"));



    }//end of main
}//end of class
