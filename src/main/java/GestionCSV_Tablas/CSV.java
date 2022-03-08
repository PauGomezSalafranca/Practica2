package GestionCSV_Tablas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.File;
public class CSV {

    public Table leerTabla(String NombreFichero) throws IOException {
        Table tabla = new Table();
        List<ROW> listaFilas = new LinkedList<>();
        File fichero = new File(NombreFichero);
        ComprobarFicheroVacio(fichero);

        Scanner leer = new Scanner(fichero);
        List<String> cabezeraNueva = getCabezeras(leer);
                                                            // --> Accedemos a la cabezera y la actualizamos en Table
        tabla.setCabezera(cabezeraNueva);

        while(leer.hasNextLine()) {
            ROW filax = extraerFila(leer);
            listaFilas.add(filax);
        }
                                                            // --> Accedemos a los datos y actualizamos la Lista de Filas
        tabla.setListaFilas(listaFilas);
        return tabla;
    }

    ///////////////////////////////////////////////////////////////////////////////
    //----------------- Extraemos los siguientes metodos: -----------------------//
    ///////////////////////////////////////////////////////////////////////////////

    private void ComprobarFicheroVacio(File fichero) throws IOException {
        if(fichero.length() == 0)
            throw new IOException();
    }

    private ROW extraerFila(Scanner leer) {
        String[] lista = leer.next().split(",");
        List<Double> filas = convertirStringDobles(lista);
        return new ROW(filas);
    }

    private List<String> getCabezeras(Scanner leer) {
        String[] separado = leer.next().split(",");
        return new LinkedList<>(Arrays.asList(separado));
    }

    private List<Double> convertirStringDobles(String[] lista) {
        List<Double> filas = new LinkedList<>();
        for (String aux : lista) {
            double str1 = Double.parseDouble(aux);
            filas.add(str1);
        }
        return filas;
    }

    private List<Double> convertirStringDoblesConLabels(String[] ejemplar) {
        List<Double> filas = new LinkedList<>();
        for (int i = 0; i < ejemplar.length - 1; i++ ) {
            String aux = ejemplar[i];
            double str1 = Double.parseDouble(aux);
            filas.add(str1);
        }
        return filas;
    }

    ////////////////////////////////////////////////////////////////////////////////
    //--------------------------- LeerTablaConLabels -----------------------------//
    ////////////////////////////////////////////////////////////////////////////////

    public TableWithLabels LeerTablaConLabels(String nombreFich) throws IOException{
        TableWithLabels tablalabels = new TableWithLabels();
        List<RowWithLabel> listaFilas = new LinkedList<>();
        File fichero = new File(nombreFich);
        ComprobarFicheroVacio(fichero);

        Scanner leer = new Scanner(fichero);

        List<String> cabezeraNueva = getCabezeras(leer);
        tablalabels.setCabezera(cabezeraNueva);

        List<String> labels = new LinkedList<>();

        while(leer.hasNextLine()) {
            String[] ejemplar = leer.next().split(",");
            List<Double> filas = convertirStringDoblesConLabels(ejemplar);
            String label = ejemplar[ejemplar.length - 1];            // --> conseguimos el label

            RowWithLabel filax = new RowWithLabel(filas);
            listaFilas.add(filax);
            labels.add(label);

            filax.setLabel(label);      // --> Actualizamos el label en la fila correspondiente
        }

        tablalabels.setListaFilasLabels(listaFilas);    // --> Actualizamos la Lista de Filas con Labels
        return tablalabels;
    }

}

