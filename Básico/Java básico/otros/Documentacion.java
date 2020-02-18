/** Esta clase define objetos que contienen* un atributo denominado n ́umero
 * y posee un método para devolver
 * el valor doble
 * @author : Manuel Molino
 * @version : 1.0
 */

public class Documentacion{
	
	/** Constructor: es un m ́etodo que tiene
	 * el mismo nombre que la clase y se
	 * usa para crear objetos
	 * @param n parámetro para inicializar el objeto
	 * se usa para inicializar los objetos
	 * de tipo número
	 */
	
	private double numero;  
	public Numero(double n){
		this.numero = n;
	}
	
	/** método que devuelve el valor doble
	 * @return el valor doble del atributo
	 * numero de dicho objeto.
	 */
	 
	public double calcularDoble(){
		return this.numero*2;
	}
	
	/** método que devuelve el valor triple
	 * @return el valor triple del atributo
	 * numero de dicho objeto.
	 */
	 
	public double calcularTriple(){
		return this.numero*3;
	}
	
	/** método que devuelve el valor mitad
	 * @return el valor mitad del atributo
	 * numero de dicho objeto.
	 */
	 
	public double calcularMitad(){
		return this.numero/2;
	}
}

class TestNumeros {
	public static void main(String[] arg){
	Numero n1 = new Numero(5);
	System.out.println("Valor doble: " + n1.calcularDoble());
	System.out.println("Valor triple " + n1.calcularTriple());
	System.out.println("Valor mitad " + n1.calcularMitad());
	}
}
