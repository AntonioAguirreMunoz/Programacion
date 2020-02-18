package Ejercicio3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio3 {

/*    public static void main(String[] args) {

        List<String> lista = Arrays.asList("uno", "dos", "tres", "cuatro", "cinco", "siete", "diez");
        List<String> listaEmpiezaPor = obtenerNombreEmpiezanCaracter( lista,'c');
        System.out.println(listaEmpiezaPor);
        System.out.println(obtenerNombreNoAcabaVocal(lista));
        int[] valoresMaxMin = obtenerMaximoYMinimoDeCar(lista);
        System.out.printf("Palabra más chica: %d\nPalabra más grande: %d\n",
                            valoresMaxMin[0], valoresMaxMin[1]);
        System.out.printf("Existe el nombre %s: %B\n", "dos", contieneNombre(lista, "dos"));
        System.out.println(obtenerSimilitud(lista, "ie"));
    }*/

    public static List<String> obtenerNombreEmpiezanCaracter(List<String> lista, char caracter){

        List<String> listaEmpiezaPor = new ArrayList<>();
        for (String nombre:lista){
            if ((nombre.charAt(0) +"").equalsIgnoreCase(caracter +"")){
                listaEmpiezaPor.add(nombre);
            }
        }
        return listaEmpiezaPor;
    }

    public static List<String> obtenerNombreNoAcabaVocal(List<String> lista){

        List<String> listaNoAcabaVocal = new ArrayList<>();
        for (String nombre:lista){
            if (!nombre.toLowerCase().matches(".*[aeiouáéíóú]$")){
                listaNoAcabaVocal.add(nombre);
            }
        }
        return listaNoAcabaVocal;
    }

    public static int[] obtenerMaximoYMinimoDeCar(List<String> lista){

        int[] valoresMaxMin = new int[2];
        String palabraMasGrande = ""; //opcion con String
        int longitudPalabraMasChica = Integer.MAX_VALUE; //opcion con int (forma buena)
        for (String nombre:lista){
            if (nombre.length() > palabraMasGrande.length()){
                palabraMasGrande = nombre;
            }
            if(nombre.length() < longitudPalabraMasChica){
                longitudPalabraMasChica = nombre.length();
            }
        }
        valoresMaxMin[0] = longitudPalabraMasChica;
        valoresMaxMin[1] = palabraMasGrande.length();
        return valoresMaxMin;
    }

    public static boolean contieneNombre (List<String> lista, String nombre){

        return lista.contains(nombre);
    }

    public static List<String> obtenerSimilitud (List<String> lista, CharSequence secuencia){

        List<String> listaDeSimilitud = new ArrayList<>();
        for(String nombre: lista){
            if (nombre.contains(secuencia)){
                listaDeSimilitud.add(nombre);
            }
        }
        return listaDeSimilitud;
    }
}
