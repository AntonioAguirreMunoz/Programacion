package ecuacion;

import java.util.Scanner;

public class Test_EcuacionV2 {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce los valores de a, b y c para realizar una ecuación de segundo grado");
		System.out.println("Introduce el valor de a");
		double a = sc.nextDouble();
		System.out.println("Introduce el valor de b");
		double b = sc.nextDouble();
		System.out.println("Introduce el valor de c");
		double c = sc.nextDouble();
		EcuacionV2 ecuacion = new EcuacionV2(a, b, c);		
		sc.close();
		if (ecuacion.esResoluble()) {
			
			System.out.println("Respuesta 1");
			System.out.println("------------------");
			System.out.printf("%.2f\n", ecuacion.resolverEcuacion1());
			System.out.println("------------------");
			
			System.out.println("Respuesta 2");
			System.out.println("------------------");
			System.out.printf("%.2f\n", ecuacion.resolverEcuacion2());
			System.out.println("------------------");
		}else {
		 
			System.out.println("La ecuación no tiene solución");
		}
	}
}
