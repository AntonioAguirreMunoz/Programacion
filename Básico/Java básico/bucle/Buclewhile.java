public class Buclewhile {
	
	public static void main (String[] args){
		
		int numero         = 5;
		int contador       = 1;
		int multiplicacion = 1;
		
		/*if (numero < 0){
			
			numero = -numero;
		}*/	
	
		if (numero % 0){
			
			multiplicacion *= contador;	
		}

		while (contador <= numero){
			
			multiplicacion *= contador;				
			contador ++; 
		}	
		
		System.out.println ("Multiplicacion = " + multiplicacion);
		System.out.println ("Contador = " + contador);
		System.out.println ("Numero = " + numero);
	}	
}
