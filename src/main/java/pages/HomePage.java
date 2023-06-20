package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    //Defining Locators
    private final Page page;
    private final Locator mainImage;
    private final Locator alertMessage;
    private final Locator signUpButton;
    private final Locator displaySignInButton;
    private final Locator signInButton;
    private final Locator signInForm;
    private final Locator signUpForm;
    public HomePage(Page page) {
        //Giving value to the Locators
        this.page = page;
        this.mainImage = page.locator("div:nth-child(3) > picture > picture > .slider-main-content");
        this.alertMessage = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Got it"));
        this.signUpButton = page.locator("[data-test='nav-reg-head']");
        this.displaySignInButton = page.locator("body > div.helper > header > div > div > div.header--right > div > div.button.header-button.header-button--login");
        this.signInButton = page.locator("[data-test='nav-login-head']");
        this.signInForm = page.locator("body > div.helper > main > div > div > div > div > div.page__header.page__header--center");
        this.signUpForm = page.locator("body > div.helper > main > div > div > div > div.page__header.page__header--center");
    }
    //Method to navigate to the home page
    public void navigate() {
        page.navigate("https://demo.casino/");
    }
    //Methods to interact with the page
    public void checkAlertMessage(){
        assertThat(this.alertMessage).isVisible();
    }
    public void checkMainImage(){
        assertThat(this.mainImage).isVisible();
    }
    public void validateHidden(){
        assertThat(this.alertMessage).isHidden();
    }
    public void closeMessage() {
        this.alertMessage.click();
    }
    public void clickSignUpButton(){
        this.signUpButton.click();
    }
    public void displaySignInButton(){
        this.displaySignInButton.click();
    }
    public void clickSignInButton(){
        this.signInButton.click();
    }
    public void validateSignInForm(){
        assertThat(this.signInForm).isVisible();
    }
    public void validateSignUpForm(){
        assertThat(this.signUpForm).isVisible();
    }
}

