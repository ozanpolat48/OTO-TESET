package FrontEnd.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']//img")
    public WebElement accountDropdown;

    @FindBy(xpath = "//span[@title='Employee3']")
    public WebElement accountUsernameDropdown;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    public WebElement accountLogoutDropdown;
}
