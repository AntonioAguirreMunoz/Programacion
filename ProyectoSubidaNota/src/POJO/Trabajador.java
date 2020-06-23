package POJO;

public class Trabajador {

    private int id;
    private String nombre;
    private String apellido;
    private String genero;
    private String puestoTrabajo;

    public Trabajador(int id, String nombre, String apellido, String genero, String puestoTrabajo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.puestoTrabajo = puestoTrabajo;
    }

    public Trabajador(String nombre, String apellido, String genero, String puestoTrabajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.puestoTrabajo = puestoTrabajo;
    }

    public Trabajador() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s", id, nombre, apellido, genero, puestoTrabajo);
    }
}
