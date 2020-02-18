package Ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Ejercicio3.Ejercicio3.*;

public class TestEjercicio3 {

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            lista.add(sc.nextLine());
        }
        System.out.printf("Líneas leídas: %d\n", lista.size());
        List<String> listaEmpiezaPor = obtenerNombreEmpiezanCaracter( lista,'c');
        System.out.println(listaEmpiezaPor);
        System.out.println(obtenerNombreNoAcabaVocal(lista));
        int[] valoresMaxMin = obtenerMaximoYMinimoDeCar(lista);
        System.out.printf("Palabra más chica: %d\nPalabra más grande: %d\n",
                valoresMaxMin[0], valoresMaxMin[1]);
        System.out.printf("Existe el nombre %s: %B\n", "dos", contieneNombre(lista, "dos"));
        System.out.println(obtenerSimilitud(lista, "i"));
    }
}
