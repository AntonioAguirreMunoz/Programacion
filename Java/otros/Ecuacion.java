public class Ecuacion {
	
	public static boolean esResoluble (int a, int b, int c, int d){
		
		return ((a * d) - (b * c) != 0);
	}	
	
	public static double calcularX(int a, int b, int c, int d, int e, int f){
		
		return ((e * d) - (b * f)) * 1.0 /((a *d) - (b * c));
	}		
	public static double calcularY(int a, int b, int c, int d, int e, int f){
		
		return ((a * f) - (e * c)) * 1.0 /((a *d) - (b * c));
	}
}

