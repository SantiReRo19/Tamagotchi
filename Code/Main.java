import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Controller.ControladorTamagotchi;
import Model.Autoguardado;
import Model.Tamagotchi;
import View.VentanaInicio;

public class Main  {
    
    public static void main(String[] args) {

        new VentanaInicio();
        

        /* 
        //new VentanaInicio();
        ControladorTamagotchi controlador = new ControladorTamagotchi();
    	Tamagotchi tamagotchi = new Tamagotchi();
    	
    	String nombreArchivo = controlador.getPartida1();

    	Autoguardado autoguardado = new Autoguardado(tamagotchi); 
    
        tamagotchi = autoguardado.cargarEstado(nombreArchivo);
        autoguardado = new Autoguardado(tamagotchi);
        //autoguardado.start();
        
        Thread tamagotchiThread = new Thread(tamagotchi);
        tamagotchiThread.start();
        
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String input = reader.readLine();
                if (input.equalsIgnoreCase("a")) {
                    tamagotchi.alimentar();
                } else if (input.equalsIgnoreCase("e")) {
                    tamagotchi.entrenar();
                } else if (input.equalsIgnoreCase("b")) {
                    tamagotchi.banar();
                } else if (input.equalsIgnoreCase("d")) {
                    tamagotchi.dormir();
                }else {
                	tamagotchi.guardarEstado(nombreArchivo);
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        */
    }
}

