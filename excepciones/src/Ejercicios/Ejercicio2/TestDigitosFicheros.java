package Ejercicios.Ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDigitosFicheros {
    public static void main(String[] args) {

        //cierre automático del Scanner
        List<Hexadecimal> listaHexadecimal = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("ficheros/hexadecimal.txt"));){
            while (sc.hasNextLine()){
                String numero = null;
                try {
                    numero = sc.nextLine();
                    listaHexadecimal.add(new Hexadecimal(sc.nextLine()));
                } catch (HexadecimalException e) {
                    //System.out.println(numero + ": " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //System.out.println(listaHexadecimal);
        //System.out.printf("La suma de todos los valores hexadecimales, en decimal vale %d\n",
        //                Hexadecimal.obtenerSumaDecimalListaHexadecimales(listaHexadecimal));

        System.out.println("Fin de programa");
    }
}
