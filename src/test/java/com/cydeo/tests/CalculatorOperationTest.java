package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorOperationTest {
    AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setCapability("deviceName", "Pixel 3");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        //set URL for the appium server
        URL url = new URL("http://localhost:4723/wd/hub");

        //launch appiumDriver
        driver = new AndroidDriver<MobileElement>(url, caps);
    }

    @Test
    public void addTest() {
        MobileElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        MobileElement one = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        MobileElement zero = driver.findElement(By.id("com.google.android.calculator:id/digit_0"));
        MobileElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        five.click();
        plus.click();
        one.click();
        zero.click();
        equal.click();

        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));

        String actResult = result.getText();
        System.out.println("actResult = " + actResult);

        int expResult = 15;

        Assertions.assertEquals(expResult, Integer.parseInt(actResult));

    }

    @Test
    public void test2(){
        //   15/5=3

        MobileElement one = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        one.click();
        MobileElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        five.click();
        //
        MobileElement divide = driver.findElement(MobileBy.AccessibilityId("divide"));
        divide.click();
        five.click();
        MobileElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        equal.click();

        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));

        String actResult = result.getText();
        System.out.println("actResult = " + actResult);

        int expResult = 3;

        Assertions.assertEquals(expResult, Integer.parseInt(actResult));


    }

    @AfterEach
    public void cleanUp() {
         driver.closeApp();
    }
}