package FrontEnd.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends BasePage{

    @FindBy(xpath = "//input[@id='reset-password-submit']")
    public WebElement resetPasswordButton;

    @FindBy(xpath = "//input[@id='user']")
    public WebElement usernameInput;


}
