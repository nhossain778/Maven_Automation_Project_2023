package ReusabkeLibray;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class ReusableAnnotations {

    //you need to make your WebDriver driver variable static since we are calling it to our test class
    public static WebDriver driver;
    //declare reports
    public static ExtentReports reports;
    //declare logger variable
    public static ExtentTest logger;



    //set before suite annotation method
    @BeforeSuite
    public void setDriver(){
        driver = ReusableMethods.defineChromeDriver();
        // set path to report here
        reports = new ExtentReports("src/main/java/HTML_Report/automationReport2.html",true);
    }//end of before suite

    @BeforeMethod
    public void getTestName(Method MethodName){
        //give a name to the test
        logger = reports.startTest(MethodName.getName());
    }// end of before method

    @AfterSuite
    public void postCondition(){
        driver.quit();
        // end all logger
        reports.endTest(logger);
        // write the logs back to the html report
        reports.flush();
    }//end of after suite


}// end of class
