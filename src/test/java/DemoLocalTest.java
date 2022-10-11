import base.LocalTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DemoLocalTest extends LocalTest {

    @Test
    public void open_app() throws MalformedURLException, InterruptedException {
        iOS_setUp();
        homePage.showIOSNotifications();
        Thread.sleep(3000);
        homePage.hideIOSNotifications();
/*        Enterprise_setUp();
        homePage.listNotifications();
        homePage.clickNotification("Jaderson");
        Thread.sleep(5000);
        homePage.listNotifications();
        homePage.clearAllNotifications();
        System.out.println("Test steps complete");
        Thread.sleep(3000);
        tearDown();*/
    }
}
