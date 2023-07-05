package Controller;
import Model.Tamagotchi;
import View.VentanaPrincipal;

public class ControladorTamagotchi {

    Tamagotchi tamagotchi = new Tamagotchi();
    VentanaPrincipal ventana = new VentanaPrincipal();

    public void metodoControlador(String gif){
        ventana.mostrarGifNivel(gif);
    }

    public void AdvMalaAtencion(String gif){
        ventana.MensajeMalaAtencion(gif);
    }
    
    
    
}
