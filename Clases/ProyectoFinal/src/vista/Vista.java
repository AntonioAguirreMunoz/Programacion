package vista;

import excepciones.NoPortatilException;
import modelo.Portatil;
import modelo.PortatilDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Vista extends JFrame {

    private JTextField inputID = null;
    private JTextField inputRAM = null;
    private JTextField inputSSD = null;
    private JTextField inputPULG = null;

    private PortatilDAO portatilDAO = new PortatilDAO();
    private List<Portatil> listaPortatiles = portatilDAO.obtenerTodosPortatiles();
    private int contador = 0;

    JLabel etiquetaID = new JLabel("ID", SwingConstants.CENTER);
    JLabel etiquetaRAM = new JLabel("RAM", SwingConstants.CENTER);
    JLabel etiquetaSSD = new JLabel("SSD", SwingConstants.CENTER);
    JLabel etiquetaPULG = new JLabel("PULG", SwingConstants.CENTER);
    JPanel botonInferior = new JPanel();
    JButton botonAvanzar = new JButton(">");
    JButton botonRetroceder = new JButton("<");
    JButton botonCrear = new JButton("Crear");
    JButton botonActualizar = new JButton("Actualizar");
    JButton botonBorrar = new JButton("Borrar");
    JButton botonSalir = new JButton("Salir");
    JButton botonAvanzarDiez = new JButton(">>");
    JButton botonRetrocederDiez = new JButton("<<");

    public Vista(){
        super("Aula de departamentos");

        setVentana();
        Container cp = setLayout();
        crearPanelSuperior(cp);
        crearBotonesPanelInferior();
        crearPanelInferior(cp, botonInferior, botonAvanzar, botonRetroceder, botonCrear,
                            botonActualizar, botonBorrar, botonSalir, botonAvanzarDiez,
                            botonRetrocederDiez);
        crearPanelCentral(cp);
        logicaBotones(botonAvanzar, botonRetroceder, botonCrear, botonActualizar,
                        botonBorrar, botonSalir, botonAvanzarDiez, botonRetrocederDiez);
    }

    private void setVentana() {
        setSize(600, 400); //Tamaño de la vista
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private Container setLayout() {
        Container cp = getContentPane();
        BorderLayout layoutPrincipal = new BorderLayout();
        cp.setLayout(layoutPrincipal);
        return cp;
    }

    private void logicaBotones(JButton botonAvanzar, JButton botonRetroceder, JButton botonCrear, JButton botonActualizar, JButton botonBorrar, JButton botonSalir, JButton botonAvanzarDiez, JButton botonRetrocederDiez) {

        botonSalir.addActionListener(actionEvent -> {
            System.exit(0);
        });

        botonAvanzar.addActionListener(actionEvent -> {
            contador++;
            if (contador >= listaPortatiles.size())
                contador %= listaPortatiles.size();
            inputID.setText(listaPortatiles.get(contador).getId() + "");
            inputRAM.setText(listaPortatiles.get(contador).getRam() + "");
            inputSSD.setText(listaPortatiles.get(contador).getSsd() + "");
            inputPULG.setText(listaPortatiles.get(contador).getPantalla() + "");
        });
        botonRetroceder.addActionListener(actionEvent -> {
            contador--;
            if (contador < 0)
                contador += listaPortatiles.size();
            inputID.setText(listaPortatiles.get(contador).getId() + "");
            inputRAM.setText(listaPortatiles.get(contador).getRam() + "");
            inputSSD.setText(listaPortatiles.get(contador).getSsd() + "");
            inputPULG.setText(listaPortatiles.get(contador).getPantalla() + "");
        });
        botonAvanzarDiez.addActionListener(actionEvent -> {
            contador += 10;
            if (contador >= listaPortatiles.size())
                contador %= listaPortatiles.size();
            inputID.setText(listaPortatiles.get(contador).getId() + "");
            inputRAM.setText(listaPortatiles.get(contador).getRam() + "");
            inputSSD.setText(listaPortatiles.get(contador).getSsd() + "");
            inputPULG.setText(listaPortatiles.get(contador).getPantalla() + "");
        });
        botonRetrocederDiez.addActionListener(actionEvent -> {
            contador -= 10;
            if (contador < 0)
                contador += listaPortatiles.size();
            inputID.setText(listaPortatiles.get(contador).getId() + "");
            inputRAM.setText(listaPortatiles.get(contador).getRam() + "");
            inputSSD.setText(listaPortatiles.get(contador).getSsd() + "");
            inputPULG.setText(listaPortatiles.get(contador).getPantalla() + "");
        });

        botonActualizar.addActionListener(actionEvent -> {

            int id = Integer.parseInt(inputID.getText());
            int ramActual = Integer.parseInt(inputRAM.getText());
            int ssdActual = Integer.parseInt(inputSSD.getText());
            int pulgActual = Integer.parseInt(inputPULG.getText());
            String sRamNueva = "";
            String sSsdNueva = "";
            String sPulgNueva = "";
            int ramAmpliacion = 0;
            int ssdAmpliacion = 0;
            int pulgAmpliacion = 0;
            while (true) {
                sRamNueva = JOptionPane.showInputDialog("Introduce ram a añadir");
                sSsdNueva = JOptionPane.showInputDialog("Introduce ssd a añadir");
                sPulgNueva = JOptionPane.showInputDialog("Introduce pulg a añadir");
                if (sRamNueva != null && sSsdNueva != null && sPulgNueva != null &&
                        sRamNueva.matches("[0-9]+") &&
                        sSsdNueva.matches("[0-9]+") &&
                        sPulgNueva.matches("[0-9]+")) {
                    ramAmpliacion = Integer.parseInt(sRamNueva);
                    ssdAmpliacion = Integer.parseInt(sSsdNueva);
                    pulgAmpliacion = Integer.parseInt(sPulgNueva);
                    break;
                }
            }
            int nuevaRAM = ramActual + ramAmpliacion;
            int nuevaSSD = ssdActual + ssdAmpliacion;
            int nuevaPULG = pulgActual + pulgAmpliacion;
            try {
                portatilDAO.actualizarPortatil(new Portatil(id,nuevaRAM, nuevaSSD, nuevaPULG));
            } catch (NoPortatilException e) {
                e.printStackTrace();
            }
            inputRAM.setText(nuevaRAM + "");
            inputSSD.setText(nuevaSSD + "");
            inputPULG.setText(nuevaPULG + "");
            try {
                listaPortatiles.get(contador).setRam(nuevaRAM);
            } catch (NoPortatilException e) {
                e.printStackTrace();
            }
            try {
                listaPortatiles.get(contador).setSsd(nuevaSSD);
            } catch (NoPortatilException e) {
                e.printStackTrace();
            }
            try {
                listaPortatiles.get(contador).setPantalla(nuevaPULG);
            } catch (NoPortatilException e) {
                e.printStackTrace();
            }
        });

        botonBorrar.addActionListener(actionEvent -> {
            int id = Integer.parseInt(inputID.getText());
            portatilDAO.borrarPortatilPorId(id);
            listaPortatiles.remove(contador);
            if (contador >= listaPortatiles.size())
                contador %= listaPortatiles.size();
            setDatosFormularioPanelCentral();
        });

        botonCrear.addActionListener(actionEvent -> {
            int id, ram, ssd, pulg;
            String sRam = "";
            while (true) {
                sRam = JOptionPane.showInputDialog("Introduce ram");
                if (sRam != null && sRam.matches("[0-9]+")) {
                    ram = Integer.parseInt(sRam);
                    break;
                }
            }
            String sSSD = "";
            while (true) {
                sSSD = JOptionPane.showInputDialog("Introduce ssd");
                if (sSSD != null && sRam.matches("[0-9]+")) {
                    ssd = Integer.parseInt(sSSD);
                    break;
                }
            }
            String sPulg = "";
            while (true) {
                sPulg = JOptionPane.showInputDialog("Introduce pulg");
                if (sPulg != null && sPulg.matches("[0-9]+")) {
                    pulg = Integer.parseInt(sPulg);
                    break;
                }
            }

            try {
                crearTextoLogicaBotones(ram, ssd, pulg);
            } catch (NoPortatilException e) {
                e.printStackTrace();
            }
        });

    }

    private void crearTextoLogicaBotones(int ram, int ssd, int pulg) throws NoPortatilException {
        Portatil portatil = new Portatil(ram, ssd, pulg);
        portatilDAO.crearPortatil(portatil);
        listaPortatiles = portatilDAO.obtenerTodosPortatiles();
        contador = listaPortatiles.size() - 1;
        setDatosFormularioPanelCentral();
    }

    private void setDatosFormularioPanelCentral() {
        inputID.setText(listaPortatiles.get(contador).getId() + "");
        inputRAM.setText(listaPortatiles.get(contador).getRam() + "");
        inputSSD.setText(listaPortatiles.get(contador).getSsd() + "");
        inputPULG.setText(listaPortatiles.get(contador).getPantalla() + "");
    }

    private void crearPanelSuperior(Container cp) {
        JPanel panelSuperior = new JPanel();
        JLabel etiquetaSuperior = new JLabel("Datos de ordenadores");
        panelSuperior.add(etiquetaSuperior);
        cp.add(panelSuperior, BorderLayout.NORTH);
    }

    private void crearPanelCentral(Container cp) {
        JPanel panelCentral = new JPanel();
        GridLayout layoutCentral = new GridLayout(6, 2);
        layoutCentral.setVgap(10);
        layoutCentral.setHgap(10);
        panelCentral.setLayout(layoutCentral);
        crearEtiquetasPanelCentral();
        crearFormularioPanelCentral();
        addInputPanelCentral(cp, panelCentral, etiquetaID, etiquetaRAM, etiquetaSSD, etiquetaPULG);
    }

    private void crearEtiquetasPanelCentral() {
        etiquetaID = new JLabel("ID", SwingConstants.CENTER);
        etiquetaRAM = new JLabel("RAM", SwingConstants.CENTER);
        etiquetaSSD = new JLabel("SSD", SwingConstants.CENTER);
        etiquetaPULG = new JLabel("PULG", SwingConstants.CENTER);
    }

    private void crearFormularioPanelCentral() {
        inputID = new JTextField(10);
        inputID.setEditable(false);
        inputRAM = new JTextField(10);
        inputSSD = new JTextField(10);
        inputPULG = new JTextField(10);
        setDatosFormularioPanelCentral();
    }

    private void addInputPanelCentral(Container cp, JPanel panelCentral, JLabel etiquetaID, JLabel etiquetaRAM, JLabel etiquetaSSD, JLabel etiquetaPULG) {
        panelCentral.add(etiquetaID);
        panelCentral.add(inputID);
        panelCentral.add(etiquetaRAM);
        panelCentral.add(inputRAM);
        panelCentral.add(etiquetaSSD);
        panelCentral.add(inputSSD);
        panelCentral.add(etiquetaPULG);
        panelCentral.add(inputPULG);
        cp.add(panelCentral, BorderLayout.CENTER);
    }

    private void crearPanelInferior(Container cp, JPanel botonInferior, JButton botonAvanzar, JButton botonRetroceder, JButton botonCrear, JButton botonActualizar, JButton botonBorrar, JButton botonSalir, JButton botonAvanzarDiez, JButton botonRetrocederDiez) {
        botonInferior.add(botonSalir);
        botonInferior.add(botonActualizar);
        botonInferior.add(botonRetrocederDiez);
        botonInferior.add(botonRetroceder);
        botonInferior.add(botonAvanzar);
        botonInferior.add(botonAvanzarDiez);
        botonInferior.add(botonCrear);
        botonInferior.add(botonBorrar);
        cp.add(botonInferior, BorderLayout.SOUTH);
    }

    private void crearBotonesPanelInferior() {
        botonInferior = new JPanel();
        botonAvanzar = new JButton(">");
        botonRetroceder = new JButton("<");
        botonCrear = new JButton("Crear");
        botonActualizar = new JButton("Actualizar");
        botonBorrar = new JButton("Borrar");
        botonSalir = new JButton("Salir");
        botonAvanzarDiez = new JButton(">>");
        botonRetrocederDiez = new JButton("<<");
    }
}
