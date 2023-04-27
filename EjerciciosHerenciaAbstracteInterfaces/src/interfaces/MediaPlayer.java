package interfaces;

public class MediaPlayer {
	 private Playable media;

	    public Playable getMedia() {
	        return media;
	    }

	    public void setMedia(Playable media) {
	        this.media = media;
	    }

	    public void relampago() {
	        if (media == null) {
	            System.out.println("No se ha establecido ningún objeto Playable");
	            return;
	        }
	        media.play();
	        media.stop();
	        media.play();
	        media.stop();
	    }
}
