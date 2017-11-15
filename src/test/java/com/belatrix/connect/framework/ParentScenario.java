package com.belatrix.connect.framework;

import com.belatrix.connect.page.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class ParentScenario {
    private AppiumDriver driver;
    protected static LoginPage loginPage;
    protected static NewsPage newsPage;
    protected static MainProfilePage mainProfilePage;
    protected static EditProfilePage editProfilePage;
    protected static ContactProfilePage contactProfilePage;
    protected static ContactsPage contactsPage;
    protected static KudosPage kudosPage;
    protected static SideBarNavigation sideBarNavigation;
    protected static AlertMessageTwoOptions alertMessageTwoOptions;
    protected static ManageEventBelaPage manageEventBelaPage;

    public void startAndroid(){
        String url = "http://localhost:4723/wd/hub";
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
        cap.setCapability(MobileCapabilityType.APP, "C:\\Belatrix\\Appium-CursoBrayan\\app-debug-pre-produccion.apk");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.belatrixsf.connect");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.belatrixsf.connect.ui.SplashActivity");

        try{
            driver = new AndroidDriver<MobileElement>(new URL(url),cap);
        }catch (Exception e){
            System.out.println("Excepcion al momneto de generar el Driver " + e);
        }

        loginPage = new LoginPage(driver);
        newsPage = new NewsPage(driver);
        mainProfilePage = new MainProfilePage(driver);
        editProfilePage = new EditProfilePage(driver);
        contactProfilePage = new ContactProfilePage(driver);
        contactsPage = new ContactsPage(driver);
        kudosPage = new KudosPage(driver);
        sideBarNavigation = new SideBarNavigation(driver);
        alertMessageTwoOptions = new AlertMessageTwoOptions(driver);
        manageEventBelaPage = new ManageEventBelaPage(driver);
    }

    protected void closeDriver() {
        driver.quit();
    }

}
