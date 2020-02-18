public class Bucledowhile {
	
	public static void main (String[] args){
		
		int numero      = 5;
		int contador    = 1;
		int multiplicar = 1;
		
		do {
			
			multiplicar *= contador;
			contador ++; 
			
		}	while (contador <= numero);
		
		System.out.println (multiplicar);
		System.out.println (contador);
		System.out.println (numero);
	}	
}
