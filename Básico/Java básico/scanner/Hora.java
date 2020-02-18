import java.util.Scanner;

/**
 * Programa que da la hora
 * Programa que te da la una hora con scanner
 * @author Antonio Aguirre
 * @version 1.0
 */

public class Hora{
	
	public static void main(String[] args){
		
		int hora = leerHora();
		int minuto = leerMinuto();
		int segundos = leerSegundos();
		
		if (hora < 24 && hora >= 0 && minuto < 60 && minuto >= 0 && segundos < 60 && segundos >= 0){
		
		System.out.printf("Hora válida\nHora: %dh:%dm:%ds", hora, minuto, segundos);
		
		}else {
			
			System.out.println ("Hora no valida");
		}
		
	}	
	
	public static int leerHora(){
		
		System.out.println("Dame horas");
		Scanner sc = new Scanner(System.in);
		int hora = sc.nextInt();
	
		return hora;
	}
	
	public static int leerMinuto(){
		
		System.out.println("Dame minutos");
		Scanner sc = new Scanner(System.in);
		int minuto = sc.nextInt();
	
		return minuto;
	}
	
	public static int leerSegundos(){
		
		System.out.println("Dame segundos");		
		Scanner sc = new Scanner(System.in);
		int segundos = sc.nextInt();
	
		return segundos;
	}
}
