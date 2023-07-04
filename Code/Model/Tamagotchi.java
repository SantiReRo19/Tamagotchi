package Model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tamagotchi implements Runnable {

    private int hambre;
    private int felicidad;
    private int suciedad;
    private int energia;
    private int nivel;

    public Tamagotchi() {
        hambre = 100;
        felicidad = 100;
        suciedad = 100;
        energia = 100;
        nivel = 1;
    }

    boolean activate = true;
    boolean alimentando = false;

    @Override
    public void run() {
        while (true) {
            if(!alimentando) {
            clearScreen();
            mostrarEstado();
            comprobarEstadosBajos();
            /* 
            switch (nivel) {
                case 1:
                    tamagotchiNormal();
                    break;
                case 2:
                    tamagotchiComiendo();
                    System.out.println("Hola");
                    break;
                case 3:
                    tamagotchiDurmiendo();
                    break;
                case 4:
                    tamagotchiJugando();
                    break;
                case 5:
                    tamagotchiSucio();
                    break;
            }
            */
            tamagotchiNormal1();

            hambre -= 2;
            felicidad -= 1;
            suciedad -= 1;
            energia -= 3;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen();
            mostrarEstado();
            comprobarEstadosBajos();
            tamagotchiNormal2();

            hambre -= 2;
            felicidad -= 1;
            suciedad -= 1;
            energia -= 3;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }}
    }

    public void alimentar() {
        //activate = false;
        alimentando =true;
        hambre += 20;
        felicidad += 10;
        suciedad += 5;
        energia += 5;
        clearScreen();
        mostrarEstado();
        comprobarEstadosBajos();
        comprobarEstadosAltos();
        tamagotchiComiendo();
        //activate = true;

        try {
            Thread.sleep(2000); // Detener el hilo durante 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alimentando = false;
        
        
    }

    public void entrenar() {
        hambre += 10;
        felicidad += 15;
        suciedad += 5;
        energia -= 2;
        comprobarEstadosAltos();
        tamagotchiJugando();
    }

    public void banar() {
        hambre += 5;
        felicidad += 5;
        suciedad += 10;
        energia += 5;
        comprobarEstadosAltos();
        tamagotchiSucio();
    }

    public void dormir() {
        hambre += 10;
        felicidad += 10;
        suciedad += 5;
        energia += 30;
        comprobarEstadosAltos();
        tamagotchiDurmiendo();
    }

    private void comprobarEstadosBajos() {
        if (hambre < 20) {
            System.out.println("¡El Tamagotchi tiene mucha hambre!");
        }
        if (felicidad < 20) {
            System.out.println("¡El Tamagotchi está muy triste!");
        }
        if (suciedad < 20) {
            System.out.println("¡El Tamagotchi está muy sucio!");
        }
        if (energia < 20) {
            System.out.println("¡El Tamagotchi está agotado!");
        }
    }

    private void comprobarEstadosAltos() {
        if (hambre > 100 ) {
            hambre = 100;
        }if(hambre < 0) {
            hambre = 0;
        }
        if (felicidad > 100) {
            felicidad = 100;
        }if(felicidad < 0) {
            felicidad = 0;
        }
        if (suciedad > 100) {
            suciedad = 100;
        }if(suciedad < 0) {
            suciedad = 0;
        }
        if (energia > 100) {
            energia = 100;
        }if(energia < 0) {
            energia = 0;
        }
    }

    private void mostrarEstado() {
        System.out.println("Estado del Tamagotchi:");
        System.out.println("Nivel: " + nivel);
        System.out.println("Hambre: " + hambre);
        System.out.println("Felicidad: " + felicidad);
        System.out.println("Suciedad: " + suciedad);
        System.out.println("Energía: " + energia);
        System.out.println("------------------------");
    }

    public void tamagotchiNormal1() {
        System.out.println("  /\\_/\\");
        System.out.println(" ( o.o )");
        System.out.println("  > ^ <");
    }
    public void tamagotchiNormal2() {
        System.out.println("  /\\_/\\");
        System.out.println(" ( -.- )");
        System.out.println("  > ^ <");
    }

    public void tamagotchiComiendo() {
        System.out.println("  /\\_/\\");
        System.out.println(" ( -o- )");
        System.out.println("  >   <_/0");
        System.out.println("¡El Tamagotchi está comiendo!");
    }

    public void tamagotchiDurmiendo() {
        System.out.println("  /\\_/\\");
        System.out.println(" ( -.- )");
        System.out.println("  > ^ <");
        System.out.println("¡El Tamagotchi está durmiendo!");
    }

    public void tamagotchiJugando() {
        System.out.println("  /\\_/\\");
        System.out.println(" ( ^◡^ )");
        System.out.println("  > ^ <");
        System.out.println("¡El Tamagotchi está jugando!");
    }

    public void tamagotchiSucio() {
        System.out.println("  /\\_/\\");
        System.out.println(" ( @.@ )");
        System.out.println("  > ^ <");
        System.out.println("¡El Tamagotchi está sucio!");
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi();
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
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
