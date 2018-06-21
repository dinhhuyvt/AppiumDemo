import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest extends TestBase{

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    CalculatorObjects calculatorObjects;
    CalculatorMethods calculatorMethods;


    @BeforeMethod
    //Setup real device to run appium automation
    public void setupRealDevice () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
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
        calculatorObjects = new CalculatorObjects(driver);
        calculatorMethods = new CalculatorMethods(driver);
    }



    /*
    //Virtual Device
    public void setupVirtualDevice () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
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
*/

    @Test
    public void tc01_AddTwoNumbers () throws IOException, InterruptedException {
        try{
        testReport = reporter.createTest("tc01_AddTwoNumbers");
        System.out.println("\r\n ----------Add any 2 numbers----------");
        log("Step 1: Get two numbers");
        String num01 = ReadData.getNum(1,0);
        String num02 = ReadData.getNum(1, 1);
        System.out.println("Number 01: " + num01);
        System.out.println("Number 02: " + num02);

        log("Step 2: Get expected result");
        String addExpResult = ReadData.getNum(1,2);
        System.out.println("Expected add number: " + addExpResult);

        log("Step 3: Implement add method");
        String addActResult = calculatorMethods.methodAddTwoNumbers(num01,num02);
        System.out.println("Actual add result: " + addActResult);

        log("Step 4: Compare actual result to expected result");
        Assert.assertEquals(addActResult, addExpResult);
        }
        catch (Exception ex)
        {
            logExtentReportFail("Error message : " + ex.getMessage());
        }
        driver.quit();
    }

    @Test
    public void tc02_SubtractTwoNumbers () throws IOException, InterruptedException {
        try{
            testReport = reporter.createTest("tc02_SubtractTwoNumbers");
        System.out.println("\r\n ----------Subtract any 2 numbers----------");
            log("Step 1: Get two numbers");
        String num01 = ReadData.getNum(2,0);
        String num02 = ReadData.getNum(2, 1);
        System.out.println("Number 01: " + num01);
        System.out.println("Number 02: " + num02);

            log("Step 2: Get expected result");
        String subtractExpResult = ReadData.getNum(2,2);
        System.out.println("Expected subtract number: " + subtractExpResult);

            log("Step 3: Implement subtract method");
        String subtractActResult = calculatorMethods.methodSubtractTwoNumbers(num01,num02);
        System.out.println("Actual subtract result: " + subtractActResult);

            log("Step 4: Compare actual result to expected result");
        Assert.assertEquals(subtractActResult, subtractActResult);
        }
        catch (Exception ex)
        {
            logExtentReportFail("Error message : " + ex.getMessage());
        }
        driver.quit();
    }

    @Test
    public void tc03_MultiplyTwoNumbers () throws IOException, InterruptedException {
        try{
            testReport = reporter.createTest("tc03_MultiplyTwoNumbers");
        System.out.println("\r\n ----------Multiply any 2 numbers----------");

            log("Step 1: Get two numbers");
        String num01 = ReadData.getNum(3,0);
        String num02 = ReadData.getNum(3, 1);
        System.out.println("Number 01: " + num01);
        System.out.println("Number 02: " + num02);

            log("Step 2: Get expected result");
        String multiplyExpResult = ReadData.getNum(3,2);
        System.out.println("Expected multiply result: " + multiplyExpResult);

            log("Step 3: Implement Multiply method");
        String multiActResult = calculatorMethods.methodMultiplyTwoNumbers(num01,num02);
        System.out.println("Actual multiply result: " + multiActResult);

            log("Step 4: Compare actual result to expected result");
        Assert.assertEquals(multiActResult, multiplyExpResult);
        }
        catch (Exception ex)
        {
            logExtentReportFail("Error message : " + ex.getMessage());
        }
        driver.quit();
    }

    @Test
    public void tc04_DevidedTwoNumbers () throws IOException, InterruptedException {
        try{
            testReport = reporter.createTest("tc04_DevidedTwoNumbers");
        System.out.println("\r\n ----------Devide any 2 numbers----------");

            log("Step 1: Get two numbers");
        String num01 = ReadData.getNum(4,0);
        String num02 = ReadData.getNum(4, 1);
        System.out.println("Number 01: " + num01);
        System.out.println("Number 02: " + num02);

            log("Step 2: Get expected result");
        String devidedExpResult = ReadData.getNum(4,2);
        System.out.println("Expected devided result: " + devidedExpResult);

            log("Step 3: Implement Devide method");
        String devidedActResult = calculatorMethods.methodDevidedTwoNumbers(num01,num02);
        System.out.println("Actual devided result: " + devidedActResult);

            log("Step 4: Compare actual result to expected result");
        Assert.assertEquals(devidedActResult, devidedExpResult);
        }
        catch (Exception ex)
        {
            logExtentReportFail("Error message : " + ex.getMessage());
        }
        driver.quit();
    }

}
