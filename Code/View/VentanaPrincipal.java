package View;
import Controller.ControladorTamagotchi;

public class VentanaPrincipal {
    ControladorTamagotchi controlador;

    public void mostrarGifNivel(String name) {
        controlador = new ControladorTamagotchi();
        
        //Codigo 

    } 

    public void MensajeMalaAtencion(String gif){
        System.out.println("\nOye cuidado con tu animal animal, se esta muriendo de " + gif+"\n");
    }

}
