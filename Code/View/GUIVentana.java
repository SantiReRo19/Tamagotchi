package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIVentana extends JFrame implements ActionListener{

    JPanel panelInfo, panelAnima, panelAccion;
    JLabel titulo, nivel, hambre, iHambre, suciedad, iSuciedad, sueno, iSueno, entrenamiento, iEntrenamiento;
    JButton comer, dormir, entrenar, banar;

    public GUIVentana(){

        //Propiedades del panel 1
        panelInfo = new JPanel();
        panelInfo.setBounds(0,0,400,170);
        panelInfo.setLayout(null);
        panelInfo.setBackground(Color.gray);

        titulo = new JLabel("NIVEL ");
        titulo.setBounds(170, 10, 40, 30);  

        hambre = new JLabel("Hambre ");
        hambre.setBounds(70,45,80,20);

        suciedad = new JLabel("Suciedad ");
        suciedad.setBounds(70,95,80,20);

        sueno = new JLabel("Sueño ");
        sueno.setBounds(200,45,80,20);

        entrenamiento = new JLabel("Entrenamiento ");
        entrenamiento.setBounds(200,95,100,20);

        add(panelInfo);
        panelInfo.add(titulo);
        panelInfo.add(hambre);
        panelInfo.add(suciedad);
        panelInfo.add(sueno);
        panelInfo.add(entrenamiento);
        


        //Propiedades del panel 2
        panelAnima = new JPanel();
        panelAnima.setBounds(0,170,400,300);
        panelAnima.setLayout(null);
        panelAnima.setBackground(Color.CYAN);

        ImageIcon gifIcon = new ImageIcon("C:\\Users\\Usuario\\Documents\\Java\\Tamagotchi\\GIFS\\awesome.gif"); 
        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setBounds(0, 0, 400,300);

        add(panelAnima);
        panelAnima.add(gifLabel);


        //Propiedades del panel 3
        panelAccion = new JPanel();
        panelAccion.setBounds(0,470,400,160);
        panelAccion.setLayout(null);
        panelAccion.setBackground(Color.gray);
        
        comer=new JButton("Comer");
        comer.setBounds(60,20,90, 30);
        comer.addActionListener(this);

        dormir=new JButton("Dormir");
        dormir.setBounds(240,20,90,30);
        dormir.addActionListener(this);

        entrenar=new JButton("Entrenar");
        entrenar.setBounds(60,65,90, 30);
        entrenar.addActionListener(this);

        banar=new JButton("Bañar");
        banar.setBounds(240,65,90, 30);
        banar.addActionListener(this);
               
        add(panelAccion);
        panelAccion.add(comer);
        panelAccion.add(dormir);
        panelAccion.add(entrenar);
        panelAccion.add(banar);

        
        setSize(400, 630);
        setTitle("Tamagochi");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton pb = (JButton) e.getSource();
        if(pb==comer){
            System.out.println("Hola");
        }
    }

    public static void main(String[] args) {
        new GUIVentana();
    }
}
