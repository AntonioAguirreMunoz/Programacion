
/**
 * Programa que convierte grados centigrador a farenheit y viceversa
 * @author Antonio Aguirre Muñoz
 * @version 1.0
 */


public class MetodoTemp {
	
	/**
	 * Método para convertir grados Far a grados Cent
	 */ 
	public static double pasarFarACen(double gradosFar, double gradosCen){
		
		gradosCen = ((gradosFar - 32) * 5) / 9;
		return gradosCen;
	}
	/**
	 * Método para convertir grados Cent a grados Far
	 */
	public static double pasarCenAFar(double gradosCen, double gradosFar){
		
		gradosFar = ((gradosCen * 9) / 5) + 32;
		return gradosFar;
	}
}

