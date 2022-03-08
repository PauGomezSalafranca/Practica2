import AprendizajeAutomatico.Estimacion;
import AprendizajeAutomatico.RegresionLineal;
import GestionCSV_Tablas.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class CSVTest {

    CSV fichero = new CSV();

    @Test
    void leerTablaCorrecta() throws FileNotFoundException,IOException {
        fichero.leerTabla("miles_dollars.csv");
    }

    @Test
    void FicheroVacio() throws FileNotFoundException, IOException {
        assertThrows(IOException.class, ()->fichero.leerTabla("vacio.csv"));
    }

    @Test
    void leerTablaNombreErroneo() throws FileNotFoundException {
        assertThrows(IOException.class, ()->fichero.leerTabla("mal.csv"));
    }
    @Test
    void imprimirColumna() throws FileNotFoundException, IOException {
       Table tabla;
       tabla = fichero.leerTabla("miles_dollars.csv");
       List<Double> imprimir = tabla.getColumnAt(1);
       for(Double elem : imprimir)
           System.out.println(elem);
    }

    @Test
    void mostrarFila() throws FileNotFoundException, IOException{
        Table tabla;
        tabla = fichero.leerTabla("miles_dollars.csv");
        ROW fila = tabla.getRowAt(1);
        System.out.println(fila.getData());
    }


    @Test
    void imprimirColumnaErronea() throws IndexOutOfBoundsException,FileNotFoundException, IOException{
        Table tabla;
        tabla = fichero.leerTabla("miles_dollars.csv");
        assertThrows(IndexOutOfBoundsException.class, ()->tabla.getColumnAt(2));
    }

    @Test
    public void mostrarTablaMiles_Dollars() throws FileNotFoundException, IOException{
        Table tabla;
        tabla = fichero.leerTabla("miles_dollars.csv");
        System.out.println(tabla.cabezeras);
        for(ROW elemento : tabla.listaFilas){
            System.out.println(elemento.getData());
        }
    }

    @Test
    public void mostrarTablaIrisSoloNumeros() throws FileNotFoundException, IOException {
        Table tablax;
        tablax = fichero.leerTabla("irisSolonumeros.csv");
        System.out.println(tablax.cabezeras);
        for(ROW elemento : tablax.listaFilas) {
            System.out.println(elemento.getData());
        }
    }

    @Test
    public void mostrarFilaConLabel() throws FileNotFoundException, IOException{
        TableWithLabels tabla;
        tabla = fichero.LeerTablaConLabels("iris.csv");
        RowWithLabel fila = tabla.getRowAt(1);
        System.out.println(fila.getData() + " " + fila.getLabel());

    }

    @Test
    public void numeroEjemplaresSinLabels() throws FileNotFoundException, IOException{
        Table tabla;
        tabla = fichero.leerTabla("miles_dollars.csv");
        assertEquals(25,tabla.numeroEjemplares());

    }

    @Test
    public void numeroEjemplaresConLabels() throws FileNotFoundException, IOException {
        TableWithLabels tabla;
        tabla = fichero.LeerTablaConLabels("iris.csv");
        assertEquals(150, tabla.numeroEjemplares());

    }
    @Test
    public void mostrarTablaIris() throws FileNotFoundException, IOException {
        TableWithLabels tablax;
        tablax = fichero.LeerTablaConLabels("iris.csv");
        System.out.println(tablax.cabezeras);
        for(RowWithLabel elemento : tablax.listaFilas) {
            System.out.println(elemento.getData() + " " + elemento.getLabel());
        }
    }

    @Test
    public void regresionLinealAlpha() throws FileNotFoundException, IOException {
        Table tabla;
        tabla = fichero.leerTabla("miles_dollars.csv");
        RegresionLineal regresion = new RegresionLineal();
        regresion.train(tabla);
        assertEquals(1.255,regresion.alpha,0.001);

    }

    @Test
    public void regresionLinealBeta() throws FileNotFoundException, IOException {
        Table tabla;
        tabla = fichero.leerTabla("miles_dollars.csv");
        RegresionLineal regresion = new RegresionLineal();
        regresion.train(tabla);
        assertEquals(274.85, regresion.beta,0.001);

    }

    @Test
    public void estimacionIris() throws FileNotFoundException, IOException {
        TableWithLabels tabla;
        tabla = fichero.LeerTablaConLabels("iris.csv");
        List<Double> est = new LinkedList<>();
        est.add(5.8);
        est.add(2.7);
        est.add(5.1);
        est.add(1.9);
        Estimacion iris = new Estimacion();
        iris.train(tabla);
        assertEquals("Iris-virginica",iris.estimate(est));

    }
}


