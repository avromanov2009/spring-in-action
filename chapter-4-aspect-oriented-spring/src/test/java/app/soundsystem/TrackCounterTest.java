package app.soundsystem;

import app.config.TrackCounterConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {

    @Autowired
    private TrackCounter trackCounter;

    @Autowired
    private CompactDisc cd;

    @Test
    public void testTrackCounter() {
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(2);
        cd.playTrack(5);
        cd.playTrack(5);
        cd.playTrack(5);

        assertEquals(1, trackCounter.getPlayCount(1));
        assertEquals(2, trackCounter.getPlayCount(2));
        assertEquals(0, trackCounter.getPlayCount(3));
        assertEquals(0, trackCounter.getPlayCount(4));
        assertEquals(3, trackCounter.getPlayCount(5));
    }
}
