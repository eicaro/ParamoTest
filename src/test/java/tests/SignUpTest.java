package tests;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Config;
import utils.IdentityGenerator;
import pages.SignUpPage;
import utils.Sleeper;
public class SignUpTest {

    private Page page;
    private final String email = IdentityGenerator.generateRandomGmail();
    private final String number = IdentityGenerator.generateRandomNumber();
    @BeforeEach
    public void setUp() {
        Config.setUp();
        page = Config.getPage();
    }

    @AfterEach
    public void tearDown() {
        Config.tearDown();
    }

    @Test
    public void validateFacebookSignUp() {
        SignUpPage signUpPage = new SignUpPage(page);
        signUpPage.navigate();
        signUpPage.closeMessage();
        signUpPage.signUpWithFacebook();
        signUpPage.validateFacebook();
    }

    @Test
    public void validateGmailSignUp() {
        SignUpPage signUpPage = new SignUpPage(page);
        signUpPage.navigate();
        signUpPage.closeMessage();
        signUpPage.signUpWithGmail();
        signUpPage.validateGmail();
    }

    @Test
    public void validateTelegramSignUp() {
        SignUpPage signUpPage = new SignUpPage(page);
        signUpPage.navigate();
        signUpPage.closeMessage();
        signUpPage.signUpWithTelegram();
        signUpPage.validateTelegram();
    }
    @Test
    public void createAccountEmail() {
        SignUpPage signUpPage = new SignUpPage(page);
        signUpPage.navigate();
        signUpPage.closeMessage();
        signUpPage.emailInput(email);
        Sleeper.waitRandomInterval();
        signUpPage.acceptConditionsCheck();
        Sleeper.waitRandomInterval();
        signUpPage.setPasswordInput("Abc123456");
        Sleeper.waitRandomInterval();
        signUpPage.setReenterPasswordInput("Abc123456");
        signUpPage.setNoBonusCheck();
        signUpPage.createAccountButton();
        signUpPage.validateSuccess();
    }

    //This particular test is flacky, sometimes it works but sometimes it doesn't' since sometimes it popups the captcha
    @Test
    public void createAccountPhone() {
        SignUpPage signUpPage = new SignUpPage(page);
        signUpPage.navigate();
        signUpPage.closeMessage();
        signUpPage.phoneButton();
        signUpPage.setPhoneInput(number);
        Sleeper.waitRandomInterval();
        signUpPage.acceptConditionsCheck();
        signUpPage.setPasswordInput("Abc123456");
        Sleeper.waitRandomInterval();
        signUpPage.setReenterPasswordInput("Abc123456");
        signUpPage.setNoBonusCheck();
        Sleeper.waitRandomInterval();
        signUpPage.createAccountButton();
        Sleeper.waitRandomInterval();
        signUpPage.checkCode();
    }

}
