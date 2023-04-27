package interfaces;

public class Video implements Playable {
	@Override
    public void play() {
        System.out.println("Reproduciendo video");
    }

    @Override
    public void stop() {
        System.out.println("Parando video");
    }

}
