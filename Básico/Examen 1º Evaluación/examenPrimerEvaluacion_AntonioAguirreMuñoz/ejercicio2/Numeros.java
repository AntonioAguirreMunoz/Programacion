import java.util.Scanner;

public class Numeros {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una secuencia de números reales: ");
		System.out.println("Para acabar introduce el numero 0");
		double i = 0;
		double numMayor = 0;
		double numMenor = 0;
		int contador = 1;
		
			for(i = sc.nextInt(); i != 0; i++){
				
				i = sc.nextInt();
				contador++;
				if (i == 0){
				System.out.printf("Introducidos %d números, el valor más grande es:  y el valor más pequeño es: ", 
									contador );
				break;
				}
			} 
	}
}

