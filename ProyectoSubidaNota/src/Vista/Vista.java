package Vista;

import DAO.TrabajadorDAO;
import POJO.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Vista extends JFrame {

    JTable tabla;
    TrabajadoresTabla modeloTabla;
    TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
    List<Trabajador> trabajadores = trabajadorDAO.obtenerTrabajadores();

    public Vista(){
        setVista();
        setLayout();
        crearTabla();
        setBotones();
        pack();
    }

    private void setVista() {
        setTitle("Trabajadores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void setLayout() {
        getContentPane().setLayout(new BorderLayout());
    }

    private void crearTabla() {
        modeloTabla = new TrabajadoresTabla(trabajadores);
        tabla = new JTable(modeloTabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tabla);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }


    private void setBotones(){
        JPanel panelInferior = new JPanel();
        JButton botonBorrar = new JButton("Borrar");
        JButton botonNuevo = new JButton("Nuevo Trabajador");
        panelInferior.add(botonBorrar);
        panelInferior.add(botonNuevo);
        getContentPane().add(panelInferior, BorderLayout.SOUTH);
        botonBorrar.addActionListener(actionEvent -> {
            int fila = tabla.getSelectionModel().getMinSelectionIndex();
            System.out.println(fila);
            Trabajador trabajador = trabajadores.get(fila);
            trabajadorDAO.borrarTrabajadorPorId(trabajador.getId());
            System.out.println("Borrado trabajador " + trabajador.getId());
            trabajadores.remove(trabajador);
            modeloTabla.fireTableRowsDeleted(fila, fila);
        });
        botonNuevo.addActionListener(actionEvent -> {
            Trabajador trabajador = vistaAddTrabajador();
            trabajadorDAO.addTrabajador(trabajador);
            trabajadores = trabajadorDAO.obtenerTrabajadores();
            modeloTabla.setTrabajadores(trabajadores);
        });
    }

    public Trabajador vistaAddTrabajador() {
        String sNombre = JOptionPane.showInputDialog("Introduce nombre");
        String sApellido = JOptionPane.showInputDialog("Introduce apellido");
        String sGenero = JOptionPane.showInputDialog("Introduce género");
        String sPuestoTrabajo = JOptionPane.showInputDialog("Introduce puesto de trabajo");
        Trabajador trabajador = new Trabajador(sNombre, sApellido, sGenero, sPuestoTrabajo);
        return trabajador;
    }
}