import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class ioSampleTest {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    //Elements
    String secondNewJob = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
            "android.widget.RelativeLayout/android.widget.ImageView";

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "E6883");
        caps.setCapability("udid", "CB5A29JCZT"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.1.1");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.sonymobile.android.dialer");
        caps.setCapability("appActivity","com.android.dialer.DialtactsActivity");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);

        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public void basicTest () throws InterruptedException {
        //Click and pass Splash
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.isinolsun.app:id/animation_view"))).click();

        //Click and pass Tutorial
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.isinolsun.app:id/btn_skip"))).click();

        //Click to "Is Ariyorum" Button
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.isinolsun.app:id/bluecollar_type_button"))).click();


        //Notification Allow
        if (driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).size()>0) {
            driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).get(0).click();
        }

        //Click second job
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(secondNewJob))).click();
        
    }

    @Test
    public void basicTestDialer () throws InterruptedException {
        //Click and pass Splash
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("Contacts"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='Contacts']"))).click();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
