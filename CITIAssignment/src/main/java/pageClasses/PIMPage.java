package pageClasses;

import base.BaseClass;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ActionClass;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;

public class PIMPage extends BaseClass {

    @FindBy(xpath = "(//li[@class='oxd-topbar-body-nav-tab'])[1]")
    private WebElement AddEmployee;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement FirstName;
    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement MiddleName;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement LastName;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//a[text()='Employee List']")
    private WebElement EmployeeList;

    @FindBy(css= "(//div[contains(@class,'autocomplete-text')])[1]")
    private WebElement name;
    public PIMPage() {
        PageFactory.initElements(driver, this);
    }
    public void AddEmployee() throws AWTException {
        Point location = AddEmployee.getLocation();
        int xpoint = location.getX();
        int ypoint=location.getY();
        Robot robot=new Robot();
        robot.mouseMove(xpoint, ypoint);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void AddDetails(String firstname, String middlename, String lastname) throws InterruptedException {
        Thread.sleep(2000);
        ActionClass.enterText(FirstName, firstname);
        log.info("First Name entered");
        Thread.sleep(2000);
        ActionClass.enterText(MiddleName, middlename);
        log.info("Middle Name Entered");
        Thread.sleep(2000);
        ActionClass.enterText(LastName, lastname);
        log.info("Last name entered");
    }
    public void ClickElement(){
        ActionClass.clickElement(submit);
        log.info("Click on Save button");
    }

    public void SearchEmployee(String Epname) throws InterruptedException {
        Thread.sleep(2000);
        ActionClass.clickElement(EmployeeList);
        Thread.sleep(2000);
        ActionClass.enterText(name, Epname);
        log.info("Searched Employee");
    }

}
