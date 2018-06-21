import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class CalculatorObjects {
    public AppiumDriver<MobileElement> driver;

    public MobileElement dig_1;
    public MobileElement dig_2;
    public MobileElement dig_3;
    public MobileElement dig_4;
    public MobileElement dig_5;
    public MobileElement dig_6;
    public MobileElement dig_7;
    public MobileElement dig_8;
    public MobileElement dig_9;
    public MobileElement dig_0;
    public MobileElement btnAdd;

    public CalculatorObjects(AppiumDriver<MobileElement> driver) {
        this.driver = driver;

        dig_1 = driver.findElement(By.id("com.android.calculator2:id/digit_1"));
        dig_2 = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        dig_3 = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
        dig_4 = driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        dig_5 = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        dig_6 = driver.findElement(By.id("com.android.calculator2:id/digit_6"));
        dig_7 = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
        dig_8 = driver.findElement(By.id("com.android.calculator2:id/digit_8"));
        dig_9 = driver.findElement(By.id("com.android.calculator2:id/digit_9"));
        dig_0 = driver.findElement(By.id("com.android.calculator2:id/digit_0"));

        btnAdd = driver.findElement(By.id("com.android.calculator2:id/op_add"));
    }

}
