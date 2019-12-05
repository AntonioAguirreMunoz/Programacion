import java.util.Scanner;

public class Temperatura {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int gradosFar = 0;
		int gradosCen = 0;
		
		System.out.println("Introduce una temperatura en farenheit: ");
		String grados1 = sc.next();
		System.out.printf("La conversión de %s farenheit a centigrados es: %.2f\n", grados1, MetodoTemp.pasarFarACen(gradosFar, gradosCen));
		System.out.println("Introduce una temperatura en centigrados: ");
		String grados2 = sc.next();
		System.out.printf("La conversión de %s farenheit a centigrados es: %.2f\n", grados2, MetodoTemp.pasarCenAFar(gradosCen, gradosFar));		
		

	}
}
