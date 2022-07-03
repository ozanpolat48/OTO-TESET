package FrontEnd.Pages;

import FrontEnd.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

public abstract class BasePage {

    public BasePage(){PageFactory.initElements(Driver.getDriver(),this);}

    public void pressEnter(WebElement element,String text){
        element.sendKeys(text+ Keys.ENTER);
    }


}
