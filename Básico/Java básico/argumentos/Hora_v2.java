
/**
 * Programa que da la hora
 * Programa que te da la una hora con argumentos (args)
 * @author Antonio Aguirre
 * @version 2.0
 */

public class Hora_v2 {

	public static void main(String[] args) {
	
	if (args.length < 3){
		System.out.println("Faltan argumentos");
		System.exit(1);
		
	}
	
	String sHora = args[0];
	String sMinutos = args[1];
	String sSegundos = args [2];
	
	int iHora = Integer.parseInt(sHora);
	int iMinutos = Integer.parseInt(sMinutos);
	int iSegundos = Integer.parseInt(sSegundos);

	if (iHora < 24 && iHora >= 0 && iMinutos < 60 && iMinutos >= 0 && iSegundos < 60 && iSegundos >= 0)
	System.out.println("Hora válida");
	else
	System.out.println("Hora no válida");

	}
}
