package Action_item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Bing_ActionItem{
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

//define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();

//set up the ArrayList of sports
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Cricket");
        sports.add("Soccer");
        sports.add("Football");
        sports.add("Baskeball");

//iterate through the list of sports and print out the search number for each sport
        for(int i=0; i<sports.size(); i++){
            //navigate to bing home page
            driver.navigate().to("https://www.bing.com");

            //maximize the browser

            //driver.manage().window().maximize();


            //wait for 2 seconds
            Thread.sleep(2000);

            //enter keyword cricket to search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));

            //click on bing search button
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).submit();


            Thread.sleep(2000);
//capture the search results using .getText()
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //System.out.println("Search results: " + result);


            //print out only the number
            String[] arrayResult = result.split(" ");
            System.out.println("For " + sports.get(i) + " the search number is " + arrayResult[1]);
            //System.out.println(" search number: " + arrayResult[0] + " seconds " + arrayResult[1] + arrayResult[2]);

        }//end of loop

        driver.quit();


    }//end of main
}// end of java class
