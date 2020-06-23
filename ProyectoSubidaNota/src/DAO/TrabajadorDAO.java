package DAO;

import Conexion.Conexion;
import POJO.Trabajador;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO implements InterfazTrabajadorDAO{

    private static Connection conexion;

    static {
        try {
            conexion = Conexion.getConexion();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addTrabajador(Trabajador trabajador) {
        PreparedStatement sentencia = null;
        int resultado = 0;
        String sqlite = "INSERT INTO Trabajadores(nombre, apellido, genero, puestoTrabajo) VALUES (?, ?, ?, ?);";
        try {
            sentencia = conexion.prepareStatement(sqlite);
            sentencia.setString(1, trabajador.getNombre());
            sentencia.setString(2, trabajador.getApellido());
            sentencia.setString(3, trabajador.getGenero());
            sentencia.setString(4, trabajador.getPuestoTrabajo());
            resultado = sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sentencia != null){
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado == 1;
    }

    @Override
    public boolean borrarTrabajadorPorId(int id) {
        PreparedStatement sentencia = null;
        int resultado = 0;
        String sqlite = "DELETE FROM Trabajadores WHERE id = ?;";
        try {
            sentencia = conexion.prepareStatement(sqlite);
            sentencia.setInt(1, id);
            resultado = sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sentencia != null){
                try {
                    sentencia.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return resultado == 1;
    }

    @Override
    public List<Trabajador> obtenerTrabajadores() {
        List<Trabajador> listaTrabajadores = new ArrayList<>();
        String sqlite = "SELECT * FROM Trabajadores;";
        try (Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(sqlite)) {
                while (resultado.next()){
                    listaTrabajadores.add(new Trabajador(resultado.getInt("id"), resultado.getString("nombre"),
                            resultado.getString("apellido"), resultado.getString("genero"), resultado.getString("puestoTrabajo")));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaTrabajadores;
    }
}
