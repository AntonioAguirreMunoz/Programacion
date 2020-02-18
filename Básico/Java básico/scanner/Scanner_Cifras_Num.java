import java.util.Scanner;


public class Scanner_Cifras_Num{
	
	public static void main (String[] args){
		
		Scanner sc = new Scanner(System.in);		
		System.out.println("Escribe un numero");
		int numero = sc.nextInt();
		int cifra1 = numero / 100;
		int cifra2 = (numero % 100) / 10;
		int cifra3 = (numero % 100) % 10;
		System.out.printf("Cifra 1: %d%n", cifra1);
		System.out.printf("Cifra 2: %d%n", cifra2);
		System.out.printf("Cifra 3: %d%n", cifra3);
		
	}	
}
