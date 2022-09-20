package page;

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static driver.DriverContext.getDriver;

public class Datos {
    public AppiumDriver driver;
    public int tiempo = 3;
    public int tiempoLargo = 10;

    private String a;


    public Datos() {
        this.driver = getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/firstname")
    private MobileElement name;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/lastname")
    private MobileElement apellido;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/email")
    private MobileElement mail;

    //Hasta esta items no puedo continuar, ya que la app tiene el sistema de captura bloqueado
    public void ingresoDatos() {
        name.sendKeys("");
        apellido.sendKeys("");
        mail.sendKeys("");
    }

}


