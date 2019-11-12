public class Factorial {
	
	public static void main (String[] args){
	
		int numero = 5;
		
		while (numero <= 0){
		numero = numero - 1;
		int resultado = numero + (numero - 1);
		}
		
		
		
			if (numero < 0){
						
				System.out.println ("No existe el factorial de " + numero + " porque es negativo ");
			}
			else if (numero == 0){
				
				System.out.println ("El factorial de " + numero + " es " + resultado);
			}	
			else {
				
				System.out.println ("El factorial de " + numero + " es " + resultado);
			}	
	}
}
