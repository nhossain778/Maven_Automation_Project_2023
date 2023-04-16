package Action_item;

import ReusabkeLibray.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action_Item5ReusableMethods {
    public static void main(String[] args) throws InterruptedException {
        //set up the chrome driver
        WebDriver driver = ReusableMethods.defineChromeDriver();

        //navigate to staples home page
        driver.navigate().to("https://www.bestbuy.com");

        //type on search field using sendkeys method
        ReusableMethods.sendKeysMethod(driver,"//*[@id='gh-search-input']","iphone","Search Field");

        //click on the search icon
        ReusableMethods.clickMethod(driver,"//*[@class='header-search-button']","Search Icon");

        // wait for the dropdown to be visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tb-select']")));
        //click on sort by
        ReusableMethods.clickMethod(driver, "//*[@id='sort-by-select']", "sort by");

        // select the "Best Selling" option from the dropdown

        //ReusableMethods.selectByTextMethod(driver, "//*[@class='tb-select']","Best Selling","Select Best Selling");

        Thread.sleep(2000);

        //click on the first iphone that pops up
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='product-image ']", 0, "First Image");


        // Find the element to scroll to
        WebElement element = driver.findElement(By.xpath("//*[@class='c-button c-button-outline c-button-md c-button-block v-m-top-xs']"));

        // Scroll to the element using ReusableMethods
        //ReusableMethods.scrollByElement(driver, element);

        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 50)");

        //Add the phone to cart
        // Click the "Add to Cart" button
        ReusableMethods.clickMethod(driver, "//button[contains(@class, 'add-to-cart-button')]", "Add to Cart button");

        //ReusableMethods.captureTextMethod(driver, "//*[@class='quantity']", "Quantity", "$179.99");

        driver.quit();
    }// end of main
}// end of class
