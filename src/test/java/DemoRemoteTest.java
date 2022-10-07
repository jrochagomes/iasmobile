import base.BrowserStackTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DemoRemoteTest extends BrowserStackTest {

    @Test
    public void open_app() throws MalformedURLException, InterruptedException {
        Android_setUp();
        Enterprise_setUp();
        homePage.listNotifications();
        Thread.sleep(2000);
        homePage.clickNotification("Appium");
        Thread.sleep(5000);
        homePage.clearAllNotifications();
        System.out.println("Test steps complete");
        tearDown();
    }
}
