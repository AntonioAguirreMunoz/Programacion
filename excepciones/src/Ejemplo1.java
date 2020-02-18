import java.util.Scanner;

public class Ejemplo1 {

    public static void main(String[] args) {

        //Ejemplo de excepción no declarativa

        int numerador = 5;
        int denominador = 2;
        double division = 1.0 * numerador / denominador;

        if (denominador != 0){
            System.out.printf("Valor de la division: %.2f\n", division);
        } else {
            System.out.println("División por cero");
        }

        int[] valores = {1,2,3,4,5};
        int suma = 0;
        for (int i = 0; i < valores.length; i++) {
            suma += valores[i];
        }
        double average = 1.0 * suma / valores.length;
        System.out.printf("Media: %.2f\n", average);
        int posicion = 3;
        if (valores.length > posicion) {
            System.out.printf("Posición %d del array: %d\n", posicion, valores[posicion]);
        }else {
            System.out.printf("Posición %d no existe\n", posicion);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número");
        String sNumero = sc.next();
        if (sNumero.matches("^[0-9]+$")){
            int iNumero = Integer.parseInt(sNumero);
            System.out.printf("El valor doble de %d es %d\n", iNumero, iNumero * 2);
        }else {
            System.out.printf("%s no es un número", sNumero);
        }
        sc.close();

    }
}
