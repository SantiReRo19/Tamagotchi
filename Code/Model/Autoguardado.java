package Model;
import java.io.Serializable;
import Controller.ControladorTamagotchi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Autoguardado extends Thread implements Serializable {
    Tamagotchi tamagotchi ;
    ControladorTamagotchi controlador = new ControladorTamagotchi();

    private static final int INTERVALO_GUARDADO = 30 * 1000;
    private String nombreArchivo = controlador.getPartida1();

    @Override
    public void run() {
        while (true) {
            try {
                // Lógica para guardar las variables en el archivo.bin
                guardarEstado(nombreArchivo);

                // Esperar el intervalo de tiempo antes del próximo autoguardado
                Thread.sleep(INTERVALO_GUARDADO);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Autoguardado(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }
    

    public void guardarEstado(String archivo) {
        //tamagotchi = new Tamagotchi(tamagotchi);
        try {
            System.out.println("Estado del Tamagotchi guardado");
            System.out.println("\nHambre: " + tamagotchi.getHambre());
            System.out.println("Felicidad: " + tamagotchi.getFelicidad());
            System.out.println("Suciedad: " + tamagotchi.getSuciedad());
            System.out.println("Energia: " + tamagotchi.getEnergia());
            System.out.println("");

            FileOutputStream fileOut = new FileOutputStream(archivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tamagotchi);
            out.close();
            fileOut.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Tamagotchi cargarEstado(String archivo) {
        
        try {
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Tamagotchi tamagotchi = (Tamagotchi) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Estado del Tamagotchi cargado desde ");
            System.out.println("Hambre: " + tamagotchi.getHambre());
            System.out.println("Felicidad: " + tamagotchi.getFelicidad());
            System.out.println("Suciedad: " + tamagotchi.getSuciedad());
            System.out.println("Energia: " + tamagotchi.getEnergia());
            return tamagotchi;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}


