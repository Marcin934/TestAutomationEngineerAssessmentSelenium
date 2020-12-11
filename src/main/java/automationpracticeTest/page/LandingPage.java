package automationpracticeTest.page;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    @FindBy(xpath="//a[@class='login']")
    WebElement signInLink;

    public LandingPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void clickSignInLink(){
        signInLink.click();;
    }
}
