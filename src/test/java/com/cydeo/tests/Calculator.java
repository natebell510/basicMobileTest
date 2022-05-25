package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {
    @Test
    public void test1() throws InterruptedException, MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        //Set capabilities
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        //set URL for Appium Server
        URL url = new URL("http://localhost:4723/wd/hub");
        //create driver for Android
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getDeviceTime() = " + driver.getDeviceTime());
        //Assertions.assertTrue(!driver.getDeviceTime().isEmpty());
        //Assertions.assertTrue(driver.getPlatformName().equalsIgnoreCase("android"));
        //2+2=4
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"plus\"]")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();



        //close APP
        driver.closeApp();


    }
}
