package triangulo;

import java.lang.Math;

public class Triangulo {
	
	private float cateto1;
	private float cateto2;
	
	public Triangulo(float cateto1, float cateto2) {
		
		this.cateto1 = cateto1;
		this.cateto2 = cateto2;
	}
	
	public float calcularHipotenusa(){
		
		return (float) Math.hypot(cateto1, cateto2); 
	}
	
	public float calcularArea() {
		
		return cateto1 * cateto2 / 2;
	}

	public float calcularPerimetro() {
		
		return cateto1 + cateto2 + calcularHipotenusa();
	}
	
	public String toString() {
		return String.format("Triángulo de lados %.2f, %.2f y %.2f \nde área %.2f \ny de perímetro %.2f", 
								cateto1, cateto2, calcularHipotenusa(), calcularArea(), calcularPerimetro());
	}	
} 
