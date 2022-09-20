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
import java.util.ArrayList;
import java.util.List;

import static driver.DriverContext.getDriver;
import static util.AccionesGenericas.*;

public class ResultadoBusqueda {
    public static AppiumDriver driver;
    public static int tiempo = 3;
    public int tiempoLargo = 10;


    public ResultadoBusqueda() {
        this.driver = getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/toolbar_item_label")
    private static MobileElement cuerpoFiltros;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/facet_search_box_cta")
    private static MobileElement btnSearch;

    @AndroidFindBy(id = Constants.APP_PACKAGE_ID + ":id/genius_onbaording_bottomsheet_cta")
    private static MobileElement btnEmpezarBusqueda;

    @Step("Page Resultado Busqueda: realiza busqueda")
    public static void search() throws InterruptedException, IOException {
        if (existeElemento(btnSearch, tiempo)) {
            btnSearch.click();
            if (existeElemento(btnEmpezarBusqueda, tiempo)) {
                ((AndroidDriver<MobileElement>) getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
            }
            encontrarObjeto(cuerpoFiltros, "Page Resultado de busqueda");
            Thread.sleep(3000);
            scrollAbajoCorto();
            if (existeElemento(btnEmpezarBusqueda, tiempo)) {
                ((AndroidDriver<MobileElement>) getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
            }
            List<WebElement> weList = driver.findElements(By.className("android.view.ViewGroup"));
            List<String> weText = new ArrayList<>();
            for (WebElement webElement : weList) {
                weText.add(webElement.getText());
                weList.get(14).click();
                break;
            }
        } else {
            Assert.fail("No se logro realizar la busqueda de hotel");
        }
        AccionesGenericas.saveScreenshot("Page Resultado Busqueda: realiza busqueda");

    }

}
