package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.ControladorTamagotchi;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class VentanaInicio extends JFrame implements ActionListener {

    JFrame VentanaIni = new JFrame();
    JFrame VentanaTag = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    private int contadorlistener = 0;
    JPanel panelInfo, panelAnima, panelAccion;
    JLabel titulo, nivel, hambre, iHambre, suciedad, iSuciedad, sueno, iSueno, entrenamiento, iEntrenamiento;
    JButton comer, dormir, entrenar, banar, volver;
    Timer timer, timer1;
    Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
    int colorIndex = 0;
    Color comparacion, ColorFondo, ColorFuente, ColorFondo2, ColorBoton1;

    ControladorTamagotchi controlador;
    int a;

    JButton bjugar = new JButton("Jugar");
    public VentanaInicio cara;

    public VentanaInicio() {
        VentInicio();
    }

    public void VentInicio() {
        VentanaIni.setTitle("Tamagotchi");
        VentanaIni.setVisible(true);
        VentanaIni.setSize(500, 580);
        VentanaIni.setResizable(false);
        VentanaIni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VentanaIni.setLocationRelativeTo(null);
        VentanaIni.setLayout(null);
        // panel superior
        panel1.setBounds(0, 0, 500, 70);
        panel1.setBackground(new java.awt.Color(242, 239, 244));
        panel1.setLayout(null);
        VentanaIni.add(panel1);
        // panel central
        panel2.setBounds(0, 70, 500, 413);
        panel2.setBackground(new java.awt.Color(249, 243, 255));
        panel2.setLayout(null);
        ImageIcon gifIncial = new ImageIcon(
                "D:\\documentos\\Tercer semestre U\\Programaci\u00F3n\\Miniproyecto4\\Tamagotchi\\Recursos\\Assets\\Saludo.gif");
        JLabel giflabelInicial = new JLabel(gifIncial);
        giflabelInicial.setBounds(0, 0, 498, 413);
        panel2.add(giflabelInicial);
        VentanaIni.add(panel2);

        // panel inferiror
        panel3.setBounds(0, 463, 500, 80);
        panel3.setBackground(new java.awt.Color(242, 239, 244));
        panel3.setLayout(null);
        VentanaIni.add(panel3);

        bjugar.setLayout(null);
        bjugar.setBounds(183, 30, 100, 40);
        bjugar.setBackground(new java.awt.Color(235, 228, 240));
        bjugar.setForeground(new java.awt.Color(127, 70, 3));
        Font fuenteb1 = new Font("Arial", Font.BOLD, 15);
        bjugar.setFont(fuenteb1);
        bjugar.setLayout(new FlowLayout(FlowLayout.CENTER));
        bjugar.addActionListener(this);
        panel3.add(bjugar);

        JLabel bienvenida = new JLabel("Bienvenido");
        bienvenida.setBounds(165, 15, 500, 40);
        Font fuenteMensaje = new Font("Arial", Font.BOLD, 30);
        bienvenida.setFont(fuenteMensaje);
        bienvenida.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Cambiar el color del texto
        int delay = 1000; // milisegundos
        Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA };
        AtomicInteger index = new AtomicInteger(0);
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bienvenida.setForeground(colors[index.getAndIncrement() % colors.length]);
            }
        };

        new Timer(delay, taskPerformer).start();

        panel1.add(bienvenida);

    }

    public void VentPrincipal() {

        ColorFondo = new Color(252, 249, 221);// 242, 239, 244
        ColorFuente = new Color(59, 59, 76);
        ColorFondo2 = new Color(254, 245, 130);
        ColorBoton1 = new Color(233, 187, 55);
        // Propiedades del panel 1
        panelInfo = new JPanel();
        panelInfo.setBounds(0, 0, 400, 155);
        panelInfo.setLayout(null);
        panelInfo.setBackground(ColorFondo);

        titulo = new JLabel("NIVEL ");
        titulo.setBounds(140, 10, 140, 30);
        titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

        hambre = new JLabel("Hambre ");
        hambre.setBounds(70, 65, 100, 20);
        hambre.setFont(new Font("Trebuchet MS", Font.BOLD, 17));

        suciedad = new JLabel("Suciedad ");
        suciedad.setBounds(70, 105, 80, 20);
        suciedad.setFont(new Font("Trebuchet MS", Font.BOLD, 17));

        sueno = new JLabel("Sueño ");
        sueno.setBounds(230, 65, 80, 20);
        sueno.setFont(new Font("Trebuchet MS", Font.BOLD, 17));

        entrenamiento = new JLabel("Entrenamiento ");
        entrenamiento.setBounds(200, 105, 140, 20);
        entrenamiento.setFont(new Font("Trebuchet MS", Font.BOLD, 17));

        VentanaTag.add(panelInfo);
        panelInfo.add(titulo);
        panelInfo.add(hambre);
        panelInfo.add(suciedad);
        panelInfo.add(sueno);
        panelInfo.add(entrenamiento);

        // Propiedades del panel 2
        panelAnima = new JPanel();
        panelAnima.setBounds(0, 155, 400, 315);
        panelAnima.setLayout(null);
        panelAnima.setBackground(ColorFondo2);

        ImageIcon gifIcon = new ImageIcon(
                "D:\\documentos\\Tercer semestre U\\Programaci\u00F3n\\Miniproyecto4\\Tamagotchi\\Recursos\\Assets\\Saludo.gif");
        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setBounds(0, 0, 400, 300);

        VentanaTag.add(panelAnima);
        panelAnima.add(gifLabel);

        // Propiedades del panel 3
        panelAccion = new JPanel();
        panelAccion.setBounds(0, 470, 400, 210);
        panelAccion.setLayout(null);
        panelAccion.setBackground(ColorFondo);

        comer = new JButton("Comer");
        comer.setBounds(60, 20, 100, 30);
        comer.addActionListener(this);
        comer.setFont(new Font("Arial", Font.BOLD, 15));
        comer.setBackground(ColorBoton1);
        comer.setForeground(ColorFuente);
        comer.setFocusPainted(false);

        dormir = new JButton("Dormir");
        dormir.setBounds(230, 20, 100, 30);
        dormir.addActionListener(this);
        dormir.setFont(new Font("Arial", Font.BOLD, 15));
        dormir.setBackground(ColorBoton1);
        dormir.setForeground(ColorFuente);
        dormir.setFocusPainted(false);

        banar = new JButton("Bañar");
        banar.setBounds(60, 65, 100, 30);
        banar.addActionListener(this);
        banar.setFont(new Font("Arial", Font.BOLD, 15));
        banar.setBackground(ColorBoton1);
        banar.setForeground(ColorFuente);
        banar.setFocusPainted(false);

        entrenar = new JButton("Entrenar");
        entrenar.setBounds(230, 65, 100, 30);
        entrenar.addActionListener(this);
        entrenar.setFont(new Font("Arial", Font.BOLD, 16));
        entrenar.setBackground(ColorBoton1);
        entrenar.setForeground(ColorFuente);
        entrenar.setFocusPainted(false);

        volver = new JButton("Volver");
        volver.setBounds(140, 120, 100, 30);
        volver.addActionListener(this);
        volver.setFont(new Font("Arial", Font.BOLD, 16));
        volver.setBackground(ColorBoton1);
        volver.setForeground(ColorFuente);
        volver.setFocusPainted(false);

        VentanaTag.add(panelAccion);
        panelAccion.add(comer);
        panelAccion.add(dormir);
        panelAccion.add(entrenar);
        panelAccion.add(banar);
        panelAccion.add(volver);

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titulo.setForeground(getNextColor());
            }
        });
        timer.start();

        VentanaTag.setSize(400, 680);
        VentanaTag.setTitle("Tamagochi");
        VentanaTag.setLayout(null);
        VentanaTag.setLocationRelativeTo(null);
        VentanaTag.setVisible(true);

    }

    private Color getNextColor() {
        Color color = colors[colorIndex];
        colorIndex = (colorIndex + 1) % colors.length;
        return color;
    }

    public void mostrarGifNivel(String name) {
        controlador = new ControladorTamagotchi();

        // Codigo

    }

    public void MensajeMalaAtencion(String gif) {
        System.out.println("\nOye cuidado con tu animal animal, se esta muriendo de " + gif + "\n");
    }

    public void actionPerformed(ActionEvent e) {

        JButton bPress = (JButton) e.getSource();
        if (bPress == bjugar) {
            VentanaIni.setVisible(false);
            //acá

            if (contadorlistener > 0) {
                //acá se debe implementar la segunda partida
                int opcion = JOptionPane.showOptionDialog(
                null, // Componente padre (null para centrar en la pantalla)
                "Selecciona una opción:", // Mensaje del cuadro de diálogo
                "Partidas", // Título del cuadro de diálogo
                JOptionPane.YES_NO_CANCEL_OPTION, // Tipo de botones (si, No, Cancelar)
                JOptionPane.QUESTION_MESSAGE, // Tipo de mensaje (pregunta)
                null, // Icono personalizado (null para el icono predeterminado)
                new Object[]{"Nueva partida", "Cargar Partida", "Cancelar"}/*Texto de los botones */,"Si"/*Botón predeterminado */);
                System.out.println("llegamos al contador >0");
                VentanaTag.setVisible(true);
                // Comprobar la opción seleccionada
                if (opcion == JOptionPane.YES_OPTION) {
                    System.out.println("Se seleccionó nueva partida");
                    // Realizar las acciones
                } else if (opcion == JOptionPane.NO_OPTION) {
                    System.out.println("Se seleccionó cargar partida");
                    // Realizar las acciones
                } else if (opcion == JOptionPane.CANCEL_OPTION) {
                    System.out.println("Se seleccionó Cancelar");
                    // Realizar las acciones
                } else {
                    System.out.println("Se cerró el cuadro de diálogo sin seleccionar ninguna opción");
                    // Realizar acciones cuando se cierra el cuadro de diálogo sin seleccionar ninguna opción
                }
            } else if (contadorlistener == 0) {
                //primera partida
                VentPrincipal();
                System.out.println("hello papu");
                contadorlistener++;
            }

        } else if (bPress == comer) {
            panelAnima.removeAll();
            ImageIcon gifIcon = new ImageIcon(
                    "D:\\documentos\\Tercer semestre U\\Programaci\u00F3n\\Miniproyecto4\\Tamagotchi\\Recursos\\Assets\\Comer.gif");
            JLabel gifLabel = new JLabel(gifIcon);
            gifLabel.setBounds(0, 0, 400, 300);
            panelAnima.add(gifLabel);
            panelAnima.repaint();
        } else if (bPress == dormir) {
            panelAnima.removeAll();
            ImageIcon gifIcon = new ImageIcon(
                    "D:\\documentos\\Tercer semestre U\\Programaci\u00F3n\\Miniproyecto4\\Tamagotchi\\Recursos\\Assets\\Dormir.gif");
            JLabel gifLabel = new JLabel(gifIcon);
            gifLabel.setBounds(0, 0, 400, 300);
            panelAnima.add(gifLabel);
            panelAnima.repaint();
        } else if (bPress == entrenar) {
            panelAnima.removeAll();
            ImageIcon gifIcon = new ImageIcon(
                    "D:\\documentos\\Tercer semestre U\\Programaci\u00F3n\\Miniproyecto4\\Tamagotchi\\Recursos\\Assets\\Entrenar.gif");
            JLabel gifLabel = new JLabel(gifIcon);
            gifLabel.setBounds(0, 0, 400, 300);
            panelAnima.add(gifLabel);
            panelAnima.repaint();
        } else if (bPress == banar) {
            panelAnima.removeAll();
            ImageIcon gifIcon = new ImageIcon(
                    "D:\\documentos\\Tercer semestre U\\Programaci\u00F3n\\Miniproyecto4\\Tamagotchi\\Recursos\\Assets\\Sucio.gif");
            JLabel gifLabel = new JLabel(gifIcon);
            gifLabel.setBounds(0, 0, 400, 300);
            panelAnima.add(gifLabel);
            panelAnima.repaint();
        } else if (bPress == volver) {
            panelAnima.removeAll();
            ImageIcon gifIcon = new ImageIcon(
                    "D:\\documentos\\Tercer semestre U\\Programaci\u00F3n\\Miniproyecto4\\Tamagotchi\\Recursos\\Assets\\Saludo.gif");
            JLabel gifLabel = new JLabel(gifIcon);
            gifLabel.setBounds(0, 0, 400, 300);
            panelAnima.add(gifLabel);
            panelAnima.repaint();
            VentanaTag.setVisible(false);
            VentanaIni.setVisible(true);

        }

    }

}
