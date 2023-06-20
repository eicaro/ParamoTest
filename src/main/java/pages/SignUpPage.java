package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class SignUpPage {
    //Defining Locators
    private final Page page;
    private final Locator alertMessage;
    private final Locator facebookButton;
    private final Locator welcomeFacebook;
    private final Locator gmailButton;
    private final Locator welcomeGmail;
    private final Locator telegramButton;
    private final Locator telegramError;
    private final Locator emailButton;
    private final Locator phoneButton;
    private final Locator emailInput;
    private final Locator phoneInput;
    private final Locator acceptConditionsCheck;
    private final Locator passwordInput;
    private final Locator reenterPasswordInput;
    private final Locator promoCodeCheck;
    private final Locator promoCodeInput;
    private final Locator noBonusCheck;
    private final Locator createAccountButton;
    private final Locator successMessage;
    private final Locator codeVerification;

    public SignUpPage(Page page) {
        //Giving value to the Locators
        this.page = page;
        this.alertMessage = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Got it"));
        this.facebookButton = page.locator("#registration_form_1 > div.form__section.form__section--links > ul > li:nth-child(1) > a > i");
        this.welcomeFacebook = page.getByText("Log Into Facebook");
        this.gmailButton = page.locator("#registration_form_1 > div.form__section.form__section--links > ul > li:nth-child(2) > a > i");
        this.welcomeGmail = page.getByText("Sign in with Google");
        this.telegramButton = page.locator("#registration_form_1 > div.form__section.form__section--links > ul > li:nth-child(3) > a > i");
        this.telegramError = page.locator("html");
        this.emailButton = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("E-mail"));
        this.phoneButton = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Phone"));
        this.emailInput = page.locator("[data-test='input-email']");
        this.phoneInput = page.locator("[data-test='input-phone']");
        this.acceptConditionsCheck = page.getByText("I unconditionally agree with Terms & Conditions, Data Policy, Cookie Policy and ");
        this.passwordInput = page.locator("[data-test = 'input-password']");
        this.reenterPasswordInput = page.locator("[data-test = 'input-password_confirmation']");
        this.promoCodeCheck = page.locator("label").filter(new Locator.FilterOptions().setHasText("Use a promo code"));
        this.promoCodeInput = page.getByPlaceholder("Promo code");
        this.noBonusCheck = page.locator("label").filter(new Locator.FilterOptions().setHasText("No bonus"));
        this.createAccountButton = page.locator("[data-test='control-submit']");
        this.successMessage = page.getByText("Registration successfully finished! Confirmation has been sent to you.");
        this.codeVerification = page.getByText("Verification code");
    }
        //Method to navigate to the registration page
        public void navigate(){
            page.navigate("https://demo.casino/user/registration");
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

        public void emailButton(){
            this.emailButton.click();
        }

        public void phoneButton(){
            this.phoneButton.click();
        }

        public void emailInput(String email){
            this.emailInput.fill(email);
        }
        public void setPhoneInput(String phone){
            this.phoneInput.fill(phone);
        }
        public void checkCode(){
            assertThat(this.codeVerification).isVisible();
        }
        public void acceptConditionsCheck(){
            this.acceptConditionsCheck.click();
        }

        public void setPasswordInput(String password){
             this.passwordInput.fill(password);
        }

        public void setReenterPasswordInput(String reenterPassword){
             this.reenterPasswordInput.fill(reenterPassword);
        }

        public void setPromoCodeCheck(){
             this.promoCodeCheck.click();
        }

        public void setPromoCodeInput(String promoCode){
             this.promoCodeInput.fill(promoCode);
        }

        public void setNoBonusCheck(){
             this.noBonusCheck.click();
        }

        public void createAccountButton(){
            this.createAccountButton.click();
        }
        public void validateSuccess(){
        assertThat(this.successMessage).isVisible();
        }
    }
