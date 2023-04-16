package ReusabkeLibray;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.util.ArrayList;

public class ReusableMethods {
    //create a return method to return the webdriver you going to use on your test classes
    //static command allows your method to be global
    public static WebDriver defineChromeDriver() {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("incognito");
        //options.addArguments("headless");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //set maximized for mac users
        driver.manage().window().maximize();

        return driver;

    }//end of webdriver method
    // return method will execute your statements with retruning some conditions/value
    //get text or webdriver method

    // void method will only perform the action
    // click action is one of the actions click sendkeys scrolling submit select mouse hover and clear

    //return method will execute your statements along with returning some conditions/value
    //example of return methods are only WebDriver method & getText action

    //void method will only perform the action but won't return anything
    //void actions are click, sendKeys, scrolling, submit, select, mouse hover, clear

    //click action is one of the type of void method
    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
        }
    }//end of click method

    public static void submitmethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully submitted on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit key word on element " + elementName + ": " + e);
        }
    }//end of click method

    public static void clickMethodByIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
        }
    }//end of click method by index

    //send action is one of the type of void method
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + ": " + e);
        }
    }//end of sendkeys method

    //click action is one of the type of void method


    //SENDKEYS action is one of the type of void method
    public static void sendKeysMethodindex(WebDriver driver, String xpath, int index, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + ": " + e);
        }
    }//end of sendkeysindex method

    //capture a text and return it using return method
    public static String captureTextMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured a text from element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text from element " + elementName + ": " + e);
        }
        return result;

    //capture a text using the SelectByText Method
    //public static String selectByText(WebElement dropdownElement, String text){
    //Select dropdown = new Select(dropdownElement);
    //dropdown.selectByVisibleText(text);
    //String selectedText = dropdown.getFirstSelectedOption().getText();
    //System.out.println("Successfully selected " + selectedText + " from dropdown");
    //return selectedText;

    //}//end of select by text method


    // Method to scroll to a web element
    //public static void scrollByElement(WebDriver driver, String xpath, String elementName) {
        // Create an instance of JavascriptExecutor and cast the WebDriver instance to it
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll to the element using JavaScript
        //js.executeScript("arguments[0].scrollIntoView();", elementName);
    // end of scroll method


    // Method to perform a mouse hover over an element
    //public static void mouseHover(WebDriver driver, String elementLocator) {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //Actions actions = new Actions(driver);
        //WebElement element = driver.findElement(By.cssSelector(elementLocator));
        //actions.moveToElement(element).perform();
    }//end of mouse hover

    public static void verifyBooleanStatement(WebDriver driver, String xpath, boolean expectedValue, String elementName) {
        //store the xpath in boolean statement
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            System.out.println("Value: " + elementState);
            if (elementState == expectedValue) {
                System.out.println("Passed: Checkbox is " + expectedValue);
            } else {
                System.out.println("Failed: Checkbox is " + elementState);
            }
        } catch (Exception e) {
            System.out.println("Unable to verify element  " + elementName + " " + e);
        }//end of exception
    }//end of verifyBooleanStatement

    public static void switchToTabByIndex(WebDriver driver, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        try {
            driver.switchTo().window(tabs.get(index));
            System.out.println("sucessfully switched to " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to switch to " + elementName + " because " + e);
        }// end of exception
    }//end of select method

    public static void scrollByPixel(WebDriver driver, String Pixel, String elementName) {
        try {
            //scroll to the bottom to click on mortgage rate
            JavascriptExecutor jse = (JavascriptExecutor) driver;
//scroll using pixels
            jse.executeScript(Pixel);
            System.out.println("scroll to view sucuessufl " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll " + elementName + " because " + e);


        }// end of exception
    }// end of main method
}// end of class
