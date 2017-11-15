package com.belatrix.connect.page;

import com.belatrix.connect.framework.ParentPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ManageEventBelaPage extends ParentPage {

    public ManageEventBelaPage(AppiumDriver driver) {
        super(driver);
    }

    By BTN_REGISTER = By.id("com.belatrixsf.connect:id/btn_register");
    By LBL_UPCOMING_EVENTS = By.xpath("//android.widget.TextView[@text='My upcoming events']");
    By BTN_OK = By.xpath("//android.widget.Button[@text='Got it!']");


// Event Page register
    public void RegisterUser() {
        handlingWaitToElement(BTN_REGISTER);
        click(BTN_REGISTER);
    }

    public String getStatus() {
        return getElementValue(BTN_REGISTER);
    }

    public void searchEventByName(String eventName) {
        handlingWaitToElement(LBL_UPCOMING_EVENTS);
        String eventXpath = String.format("//android.widget.TextView[@text='%1$s']", eventName);
        click(By.xpath(eventXpath));
    }

    public void waitElement() {
        handlingWaitToElement(BTN_OK);
        click(BTN_OK);
    }

}
