public class Metodos {
	
	public static void main (String[] args) {
				
		//añadirNumeroWhile ();
		//añadirNumerosDoWhile ();
		//añadirNumerosFor ();
		//añadirNumeroMasCinco ();
		//añadirNumerosMasCincoDoWhile ();
		//añadirNumerosMasCincoFor ();
		//quitarNumerosMenosDosWhile ();
		//quitarNumerosMenosDosDoWhile ();
		//quitarNumerosMenosDosFor ();
		//sumarNumeros (3);
		//sumarCuadradosDeLosNPrimerosNumeros (20);
		sumarParesEImpares();
	}
	
	public static void añadirNumeroWhile (){
			
		int contador = 0;

			while (contador <= 10){
				
				System.out.println (contador);
				contador++;
				
		}
	}
	
	public static void añadirNumerosDoWhile () {
		
		int contador = 0;
		
			do {
				
				System.out.println (contador);
				contador++;
		} while (contador <= 10);
	}
	
	public static void añadirNumerosFor (){
		
		for (int i = 0; i <= 10; i++) {
			
			System.out.println (i);
		}
	}
	
	public static void añadirNumeroMasCinco () {
		
		int contador = 0;
		
		while (contador <= 80){
			
			System.out.println (contador);
			contador += 5;			
		}
	}
	
	
	public static void añadirNumerosMasCincoDoWhile (){
		
		int contador = 0;
		
		do {
			
			System.out.println (contador);
			contador += 5;
		} while (contador <= 80);
	}
	
	public static void añadirNumerosMasCincoFor () {
		
		for (int i = 0; i <= 80; i += 5) {
			
			System.out.println (i);
		}		
	}
	
	public static void quitarNumerosMenosDosWhile (){
		
		int contador = 100;
		while (contador >= 50){
			
			System.out.println (contador);
			contador -= 2;
		}
	}
	public static void quitarNumerosMenosDosDoWhile (){
		
		int contador = 100;
		do {
			
			System.out.println (contador);
			contador -= 2;
		} while (contador >= 50);
	}
	public static void quitarNumerosMenosDosFor (){
		
		for (int i = 100; i >= 50; i -= 2)
			System.out.println (i);
	}
	
	public static int sumarNumeros (int limite) {
		
		int suma = 1;
		for (int i = 1; i <= limite; i++) {
			suma += i;	
		}
		
		System.out.println (suma);
		return suma; 
	}
	
	public static int sumarCuadradosDeLosNPrimerosNumeros (int limite) {
		
		int suma = 0;
		for (int i = 1; i <= limite; i++) {
			suma = i * i + suma;	
			
			if (i == 10){
			
				break;
			}
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        	
		
		System.out.println (suma);
		return suma; 
	}
	
	public static void sumarParesEImpares (){
		
		int numero = 5; //veces que hace el bucle
		int sumapar = 0; 
		int sumaimpar = 0;
					
		for (int i = 0; i <= numero; i++){
			
			if (i % 2 == 0){
				
				sumapar += i;
			}	
			else {
				
				sumaimpar += i; 
			}		
		}	
		System.out.println (sumapar);
		System.out.print (sumaimpar);		
	}
}
