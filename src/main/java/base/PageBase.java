package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class PageBase {

    AppiumDriver driver;
    public static final long WAIT = 10;

    public PageBase(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
    }

    public void waitForVisibility(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(MobileElement element) {
        waitForVisibility(element);
        element.clear();
    }

    public void click(MobileElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void sendText(MobileElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public String getAttribute(MobileElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    @SuppressWarnings("unchecked")
    public void notifications() {
        Map<String, Object> response = (Map<String, Object>) driver.executeScript("mobile: getNotifications");
        List<Map<String, Object>> notifications = (List<Map<String, Object>>) response.get("statusBarNotifications");
        for (Map<String, Object> notification : notifications) {
            Map<String, String> innerNotification = (Map<String, String>) notification.get("notification");
            if (innerNotification.get("title") != null) {
                System.out.println(innerNotification.get("title"));
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void androidNotifications(){
        Dimension dim = driver.manage().window().getSize();
        int h = dim.getHeight();
        int w = dim.getWidth();

        int x = (int) (w*0.2);
        int bottom = (int) (h*0.2);

        TouchAction action;
        action = new TouchAction(driver);
        action.press(PointOption.point(x,5))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(x,bottom)).release().perform();
    }
    public void iOSNotifications(Boolean show){
        Dimension dim = driver.manage().window().getSize();
        int h = dim.getHeight();
        int w = dim.getWidth();

        int y = 5;
        int x = (int) (w*0.2);

        PointOption top = PointOption.point(x,y);
        PointOption bottom = PointOption.point(x, h-y);

        TouchAction action;
        action = new TouchAction(driver);
        if(show){
            action.press(top);
        } else {
            action.press(bottom);
        }
        action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
        if(show){
            action.moveTo(bottom);
        } else {
            action.moveTo(top);
        }
        action.perform();
    }

    public void specificAndroidNotification(String notification){
        driver.findElementByXPath("//*[contains(@text,'"+notification+"')]").click();
    }
    public void specificIOSNotification(String notification){
        driver.findElementByXPath("//XCUIElementTypeCell[contains(@label,'"+notification+"')]").click();
    }
}
