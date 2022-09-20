package util;

import driver.DriverContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static driver.DriverContext.getDriver;

public class AccionesGenericas {

    public static void esperar(int segundos) throws InterruptedException {
        long sec = segundos * 5;
        getDriver().manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }


    public static boolean existeElemento(MobileElement objeto, int segundos) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), (long) segundos);
            wait.until(ExpectedConditions.visibilityOf(objeto));
            return true;
        } catch (Exception var3) {
            return false;
        }
    }


    public static boolean visualizarObjeto(MobileElement objeto, int segundos) {
        try {
            System.out.println("Buscamos el objeto:" + objeto + ", esperamos " + segundos + " segundos, hasta que aparezca.");
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), segundos);
            wait.until(ExpectedConditions.visibilityOf(objeto));
            System.out.println("Se encontró objeto:" + objeto + ", se retorna true.");
            return true;
        } catch (Exception e) {
            System.out.println("No se encontró objeto:" + objeto + ", se retorna false.");
            return false;
        }
    }


    public static void scrollAbajo() {
        Dimension size = getDriver().manage().window().getSize();
        int anchor, startPoint, endPoint;
        anchor = (int) (size.width * 0.080);
        startPoint = (int) (size.height * 0.8);
        endPoint = (int) (size.height * 0.4);
        new TouchAction(getDriver()).press(PointOption.point(anchor, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(anchor, endPoint)).release().perform();
    }


    public static void scrollAbajoCorto() {
        Dimension size = getDriver().manage().window().getSize();
        int anchor, startPoint, endPoint;
        anchor = (int) (size.width * 0.090);
        startPoint = (int) (size.height * 0.4);
        endPoint = (int) (size.height * 0.2);
        new TouchAction(getDriver()).press(PointOption.point(anchor, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(anchor, endPoint)).release().perform();
    }

    public static void saveScreenshot(String nameScreenshot) throws IOException {
        try {
            File screenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment(nameScreenshot, FileUtils.openInputStream(screenShot));
        } catch (Exception e) {
            System.out.println("No se pudo sacar Screenshot");
            System.out.println("Causa: " + e.getCause().toString() + " \n" + "StackTrace: " + e.fillInStackTrace().toString());
        }
    }

    public static void encontrarObjeto(MobileElement elemento, String detalle) {
        boolean existe;
        int intento = 0;
        existe = AccionesGenericas.existeElemento(elemento, 1);
        while (!existe) {
            existe = AccionesGenericas.existeElemento(elemento, 1);
            intento++;
            if (intento == 10) {
                Assert.fail("NO se visualiza el resultado esperado");
            }
        }
    }

    public static String readData(String param) {
        Properties prop = new Properties();
        String Value = "NULL";
        try {
            InputStream input = new FileInputStream("src/main/resources/datos.properties");
            prop.load(input);
            Value = prop.getProperty(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Value;
    }

}
