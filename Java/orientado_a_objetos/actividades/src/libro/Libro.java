package libro;

public class Libro {
	
	private int n_paginas;
	private String autor;
	private String titulo;
	
	//Constructor: Sirve para inicializar las variables 
	public Libro(int n_paginas, String autor, String titulo) {
		this.n_paginas = n_paginas;
		this.autor = autor;
		this.titulo = titulo;
	}
	
	//Getters
	public int getN_Paginas() {
		
		return n_paginas;
	}
	
	public String getAutor() {	
		
		return autor;
	}
	
	public String getTitulo() {
	
		return titulo;
	}

	
	
	@Override
	public String toString() {
		return String.format("El libro %s escrito por %s tiene %d páginas%n", 
				titulo, autor, n_paginas);
	}	
}
