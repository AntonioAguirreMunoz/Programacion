package palabra;
import java.util.Scanner;

public class Test_Palabra {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena:");
		String palabraLeida = sc.next();
		
		Palabra palabra = new Palabra(palabraLeida);
		System.out.printf("\n\nPalabra leida: %s.\n"
						+ "Su valor en mayúscula es %s.\n"
						+ "Su valor en minúscula es %s.\n"
						+ "Su número de letras es %d.\n" 
						+ "Su primera letra es %c.\n" 
						+ "Su última letra es %c.\n", 
						palabraLeida, palabra.obtenerPalabraMayuscula(), palabra.obtenerPalabraMinuscula(),
						palabra.obtenerNumeroPalabra(), palabra.obtenerPrimeraLetra(), 
						palabra.obtenerUltimaLetra());
		
		System.out.println("Introduce un carater a remplazar");
		String caracterARemplazar = sc.next();
		System.out.println("Introduce un caracter de remplazo");
		String caracterRemplazo = sc.next();
		System.out.printf("En la cadena %s si cambio %s por %s queda %s\n", 
							palabraLeida, caracterARemplazar, caracterRemplazo,
							palabra.remplazarLetra(caracterARemplazar, caracterRemplazo));
		sc.close();
	}
}
