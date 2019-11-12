public class Condiciones_if{
	
	public static void main (String[] args){
		
		int numero = 573;
		int contador; 
		int multiplo1 = 3;
		int multiplo2 = 2;
		
		for (contador = 0; contador <= numero; contador++){
			
			if (contador % multiplo1 == 0 && contador % multiplo2 == 0){
			
				System.out.print (contador + " ");
			
			}
		}		
	}	
}
