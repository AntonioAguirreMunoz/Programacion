public class Buclefor {
	
	public static void main (String[] args){
		
		int numero = -6;
		int multiplicar = 0;
		int i = 0;
		
		if (numero % 2 == 0){
			
			for (i = 0; i <= numero; i++){
				
				multiplicar *= multiplicar;
			}
		}	
		
		else {
			
			for (i = 0; i <= numero; i++)
			
			multiplicar *= multiplicar;
			multiplicar = -multiplicar; 
		}	
		
		System.out.println ("Numero: " + numero );
		System.out.println ("Multiplicar: " + multiplicar );		
		System.out.println ("Contador " + i );

	}
}
