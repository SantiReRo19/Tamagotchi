package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class VentanaInicio extends JFrame implements ActionListener {

    //JFrame VentanaP = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    private int contadorlistener = 0;

    JButton bjugar = new JButton("Jugar");
    VentanaPrincipal ventanaPri;
    public VentanaInicio cara;

   
        
        public void inicio(){
        setTitle("Tamagotchi");
        setVisible(true);
        setSize(500, 580);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        // panel superior
        panel1.setBounds(0, 0, 500, 70);
        panel1.setBackground(new java.awt.Color(242, 239, 244));
        panel1.setLayout(null);
        add(panel1);
        // panel central
        panel2.setBounds(0, 70, 500, 413);
        panel2.setBackground(new java.awt.Color(249, 243, 255));
        panel2.setLayout(null);
        ImageIcon gifIncial = new ImageIcon(
                "C:\\Users\\santi\\OneDrive\\Documentos\\Proyectos Programacion\\Tamagotchi\\Recursos\\Assets\\Saludo.gif");
        JLabel giflabelInicial = new JLabel(gifIncial);
        giflabelInicial.setBounds(0, 0, 498, 413);
        panel2.add(giflabelInicial);
        add(panel2);

        // panel inferiror
        panel3.setBounds(0, 463, 500, 80);
        panel3.setBackground(new java.awt.Color(242, 239, 244));
        panel3.setLayout(null);
        add(panel3);
        
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

    public void actionPerformed(ActionEvent e) {
        
        JButton bPress = (JButton) e.getSource();
        if (bPress==bjugar){
            //setVisible(false);
            if (ventanaPri == null) {
                System.out.println("Cosa vacia");
                ventanaPri = new VentanaPrincipal();
            }
            ventanaPri.setVisible(true);
            
            
            if(contadorlistener > 0 ){
                System.out.println("llegamos al contador >0");
                // Muestra la ventana B
            }
            else if(contadorlistener == 0){
                
                System.out.println("hello papu");
                contadorlistener++;
            }
            
        }
    
    }
    public VentanaInicio(){
        inicio();
        
    }

    public void MostrarInicio(){
        setVisible(true);
    }
    
}

