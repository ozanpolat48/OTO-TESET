package FrontEnd.StepDefinitions;

import FrontEnd.Pages.LoginPage;
import FrontEnd.Pages.ResetPasswordPage;
import FrontEnd.Utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ResetPasswordSteps {
    LoginPage loginPage = new LoginPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();


    @Given("user clicks on forgot password link")
    public void user_clicks_on_forgot_password_link() {
    loginPage.forgotPassowordButton.click();
    }
    @Then("user verify that {string} button visible")
    public void user_verify_that_button_visible(String buttonText) {
        BrowserUtils.waitForVisibility(resetPasswordPage.resetPasswordButton,5);
        Assert.assertEquals(resetPasswordPage.resetPasswordButton.getText(),buttonText);
    }
}
