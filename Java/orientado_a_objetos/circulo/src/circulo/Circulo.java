package circulo;

public class Circulo {
	
	private int radio = 1;
	
	public int getRadio(){
		
		return radio;		
	}
	
	public void setRadio(int radio){
		
		this.radio = radio;
	}
	
	public double getArea(){
		
		return Math.PI * Math.pow(radio, 2);
	}
	
	public double getPerimetro() {
		
		return 2.0 * Math.PI * radio;
	}

	public String toString(){
		return "Radio del circulo: " + radio + ". Area = " + getArea() + 
				" y perimetro=" + getPerimetro();
	}
}