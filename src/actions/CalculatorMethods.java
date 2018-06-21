import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class CalculatorMethods {
    public AppiumDriver<MobileElement> driver;
    CalculatorObjects calculatorObjects;

    public CalculatorMethods(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        calculatorObjects = new CalculatorObjects(driver);
    }

    public void pressNumber(String n) throws InterruptedException{
        String number = String.valueOf(n);
        for(int i = 0; i < number.length(); i++){
            int j = Character.digit(number.charAt(i), 10);

            driver.findElement(By.id("com.android.calculator2:id/digit_" + j)).click();
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }

    public String methodAddTwoNumbers(String n1, String n2) throws InterruptedException {

        pressNumber(n1);
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        pressNumber(n2);
        driver.findElement(By.id("equals")).click();

        String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        return result;
    }

    public String methodSubtractTwoNumbers(String n1, String n2) throws InterruptedException {
        pressNumber(n1);
        driver.findElement(By.id("com.android.calculator2:id/op_sub")).click();
        pressNumber(n2);
        driver.findElement(By.id("equals")).click();

        String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        return result;
    }

    public String methodMultiplyTwoNumbers(String n1, String n2) throws InterruptedException {
        pressNumber(n1);
        driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
        pressNumber(n2);
        driver.findElement(By.id("equals")).click();

        String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        return result;
    }

    public String methodDevidedTwoNumbers(String n1, String n2) throws InterruptedException {
            pressNumber(n1);
            driver.findElement(By.id("com.android.calculator2:id/op_div")).click();
            pressNumber(n2);
            driver.findElement(By.id("equals")).click();

            String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
            return result;

    }
}
