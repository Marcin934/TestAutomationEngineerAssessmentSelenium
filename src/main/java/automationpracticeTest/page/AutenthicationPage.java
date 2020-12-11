package automationpracticeTest.page;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AutenthicationPage {

    @FindBy(id="email")
    WebElement loginEmailField;

    @FindBy(id="passwd")
    WebElement loginPasswordField;

    @FindBy(id="SubmitLogin")
    WebElement signInButton;

    @FindBy(xpath="//div[contains(@class,'form-group ')]")
    WebElement emailFormGroup;

    @FindBy(xpath="//div[@class='alert alert-danger']//li")
    WebElement errorMessage;

    public AutenthicationPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    public void sendLoginEmail(String mail){
        loginEmailField.clear();
        loginEmailField.sendKeys(mail);
    }

    public void sendLoginPassword(String passw){
        loginPasswordField.clear();
        loginPasswordField.sendKeys(passw);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public void checkMailValidation(boolean shouldPass){
        String formGorupClassName;
        if(shouldPass){
            formGorupClassName="form-group form-ok";
        }else{
            formGorupClassName="form-group form-error";
        }
        Assert.assertEquals(formGorupClassName,emailFormGroup.getAttribute("class"));;
    }

    public void checkErrorMessage(String message){
        Assert.assertEquals(errorMessage.getText(),message);
    }

}
