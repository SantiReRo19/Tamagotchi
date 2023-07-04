import Model.Tamagotchi;

public class Main {
    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi();
        Thread thread = new Thread(tamagotchi);
        thread.start();
    }
}
