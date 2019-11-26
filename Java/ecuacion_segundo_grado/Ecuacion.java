import java.util.Scanner;


public class Ecuacion {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce los valores de a, b y c para realizar una ecuación de segundo grado");
		System.out.println("Introduce el valor de a");
		double a = sc.nextDouble();
		System.out.println("Introduce el valor de b");
		double b = sc.nextDouble();
		System.out.println("Introduce el valor de c");
		double c = sc.nextDouble();
		if ((b * b) - (4 * a * c) < 0){
			
			System.out.println("La ecuación no tiene solución");
		}
		else if (Operaciones.getDenominador(a) == 0){
			
			System.out.println("La ecuación no tiene solución");
		}else{
		
		System.out.println("Respuesta positiva");
		System.out.println("------------------");
		double solucionPositiva = Operaciones.getNumeradorPositivo(a, b, c) / Operaciones.getDenominador(a);
		System.out.println(solucionPositiva);
		System.out.println("------------------");
		
		System.out.println("Respuesta negativa");
		System.out.println("------------------");
		double solucionNegativa = Operaciones.getNumeradorNegativo(a, b, c) / Operaciones.getDenominador(a);
		System.out.println(solucionNegativa);
		System.out.println("------------------");
		}
	}
}

