package Action_item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class inclass_ActionItem {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Las Vegas");
        cities.add("Miami");
        cities.add("Houston");

        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(1);
        adults.add(2);
        adults.add(3);

        for (int i =0; i < cities.size(); i++){
            driver.navigate().to("https://www.hotels.com");
            //put few seconds wait
            Thread.sleep(2000);
            try{
               WebElement searchBox= driver.findElement(By.xpath("//*[@aria-label='Going to']"));
               searchBox.click();
               Thread.sleep(2000);

               driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(cities.get(i) + "\n");
                System.out.println("Successfully clicked on textbox");
            }catch (Exception e) {
                System.out.println("Unable to click on textbox. " + e);
            }//end of exception for click
            Thread.sleep(2000);
            // end of searcbing fpr the cities.


            try{
                driver.findElement(By.xpath("//*[@data-stid=estination_form_field-search']")).click();
                System.out.println("Successfully clicked on destination box");
            }catch (Exception e){
                System.out.println("clicking on destination was unsucessful");
            } Thread.sleep(2000);

            try{
                driver.findElement(By.xpath("//*[@class='uitk-step-input-button']")).click();
                System.out.println("Successfully clicked minus box");
            }catch (Exception e){
                System.out.println("clicking on minus box was unsucessful");
            } Thread.sleep(2000);
            // emd of clickonh on minis box

            // calander
            try{ driver.findElement(By.xpath("//*[@id='data_form_field btn']")).click();

            }catch (Exception e){
                System.out.println("unable to print out calander");
            }
            try{
                //travler button click on it
                WebElement traveler = driver.findElement(By.xpath("//*[@data-stid='open-room-picker']"));
                traveler.click();

            }catch (Exception e){
                System.out.println("unable to open calander");
            }
            // making an array list webelemet to clicn on the bitton
            ArrayList<WebElement> button =new ArrayList<>(driver.findElements(By.xpath("//*[@class='utik-layout-flex-item utik-step-input-touch-target']")));
            try{
                button.get(0).click();
            }catch (Exception e){
                System.out.println("unable to clicjk on adults");
            }

            Thread.sleep(2000);

            for(int J = 0; J < adults.get(i); J++) {
                button.get(1).click();
                Thread.sleep(1000);

                //click on get a child
                button.get(3).click();

                //create a WebElement shortcut to click child age dropdown
                WebElement childAge = driver.findElement(By.xpath("//*[@class='uitk-field-select']"));
                Select dropDown = new Select(childAge);
                dropDown.selectByVisibleText("1");

                //click on done
                try {
                    WebElement Done = driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']"));
                    Done.click();

                } catch (Exception e) {
                    //print error statement
                    System.out.println("Unable to click Done" + e);
                }
                //click on the search bar on top right corner
                try {
                    WebElement Search = driver.findElement(By.xpath("//*[@id='search_button']"));
                    Search.click();
                } catch (Exception e){
                    System.out.println("unable to click done");

                }

                //create ArrayList to click on resort
                ArrayList<WebElement> resort = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")));

                //click first resort link for first option , third resort link for second optiom , and second resort
                try {
                    if (i == 0) {
                        resort.get(1).click();
                    }
                } catch (Exception e) {
                    System.out.println("firts lonk failed " + e);
                }
                Thread.sleep(2000);
                try {
                    if (i == 1) {
                        resort.get(2).click();
                    }
                } catch (Exception e) {
                    System.out.println("unbale to click on 2nd option");
                }
                Thread.sleep(2000);
                try {
                    if (i == 2) {
                        //click the 2nd resort
                        resort.get(1).click();
                    }

                } catch (Exception e) {
                    //print error statement
                    System.out.println("unable to run third condition" + e);
                }

                //call the window handles in arrayList and switch to the new tab
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                //switch to the new tab by index of 1
                driver.switchTo().window(tabs.get(1));
                Thread.sleep(2000);

                try {
                    WebElement resortAddress = driver.findElement(By.xpath("//*[@data-stid='content-hotel-address']"));
                    //print address
                    System.out.println("Address: ");
                    System.out.println(resortAddress.getText());
                } catch (Exception e) {
                    //print error statement
                    System.out.println("unable to print address" + e);
                }
                Thread.sleep(2000);
                //close tab
                driver.close();
                //switch to original tab
                driver.switchTo().window(tabs.get(0));
            }//end of 1st loop

            driver.quit();


        }// end of loop



    }// end of main
}// end of java class
