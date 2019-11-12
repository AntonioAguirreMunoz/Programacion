public class Contador_no_divisores {
	
	public static void main (String[] args){
		
		int numero = 10;
		int contadorNoDivisores = 0;
		
		for (int i = 1; i <= numero; i++){
			
			if (numero % i == 0){
				
				System.out.println (i + " es divisor de " + numero);			
				continue;
			}			
			contadorNoDivisores++;
		}	
		System.out.println ("Nº de no divisores: " + contadorNoDivisores);
	}		
}
