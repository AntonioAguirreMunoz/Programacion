import libreria.subcarpeta.Numero;
import libreria.subcarpeta.Palabra;

public class Test {

    public static void main(String[] args) {
        Numero numero = new Numero("9");
        Palabra palabra = new Palabra("palabra");

        System.out.printf("Valor = %s\n", numero.getNumero());
        System.out.printf("Valor = %s\n", palabra.getPalabra());
    }
}
