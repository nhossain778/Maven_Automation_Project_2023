package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xapth_Contains {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

//define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();
        // naviagte to google home
        driver.navigate().to("https://www.Yahoo.com");

        Thread.sleep(2000);

        //using xpath Contains click on the mail link by ignoring the white space on the text property of the element
        driver.findElement(By.xpath("//a[contains(text(),'Mail')]")).click();



    }//end of main
}//end of class
