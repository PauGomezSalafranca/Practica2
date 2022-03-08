package AprendizajeAutomatico;

import GestionCSV_Tablas.RowWithLabel;
import GestionCSV_Tablas.TableWithLabels;

import java.util.List;


public class Estimacion implements AlgoritmoML<TableWithLabels, String, List<Double>> {

    TableWithLabels aux = new TableWithLabels();

    public void train(TableWithLabels data){
        aux = data;
    }   // --> No hay ningun modelo que construir

    public String estimate(List<Double> sample){
        Double distanciaMenor = 10000.0;                // --> Inicializamos con un numero muy grande
        String clase = null;
        Double distancia;

        for(RowWithLabel linea : aux.listaFilas) {
            distancia = Sumatorio(sample, linea);

            if (distancia < distanciaMenor) {
                distanciaMenor = distancia;   // --> Comparamos cada distancia con la menor y actualizamos el label
                clase = linea.getLabel();
            }
        }
        return clase;
    }

    //////////// ------- Metrica Euclidea -------- //////////

    private Double Sumatorio(List<Double> sample, RowWithLabel linea) {
        Double distancia = 0.0;
        for (int i = 0; i < sample.size(); i++) {
            distancia += (sample.get(i) - linea.getData().get(i)) * (sample.get(i) - linea.getData().get(i));
        }
        distancia = Math.sqrt(distancia);
        return distancia;
    }
}
