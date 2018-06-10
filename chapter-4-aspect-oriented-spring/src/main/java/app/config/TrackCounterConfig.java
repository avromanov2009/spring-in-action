package app.config;

import app.soundsystem.BlankDisc;
import app.soundsystem.CompactDisc;
import app.soundsystem.TrackCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean(name = "cd")
    public CompactDisc sgtPeppers() {
        final BlankDisc cd = new BlankDisc();
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The Beatles");
        List<String> tracks = List.of("Sgt. Pepper's Lonely Hearts Club Band", "With a Little Help from My Friends",
                "Lucy in the Sky with Diamonds", "Getting Better", "Fixing a Hole");
        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
