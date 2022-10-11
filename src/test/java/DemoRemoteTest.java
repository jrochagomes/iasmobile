import base.BrowserStackTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DemoRemoteTest extends BrowserStackTest {

    @Test
    public void open_app() throws MalformedURLException, InterruptedException {
        iOS_setUp();
        homePage.showIOSNotifications();
        Thread.sleep(3000);
        homePage.hideIOSNotifications();
        tearDown();
    }
}
