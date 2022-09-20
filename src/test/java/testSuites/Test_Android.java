package testSuites;

import constants.OS;
import driver.DriverContext;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.*;

public class Test_Android {


    @BeforeMethod
    public void setUp() {
       // DriverContext.setUp(OS.ANDROID, "emulator-5554", "Pixel", true, "booking-com-32-9", false);
        DriverContext.setUp(OS.ANDROID, "4845374d4b363098", "S9+", false, "booking-com-32-9", false);

    }

    @AfterMethod
    public void tearDown() {
        DriverContext.quitDriver();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Busca hotela con destino a cuzco")
    public void PA01_ANDROID() throws Exception {
        CPA001_ServiciosAlojamientos cpa001_serviciosAlojamientos = new CPA001_ServiciosAlojamientos();
        cpa001_serviciosAlojamientos.CPA001();
    }

}
