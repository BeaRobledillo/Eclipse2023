package interfaces;

public class Audio implements Playable{

    @Override
    public void play() {
        System.out.println("Reproduciendo audio");
    }

    @Override
    public void stop() {
        System.out.println("Parando audio");
    }
}
