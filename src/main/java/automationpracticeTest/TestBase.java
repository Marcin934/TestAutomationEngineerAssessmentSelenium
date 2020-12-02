package automationpracticeTest;

import driver.DriverManager;
import driver.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import reporting.GenerateReport;

public class TestBase {

    @BeforeMethod
    @Parameters({"landingPage"})
    public void prepare(String landingPage){
        DriverManager.getWebDriver();
        DriverUtils.initialConfiguration();
        DriverUtils.navigateToPage(landingPage);
    }

    @AfterMethod
    public void closeMethod(){
        DriverManager.disposeDriver();
    }
}
