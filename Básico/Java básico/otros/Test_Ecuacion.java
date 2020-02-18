import java.util.Scanner;


public class Test_Ecuacion{
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime un valor para a");
		int a = sc.nextInt(); 
		System.out.println("Dime un valor para b");
		int b = sc.nextInt();
		System.out.println("Dime un valor para c");
		int c = sc.nextInt();
		System.out.println("Dime un valor para d");
		int d = sc.nextInt();
		System.out.println("Dime un valor para e");
		int e = sc.nextInt();
		System.out.println("Dime un valor para f");
		int f = sc.nextInt();
		sc.close();
		
		System.out.printf("La ecuación 1 es: %dx · %dy = %d\n", a, b, e);	
		System.out.printf("La ecuación 1 es: %dx · %dy = %d\n", c, d, f);	
		
		if (Ecuacion.esResoluble(a, b, c, d)){
				
			System.out.println("Este sistema de ecuacicones se puede resolver");
			double x = Ecuacion.calcularX(a, b, c, d, e, f);
			double y = Ecuacion.calcularY(a, b, c, d, e, f);
			
			System.out.printf("La solución de x es %.2f\n", x);
			System.out.printf("La solución de y es %.2f\n", y);
			
		}else{
		
			System.out.println("Este sistema de ecuacicones NO se puede resolver");
		}				
	}
}
