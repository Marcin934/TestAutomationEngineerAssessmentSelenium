package automationpracticeTest.page;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyAccountPage {

    @FindBy(className="header_user_info")
    WebElement myAccountLabel;

    @FindBy(className="logout")
    WebElement signOutButton;

    public MyAccountPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void checkAccountName(String myAccount){
        Assert.assertEquals(myAccountLabel.getText(),myAccount);
    }

    public void clickSignOut(){
        signOutButton.click();
    }

}
