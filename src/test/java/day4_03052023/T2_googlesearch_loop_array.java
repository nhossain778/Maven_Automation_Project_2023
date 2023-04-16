package day4_03052023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T2_googlesearch_loop_array {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

//define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();

//set up the ArrayList of cars
        ArrayList<String>cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Mercedes");
        cars.add("Honda");

//iterate through the list of cars and print out the search number for each car
        for(int i=0; i<cars.size(); i++){
            //navigate to google home page
            driver.navigate().to("https://www.google.com");

            //maximize the browser
            //driver.manage().window().maximize(); //for windows
            //driver.manage().window().fullscreen(); //for mac

            //wait for 2 seconds
            Thread.sleep(2000);

            //enter keyword bmw to search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cars.get(i));

            //click on google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //whenever you go to a new page or navigate, always use 2-3 seconds wait to pause your script a bit
            Thread.sleep(2000);
//capture the search results using .getText()
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            System.out.println("Search results: " + result);


            //print out only the number
            String[] arrayResult = result.split(" ");
            System.out.println("For " + cars.get(i) + " the search number is " + arrayResult[1]);
            //System.out.println(" search number: " + arrayResult[1] + " seconds " + arrayResult[2] + arrayResult[3]);

        }//end of loop

//outside of loop is where you quit/close the driver
        driver.quit();


    }//end of main
}//end of java class
