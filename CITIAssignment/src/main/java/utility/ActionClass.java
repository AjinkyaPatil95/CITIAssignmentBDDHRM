package utility;

import base.BaseClass;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActionClass extends BaseClass {

    public static void enterText(WebElement we, String value) {
        if ((we.isDisplayed()) && (we.isEnabled())) {
            we.sendKeys(value);
        }
    }

    public static void clickElement(WebElement we) {
        if ((we.isDisplayed()) && (we.isEnabled())) {
            we.click();
        }
    }

//    public static void getLink(List<WebElement> PIMPTab) {
//        for (WebElement link : PIMPTab) {
//            if (link.getText().equalsIgnoreCase("PIM"));
//            link.click();
//            break;
//        }
//    }
}