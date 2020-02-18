import java.util.Scanner ;


public class Scanner_Basico {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		System.out.println ("Escribe tu nombre y apellidos ");
		String token = sc.nextLine();
		System.out.printf ("Hola %s%n", token);
		sc.close();
	}	
}
