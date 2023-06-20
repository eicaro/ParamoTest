package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class SignInPage {
    //Defining Locators
    private final Page page;
    private final Locator alertMessage;
    private final Locator facebookButton;
    private final Locator welcomeFacebook;
    private final Locator gmailButton;
    private final Locator welcomeGmail;
    private final Locator telegramButton;
    private final Locator telegramError;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator submitButton;
    private final Locator slider;
    private final Locator userId;

    public SignInPage(Page page) {
        //Giving value to the Locators
        this.page = page;
        this.alertMessage = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Got it"));
        this.facebookButton = page.locator("#login-form > div.form__section.form__section--links > ul > li:nth-child(1) > a > i");
        this.welcomeFacebook = page.getByText("Log Into Facebook");
        this.gmailButton = page.locator("#login-form > div.form__section.form__section--links > ul > li:nth-child(2) > a > i");
        this.welcomeGmail = page.getByText("Sign in with Google");
        this.telegramButton = page.locator("#login-form > div.form__section.form__section--links > ul > li:nth-child(3) > a > i");
        this.telegramError = page.locator("html");
        this.emailInput = page.locator("[data-test='input-username']");
        this.passwordInput = page.locator("[data-test='input-password']");
        this.submitButton = page.locator("[data-test='control-submit']");
        this.slider = page.locator("div:nth-child(3) > picture > picture > .slider-main-content");
        this.userId = page.getByText("id 61846307");
    }
    //Methods to navigate to login
    public void navigate(){
        page.navigate("https://demo.casino/user/login");
    }
    //Methods to interact with the page
    public void closeMessage() {
        this.alertMessage.click();
    }
    public void signUpWithFacebook(){
        this.facebookButton.click();
    }
    public void validateFacebook(){
        assertThat(this.welcomeFacebook).isVisible();
    }

    public void signUpWithGmail(){
        this.gmailButton.click();
    }
    public void validateGmail(){
        assertThat(this.welcomeGmail).isVisible();
    }

    public void signUpWithTelegram(){
        this.telegramButton.click();
    }
    public void validateTelegram(){
        assertThat(this.telegramError).isVisible();
    }
    public void fillEmail(String email){
        this.emailInput.fill(email);
    }
    public void fillPassword(String password){
        this.passwordInput.fill(password);
    }
    public void submit(){
        this.submitButton.click();
    }
    public void validateWelcome(){
        assertThat(this.slider).isVisible();
    }
    public void validateUserId(){
        assertThat(this.userId).isVisible();
    }
}
