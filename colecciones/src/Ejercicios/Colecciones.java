package Ejercicios;

import java.util.Arrays;

public class Colecciones {

    private int[] coleccion1 = new int[10];
    private int[] coleccion2 = new int[10];

    public Colecciones(int valorRellenarColeccion2) {
        for(int i = 0; i < coleccion1.length; i++){

            coleccion1[i] = 3;
        }
        Arrays.fill(coleccion2, valorRellenarColeccion2);
    }

    public void mostrarValores(){

        for (int i = 0; i < coleccion1.length; i++){

            System.out.printf("%5d%5d\n", coleccion1[i], coleccion2[i]);
        }
    }
}
