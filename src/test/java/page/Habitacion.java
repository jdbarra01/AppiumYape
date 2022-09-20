package page;

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import util.AccionesGenericas;

import java.io.IOException;

import static driver.DriverContext.getDriver;
import static util.AccionesGenericas.existeElemento;

public class Habitacion {

    public AppiumDriver driver;
    public int tiempo = 3;
    public int tiempoLargo = 10;

    private String a;


    public Habitacion() {
        this.driver = getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/select_room_cta")
    private MobileElement btnHabitacion;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/list_item")
    private MobileElement titleHabitacion;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/main_action")
    private MobileElement btnReserva;

    @Step("Page Habitacion: realiza reserva de habitacion")
    public void resevaHabitacion() throws IOException {
        if (existeElemento(btnHabitacion, tiempo)) {
            btnHabitacion.click();
        }
        AccionesGenericas.saveScreenshot("Page Habitacion: realiza reserva de habitacion");

    }

    @Step("Page Habitacion: seleciona estancia")
    public void elegirEstacia() throws IOException {
        if (existeElemento(titleHabitacion, tiempo)) {
            titleHabitacion.click();
        }
        AccionesGenericas.saveScreenshot("Page Habitacion: seleciona estancia");
    }

    @Step("Page Habitacion: realiza reserva")
    public void reservarAhora() throws IOException {
        if (existeElemento(btnReserva, tiempo)) {
            btnReserva.click();
        }
        AccionesGenericas.saveScreenshot("Page Habitacion: realiza reserva");
    }
}
