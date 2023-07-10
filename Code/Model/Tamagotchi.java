package Model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

import Controller.ControladorTamagotchi;
import View.VentanaInicio;


public class Tamagotchi implements Runnable, Serializable {
    //ControladorTamagotchi controlador;
    private Tamagotchi tamagotchi;
    ControladorTamagotchi controlador;
    protected int hambre;
    protected int felicidad;
    protected int suciedad;
    protected int energia;
    protected int nivel;
    private int cant_BuenaAtencion;

    public Tamagotchi() {
        hambre = 0;
        felicidad = 100;
        suciedad = 0;
        energia = 100;
        nivel = 1;
        cant_BuenaAtencion = 0;
    }

    public Tamagotchi(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    public Tamagotchi(ControladorTamagotchi controladorcito) {
        this.controlador = controladorcito;
        hambre = 0;
        felicidad = 100;
        suciedad = 0;
        energia = 100;
        nivel = 1;
        cant_BuenaAtencion = 0;
    }


    boolean ActivacionRun = true;
    //Hilo que ejecura el ciclo de desgaste del tamagotchi en base de 2 segundos
    @Override
    public void run() {
        
        while (ActivacionRun) {

            limitarRango(hambre);
            AdvMalaAtencion();
            
            if(nivel < 10 ){SubirNivel();}
            
            hambre += 2;
            felicidad -= 1;
            suciedad += 1;
            energia -= 3;

            hambre = limitarRango(hambre);
            felicidad = limitarRango(felicidad); 
            suciedad = limitarRango(suciedad);
            energia = limitarRango(energia);

            System.out.println(hambre + " " + felicidad + " "
             + suciedad + " " + energia + " " );
             
            controlador.setEnergia(energia);
            controlador.setFelicidad(felicidad);
            controlador.setSuciedad(suciedad);
            controlador.setHambre(hambre);

            vidaTamagotchi();

            try {
                Thread.sleep(1000);//Cada 2 segundos ejecuta el run
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        try {
                Thread.sleep(3000);//Cada 3 segundos ejecuta el ciclo para evitar que el hilo termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
    }

    //Metodos que realizan las Actividades del Tamagotchi, alteran sus variables 
    //y evita que sobre pasen el umbral determinado de 0 a 100
    public void alimentar() {
        System.out.println("Alimente");
        ActivacionRun = true;//Revivir al Tamagotchi(PARA PRUEBAS)
        hambre -= 20;
        felicidad += 5;
        suciedad += 5;
        energia -= 5;
        limitarRango(hambre);
        limitarRango(felicidad);
        limitarRango(suciedad); 
        limitarRango(energia);
        cant_BuenaAtencion += 1;

    }

    public void entrenar() {
        hambre += 5;
        felicidad += 15;
        suciedad += 1;
        energia -= 8;
        hambre = limitarRango(hambre);
        felicidad = limitarRango(felicidad); 
        suciedad = limitarRango(suciedad);
        energia = limitarRango(energia);
        cant_BuenaAtencion += 1;
       
    }

    public void banar() {
        
        felicidad += 8;
        suciedad -= 15;
        energia += 1;
        hambre = limitarRango(hambre);
        felicidad = limitarRango(felicidad); 
        suciedad = limitarRango(suciedad);
        energia = limitarRango(energia);
        cant_BuenaAtencion += 1;
    }

    public void dormir() {
        hambre += 2;
        felicidad += 10;
        energia += 20;
        hambre = limitarRango(hambre);
        felicidad = limitarRango(felicidad); 
        suciedad = limitarRango(suciedad);
        energia = limitarRango(energia);
        cant_BuenaAtencion += 1;
        
    }

    //Metodo que le avisa al modelo que hay una Advertencia de Mala Atención
    //Y la muestre en la ventana
    private void AdvMalaAtencion() {
        if (hambre > 80) {
            JOptionPane.showMessageDialog(null,"EL TAMAGOTCHI TIENE HAMBRE");
        }
        if (felicidad < 20) {
            JOptionPane.showMessageDialog(null,"EL TAMAGOTCHI TIENE FELICIDAD");
        }
        if (suciedad > 80 && suciedad <83 ) {
            JOptionPane.showMessageDialog(null,"EL TAMAGOTCHI ESTA SUCIO");
        }
        if (energia > 18 && energia < 21) {
            JOptionPane.showMessageDialog(null,"EL TAMAGOTCHI ESTA CANSADO");
        }
    }


    //Metodo que limita el rango de los valores de los atributos(hambre, suciedad, felicidad, sueño)
    public static int limitarRango(int valor) {
        if (valor<0) {
            return valor = 0;}
        if (valor>100) {
            return valor = 100;}
        else{return valor;}
        
    }

    //Metodo que calcula si el tamagotchi está vivo, si no lo está detiene el Hilo
    public void vidaTamagotchi() {
        if(hambre == 100 || felicidad == 0 || suciedad == 100 || energia == 0) {
            System.out.println("\n¡El Tamagotchi ha muerto!");
            JOptionPane.showMessageDialog(null,"EL TAMAGOTCHI ESTA MUERTOOOOOO");
            //controlador.getGIF("morir");
            ActivacionRun = false;
        }
    }

    public void SubirNivel() {
        //controlador = new ControladorTamagotchi();
        controlador.setNivel(nivel);
        if(cant_BuenaAtencion == 10) { 
            nivel += 1;
            cant_BuenaAtencion = 0;
            JOptionPane.showMessageDialog(null,"El Tamagotchi subio al nivel: " + nivel);
            System.out.println("\nEl Tamagotchi ha subido el nivel " + nivel);
            //Codigo que llama al controlador para que muestre el nuevo tamagotchi
            controlador.setNivel(nivel);
            //controlador.metodoControlador(gif);
    
            if(nivel == 10) {
                System.out.println("\n***El Tamagotchi ha alcanzado el maximo nivel ***");
            }
        }
    }

    public void guardarEstado(String archivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(archivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Estado del Tamagotchi guardado en " + archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void IniciarTamagotchi(Tamagotchi tamagotchi, Thread tamagotchiThread, ControladorTamagotchi controlador,VentanaInicio ventanita) {
        
        //Autoguardado autoguardado = new Autoguardado(tamagotchi);
        //autoguardado.start();
        
        new VentanaInicio(tamagotchi,tamagotchiThread,controlador,ventanita);
        
    }

    
    

    public int getHambre() {
    	return hambre;
    }
    public int getFelicidad() {
    	return felicidad;
    }
    public int getSuciedad() {
    	return suciedad;
    }
    public int getEnergia() {
    	return energia;
    }
    public void setActivacionRun(boolean activacionRun) {
        ActivacionRun = activacionRun;
    }
}


