
/**
 * Programa para pedir constantemente números hasta que pongas un 0
 * @author Antonio Aguirre Muñoz
 * @version 1.0
 */ 

public class MetodoNumeros {
	
	/**
	 * Método para saber que número es mayor
	 */ 
	public static double decirMayor(double i, double numMayor){
			
			
			if (numMayor < i){
				numMayor = i;
			}

		return numMayor;
	}
	/**
	 * Método para saber que número es menor
	 */
	public static double decirMenor(double i, double numMenor){
		
		if (numMenor < i){
			numMenor = i;
		}
		
		return numMenor;
	}
}

