public class Area {
	
		public static final double PI = 3.1416;
		
		public static void main (String[] args){
	
			double radio, area;
			radio = 15;
			if (radio <= 0) {
				
			System.out.println ( "No se puede hacer el area de un numero negativo ");
			
			} else { 
				
			area = radio * radio * PI;
			System.out.println ( "El area de un circulo de radio " + radio + " es " + area);
			}
	}
}
