package FrontEnd.Pages;

import FrontEnd.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='user']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongCredentialsMessage;

    @FindBy(xpath = "//a[@id='lost-password']")
    public WebElement forgotPassowordButton;

    @FindBy(xpath = "//img[@src='/core/img/actions/toggle.svg']")
    public WebElement passwordToggleButton;

    @FindBy(xpath = "(//input[@placeholder])[1]")
    public WebElement usernamePlaceholder;

    @FindBy(xpath = "(//input[@placeholder])[2]")
    public WebElement passwordPlaceholder;


    public String usernameBlankErrorMessage(){
        return Driver.getDriver().findElement(By.name("user")).getAttribute("validationMessage");
    }

    public String passwordBlankErrorMessage(){
        return Driver.getDriver().findElement(By.name("password")).getAttribute("validationMessage");
    }

    public void login(String username,String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }
}
