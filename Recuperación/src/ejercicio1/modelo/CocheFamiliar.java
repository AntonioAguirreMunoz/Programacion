package ejercicio1.modelo;

import java.time.LocalDate;

public class CocheFamiliar extends Coche {

    private int numeroAsientos;

    public CocheFamiliar(String matricula, String modelo, String fabricante, LocalDate fechaFabricacion, int numeroAsientos) {
        super(matricula, modelo, fabricante, fechaFabricacion);
        this.numeroAsientos = numeroAsientos;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    @Override
    public String toString() {
        return String.format("%s,%d", super.toString(), numeroAsientos);
    }
}
