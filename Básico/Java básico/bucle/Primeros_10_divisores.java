public class Primeros_10_divisores {
	
	public static void main (String[] args) {
		
		int numero = 54596384;
		int contador = 0;
		
		for (int i = 1; i <= 1234; i++)	{
			
			if (numero % i == 0) {
				
				System.out.println (i + " es divisor de " + numero);
				contador++;
			}
			if (contador == 10){
				break; 
			}
		}		
	}
}

