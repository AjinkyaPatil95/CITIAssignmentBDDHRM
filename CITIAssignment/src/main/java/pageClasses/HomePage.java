package pageClasses;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ActionClass;

import javax.swing.*;
import java.util.List;

public class HomePage extends BaseClass {
    @FindBy(xpath = "(//li[@class='oxd-main-menu-item-wrapper'])[2]")
    private WebElement PIMPTab;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void homePagePIM() {
        ActionClass.clickElement(PIMPTab);
    }
}
