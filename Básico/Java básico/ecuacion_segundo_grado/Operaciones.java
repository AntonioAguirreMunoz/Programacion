import java.lang.Math;

/**
 * Programa para resolver ecuaciones de segundo grado con Scanner
 * @author Antonio Aguirre Muñoz
 * @version 1.0
 */

public class Operaciones {

	/**
	 * Método para devolver el numerador positivo
	 * @return Valor del numeradorPositivo
	 */
	  
	public static double getNumeradorPositivo (double a, double b, double c){
		
		b = b * (-1);
		return b + Math.sqrt((b * b) - (4 * a * c));
	}
	
	/**
	 * Método para devolver el numerador positivo
	 * @return Valor del numeradorNegativo
	 */
	 
	public static double getNumeradorNegativo (double a, double b, double c){
		
		b = b * (-1);
		return b - Math.sqrt((b * b) - (4 * a * c));
	}
	
	/**
	 * Método para devolver el denominador
	 * Solo funciona si la variable a es distinto que 0
	 * @return Valor del denominador
	 */
	
	public static double getDenominador (double a){
		if (a < 0 || a > 0){
			return 2 * a;
		}else{
			
			return 0;
		}
	}
}
