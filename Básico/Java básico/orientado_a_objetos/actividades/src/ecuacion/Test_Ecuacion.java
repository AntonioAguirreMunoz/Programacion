package ecuacion;

import java.util.Scanner;

public class Test_Ecuacion {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce los valores de a, b y c para realizar una ecuación de segundo grado");
		System.out.println("Introduce el valor de a");
		double a = sc.nextDouble();
		System.out.println("Introduce el valor de b");
		double b = sc.nextDouble();
		System.out.println("Introduce el valor de c");
		double c = sc.nextDouble();
		sc.close();
		if ((b * b) - (4 * a * c) < 0){
			
			System.out.println("La ecuación no tiene solución");
		}
		else if (Ecuacion.getDenominador(a) == 0){
			
			System.out.println("La ecuación no tiene solución");
		}else{
		
		System.out.println("Respuesta 1");
		System.out.println("------------------");
		double solucionPositiva = Ecuacion.getNumeradorPositivo(a, b, c) / Ecuacion.getDenominador(a);
		System.out.println(solucionPositiva);
		System.out.println("------------------");
		
		System.out.println("Respuesta 2");
		System.out.println("------------------");
		double solucionNegativa = Ecuacion.getNumeradorNegativo(a, b, c) / Ecuacion.getDenominador(a);
		System.out.println(solucionNegativa);
		System.out.println("------------------");
		}
	}
}
