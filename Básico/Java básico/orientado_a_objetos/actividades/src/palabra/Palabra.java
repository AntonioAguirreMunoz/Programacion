package palabra;

public class Palabra {

	private String contenidoPalabra; 
	
	public Palabra (String contenidoPalabra){
		this.contenidoPalabra = contenidoPalabra.trim();
		
	}
	
	public String obtenerPalabraMayuscula(){
		
		return contenidoPalabra.toUpperCase();
	}

	public String obtenerPalabraMinuscula(){
		
		return contenidoPalabra.toLowerCase();
	}
	
	public int obtenerNumeroPalabra(){
		
		return contenidoPalabra.length();
	}
	
	public String remplazarLetra(String caracterARemplazar, String caracterRemplazo){
		
		return contenidoPalabra.replace(caracterARemplazar, caracterRemplazo);
	}
	
	public char obtenerPrimeraLetra(){
		if (contenidoPalabra.length() != 0)
		
			return contenidoPalabra.toLowerCase().charAt(0);
		return ' ';
	}

	public char obtenerUltimaLetra(){
		if (contenidoPalabra.length() != 0)
		
			return contenidoPalabra.toLowerCase().charAt(contenidoPalabra.length() - 1);
		return ' ';
	}
}

