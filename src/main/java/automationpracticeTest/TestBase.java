package automationpracticeTest;

import driver.DriverManager;
import driver.DriverUtils;
import org.testng.annotations.*;
import reporting.GenerateReport;

public class TestBase {

    @BeforeTest
    @Parameters({"landingPage"})
    public void prepare(String landingPage){
        DriverManager.getWebDriver();
        DriverUtils.initialConfiguration();
        DriverUtils.navigateToPage(landingPage);
    }

    @AfterTest
    public void closeMethod(){
        DriverManager.disposeDriver();
    }
}
