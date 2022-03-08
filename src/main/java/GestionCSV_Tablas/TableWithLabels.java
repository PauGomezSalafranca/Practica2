package GestionCSV_Tablas;

import GestionCSV_Tablas.RowWithLabel;
import GestionCSV_Tablas.Table;

import java.util.LinkedList;
import java.util.List;

public class TableWithLabels extends Table {

    public List<RowWithLabel> listaFilas = new LinkedList<>();

    @Override
    public RowWithLabel getRowAt(Integer fila){
       return listaFilas.get(fila - 1);

    }

    public void setListaFilasLabels(List<RowWithLabel> filasViejas) {
        this.listaFilas = filasViejas;

    }

    @Override
    public int numeroEjemplares(){
        return listaFilas.size();
    }       // --> Esto es necesario para metodos de ML
}
