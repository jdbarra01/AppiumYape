package driver;

import constants.OS;


import io.appium.java_client.AppiumDriver;


public class DriverContext {
    public static DriverManager driverManager = new DriverManager();


    public static void setUp(OS os, String udId, String deviceName, Boolean emulador, String fileName, Boolean continueFlow) {
        driverManager.resolveDriver(os, udId, deviceName, emulador, fileName, continueFlow);
    }


    public static AppiumDriver getDriver() {
        return driverManager.getDriver();
    }

    public static void quitDriver() {
        driverManager.getDriver().quit();
    }


}
