package AprendizajeAutomatico;

import GestionCSV_Tablas.Table;

import java.util.List;

public class RegresionLineal implements AlgoritmoML<Table, Double, Double> {

    public Double alpha;
    public Double beta;

    private Double media(List<Double> columna){
        Double res = 0.0;
        for(Double aux : columna)
            res += aux;
        return res / columna.size();
    }

    public void train(Table data){

        Double mediax = media(data.getColumnAt(0));     // --> Media de la primera columna
        Double mediay = media(data.getColumnAt(1));     // --> Media de la segunda columna

        Double numerador = 0.0, denominador = 0.0;


        ////////////////////////////////////////////////////////////////////////////////
        //------------------- Ecuaciones de la regresión lineal ----------------------//
        ////////////////////////////////////////////////////////////////////////////////

        for(int i = 0; i < data.numeroEjemplares(); i++){

            numerador += (data.getColumnAt(0).get(i) - mediax) * (data.getColumnAt(1).get(i) - mediay);
            denominador += (data.getColumnAt(0).get(i) - mediax) * (data.getColumnAt(0).get(i) - mediax);
        }

        alpha = numerador / denominador;

        beta = mediay - (alpha * mediax);

    }

    public Double estimate(Double sample){

        return (alpha * sample) + beta;
    }
}
