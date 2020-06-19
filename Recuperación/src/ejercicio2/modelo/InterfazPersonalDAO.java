package ejercicio2.modelo;

import java.util.List;

public interface InterfazPersonalDAO {

    List<Personal> listarTodoElPersonal();
    boolean aumentarSueldoPorNombre(double sueldo, String nombre);
    boolean borrarPersonalPorNombre(String nombre);
    boolean crearPersonal(Personal personal);
}
