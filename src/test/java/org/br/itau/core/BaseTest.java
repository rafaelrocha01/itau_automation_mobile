package org.br.itau.core;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class BaseTest {

    protected AppiumDriver<MobileElement> appiumDriver;

    protected AppiumDriver<MobileElement> startTestCase() {
        DriverFactory driverFactory = new DriverFactory();
        appiumDriver = driverFactory.getDriver("9885b5314b5a464556", "8201", "8.0");
        return appiumDriver;
    }

    public void finishTestCase() {
        DriverFactory driverFactory = new DriverFactory(appiumDriver);
        driverFactory.closeDriver();
    }
}
