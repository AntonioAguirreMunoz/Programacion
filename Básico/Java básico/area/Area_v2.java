public class Area_v2 {
		
	public static final double PI = 3.1416;
	
	public static void main (String[] args) {
	
			double radio, area;
			radio = -3;
			
			if (radio < 0){
				
				radio = -radio;
				area = radio * radio * PI;
				System.out.println ( "El area de un circulo de radio " + radio + " es " + area );					
			}
			
			else if ( radio == 0 ) {
				
				System.out.println ("El radio del circulo no puede ser 0 ");
			}
			
			else {
				area = radio * radio * PI;
				System.out.println ( "El area de un circulo de radio " + radio + " es " + area );					
			}
	}
}
