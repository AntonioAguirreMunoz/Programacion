package Ejercicios.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class TestDigitos {
    public static void main(String[] args) {

        try {
            Binario binario = new Binario("101");
            System.out.println(binario);
            Hexadecimal hexadecimal = new Hexadecimal("ff");
            System.out.println(hexadecimal);
        } catch (BinarioException | HexadecimalException e){
            System.out.println("Formato no correcto");
        }

        List<Binario> listaBinario =  new ArrayList<>();
        try {
            listaBinario.add(new Binario("00"));
            listaBinario.add(new Binario("01"));
            listaBinario.add(new Binario("10"));
        } catch (BinarioException e) {
            e.printStackTrace();
        }
        System.out.printf("La suma de los binarios vale %d\n",
                Binario.obtenerSumaDecimalListaBinarios(listaBinario));

        List<Hexadecimal> listaHexadecimal = new ArrayList<>();
        try {
            listaHexadecimal.add(new Hexadecimal("01"));
            listaHexadecimal.add(new Hexadecimal("010"));
            listaHexadecimal.add(new Hexadecimal("0A"));
        } catch (HexadecimalException e) {
            e.printStackTrace();
        }

        System.out.printf("La suma de los hexadecimales vale %d\n",
                Hexadecimal.obtenerSumaDecimalListaHexadecimales(listaHexadecimal));

        Binario binario = Binario.convertirDecimalABinario(10);
        System.out.println(binario);

        System.out.println("Fin de programa");
    }
}
