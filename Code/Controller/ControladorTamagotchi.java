package Controller;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JLabel;

import View.VentanaInicio;

public class ControladorTamagotchi implements Serializable {

    VentanaInicio ventanaInicio;
    public ControladorTamagotchi(){
        
    }

    public ControladorTamagotchi(VentanaInicio ventana){
        this.ventanaInicio = ventana;
    }
    // --------------------------------
    // Obtén la ruta absoluta del proyecto
    public transient Path projectPath = Paths.get("").toAbsolutePath();

    // Concatena la ruta relativa del archivo
    public transient Path saludoGif = projectPath.resolve("Recursos/Assets/Saludo.gif");
    public transient Path comerGif = projectPath.resolve("Recursos/Assets/Comer.gif");
    public transient Path dormirGif = projectPath.resolve("Recursos/Assets/Dormir.gif");
    public transient Path banarGif = projectPath.resolve("Recursos/Assets/Sucio.gif");
    public transient Path entrenarGif = projectPath.resolve("Recursos/Assets/Entrenar.gif");
    public transient Path muertoGif = projectPath.resolve("Recursos/partidas/Muerto.gif");

    public transient Path partida1 = projectPath.resolve("Recursos/partidas/partida1.bin");
    public transient Path partida2 = projectPath.resolve("Recursos/partidas/partida2.bin");
    

    
            
    

    public String getGIF(String a){
        String gif ="";

        if(a == "saludo"){
            gif = saludoGif.toString();
        }else if(a == "comer"){
            gif = comerGif.toString();
        }else if(a == "dormir"){
            gif = dormirGif.toString();
        }else if(a == "banar"){
            gif = banarGif.toString();
        }else if(a == "entrenar"){
            gif = entrenarGif.toString();
        }else if(a == "morir"){
            gif = muertoGif.toString();
            Morir(gif);
        }

        return gif;

    }

    public String getPartida1() {
        return partida1.toString();
    }

    public String getPartida2(){
        return partida2.toString();
    }


    int hambre, felicidad, suciedad, energia,nivel;

    public void setEnergia(int energia) {
        this.energia = energia;
        ventanaInicio.setiSueno(String.valueOf(energia));
        
    }

    public void setSuciedad(int suciedad) {
        this.suciedad = suciedad;
        ventanaInicio.setiSuciedad(String.valueOf(suciedad));
    }

    public void setFelicidad(int felicidad) {
        this.felicidad = felicidad;
        ventanaInicio.setiEntrenamiento(String.valueOf(felicidad));
    }

    public void setHambre(int hambre) {
       this.hambre = hambre;
    ventanaInicio.setiHambre(String.valueOf(hambre));
        
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
        ventanaInicio.setNivel(String.valueOf(nivel));
    }

    public void Morir(String a){
        ventanaInicio.muerto(a);
    }
    
    
    
    
    

}
