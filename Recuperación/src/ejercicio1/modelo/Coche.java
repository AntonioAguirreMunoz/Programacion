package ejercicio1.modelo;

import java.time.LocalDate;

public class Coche {

    private String matricula;
    private String modelo;
    private String fabricante;
    private LocalDate fechaFabricacion;

    public Coche(String matricula, String modelo, String fabricante, LocalDate fechaFabricacion) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.fechaFabricacion = fechaFabricacion;
    }

    public Coche() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s %n", matricula, modelo, fabricante, fechaFabricacion);
    }
}
