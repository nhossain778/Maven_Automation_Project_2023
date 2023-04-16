package day4_03052023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_GoogleHome {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

//define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();

//navigate to google home page
        driver.navigate().to("https://www.google.com");

//wait for 2 seconds
        Thread.sleep(2000);


//simply close the driver/browser
        driver.close();
    }
}
