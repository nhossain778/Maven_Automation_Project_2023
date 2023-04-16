package day4_03052023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class part2googlehome {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

//define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();

//navigate to google home page
        driver.navigate().to("https://www.google.com");
        //maximize the browser
        //driver.manage().window().maximize();//for windows
        //driver.manage().window().fullscreen();//for mac

//wait for 2 seconds
        Thread.sleep(2000);
        //enter keyword bmw to search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("BMW");

        //click on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        //whenever you go to a new page or navigate, always use 2-3 seconds wait to pause your script a bit
        Thread.sleep(2000);

//capture the search results using .getText()
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
//System.out.println("Search results: " + result);
        //String newResult = result.replace("(","").replace(")","");

        //print out only the number
        String[] arrayResult = result.split(" ");
        System.out.println("Search Number: " + arrayResult[1]);
        //System.out.println("search number:" + arrayResult[1] + "seconds" + arrayResult[2] + arrayResult[3]);


//simply close the driver/browser

        //driver.close();
        driver.quit();
    }//end of main
}//end of class
