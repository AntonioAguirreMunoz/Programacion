import java.util.Scanner;

public class Leer_Nombre_Linea {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args){
		
		String nombre = leerNombre();
		String direccion = leerDireccion();
		int edad = leerEdad();
		System.out.printf ("Nombre: %s\nDireccion: %s\nEdad: %d\n", nombre, direccion, edad);
		sc.close();				
	}	
	
	public static String leerNombre() {
		
		System.out.println ("Introduce nombre");
		String nombre = sc.nextLine();
	
		return nombre;		
	}
	
	public static int leerEdad(){
		
		System.out.println ("Introduce edad");
		int edad = sc.nextInt();
		
		return edad;		
	}
	
	public static String leerDireccion() {
		
		System.out.println ("Introduce dirección");
		String direccion = sc.nextLine();
	
		return direccion;		
	}
}
