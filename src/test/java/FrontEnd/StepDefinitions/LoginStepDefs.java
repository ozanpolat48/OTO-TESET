package FrontEnd.StepDefinitions;

import FrontEnd.Pages.BasePage;
import FrontEnd.Pages.LoginPage;
import FrontEnd.Pages.MainPage;
import FrontEnd.Utilities.BrowserUtils;
import FrontEnd.Utilities.ConfigurationReader;
import FrontEnd.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    String usernameGlobal;
    String passwordGlobal;

    @Given("user able to navigates login page")
    public void userAbleToNavigatesLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Given("user fills username as {string} and password as {string}")
    public void userFillsUsernameAsAndPasswordAs(String username, String password) {
        loginPage.login(username,password);
        usernameGlobal=username;
        passwordGlobal=password;
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.loginButton.click();
        BrowserUtils.waitFor(5);
    }

    @When("user verify that username {string}")
    public void userVerifyThatUsername(String expectedUsername) {
        mainPage.accountDropdown.click();
        BrowserUtils.waitForVisibility(mainPage.accountUsernameDropdown,10);
        Assert.assertEquals(mainPage.accountUsernameDropdown.getText(),expectedUsername);
    }

    @And("user verify that url as {string}")
    public void userVerifyThatUrlAs(String expectedURL) {
        BrowserUtils.waitFor(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedURL);
    }

    @Then("user successfully logout")
    public void userSuccessfullyLogout() {
        BrowserUtils.waitForClickablility(mainPage.accountLogoutDropdown,10);
        mainPage.accountLogoutDropdown.click();
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://qa.seamlessly.net/index.php/login?clear=1");
    }

    @And("user press enter for login")
    public void userPressEnterForLogin() {
        loginPage.passwordInput.sendKeys(Keys.ENTER);
    }

    @Then("user should see error message as {string}")
    public void userShouldSeeErrorMessageAs(String expectedErrorMessage) {
        BrowserUtils.waitForVisibility(loginPage.wrongCredentialsMessage,5);
        Assert.assertEquals(loginPage.wrongCredentialsMessage.getText(),expectedErrorMessage);
    }

    @Then("user should see blank error message as {string}")
    public void userShouldSeeBlankErrorMessageAs(String expectedErrorMessage) {
    if (usernameGlobal.equals("")){
        String actualErrorMessage = loginPage.usernameBlankErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }else if (passwordGlobal.equals("")){
        String actualErrorMessage = loginPage.passwordBlankErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
    }

    @Then("verify that filled password input shown by default")
    public void verifyThatFilledPasswordInputShownByDefault() {
        String acutualType = loginPage.passwordInput.getAttribute("type");
        Assert.assertEquals(acutualType,"password");
    }

    @When("user clicks on password toggle button")
    public void userClicksOnPasswordToggleButton() {
        loginPage.passwordToggleButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("user verify that password is visible")
    public void userVerifyThatPasswordIsVisible() {
        String acutualType = loginPage.passwordInput.getAttribute("type");
        Assert.assertEquals(acutualType,"text");
    }

    @Given("user verify that username placeholder as {string} and password placeholder as {string}")
    public void userVerifyThatUsernamePlaceholderAsAndPasswordPlacholderAs(String username, String password) {
        Assert.assertEquals(loginPage.usernamePlaceholder.getText(),username);
        Assert.assertEquals(loginPage.passwordPlaceholder.getText(),password);
    }
}
