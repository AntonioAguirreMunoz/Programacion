package ejercicio1.modelo;

import java.time.LocalDate;

public class TodoCamino extends Coche {

    private boolean cuatroPorCuatro;

    public TodoCamino(String matricula, String modelo, String fabricante, LocalDate fechaFabricacion, boolean cuatroPorCuatro) {
        super(matricula, modelo, fabricante, fechaFabricacion);
        this.cuatroPorCuatro = cuatroPorCuatro;
    }

    public boolean isCuatroPorCuatro() {
        return cuatroPorCuatro;
    }

    public void setCuatroPorCuatro(boolean cuatroPorCuatro) {
        this.cuatroPorCuatro = cuatroPorCuatro;
    }

    @Override
    public String toString() {
        return String.format("%s,%n", super.toString(), cuatroPorCuatro);
    }
}
