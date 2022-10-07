import base.LocalTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DemoLocalTest extends LocalTest {

    @Test
    public void open_app() throws MalformedURLException, InterruptedException {
        Android_setUp();
        Enterprise_setUp();
        homePage.listNotifications();
        homePage.clickNotification("Jaderson");
        Thread.sleep(5000);
        homePage.listNotifications();
        homePage.clearAllNotifications();
        System.out.println("Test steps complete");
        tearDown();
    }
}
