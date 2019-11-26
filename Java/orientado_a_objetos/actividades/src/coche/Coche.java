package coche;

public class Coche {
	
	private double combustible = 5;
	private double consumo100Km = 7;

	public double anadirCombustible(double nuevoCombustible) {
		
		return combustible += nuevoCombustible;
	}
	
	public double getCombustible(){
		
		return combustible;
	}
	
	public double getConsumo100Km() {
		
		return combustible * 100 / consumo100Km;
	}
}
