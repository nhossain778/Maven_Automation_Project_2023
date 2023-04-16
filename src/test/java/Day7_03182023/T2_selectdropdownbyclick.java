package Day7_03182023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T2_selectdropdownbyclick {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

//set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
//define the chrome driver that you will use for automation test
//option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

//navigate to yahoo home page
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(2000);
        // select start month as April from Dropdown using select option
        // click on the dropdown
       driver.findElement(By.xpath("//*[@name='param[start_month]']")).click();
       // click on dropdown value by xpath text
        driver.findElement(By.xpath("//*[text()='Apr']")).click();
        Thread.sleep(1500);

        //click on empty area to close the dropdown
        driver.findElement(By.xpath("//*[@class='content-area']")).click();



    }// end of main
}// end of class
