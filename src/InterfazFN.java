import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class InterfazFN {
    JFrame Ventana;
    JTextArea Texto1;
    JLabel Titulo, FechEntrada, FechSalida, Colectivo, Particularidad, Recomendacion;
    JButton Boton1, Boton2;

    public InterfazFN() {
        //Título
        Ventana = new JFrame();
        Titulo = new JLabel("EXPENDEDOR DE FORFAITS");
        Titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        Ventana.add(Titulo);
        Titulo.setBounds(170, 12, 650, 30);

        //Labels Fecha Entrada y Fecha Salida
        FechEntrada = new JLabel("Fecha entrada");
        Ventana.add(FechEntrada);
        FechEntrada.setBounds(50, 50, 650, 30);
        FechSalida = new JLabel("Fecha salida");
        Ventana.add(FechSalida);
        FechSalida.setBounds(350, 50, 650, 30);

        //Día, Mes, Año
        JPanel panel = new JPanel();
        JLabel labeldia1 = new JLabel("D\u00eda");
        JLabel labelmes1 = new JLabel("Mes");
        JLabel labelanio1 = new JLabel("A\u00f1o");
        JLabel labeldia2 = new JLabel("D\u00eda");
        JLabel labelmes2 = new JLabel("Mes");
        JLabel labelanio2 = new JLabel("A\u00f1o");

        //Spinners
        Date today = new Date();
        Date start = new Date(2020,Calendar.FEBRUARY,28);
        Date finish = new Date(2021,Calendar.NOVEMBER,28);

        JSpinner spinnerdia1 = new JSpinner(new SpinnerDateModel(start,null,null,Calendar.DAY_OF_WEEK));
        JSpinner.DateEditor formatdia1 = new JSpinner.DateEditor(spinnerdia1, "dd");
        spinnerdia1.setEditor(formatdia1);

        JSpinner spinnermes1 = new JSpinner(new SpinnerDateModel(start,null,null,Calendar.MONTH));
        JSpinner.DateEditor formatmes1 = new JSpinner.DateEditor(spinnermes1, "MM");
        spinnermes1.setEditor(formatmes1);

        JSpinner spinneranio1 = new JSpinner(new SpinnerDateModel(start,null,null,Calendar.YEAR));
        JSpinner.DateEditor formatanio1 = new JSpinner.DateEditor(spinneranio1, "yy");
        spinneranio1.setEditor(formatanio1);

        //Segundo Spinners
        JSpinner spinnerdia2 = new JSpinner(new SpinnerDateModel(start,null,null,Calendar.DAY_OF_WEEK));
        JSpinner.DateEditor formatdia2 = new JSpinner.DateEditor(spinnerdia1, "dd");
        spinnerdia2.setEditor(formatdia2);

        JSpinner spinnermes2 = new JSpinner(new SpinnerDateModel(start,null,null,Calendar.MONTH));
        JSpinner.DateEditor formatmes2 = new JSpinner.DateEditor(spinnermes1, "MM");
        spinnermes2.setEditor(formatmes2);

        JSpinner spinneranio2 = new JSpinner(new SpinnerDateModel(start,null,null,Calendar.YEAR));
        JSpinner.DateEditor formatanio2 = new JSpinner.DateEditor(spinneranio1, "yy");
        spinneranio2.setEditor(formatanio2);

        //Primera introducción de lo anterior en la interfaz
        Ventana.add(labeldia1);
        labeldia1.setBounds(50, 80, 50, 20);
        Ventana.add(spinnerdia1);
        spinnerdia1.setBounds(75, 80, 50, 20);
        Ventana.add(labelmes1);
        labelmes1.setBounds(130, 80, 50, 20);
        Ventana.add(spinnermes1);
        spinnermes1.setBounds(160, 80, 50, 20);
        Ventana.add(labelanio1);
        labelanio1.setBounds(215, 80, 50, 20);
        Ventana.add(spinneranio1);
        spinneranio1.setBounds(245, 80, 50, 20);
        Ventana.add(panel);

        //Segunda introducción de lo anterior en la interfaz
        Ventana.add(labeldia2);
        labeldia2.setBounds(350, 80, 50, 20);
        Ventana.add(spinnerdia2);
        spinnerdia2.setBounds(375, 80, 50, 20);
        Ventana.add(labelmes2);
        labelmes2.setBounds(430, 80, 50, 20);
        Ventana.add(spinnermes2);
        spinnermes2.setBounds(460, 80, 50, 20);
        Ventana.add(labelanio2);
        labelanio2.setBounds(515, 80, 50, 20);
        Ventana.add(spinneranio2);
        spinneranio2.setBounds(545, 80, 50, 20);
        Ventana.add(panel);

        //Botón Confirmar fechas
        Boton1 = new JButton("Confirmar fechas");
        Boton1.setBounds(100, 200, 150, 30);
        Boton1.addActionListener(this::actionPerformed);
        Ventana.add(Boton1);

        //Primera área de texto
        Texto1 = new JTextArea();
        Texto1.setBounds(280, 165, 350,100);
        Ventana.add(Texto1);

        //Botones Radio
        Colectivo = new JLabel("Colectivo");
        Colectivo.setBounds(50, 250, 350,100);
        Ventana.add(Colectivo);
        JRadioButton Rboton1=new JRadioButton("Benjam\u00edn",true);
        Rboton1.setBounds(50, 315, 100,15);
        Ventana.add(Rboton1);
        JRadioButton Rboton2=new JRadioButton("Infantil",false);
        Rboton2.setBounds(50, 335, 100,15);
        Ventana.add(Rboton2);
        JRadioButton Rboton3=new JRadioButton("Adulto",false);
        Rboton3.setBounds(50, 355, 100,15);
        Ventana.add(Rboton3);
        JRadioButton Rboton4=new JRadioButton("Senior",false);
        Rboton4.setBounds(50, 375, 100,15);
        Ventana.add(Rboton4);
        JRadioButton Rboton5=new JRadioButton("Senior Plus",false);
        Rboton5.setBounds(50, 395, 100,15);
        Ventana.add(Rboton5);
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(Rboton1);
        grupo1.add(Rboton2);
        grupo1.add(Rboton3);
        grupo1.add(Rboton4);
        grupo1.add(Rboton5);

        //Checkboxs
        Particularidad = new JLabel("Particularidad");
        Particularidad.setBounds(240, 292, 350,10);
        Ventana.add(Particularidad);
        JCheckBox Check1=new JCheckBox("Discapacitado");
        Check1.setBounds(240, 315, 100,15);
        Ventana.add(Check1);
        JCheckBox Check2=new JCheckBox("Familia Numerosa");
        Check2.setBounds(240, 340, 100,15);
        Ventana.add(Check2);

        //Botón Confirmar Datos
        Boton2 = new JButton("Confirmar fechas");
        Boton2.setBounds(240, 370, 150, 20);
        Boton2.addActionListener(this::actionPerformed);
        Ventana.add(Boton2);

        //Imágenes
        Recomendacion = new JLabel("Recomendaci\u00f3n");
        Recomendacion.setBounds(410, 292, 350,10);
        Ventana.add(Recomendacion);

        //Parte visible del programa
        Ventana.setTitle("Nevada Sierra S.A.");
        Ventana.setSize(600, 250);
        Ventana.setLayout(null);
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("pinguino.jpg");
        Ventana.setIconImage(icono);
        Ventana.setBounds(0, 0, 790, 505);
        Ventana.setDefaultCloseOperation(3);
        Ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == Boton1){
        } else if (e.getSource() == Boton2){
            Ventana.setIconImage(new ImageIcon("imagenforfait").getImage());
        }
    }
}
