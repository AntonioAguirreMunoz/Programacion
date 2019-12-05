package matematicas;

import java.lang.Math;

public class Matematicas {

	private double numero;

	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		this.numero = numero;
	}
	
	public double calcularRaiz() {
		
		return Math.sqrt(numero);
	}
	
	public double calcualarRaizCubica() {
		
		return Math.abs(Math.cbrt(numero)); 
	}
	
	public int redondearAInt() {
		
		return (int) Math.round(numero);
	}
	
	public int obtenerNumeroAleatorio() {
		
		return (int) Math.round(redondearAInt() * Math.random());
	}
}
