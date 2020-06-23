package VistaCalculadora;

import Lógica.Auxiliar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame {

    private StringBuilder sb = new StringBuilder();
    private JTextField textoResultado = new JTextField();

    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton botonMas;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;
    private JButton botonMenos;
    private JButton boton7;
    private JButton boton8;
    private JButton boton9;
    private JButton botonPor;
    private JButton boton0;
    private JButton botonLimpiar;
    private JButton botonIgual;
    private JButton botonEntre;


    public Vista(){
        super("Calculadora");

        //VENTANA
        Font fuente = setVentana();

        //LAYOUT
        Container cp = setLayout();

        //PANEL SUPERIOR
        crearPanelSuperior(fuente, cp);

        //PANEL CENTRAL
        JPanel panelCentral = crearPanelCentral();

        //BOTONES PANEL CENTRAL
        crearBotonesPanelCentral();


        //IMPLEMENTACION DE BOTONES AL PANEL Y AL LAYOUT
        botonesAñadidosAlPanelCentral(cp, panelCentral, boton1, boton2, boton3, botonMas, boton4, boton5, boton6, botonMenos, boton7, boton8, boton9, botonPor, boton0, botonLimpiar, botonIgual, botonEntre);


        logicaBotones(boton1, boton2, boton3, botonMas, boton4, boton5, boton6, botonMenos, boton7, boton8, boton9, botonPor, boton0, botonLimpiar, botonIgual, botonEntre);
    }

    private Font setVentana() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Font fuente = new Font("Kameron", Font.PLAIN,30);
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(490, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        return fuente;
    }

    private Container setLayout() {
        Container cp = getContentPane();
        BorderLayout bl = new BorderLayout();
        bl.setHgap(5);
        bl.setVgap(5);
        cp.setLayout(bl);
        return cp;
    }

    private void crearPanelSuperior(Font fuente, Container cp) {
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(new EmptyBorder(15, 0, 0, 0));

        textoResultado.setPreferredSize(new Dimension(420, 50));
        textoResultado.setHorizontalAlignment(JTextField.RIGHT);
        textoResultado.setFont(fuente);

        panelSuperior.add(textoResultado);
        cp.add(panelSuperior, BorderLayout.NORTH);
    }

    private JPanel crearPanelCentral() {
        JPanel panelCentral = new JPanel();
        GridLayout cuadricula = new GridLayout(4, 4, 15, 15);
        panelCentral.setBorder(new EmptyBorder(10,20,20,20));
        panelCentral.setLayout(cuadricula);
        return panelCentral;
    }

    private void crearBotonesPanelCentral() {
        boton1 = new JButton("1");
        boton2 = new JButton("2");
        boton3 = new JButton("3");
        botonMas = new JButton("+");
        boton4 = new JButton("4");
        boton5 = new JButton("5");
        boton6 = new JButton("6");
        botonMenos = new JButton("-");
        boton7 = new JButton("7");
        boton8 = new JButton("8");
        boton9 = new JButton("9");
        botonPor = new JButton("*");
        boton0 = new JButton("0");
        botonLimpiar = new JButton("Limpiar");
        botonIgual = new JButton("=");
        botonEntre = new JButton("/");
    }

    private void botonesAñadidosAlPanelCentral(Container cp, JPanel panelCentral, JButton boton1, JButton boton2, JButton boton3,
                                               JButton botonMas, JButton boton4, JButton boton5, JButton boton6, JButton botonMenos, JButton boton7,
                                               JButton boton8, JButton boton9, JButton botonPor, JButton boton0, JButton botonLimpiar, JButton botonIgual,
                                               JButton botonEntre) {
        panelCentral.add(boton1);
        panelCentral.add(boton2);
        panelCentral.add(boton3);
        panelCentral.add(botonMas);
        panelCentral.add(boton4);
        panelCentral.add(boton5);
        panelCentral.add(boton6);
        panelCentral.add(botonMenos);
        panelCentral.add(boton7);
        panelCentral.add(boton8);
        panelCentral.add(boton9);
        panelCentral.add(botonPor);
        panelCentral.add(boton0);
        panelCentral.add(botonLimpiar);
        panelCentral.add(botonIgual);
        panelCentral.add(botonEntre);
        cp.add(panelCentral, BorderLayout.CENTER);
    }

    private void logicaBotones(JButton boton1, JButton boton2, JButton boton3, JButton botonMas, JButton boton4, JButton boton5,
                               JButton boton6, JButton botonMenos, JButton boton7, JButton boton8, JButton boton9, JButton botonPor,
                               JButton boton0, JButton botonLimpiar, JButton botonIgual, JButton botonEntre) {

        boton0.addActionListener(new EventosBotones());
        boton1.addActionListener(new EventosBotones());
        boton2.addActionListener(new EventosBotones());
        boton3.addActionListener(new EventosBotones());
        boton4.addActionListener(new EventosBotones());
        boton5.addActionListener(new EventosBotones());
        boton6.addActionListener(new EventosBotones());
        boton7.addActionListener(new EventosBotones());
        boton8.addActionListener(new EventosBotones());
        boton9.addActionListener(new EventosBotones());
        botonMas.addActionListener(new EventosBotones());
        botonMenos.addActionListener(new EventosBotones());
        botonPor.addActionListener(new EventosBotones());
        botonEntre.addActionListener(new EventosBotones());
        botonIgual.addActionListener(new EventosBotones());

        botonLimpiar.addActionListener(actionEvent -> {
            textoResultado.setText("");
            sb = new StringBuilder();
        });
    }


    class EventosBotones implements ActionListener{

        public void actionPerformed(ActionEvent e){
            String boton = ((JButton) e.getSource()).getText();
            switch (boton){
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "-":
                    if(sb.length() == 0 || Auxiliar.regexExpresiónAritmética(sb.toString() + boton)){
                        sb.append(boton);
                        textoResultado.setText(sb.toString());
                    }
                    break;
                case "=":
                    if(Auxiliar.comprobarParaIgual(sb.toString())){
                        textoResultado.setText(Auxiliar.getOperacion(sb.toString() + ""));
                        sb = new StringBuilder();
                    }
                    break;
                default:
                    if(Auxiliar.regexExpresiónAritmética(sb.toString() + boton)){
                        sb.append(boton);
                        textoResultado.setText(sb.toString());
                    }
            }
        }
    }
}
