package mobile;

import base.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends PageBase {
    public HomePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "com.android.systemui:id/clear_all")
    MobileElement clearNotificationsBtn;

    public void clearAllNotifications(){
        click(clearNotificationsBtn);
    }

    public void clickNotification(String notification){
        getNotification(notification);
    }

    public void listNotifications(){
        swipeNotifications();
    }
}
