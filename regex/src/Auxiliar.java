import java.util.Scanner;

public class Auxiliar {

    public static boolean validarNSS (String nss){

        String regexProvincia = "(0[1-9]|[1-4][0-9]|5[0-3]|66)";
        String regexNumAfiliacion = "[0-9]{8}";
        String regexDigControl = "[0-9]{2}";
        String regexDefinitiva = regexProvincia + regexNumAfiliacion + regexDigControl;

        return nss.matches(regexDefinitiva) && comprobarDC(nss);
    }

    private static boolean comprobarDC(String nss) {

        String cadena = nss.substring(0, 10);
        String dc = nss.substring(10);

        return Long.parseLong(cadena) % 97 == Integer.parseInt(dc);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nss = "";

        do {

            System.out.println("Introduce nº de la Seguridad Social válido");
            nss = sc.next();

        } while (!validarNSS(nss.replace("/", "")));
    }
}
