import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio4 {

    public static void main(String[] args) {
        List<String> constitucion = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String sPattern1 = "^([0-9]+/?[0-9]*[\\.,;]?)(.*?)$";
        String sPattern2 = "^[a-z]\\)$";
        Pattern pPattern1 = Pattern.compile(sPattern1);
        Pattern pPattern2 = Pattern.compile(sPattern2);
        Matcher matcher1, matcher2;
        int contador = 0;

        while (sc.hasNext()){
            String palabra = sc.next();
            matcher1 = pPattern1.matcher(palabra);

            if (matcher1.find()) {
                if (matcher1.group(2).length() != 0 && matcher1.group(2).matches("^[^0-9].*$")) {
                    if (matcher1.group(2).contains(",") || matcher1.group(2).contains(".") || matcher1.group(2).contains(":") ||
                            matcher1.group(2).contains(":") || matcher1.group(2).contains(";") || matcher1.group(2).contains("(") ||
                            matcher1.group(2).contains(")") || matcher1.group(2).contains("!") || matcher1.group(2).contains("¡") ||
                            matcher1.group(2).contains("-")) {
                        palabra = matcher1.group(2).replaceAll("[\\.,:;()!¡-]", "");
                    }else{
                        palabra = matcher1.group(2);
                        constitucion.add(palabra.toLowerCase());
                    }
                    constitucion.add(palabra);
                }
                continue;
            }
            matcher2 = pPattern2.matcher(palabra);
            if (matcher2.find()){
                continue;
            }
            if (palabra.contains(",") || palabra.contains(".")) {
                palabra = palabra.replaceAll("[\\.,]", "");
            }
            if (palabra.matches("(^I{1,3}|(^I?[VX]I{0,3})$)")){
                continue;
            }
            constitucion.add(palabra.toLowerCase());
        }
        //System.out.println(constitucion); // Mostrado como lista
        //constitucion.forEach(System.out::println); // Mostrado como unitario

        System.out.printf("La constitución tiene %d palabras.\n",
                            UtilidadesString.obtenerNumeroPalabras(constitucion));
    /*
        System.out.printf("La constitución tiene %d preposiciones.\n",
                UtilidadesString.obtenerNumeroPreposicionesv0(constitucion));
        System.out.printf("La constitución tiene %d artículos determinados.\n",
                UtilidadesString.obtenerNumeroArticulosDeterminados(constitucion));
        System.out.printf("La constitución tiene %d artículos indeterminados.\n",
                UtilidadesString.obtenerNumeroArticulosIndeterminados(constitucion));

     */

        System.out.printf("La constitución tiene %d preposiciones.\n",
                UtilidadesString.obtenerNumeroTokens(constitucion, UtilidadesString.PREPOSICIONES));

        System.out.printf("La constitución tiene %d artículos determinados.\n",
                UtilidadesString.obtenerNumeroTokens(constitucion, UtilidadesString.ARTICULOS_DETERMINADOS));

        System.out.printf("La constitución tiene %d artículos indeterminados.\n",
                UtilidadesString.obtenerNumeroTokens(constitucion, UtilidadesString.ARTICULOS_INDETERMINADOS));
    }
}
