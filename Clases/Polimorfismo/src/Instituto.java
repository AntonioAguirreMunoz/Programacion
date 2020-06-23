import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Instituto {

    private String nombreInstituto;
    private List<Profesor> listaProfesores;

    public Instituto(String nombreInstituto, List<Profesor> listaProfesores) {
        this.nombreInstituto = nombreInstituto;
        this.listaProfesores = listaProfesores;
    }

    public boolean addProfesor(Profesor profesor){
        return listaProfesores.add(profesor);
    }

    public boolean eliminarProfesor (String dni){
        for (Profesor profesor: listaProfesores){
            if (profesor.getDni().equals(dni))
                listaProfesores.remove(profesor);
        }
        return false;
    }

    public void ampliarContrato(ProfesorInterino profesorInterino, int nuevosMeses){
        for (Profesor profesor: listaProfesores) {
            if (profesor instanceof ProfesorInterino){
                ProfesorInterino pfi = (ProfesorInterino) profesor;
                if (pfi.equals(profesorInterino)){
                    int nuevoContrato = nuevosMeses + pfi.getMesesContrato();
                    if (nuevoContrato > 12)
                        nuevoContrato = 12;
                    pfi.setMesesContrato(nuevosMeses + pfi.getMesesContrato() % 12);
                }
            }
        }
    }

    public void visualizarDatosProfeosres(){
        for (Profesor profesor: listaProfesores) {
            System.out.printf("%-15s,%-15s,%-15s,%-15s%n ", profesor.getApellido1(), profesor.getApellido2(),
                                profesor.getNombrePersona(), profesor.getMeteriaImpartida());
        }
    }

    public Map<String, Double> listaSueldoProfesores(double retencion){
        Map<String, Double> lista = new HashMap<>();
        for (Profesor profesor:listaProfesores) {
            lista.put(profesor.getDni(), profesor.getSueldoNeto(retencion));
        }
        return lista;
    }

    public void guardarDatos(){
        String nombreFichero = "FICHEROS/profesores_backup.csv";
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nombreFichero)))) {
            for (Profesor profesor:listaProfesores) {
                out.println(profesor);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("FICHEROS/profesores.csv"));
        String nombreInstituto = in.nextLine();
        List<Profesor> listaProfesores = new ArrayList<>();

        while (in.hasNextLine()){
            String linea =  in.nextLine();
            String[] tokens = linea.split(",");
            String nombreProfesor = tokens[0];
            String apellido1Profesor = tokens[1];
            String apellido2Profesor = tokens[2];
            String dniProfesor = tokens[3];
            String[] datosFecha = tokens[4].split("/");
            int dia = Integer.parseInt(datosFecha[1]);
            int mes = Integer.parseInt(datosFecha[0]);
            int anno = Integer.parseInt(datosFecha[2]);
            LocalDate fechaNacimiento = LocalDate.of(anno, mes, dia);
            double sueldoBruto = Double.parseDouble(tokens[5]);
            Materia materiaImpartida = null;
            switch (tokens[6]){
                case "SISTEMAS INFORMATICOS":
                    materiaImpartida = Materia.SISTEMAS_INFORMATICOS;
                    break;
                case "BASE DE DATOS":
                    materiaImpartida = Materia.BASE_DE_DATOS;
                    break;
                case "LENGUAJE DE MARCAS":
                    materiaImpartida = Materia.LENGUAJE_DE_MARCAS;
                    break;
                case "PROGRAMACION":
                    materiaImpartida = Materia.PROGRAMACION;
                    break;
                case "EMPRESAS":
                    materiaImpartida = Materia.EMPRESAS;
                    break;
                case "ENTORNOS DE PROGRAMACION":
                    materiaImpartida = Materia.ENTORNOS_DE_PROGRAMACION;
                    break;
                default:
            }
            int contador1 = 0;
            int contador2 = 0;
            if (tokens[7].matches("[\\d]+]")){
                listaProfesores.add(new ProfesorInterino(nombreProfesor, apellido1Profesor, apellido2Profesor, fechaNacimiento, dniProfesor, sueldoBruto, materiaImpartida, Integer.parseInt(tokens[7])));
                System.out.println("profesor interino: " + contador1++);
            } else {
                String[] datosFecha2 = tokens[4].split("/");
                int diaI = Integer.parseInt(datosFecha2[1]);
                int mesI = Integer.parseInt(datosFecha2[0]);
                int annoI = Integer.parseInt(datosFecha2[2]);
                LocalDate fechaIncorporacion = LocalDate.of(anno, mes, dia);
                listaProfesores.add(new ProfesorTitular(nombreProfesor, apellido1Profesor, apellido2Profesor, fechaNacimiento, dniProfesor, sueldoBruto, materiaImpartida, fechaIncorporacion));
            }
        }
        Instituto instituto = new Instituto(nombreInstituto, listaProfesores);
        instituto.visualizarDatosProfeosres();
        Map<String, Double> listadoSueldo = instituto.listaSueldoProfesores(15.5);
        Set<String> dnis = listadoSueldo.keySet();
        for (String dni: dnis) {
            System.out.printf("DNI %s: %2f€%n", dni, listadoSueldo.get(dni));
        }
    }
}


