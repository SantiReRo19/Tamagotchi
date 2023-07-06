import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Model.Tamagotchi;

public class Main {
    
    public static void main(String[] args) {
    	Tamagotchi tamagotchi = new Tamagotchi();
    	
    	String nombreArchivo = "C:\\Users\\usuario\\OneDrive\\Escritorio\\Tamagotchi\\Recursos\\partida1.bin";
    
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
        }
       //tamagotchi.guardarEstado(nombreArchivo);

		
    }
}
