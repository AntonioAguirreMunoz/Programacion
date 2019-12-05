package ecuacion;

import java.lang.Math;

public class EcuacionV2 {

	private double a;
	private double b;
	private double c;
	
	public EcuacionV2(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;	
		
	}
	public double resolverEcuacion1() {
		
		return (-b + Math.sqrt(b * b - (4 * a * c))) / (2 * a);				
	}
	public double resolverEcuacion2() {
		
		return (-b - Math.sqrt(b * b - (4 * a * c))) / (2 * a);			
	}
	public boolean esResoluble() {
		
		return a != 0 && (b * b - 4 * a * c > 0);
	}
}
