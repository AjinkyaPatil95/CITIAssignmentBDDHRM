package pageClasses;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ActionClass;

public class LoginPage extends BaseClass {

    @FindBy (xpath="//input[@name='username']")
    private WebElement UserName;

    @FindBy (xpath="//input[@name='password']")
    private WebElement PassWord;

    @FindBy (xpath="//button[@type='submit']")
    private WebElement Submit;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void login(String username, String password){
        ActionClass.enterText(UserName, username);
        log.info("Username entered");
        ActionClass.enterText(PassWord, password);
        log.info("Password entered");
        ActionClass.clickElement(Submit);
        log.info("click on Login Button");
    }
}
