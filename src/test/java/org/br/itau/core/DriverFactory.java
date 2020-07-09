package org.br.itau.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private AppiumDriver<MobileElement> driver;

    public DriverFactory(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public DriverFactory() {
    }


    public AppiumDriver<MobileElement> getDriver(String deviceName, String systemPort, String platformVersion) {
        if (driver == null) {
            createDriver(deviceName, systemPort, platformVersion);
        }
        return driver;
    }

    private void createDriver(String deviceName, String systemPort, String platformVersion) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("udid", deviceName);
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("systemPort", systemPort);
        //desiredCapabilities.setCapability("appPackage", appPackage);
        //desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("autoAcceptAlerts", true);
        //desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/test/resources/app-release (2).apk");

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeDriver() {
        try {
            driver.closeApp();
            driver.close();
            driver.quit();
        } catch (Exception ex) {
            String error = ex.toString();
        }
    }


}
