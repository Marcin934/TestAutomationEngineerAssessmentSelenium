package reporting;

import driver.DriverManager;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateReport implements ITestListener {
    public void onStart(ITestContext test) {
        System.out.println("+Begin test: " + test.getName());

    }



 
    public void onTestSuccess(ITestResult test) {

        System.out.println(" Test passed: " + test.getName());

    }

 
    public void onTestFailure(ITestResult test) {

        System.out.println(" Test failed: " + test.getName());
        File scr = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshots/" + test.getName() + new SimpleDateFormat("yyyyMMddHHmm").format(new Date())+".jpg";
        try {
            FileUtils.getFileUtils().copyFile(scr, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Path to screenshot: " + path);
    }

 
    public void onTestSkipped(ITestResult test) {

        System.out.println(" Test ignored: " + test.getName());

    }

 
    public void onFinish(ITestContext test) {

        System.out.println("-End test: " + test.getName());

    }

 
    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {


    }

}