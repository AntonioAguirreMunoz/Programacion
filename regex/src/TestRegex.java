import java.util.Scanner;

public class TestRegex {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número");
        String sNumero = sc.next();

        if (sNumero.matches("^[1-9][0-9]*$")){
            System.out.println("Es un número natural");
            int iNumero = Integer.parseInt(sNumero);
        }

        if (sNumero.matches("^-?[1-9][0-9]*$|^0$")){
            System.out.println("Es un número entero");
            int iNumero = Integer.parseInt(sNumero);
        }

        if (sNumero.matches("^-?[1-9][0-9]*$|^0$|^-?0[\\.,][0-9]+$" +
                "|^-?[1-9][0-9]*[\\.,][0-9]+$")){
            System.out.println("Es un número real");
            double dNumero = Double.parseDouble(sNumero.replace(',','.'));
        }

        else
            System.out.println("No es un número válido");
    }
}
