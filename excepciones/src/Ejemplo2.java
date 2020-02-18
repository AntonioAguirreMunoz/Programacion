import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejemplo2 {

    //Ejemplo de excepción declarativa

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("ficheros/constitucion.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(ANSI_RED + "Fichero no encontrado");
        }
        System.out.println(ANSI_RESET + "Fin de programa");
    }
}
