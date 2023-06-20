package tests;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Config;
import pages.HomePage;
public class HomeTest {
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

    @Test
    public void checkAlertMessageAndClose() {
        HomePage home = new HomePage(page);
        home.navigate();
        home.checkAlertMessage();
        home.closeMessage();
        home.validateHidden();
    }
    @Test
    public void checkHomePage() {
        HomePage home = new HomePage(page);
        home.navigate();
        home.closeMessage();
        page.pause();
        home.checkMainImage();
    }
    @Test
    public void navigateToSignIn() {
        HomePage home = new HomePage(page);
        home.navigate();
        home.closeMessage();
        home.clickSignInButton();
    }
    @Test
    public void navigateToSignUp() {
        HomePage home = new HomePage(page);
        home.navigate();
        home.closeMessage();
        home.clickSignUpButton();
    }
}

