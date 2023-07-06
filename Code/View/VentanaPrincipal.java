package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import Controller.ControladorTamagotchi;


public class VentanaPrincipal extends JFrame implements ActionListener {

    JPanel panelInfo, panelAnima, panelAccion;
    JLabel titulo, nivel, hambre, iHambre, suciedad, iSuciedad, sueno, iSueno, entrenamiento, iEntrenamiento;
    JButton comer, dormir, entrenar, banar, volver;
    Timer timer, timer1;
    Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
    int colorIndex = 0;
    Color comparacion, ColorFondo, ColorFuente;

    
    ControladorTamagotchi controlador;
    VentanaInicio ventana;
    int a;

  
    
    public VentanaPrincipal() {
        Principal();
    
    }


    public void Principal() {
        
        ColorFondo = new Color(183, 184, 184);// 242, 239, 244
        ColorFuente = new Color(59, 59, 76);
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

        add(panelInfo);
        panelInfo.add(titulo);
        panelInfo.add(hambre);
        panelInfo.add(suciedad);
        panelInfo.add(sueno);
        panelInfo.add(entrenamiento);

        // Propiedades del panel 2
        panelAnima = new JPanel();
        panelAnima.setBounds(0, 155, 400, 315);
        panelAnima.setLayout(null);
        panelAnima.setBackground(Color.black);

        ImageIcon gifIcon = new ImageIcon(
                "C:\\Users\\santi\\OneDrive\\Documentos\\Proyectos Programacion\\Tamagotchi\\Recursos\\Assets\\Saludo.gif");
        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setBounds(0, 0, 400, 300);

        add(panelAnima);
        panelAnima.add(gifLabel);

        // Propiedades del panel 3
        panelAccion = new JPanel();
        panelAccion.setBounds(0, 470, 400, 210);
        panelAccion.setLayout(null);
        panelAccion.setBackground(ColorFondo);

        comer = new JButton("Comer");
        comer.setBounds(60, 20, 90, 30);
        comer.addActionListener(this);
        comer.setFont(new Font("Arial", Font.BOLD, 15));
        comer.setForeground(ColorFuente);

        dormir = new JButton("Dormir");
        dormir.setBounds(240, 20, 90, 30);
        dormir.addActionListener(this);
        dormir.setFont(new Font("Arial", Font.BOLD, 15));
        dormir.setForeground(ColorFuente);

        banar = new JButton("Bañar");
        banar.setBounds(60, 65, 90, 30);
        banar.addActionListener(this);
        banar.setFont(new Font("Arial", Font.BOLD, 15));
        banar.setForeground(ColorFuente);

        entrenar = new JButton("Entrenar");
        entrenar.setBounds(230, 65, 110, 30);
        entrenar.addActionListener(this);
        entrenar.setFont(new Font("Arial", Font.BOLD, 16));
        entrenar.setForeground(ColorFuente);

        volver = new JButton("Volver");
        volver.setBounds(140, 120, 110, 30);
        volver.addActionListener(this);
        volver.setFont(new Font("Arial", Font.BOLD, 16));
        volver.setForeground(ColorFuente);

        add(panelAccion);
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

        setSize(400, 680);
        setTitle("Tamagochi");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        System.out.println(a);
    }

    private Color getNextColor() {
        Color color = colors[colorIndex];
        colorIndex = (colorIndex + 1) % colors.length;
        return color;
    }
    

    public void mostrarGifNivel(String name) {
        controlador = new ControladorTamagotchi();
        
        //Codigo 

    } 

    public void MensajeMalaAtencion(String gif){
        System.out.println("\nOye cuidado con tu animal animal, se esta muriendo de " + gif+"\n");
    }

    public void actionPerformed(ActionEvent e) {
        JButton pb = (JButton) e.getSource();
        if (pb == comer) {
            panelAnima.removeAll();
            ImageIcon gifIcon = new ImageIcon(
                    "C:\\Users\\santi\\OneDrive\\Documentos\\Proyectos Programacion\\Tamagotchi\\Recursos\\Assets\\Comer.gif");
            JLabel gifLabel = new JLabel(gifIcon);
            gifLabel.setBounds(0, 0, 400, 300);
            panelAnima.add(gifLabel);
            panelAnima.repaint();
        } else if (pb == dormir) {
            panelAnima.removeAll();
            ImageIcon gifIcon = new ImageIcon(
                    "C:\\Users\\santi\\OneDrive\\Documentos\\Proyectos Programacion\\Tamagotchi\\Recursos\\Assets\\Dormir.gif");
            JLabel gifLabel = new JLabel(gifIcon);
            gifLabel.setBounds(0, 0, 400, 300);
            panelAnima.add(gifLabel);
            panelAnima.repaint();
        } else if (pb == entrenar) {
            panelAnima.removeAll();
            ImageIcon gifIcon = new ImageIcon(
                    "C:\\Users\\santi\\OneDrive\\Documentos\\Proyectos Programacion\\Tamagotchi\\Recursos\\Assets\\Entrenar.gif");
            JLabel gifLabel = new JLabel(gifIcon);
            gifLabel.setBounds(0, 0, 400, 300);
            panelAnima.add(gifLabel);
            panelAnima.repaint();
        } else if (pb == banar) {
            panelAnima.removeAll();
            ImageIcon gifIcon = new ImageIcon(
                    "C:\\Users\\santi\\OneDrive\\Documentos\\Proyectos Programacion\\Tamagotchi\\Recursos\\Assets\\Sucio.gif");
            JLabel gifLabel = new JLabel(gifIcon);
            gifLabel.setBounds(0, 0, 400, 300);
            panelAnima.add(gifLabel);
            panelAnima.repaint();
        } else if (pb == volver) {
            panelAnima.removeAll();
            ImageIcon gifIcon = new ImageIcon(
                "C:\\Users\\santi\\OneDrive\\Documentos\\Proyectos Programacion\\Tamagotchi\\Recursos\\Assets\\Saludo.gif");
            JLabel gifLabel = new JLabel(gifIcon);
            gifLabel.setBounds(0, 0, 400, 300);
            panelAnima.add(gifLabel);
            panelAnima.repaint();
            setVisible(false);
                   
        }
    }
    

    



}



