import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Model.Tamagotchi;
import View.VentanaInicio;

public class Main  {
    
    public static void main(String[] args) {

        new VentanaInicio();

    	/*Tamagotchi tamagotchi = new Tamagotchi();
    	
    	String nombreArchivo = "C:\\Users\\santi\\OneDrive\\Documentos\\Proyectos Programacion\\Tamagotchi\\Recursos\\partidas\\partida1.bin";
    
    	tamagotchi.cargarEstado(nombreArchivo);
        
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
        }*/
    }
}
