package ejercicio2.modelo;

import ejercicio2.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalDAO implements InterfazPersonalDAO{

    Connection conexion = Conexion.getConexion();

    @Override
    public List<Personal> listarTodoElPersonal() {
        List<Personal> listaPersonal = new ArrayList<>();
        String sqlite = "SELECT * FROM personal";
        try (Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(sqlite)){
            while (resultado.next()){
                listaPersonal.add(new Personal(resultado.getInt("id"), resultado.getString("nombre"), resultado.getInt("edad"),
                                    resultado.getDouble("sueldo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPersonal;
    }

    @Override
    public boolean aumentarSueldoPorNombre(double sueldo, String nombre) {
        PreparedStatement sentencia = null;
        String sqlite = "UPDATE personal SET sueldo = ? where nombre = ?";
        int resultado = 0;
        try {
            sentencia = conexion.prepareStatement(sqlite);
            sentencia.setDouble(1, sueldo);
            sentencia.setString(2, nombre);
            resultado = sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sentencia != null) {
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
    public boolean borrarPersonalPorNombre(String nombre) {
        PreparedStatement sentencia = null;
        String sqlite = "DELETE FROM personal WHERE nombre = ?";
        int resultado = 0;
        try {
            sentencia = conexion.prepareStatement(sqlite);
            sentencia.setString(1, nombre);
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
    public boolean crearPersonal(Personal personal) {
        PreparedStatement sentencia = null;
        String sqlite = "INSERT INTO personal(nombre, edad, sueldo) VALUES (?, ?, ?)";
        int resultado = 0;
        try {
            sentencia = conexion.prepareStatement(sqlite);
            sentencia.setString(1, personal.getNombre());
            sentencia.setInt(2, personal.getEdad());
            sentencia.setDouble(3, personal.getSueldo());
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

    public static void main(String[] args) {

        PersonalDAO personalDAO = new PersonalDAO();

        Personal personal1 = new Personal("Antonio Aguirre", 19, 1000);

        personalDAO.crearPersonal(personal1);

        personalDAO.aumentarSueldoPorNombre(1500, "Viki Oloman");

        personalDAO.borrarPersonalPorNombre("Antonio Aguirre");

        List<Personal> listaPersonal = personalDAO.listarTodoElPersonal();
        for (Personal personal:listaPersonal) {
            System.out.println(personal);
        }

        Conexion.cierreConexion();
    }
}
