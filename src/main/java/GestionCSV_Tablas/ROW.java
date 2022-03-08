package GestionCSV_Tablas;

import java.util.LinkedList;
import java.util.List;

public class ROW {

    List<Double> filas;

    public ROW(List<Double> filax){
        this.filas = filax;
    }

    public void setFilas(List<Double> filaNueva){
        this.filas = filaNueva;
    }

    public List<Double> getData() {
        return filas;
    }
}
