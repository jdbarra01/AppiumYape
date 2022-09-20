package testClases;

import page.Datos;
import page.Habitacion;
import page.Home;
import page.ResultadoBusqueda;

public class CPA001_ServiciosAlojamientos {


    public void CPA001() throws Exception {

        Home home = new Home();
        ResultadoBusqueda resultadoBusqueda = new ResultadoBusqueda();
        Habitacion habitacion = new Habitacion();
        Datos datos = new Datos();

        home.inicio();
        home.destino("Destino");
        home.selecionCalendario("FechaInicio", "FechaTermino");
        resultadoBusqueda.search();
        habitacion.resevaHabitacion();
        habitacion.elegirEstacia();
        habitacion.reservarAhora();
    }

}
