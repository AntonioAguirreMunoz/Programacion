/** se crea una clase que convierta euros a 
 * dólares y viceversa
 * @author : Antonio Aguirre
 * @version : 1.0
 */

public class Conversor_Moneda {
	public static void main (String[] args){
		double euros = 7.5;
		convertirEurosADolares (euros);
		double dolares = 10.3;
		double cambio = convertirDolaresAEuros (dolares);
		System.out.println (dolares + "$ son " + cambio + "€ ");

	}
	
	public static void convertirEurosADolares ( double eurosAConvertir ){
		final double CONVERSOR = 1.11;
		double dolares = CONVERSOR * eurosAConvertir; 	
		System.out.println (eurosAConvertir + "€ son " + dolares + "$ ");
	}
		
	public static double convertirDolaresAEuros ( double dolaresAConvertir ) {
		final double CONVERSOR = 0.90;
		double euros = CONVERSOR * dolaresAConvertir;
		return euros;
	}
}
