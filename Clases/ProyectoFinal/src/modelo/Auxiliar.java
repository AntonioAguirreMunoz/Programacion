package modelo;

import excepciones.NoPortatilException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Auxiliar {

    //Otra opción para volcarFichero
    /*
    public static void volcarBDaFichero (InterfazPortatilDAO dao) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FILES/");
        stringBuilder.append("BD_");
        stringBuilder.append(LocalDateTime.now().toString());
        stringBuilder.append(".csv");
        String nombreFichero = stringBuilder.toString();
        System.out.println(nombreFichero);
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nombreFichero)))) {
            List<Portatil> lista = dao.obtenerTodosPortatiles();
            for (Portatil portatil: lista) {
                out.println(portatil);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

    Connection conexion = Conexion.getConexion();

    public static boolean volcarFichero(List<Portatil> portatil) throws IOException {
        File fichero = new File("FILES/" + LocalDate.now() + ".csv");
        PrintWriter writer = new PrintWriter(fichero);

        for (Portatil o:portatil) {
            writer.write(o.toString());
        }
        writer.flush();
        if(Files.exists(Paths.get("FILES/.csv")))
            return true;

        return false;
    }

    public static List<Portatil> leerFichero() throws IOException, NoPortatilException {
        List<Portatil> nuevalista = new ArrayList<>();
        List<String> fichero = Files.readAllLines(Paths.get("FILES/2020-06-06.csv"));
        for (int i = 1; i < fichero.size(); i++) {
            String[] tokens = fichero.get(i).split(", ");
            if (tokens[3].matches("[0-9]")){
                Portatil portatil = new Portatil(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]) ,Integer.parseInt(tokens[2]) , Integer.parseInt(tokens[3]));
                nuevalista.add(portatil);
            }else{
                Portatil portatil = new Portatil(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]) ,Integer.parseInt(tokens[2]) , Integer.parseInt(tokens[3]));
                nuevalista.add(portatil);
            }
        }
        return  nuevalista;
    }

    public static boolean crearPortatil(List<Portatil> listaPortatiles) {
        PreparedStatement sentencia = null;
        int resultado = 0;
        Connection conexionVolcado = ConexionVolcado.getConexion();
        for (Portatil portatil:listaPortatiles) {
            String sqlite = "INSERT INTO portatil(ram, ssd, pantalla) VALUES (?, ?, ?);";

            try {
                sentencia = conexionVolcado.prepareStatement(sqlite);
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
        }
        return resultado == 1;
    }

    public static boolean validarID(int id){
        return id >= 0;
    }

    public static boolean validarRAM (int ram){
        return ram >= 1 && ram <= 256;
    }

    public static boolean validarSSD (int ssd){
        return ssd >= 128 && ssd <= 5000;
    }

    public static boolean validarPantalla (int pantalla){
        return pantalla >= 10 && pantalla <= 32;
    }

    public static boolean validarPortatil (int id, int ram, int ssd, int pantalla){
        return validarID(id) && validarRAM(ram)
                && validarSSD(ssd) && validarPantalla(pantalla);
    }


    public static void main(String[] args) throws IOException, NoPortatilException {
        //volcarBDaFichero(new PortatilDAO());
        //Conexion.cierreConexion();

        PortatilDAO portatilDAO = new PortatilDAO();
        volcarFichero(portatilDAO.obtenerTodosPortatiles());

        Auxiliar.crearPortatil(leerFichero());
        Conexion.cierreConexion();
    }
}
