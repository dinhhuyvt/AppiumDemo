import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Utils {
    DesiredCapabilities caps = new DesiredCapabilities();
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    public void androidRealDevSetup() throws MalformedURLException {

        caps.setCapability("deviceName", "E6883");
        caps.setCapability("udid", "CB5A29JCZT"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.1.1");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.android.calculator2"); //real device
        caps.setCapability("appActivity","com.android.calculator2.Calculator");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps); //real device

        wait = new WebDriverWait(driver, 10);
    }

    public void androidVirtualDevSetup () throws MalformedURLException {

        caps.setCapability("deviceName", "Galaxy Nexus API 24");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.android.dialer"); //virtual device
        caps.setCapability("appActivity","com.android.dialer.DialtactsActivity");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps); //virtual device
        wait = new WebDriverWait(driver, 10);
    }

    public void iosSetup() throws MalformedURLException {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/build/");
        File app = new File(appDir, "WordPress.app");
        caps.setCapability("platformVersion", "9.2");
        caps.setCapability("deviceName", "iPhone 6");
        caps.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }
}
