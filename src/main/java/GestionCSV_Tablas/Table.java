package GestionCSV_Tablas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Table {

    public List<String> cabezeras;
    public List<ROW> listaFilas = new LinkedList<>();

    public ROW getRowAt(Integer fila){
        return listaFilas.get(fila - 1);
    }

    public void setCabezera(List<String> cabezeraVieja){
        this.cabezeras = cabezeraVieja;

    }

    public void setListaFilas(List<ROW> filasViejas) {
        this.listaFilas = filasViejas;

    }

    public int numeroEjemplares(){
        return listaFilas.size();
    }       // --> Esto es necesario para metodos de ML

    public List<Double> getColumnAt(Integer numerocolumna) throws IndexOutOfBoundsException {

        List<Double> res = new ArrayList<>();
        for(ROW fila : listaFilas){
            res.add(fila.getData().get(numerocolumna));
        }
        return res;
    }
}

