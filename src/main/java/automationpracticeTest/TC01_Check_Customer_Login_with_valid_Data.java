package automationpracticeTest;

import automationpracticeTest.page.AutenthicationPage;
import automationpracticeTest.page.LandingPage;
import automationpracticeTest.page.MyAccountPage;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC01_Check_Customer_Login_with_valid_Data extends TestBase {

    @Test
    @Parameters({"email","passw","myAccount"})
    public void logInWithCorrectCredentials(String mail, String passw, String myAccount){
        LandingPage landingPage = new LandingPage();
        AutenthicationPage autenthicationPage = new AutenthicationPage();
        MyAccountPage myAccountPage = new MyAccountPage();

        Reporter.log("1. Open landingPage and click sign in.");
        landingPage.clickSignInLink();

        Reporter.log("2. Fulfill email and passw for existing account.");
        autenthicationPage.sendLoginEmail(mail);
        autenthicationPage.sendLoginPassword(passw);

        Reporter.log("3. Check if email field turn green because of email validation.");
        autenthicationPage.checkMailValidation(true);

        Reporter.log("4. Click sign in button, check if  displayed myAccount is correct.");
        autenthicationPage.clickSignInButton();
        myAccountPage.checkAccountName(myAccount);

        Reporter.log("5. Logout");
        myAccountPage.clickSignOut();

    }

}
