package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    private static WebDriver driver;
    private static String chromedriverFile;

    private DriverManager(){

    }

    public static WebDriver getWebDriver(){
        if(driver==null){
            chromedriverFile="chromedriver87_0_4280_20.exe";
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/"+chromedriverFile);
            driver= new ChromeDriver();
            return driver;
        }
        return driver;
    }

    public static void disposeDriver(){
        driver.close();
        driver=null;
    }
}
