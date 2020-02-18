package coche;

public class Test_Coche {
	
	public static void main(String[] args) {

		Coche coche1 = new Coche();
		System.out.printf("Puede realizar %.2f km con %.0f litros de combustible.%n",
							coche1.getConsumo100Km(), coche1.getCombustible());
		Coche coche2 = new Coche();
		coche2.anadirCombustible(2);
		System.out.printf("Puede realizar %.2f km con %.0f litros de combustible.",
							coche2.getConsumo100Km(), coche2.getCombustible());
	}
}
