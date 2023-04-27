package interfaces;

public class Main {

	public static void main(String[] args) {
		Audio audio = new Audio();
		Video video = new Video();
		MediaPlayer mediaPlayer = new MediaPlayer();

		mediaPlayer.setMedia(audio);
		mediaPlayer.relampago();

		mediaPlayer.setMedia(video);
		mediaPlayer.relampago();

	}

}
