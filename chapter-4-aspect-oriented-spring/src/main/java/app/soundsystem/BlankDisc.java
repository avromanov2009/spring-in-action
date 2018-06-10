package app.soundsystem;

import java.util.List;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    @Override
    public void playTrack(int trackNumber) {
        final String trackName = tracks.get(trackNumber - 1);
        System.out.println("Playing " + trackName + " by " + artist);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}