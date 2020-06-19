package ejercicio1.modelo;

import ejercicio1.exceptions.CocheException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.List;

import static java.time.temporal.ChronoUnit.YEARS;

public class Concesionario {

    private String nombreConcesionario;
    private List<Coche> listaCoches;

    public Concesionario(String nombreConcesionario, List<Coche> coches) {
        this.nombreConcesionario = nombreConcesionario;
        this.listaCoches = coches;
    }

    public String getNombreConcesionario() {
        return nombreConcesionario;
    }

    public void setNombreConcesionario(String nombreConcesionario) {
        this.nombreConcesionario = nombreConcesionario;
    }

    public List<Coche> getListaCoches() {
        return listaCoches;
    }

    public void setListaCoches(List<Coche> listaCoches) {
        this.listaCoches = listaCoches;
    }

    public boolean ampliarConcesionario(Coche coche){
        return listaCoches.add(coche);
    }


    public List<Coche>obtenerCochesSegunFecha(int annos){
        List<Coche> listaSegunFecha = new ArrayList<>();
        int annosDelCoche;
        for (Coche coche:listaCoches) {
            Period period = Period.between(coche.getFechaFabricacion(),LocalDate.now());
            annosDelCoche = period.getYears();
            if (annosDelCoche >= annos)
                System.out.println(coche);
            listaSegunFecha.add(coche);
        }
        return listaSegunFecha;
    }

    public Map<String, Boolean> listarCochesTodoCamino(){

        HashMap datos = new HashMap();
        Iterator it = datos.entrySet().iterator();

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ficherosEntrada/coches.csv")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
        return datos;
    }


    public static boolean volcarFichero(List<Coche> coches) throws IOException {
        File fichero = new File("ficherosSalida/" + LocalDate.now() + ".csv");
        PrintWriter writer = new PrintWriter(fichero);

        for (Coche c:coches) {
            writer.write(c.toString());
        }
        writer.flush();
        if(Files.exists(Paths.get("ficherosSalida/.csv")))
            return true;

        return false;
    }

    public static List<Coche> gravarDatos() throws IOException {
        List<Coche> nuevalista = new ArrayList<>();
        List<String> fichero = Files.readAllLines(Paths.get("ficherosEntrada/coches.csv"));
        for (int i = 1; i < fichero.size(); i++) {
            String[] tokens = fichero.get(i).split(",");
            if (tokens[4].matches("[0-9]")){
                String[] datosFecha1 = tokens[3].split("/");
                int dia = Integer.parseInt(datosFecha1[2]);
                int mes = Integer.parseInt(datosFecha1[1]);
                int anno = Integer.parseInt(datosFecha1[0]);
                LocalDate fechaMatriculacion = LocalDate.of(anno, mes, dia);
                CocheFamiliar cocheFamiliar = new CocheFamiliar(tokens[0], tokens[1], tokens[2], fechaMatriculacion, Integer.parseInt(tokens[4]));
                nuevalista.add(cocheFamiliar);
            } else {
                String[] datosFecha1 = tokens[3].split("/");
                int dia = Integer.parseInt(datosFecha1[2]);
                int mes = Integer.parseInt(datosFecha1[1]);
                int anno = Integer.parseInt(datosFecha1[0]);
                LocalDate fechaMatriculacion = LocalDate.of(anno, mes, dia);
                TodoCamino todoCamino = new TodoCamino(tokens[0], tokens[1], tokens[2], fechaMatriculacion, Boolean.parseBoolean(tokens[4]));
                nuevalista.add(todoCamino);
            }
        }
        return  nuevalista;
    }

    public static void main(String[] args) throws CocheException, IOException {
        volcarFichero(gravarDatos());

        Concesionario concesionario = new Concesionario("Jaén", gravarDatos());

        Coche coche1 = new TodoCamino("KVC1234", "Ranger Rover Velar", "Land Rover", LocalDate.of(2020, 06, 01), true);
        Coche coche2 = new CocheFamiliar("KVC1235", "Mini Cabrio", "BMW", LocalDate.of(2020, 06, 02), 4);

        //System.out.println(concesionario.obtenerCochesSegunFecha(5));

        //concesionario.listarCochesTodoCamino();

    }
}
