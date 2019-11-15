public class Rectangulo {
		
	private int ancho = 2;
	private int alto = 1;

	/**
	 * @return int
	 */
	public int getAncho() {
		return ancho;
	}

	/**						
	 * @return int
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * @param alto
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}

	/**
	 * 	
	 * @param ancho
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return int
	 */
	public int getArea() {
		return alto * ancho;
	}

	/**
	 * @return int
	 */
	public int getPerimetro() {
		return 2 * ancho + 2 * alto;
	}
	
	public int getHipotenusa(int ancho, int alto) {	
		int hyp = ancho * ancho + alto * alto;
		return sqrt(hyp);
	}
}

