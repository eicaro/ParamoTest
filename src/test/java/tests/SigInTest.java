package tests;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Config;
import pages.SignInPage;
import utils.Sleeper;
public class SigInTest {
    private Page page;

    @BeforeEach
    public void setUp() {
        Config.setUp();
        page = Config.getPage();
    }

    @AfterEach
    public void tearDown() {
        Config.tearDown();
    }

    //Flacky due the captcha
    @Test
    public void loginWithEmail() {
        SignInPage signInPage = new SignInPage(page);
        signInPage.navigate();
        signInPage.closeMessage();
        Sleeper.waitRandomInterval();
        signInPage.fillEmail("joseluis@gmail.com");
        Sleeper.waitRandomInterval();
        signInPage.fillPassword("Abc123456");
        Sleeper.waitRandomInterval();
        signInPage.submit();
        signInPage.validateWelcome();
        signInPage.validateUserId();
    }
    @Test
    public void validateFacebookSignUp() {
        SignInPage signInPage = new SignInPage(page);
        signInPage.navigate();
        signInPage.closeMessage();
        signInPage.signUpWithFacebook();
        signInPage.validateFacebook();
    }

    @Test
    public void validateGmailSignUp() {
        SignInPage signInPage = new SignInPage(page);
        signInPage.navigate();
        signInPage.closeMessage();
        signInPage.signUpWithGmail();
        signInPage.validateGmail();
    }

    @Test
    public void validateTelegramSignUp() {
        SignInPage signInPage = new SignInPage(page);
        signInPage.navigate();
        signInPage.closeMessage();
        signInPage.signUpWithTelegram();
        signInPage.validateTelegram();
    }
}
