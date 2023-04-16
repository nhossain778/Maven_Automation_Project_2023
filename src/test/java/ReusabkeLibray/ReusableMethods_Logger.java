package ReusabkeLibray;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableMethods_Logger {
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
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element  + elementName + :  + e");
            getScreenShot(driver,elementName,logger);
        }
    }//end of click method
    public static void clickMethodByIndex(WebDriver driver, String xpath, int index, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to click on element  + elementName + :  + e");
            System.out.println("Unable to click on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of click method by index

    //submit action is one of the type of void method
    public static void submitMethod(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully submit on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of submit method

    //send action is one of the type of void method
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully entered a value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to enter a value on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }// end of exception
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
    //capture a text and return it using return method
    public static String captureTextMethod(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured a text from element " + elementName);
            logger.log(LogStatus.PASS,"Successfully captured a text from element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text from element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text from element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
        return  result;
    }//end of get text method

    //capture a text using the SelectByText Method
    //public static String selectByText(WebElement dropdownElement, String text){
    //Select dropdown = new Select(dropdownElement);
    //dropdown.selectByVisibleText(text);
    //String selectedText = dropdown.getFirstSelectedOption().getText();
    //System.out.println("Successfully selected " + selectedText + " from dropdown");
    //return selectedText;

    //}//end of select by text method

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


    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!! " + e);
        }
    }//end of getScreenshot method
}// end of class
