package automationpracticeTest;

import automationpracticeTest.page.AutenthicationPage;
import automationpracticeTest.page.LandingPage;
import automationpracticeTest.page.MyAccountPage;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC02_Check_Customer_Login_with_invalid_Data extends TestBase {

    @Test
    @Parameters({"authenticationFailedErrorMessage","invalidEmail","email","invalidPassw","passw","myAccount","emailRequiredErrorMessage","emailInvalidErrorMessage","passwordRequiredErrorMessage"})
    public void logInWithIncorrectCredentials(String authenticationFailedErrorMessage, String invalidEmail,String mail, String invalidPassw, String passw, String myAccount, String emailRequiredErrorMessage, String emailInvalidErrorMessage, String passwordRequiredErrorMessage){
        LandingPage landingPage = new LandingPage();
        AutenthicationPage autenthicationPage = new AutenthicationPage();
        MyAccountPage myAccountPage=new MyAccountPage();

        Reporter.log("1. Open landingPage and click sign in.");
        landingPage.clickSignInLink();

        Reporter.log("2. Click sign in button, check if there is error emailRequiredErrorMessage.");
        autenthicationPage.clickSignInButton();
        autenthicationPage.checkErrorMessage(emailRequiredErrorMessage);

        Reporter.log("3. Write invalidEmail and passw. email field turn red because of validation error");
        autenthicationPage.sendLoginEmail(invalidEmail);
        autenthicationPage.sendLoginPassword(passw);
        autenthicationPage.checkMailValidation(false);

        Reporter.log("4. Click sign in, check if there is emailInvalidErrorMessage error.");
        autenthicationPage.clickSignInButton();
        autenthicationPage.checkErrorMessage(emailInvalidErrorMessage);

        Reporter.log("5. Write email, delete  passwort writen before, click sign in again, check if there is passwordRequiredErrorMessage error.");
        autenthicationPage.sendLoginEmail(mail);
        autenthicationPage.sendLoginPassword("");
        autenthicationPage.clickSignInButton();
        autenthicationPage.checkErrorMessage(passwordRequiredErrorMessage);

        Reporter.log("6. Write invalidPassw, click sign in again, check if there is authenticationFailedErrorMessage error.");
        autenthicationPage.sendLoginPassword(invalidPassw);
        autenthicationPage.clickSignInButton();
        autenthicationPage.checkErrorMessage(authenticationFailedErrorMessage);

        Reporter.log("7. Fulfill email and passw for existing account, sign in and check if myAccount name display correct.");
        autenthicationPage.sendLoginEmail(mail);
        autenthicationPage.sendLoginPassword(passw);
        autenthicationPage.clickSignInButton();
        myAccountPage.checkAccountName(myAccount);

        Reporter.log("8. Logout");
        myAccountPage.clickSignOut();
    }

}
