package modelo;

import excepciones.NoPortatilException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PortatilDAO implements InterfazPortatilDAO{

    Connection conexion = Conexion.getConexion();

    @Override
    public boolean crearPortatil(Portatil portatil) {
        PreparedStatement sentencia = null;
        int resultado = 0;
        String sqlite = "INSERT INTO portatil(ram, ssd, pantalla) VALUES (?, ?, ?);";
        try {
            sentencia = conexion.prepareStatement(sqlite);
            sentencia.setInt(1, portatil.getRam());
            sentencia.setInt(2, portatil.getSsd());
            sentencia.setInt(3, portatil.getPantalla());
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
    public Portatil obtenerPortatilPorId(int id) {
        Portatil portatil = new Portatil();
        String sqlite = "SELECT * FROM portatil WHERE id = ?";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            sentencia = conexion.prepareStatement(sqlite);
            sentencia.setInt(1, id);
            resultado = sentencia.executeQuery();
            if (resultado.next()){
                System.out.println("Id buscado: " + id);

                portatil = new Portatil(resultado.getInt(1), resultado.getInt(2),
                        resultado.getInt(3), resultado.getInt(4));
            }
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
            if (resultado != null) {
                try {
                    resultado.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return portatil;
        }
    }

    @Override
    public List<Portatil> obtenerTodosPortatiles() {
        List<Portatil> listaPortatiles = new ArrayList<>();
        String sqlite = "SELECT * FROM portatil;";
        try (Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(sqlite)) {
            while (resultado.next()){
                listaPortatiles.add(new Portatil(resultado.getInt("id"), resultado.getInt("ram"),
                        resultado.getInt("ssd"), resultado.getInt("pantalla")));
            }
        } catch (SQLException | NoPortatilException e) {
            e.printStackTrace();
        }
        return listaPortatiles;
    }

    @Override
    public boolean actualizarPortatil(Portatil portatil) {
        PreparedStatement sentencia = null;
        String sqlite = "UPDATE portatil SET ram = ?, ssd = ?, pantalla = ? where id = ?";
        int resultado = 0;
        try {
            sentencia = conexion.prepareStatement(sqlite);
            sentencia.setInt(1, portatil.getRam());
            sentencia.setInt(2, portatil.getSsd());
            sentencia.setInt(3, portatil.getPantalla());
            sentencia.setInt(4, portatil.getId());
            resultado = sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sentencia != null)
                try {
                    sentencia.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
        }
        return resultado == 1;
    }

    @Override
    public boolean borrarPortatilPorId(int id) {
        PreparedStatement sentencia = null;
        int resultado = 0;
        String sqlite = "DELETE FROM portatil WHERE id = ?;";
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
    public List<Portatil> obtenerPortatilesRAMSuperiorOIgualA(int ram) {
        List<Portatil> listaPortatiles = new ArrayList<>();
        Portatil portatil = new Portatil();
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sqlite = "SELECT * FROM portatil WHERE ram >= ?";
        try {
            sentencia = conexion.prepareStatement(sqlite);
            sentencia.setInt(1, ram);
            resultado = sentencia.executeQuery();
            while (resultado.next()){
                if (ram >= portatil.getRam()){{
                    listaPortatiles.add(new Portatil(resultado.getInt("id"), resultado.getInt("ram"),
                            resultado.getInt("ssd"), resultado.getInt("pantalla")));
                }}
            }
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
            if (resultado != null) {
                try {
                    resultado.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return listaPortatiles;
        }
    }

    public static void main(String[] args) {

        PortatilDAO portatilDAO = new PortatilDAO();
        /*
        Portatil portat = new Portatil(128, 5000, 30);
        portatilDAO.crearPortatil(portat);
        System.out.println("¿Exito en el borrado? " + portatilDAO.borrarPortatilPorId(100));
        List<Portatil> lista = portatilDAO.obtenerTodosPortatiles();
        for (Portatil portatil : lista) {
            System.out.println(portatil);
        }
        */

        List<Portatil> lista = portatilDAO.obtenerPortatilesRAMSuperiorOIgualA(128);
        for (Portatil portatil : lista) {
            System.out.println(portatil);
        }

        Conexion.cierreConexion();
    }
}
