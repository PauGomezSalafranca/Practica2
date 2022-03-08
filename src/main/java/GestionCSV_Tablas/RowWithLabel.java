package GestionCSV_Tablas;

import java.util.List;

public class RowWithLabel extends ROW {

    String label;
    
    public RowWithLabel(List<Double> filax) {
        super(filax);
    }

    public void setLabel(String identificador){
        this.label = identificador;
    }
    public String getLabel(){
        return label;
    }
}
