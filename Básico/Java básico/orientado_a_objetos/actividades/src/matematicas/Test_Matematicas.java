package matematicas;

import java.util.Scanner;

public class Test_Matematicas {

	public static void main(String[] args) {
				
		System.out.println("Introduce un número");
		Scanner sc = new Scanner(System.in);
		double numero = sc.nextDouble();
		sc.close();
		Matematicas matematicas = new Matematicas();
		matematicas.setNumero(numero);	
		
		System.out.printf("La raiz cuadrada de %.2f es %.2f, y su raiz cúbica es %.2f.\n",
							matematicas.getNumero(), matematicas.calcularRaiz(), 
							matematicas.calcualarRaizCubica());	
		System.out.printf("%.2f redondeado a entero es %d\n", 
							matematicas.getNumero(), matematicas.redondearAInt());
		System.out.printf("Nº aleatorio %.2f redondeado a entero es %d\n", 
				matematicas.getNumero(), matematicas.obtenerNumeroAleatorio());
	}
}
