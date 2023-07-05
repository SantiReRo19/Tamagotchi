package Model;

public class Tamagotchi implements Runnable {

    protected int hambre;
    protected int felicidad;
    protected int suciedad;
    protected int energia;
    protected int nivel;

    public Tamagotchi() {
        hambre = 0;
        felicidad = 100;
        suciedad = 0;
        energia = 100;
        nivel = 1;
    }
    boolean ActivacionRun = true;
    //Hilo que ejecura el ciclo de desgaste del tamagotchi en base de 2 segundos
    @Override
    public void run() {
        while (true) { //While para que se ejecute el hilo indefinidamente(USADO PARA PRUEBA)
        System.out.println("Entre al ciclo");
        while (ActivacionRun) {

            limitarRango(hambre);
            AdvMalaAtencion();
            
            hambre += 2;
            felicidad -= 1;
            suciedad += 1;
            energia -= 3;

            hambre = limitarRango(hambre);
            felicidad = limitarRango(felicidad); 
            suciedad = limitarRango(suciedad);
            energia = limitarRango(energia);

            System.out.println(hambre + " " + felicidad + " " + suciedad + " " + energia + " " );

            vidaTamagotchi();

            try {
                Thread.sleep(2000);//Cada 2 segundos ejecuta el run
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
       
    }

    public void banar() {
        
        felicidad += 8;
        suciedad -= 15;
        energia += 1;
        hambre = limitarRango(hambre);
        felicidad = limitarRango(felicidad); 
        suciedad = limitarRango(suciedad);
        energia = limitarRango(energia);
    }

    public void dormir() {
        hambre += 2;
        felicidad += 10;
        energia += 20;
        hambre = limitarRango(hambre);
        felicidad = limitarRango(felicidad); 
        suciedad = limitarRango(suciedad);
        energia = limitarRango(energia);
        
    }

    //Metodo que Advertencia de Mala Atención
    private void AdvMalaAtencion() {
        if (hambre > 80) {
            System.out.println("¡El Tamagotchi tiene mucha hambre!");
        }
        if (felicidad < 20) {
            System.out.println("¡El Tamagotchi está muy triste!");
        }
        if (suciedad > 80) {
            System.out.println("¡El Tamagotchi está muy sucio!");
        }
        if (energia < 20) {
            System.out.println("¡El Tamagotchi está agotado!");
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
            ActivacionRun = false;
        }
    }
}
