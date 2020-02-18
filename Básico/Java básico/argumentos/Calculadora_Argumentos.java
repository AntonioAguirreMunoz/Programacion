public class Calculadora_Argumentos {
	
	public static void main (String[] args){
		if (args.length < 3){
			
			System.out.println ("Faltan argumentos");
			System.exit(1);
		} 
		
		String operacion = args[0].toLowerCase();
		double valor1 = Double.parseDouble(args[1]);
		double valor2 = Double.parseDouble(args[2]);
		double resultado = 0;
		boolean flag = true;
			
		switch (operacion){
				
			case "suma":
				 resultado = valor1 + valor2;
				 break;
			case "resta":
				 resultado = valor1 - valor2;
				 break;
			case "multiplicacion":
				 resultado = valor1 * valor2;
				 break;
			case "division":
				 resultado = valor1 / valor2;
				 break;			
			default: 	
				flag = false;
				System.out.println (operacion + " no permitico en esta calculadora");
				
		}
		if (flag)
			System.out.printf ("El resultado de la operacion %S de los valores %.2f y %.2f vale %.3f%n", operacion, valor1, valor2, resultado);		
		
	}
}
