package DAO;

import POJO.Trabajador;

import java.util.List;

public interface InterfazTrabajadorDAO {

    boolean addTrabajador (Trabajador trabajador);
    boolean borrarTrabajadorPorId(int id);
    List<Trabajador> obtenerTrabajadores();

}
