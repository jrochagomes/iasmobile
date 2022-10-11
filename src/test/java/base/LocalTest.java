package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.windows.WindowsDriver;
import mobile.HomePage;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalTest {
    public static AppiumDriver driver;
    public static WindowsDriver calculator;

    protected static HomePage homePage;

    public static void Android_setUp() throws MalformedURLException {
        //BrowseStack
        DesiredCapabilities capsMobile = new DesiredCapabilities();
        capsMobile.setCapability("platform", "Android");
        capsMobile.setCapability("automationName", "UiAutomator2");
        capsMobile.setCapability("platformVersion", "12");
        capsMobile.setCapability("deviceName", "RQCT303VCZH");
        capsMobile.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capsMobile.setCapability("appActivity", ".Calculator");
        driver = new AppiumDriver(new URL("http://localhost:4777/wd/hub"), capsMobile);
        homePage = new HomePage(driver);
    }
    public static void iOS_setUp() throws MalformedURLException {
        DesiredCapabilities capsMobile = new DesiredCapabilities();
        capsMobile.setCapability("platform", "iOS");
        capsMobile.setCapability("automationName", "XCUITest");
        capsMobile.setCapability("platformVersion", "14.4");
        capsMobile.setCapability("deviceName", "iPhone 12");
        capsMobile.setCapability("app", System.getProperty("user.dir") + "/resources/UIKitCatalog.app");
        driver = new AppiumDriver(new URL("http://localhost:4777/wd/hub"), capsMobile);
        homePage = new HomePage(driver);
    }

    public static void Enterprise_setUp() throws MalformedURLException {
        DesiredCapabilities capsCalculator = new DesiredCapabilities();
        capsCalculator.setCapability("app","Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        calculator = new WindowsDriver(new URL("http://localhost:4723"),capsCalculator);
    }

    public static void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }

}
