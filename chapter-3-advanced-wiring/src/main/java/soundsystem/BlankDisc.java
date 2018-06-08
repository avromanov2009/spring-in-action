package soundsystem;

import org.springframework.beans.factory.annotation.Value;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    public BlankDisc(@Value("${disc.title}") String title, @Value("${disc.artist}") String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}