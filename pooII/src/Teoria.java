public class Teoria {

    public static void main(String[] args) {
        int valor = 3;
        System.out.printf("Antes de llamar al método\n", valor);
        intentarModificarArgumentos(valor);
        System.out.printf("Después de llamar al método\n", valor);
        Persona persona = new Persona(25);
        System.out.printf("Antes de llamar al método: %s\n", persona);
        intentarModificarArgumentos(persona);
        System.out.printf("Después de llamar al método: %s\n", persona);
    }

    public static void intentarModificarArgumentos(int valor){
        valor *= 2;
        System.out.printf("%d en el método\n", valor);
    }

    public static void intentarModificarArgumentos(Persona persona){
        persona.setEdad(persona.getEdad() + 5);
        System.out.printf("Método: %s\n", persona);
    }
}

class Persona{
    private int edad;

    public Persona(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return String.format("%d", edad);
    }
}
