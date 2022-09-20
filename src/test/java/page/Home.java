package page;

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.AccionesGenericas;


import java.io.IOException;

import static driver.DriverContext.getDriver;
import static util.AccionesGenericas.*;

public class Home {
    public AppiumDriver driver;
    public int tiempo = 3;
    public int tiempoLargo = 10;

    private String a;


    public Home() {
        this.driver = getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private MobileElement btnCerrar;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/bui_empty_state_primary_action")
    private MobileElement btnComenzar;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/facet_search_box_basic_field_label")
    private MobileElement labelDestino;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/facet_with_bui_free_search_booking_header_toolbar_content")
    private MobileElement labelDestinoBuscar;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/view_disambiguation_destination_subtitle")
    private MobileElement resultadoDestino;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/facet_search_box_basic_field_label")
    private MobileElement btnCalendario;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/facet_date_picker_confirm")
    private MobileElement btnSelectDate;


    @Step("Page Home: Inicio")
    public void inicio() throws InterruptedException, IOException {
        System.out.println("Page Home: Inicio metodo inicio");
        if (getDriver() instanceof AndroidDriver) {
            esperar(tiempo);
            ((AndroidDriver<MobileElement>) getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));

            if (visualizarObjeto(btnComenzar, tiempo)) {
                ((AndroidDriver<MobileElement>) getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
            }
        }
        AccionesGenericas.saveScreenshot("Page Home: Inicio");
    }

    @Step("Page Home: Destino")
    public void destino(String destino) throws InterruptedException, IOException {
        System.out.println("Page Home: Inicio metodo destino");
        labelDestino.click();
        labelDestinoBuscar.click();
        labelDestinoBuscar.sendKeys(readData(destino));
        esperar(tiempoLargo);
        resultadoDestino.click();
        AccionesGenericas.saveScreenshot("Page Home: Ingreso destino");
    }

    @Step("Page Home: scroll")
    public void scroll() throws InterruptedException, IOException {
        scrollAbajo();
        esperar(tiempo);
        scrollAbajo();
        esperar(tiempo);
        AccionesGenericas.saveScreenshot("Page Home: Realizo scroll");
    }


    @Step("Page Home: selecciono fecha en calendario")
    public void selecionCalendario(String fechaInicio, String fechaTermino) throws Exception {
        try {
            esperar(tiempoLargo);
            scroll();
            By selectorInicio = By.xpath("//android.view.View[@content-desc='" + readData(fechaInicio) + "']");
            WebElement element = getDriver().findElement(selectorInicio);
            element.click();

            By selectorTermino = By.xpath("//android.view.View[@content-desc='" + readData(fechaTermino) + "']");
            WebElement element2 = getDriver().findElement(selectorTermino);
            element2.click();

            if (visualizarObjeto(btnSelectDate, tiempo)) {
                btnSelectDate.click();
            } else {
                Assert.fail("NO se visualiza el objeto indicado" + "Select dates");
            }
            AccionesGenericas.saveScreenshot("Page Home: selecciono fecha en calendario");
        } catch (Exception e) {
            throw new Exception("Error connecting to Appium service : " + e.getMessage());

        }
    }


}