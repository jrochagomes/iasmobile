package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.windows.WindowsDriver;
import mobile.HomePage;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackTest {
    public static AndroidDriver<AndroidElement> android_driver;
    public static IOSDriver<IOSElement> ios_driver;
    public static WindowsDriver calculator;
    public static String userName = "antonsirota2";
    public static String accessKey = "LtEJWxgayA2eVtAr3qzq";
    protected static HomePage homePage;

    public static void Android_setUp() throws MalformedURLException {
        //BrowseStack
        DesiredCapabilities capsMobile = new DesiredCapabilities();
        capsMobile.setCapability("device", "Samsung Galaxy S22");
        capsMobile.setCapability("os_version", "12.0");
        capsMobile.setCapability("project", "POC - IAS & Mobile");
        capsMobile.setCapability("build", "First Build");
        capsMobile.setCapability("name", "Sample Test");
        capsMobile.setCapability("app", "bs://7c8d4c9b80932036e570b21251342a6687460732");
        android_driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capsMobile);
        homePage = new HomePage(android_driver);
    }
    public static void iOS_setUp() throws MalformedURLException{
        DesiredCapabilities capsMobile = new DesiredCapabilities();
        capsMobile.setCapability("device", "iPhone 13");
        capsMobile.setCapability("os_version", "15");
        capsMobile.setCapability("project", "POC - IAS & Mobile");
        capsMobile.setCapability("build", "First Build");
        capsMobile.setCapability("name", "Sample Test");
        capsMobile.setCapability("app", "bs://10e80559448c9c9a4e1543ce589f3ef5ac02f5ae");
        ios_driver = new IOSDriver<IOSElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capsMobile);
        homePage = new HomePage(ios_driver);

    }
    public static void Enterprise_setUp() throws MalformedURLException {
        DesiredCapabilities capsCalculator = new DesiredCapabilities();
        capsCalculator.setCapability("app","Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        calculator = new WindowsDriver(new URL("http://localhost:4723"),capsCalculator);
    }

    public static void tearDown(){
        android_driver.quit();
    }

}
