package Controller;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ControladorTamagotchi {
    // --------------------------------
    // Obtén la ruta absoluta del proyecto
    Path projectPath = Paths.get("").toAbsolutePath();

    // Concatena la ruta relativa del archivo
    Path saludoGif = projectPath.resolve("Recursos/Assets/Saludo.gif");
    Path comerGif = projectPath.resolve("Recursos/Assets/Comer.gif");
    Path dormirGif = projectPath.resolve("Recursos/Assets/Dormir.gif");
    Path banarGif = projectPath.resolve("Recursos/Assets/Sucio.gif");
    Path entrenarGif = projectPath.resolve("Recursos/Assets/Entrenar.gif");

            
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
        }

        return gif;

    }
    
    
    
}
