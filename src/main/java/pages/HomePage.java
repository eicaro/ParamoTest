package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    private final Page page;
    private final Locator mainImage;
    private final Locator alertMessage;
    private final Locator signUpButton;
    private final Locator signInButton;


    public HomePage(Page page) {
        this.page = page;
        this.mainImage = page.locator("div:nth-child(3) > picture > picture > .slider-main-content");
        this.alertMessage = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Got it"));
        this.signUpButton = page.locator("[data-test='nav-reg-head']");
        this.signInButton = page.locator("div").filter(new Locator.FilterOptions().setHasText("Sign in"));
    }
    public void navigate() {
        page.navigate("https://demo.casino/");
    }

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
    public void clickSignInButton(){
        this.signInButton.click();
    }
}

