package triangulo;

import javax.swing.JOptionPane;

public class Test_Triangulo {

	public static void main(String[] args) {
		
		String sCateto1 = JOptionPane.showInputDialog("Introduce el valor del cateto 1");
		String sCateto2 = JOptionPane.showInputDialog("Introduce el valor del cateto 2");
		
		float fCateto1 = Float.parseFloat(sCateto1);
		float fCateto2 = Float.parseFloat(sCateto2);
		
		Triangulo triangulo = new Triangulo(fCateto1, fCateto2);
		
		JOptionPane.showMessageDialog(null, triangulo.toString(), "Triángulo rectángulo",
										JOptionPane.PLAIN_MESSAGE);

	}
}
