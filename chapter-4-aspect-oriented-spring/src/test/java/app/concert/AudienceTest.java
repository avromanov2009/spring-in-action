package app.concert;

import app.config.Config;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
@Ignore
public class AudienceTest {
    public static final String PERFORMANCE_LOG_MESSAGES = "\nSilencing mobile phones\n" +
            "Taking seats\n" +
            "Performance underway...\n" +
            "CLAP CLAP CLAP!!!\n" +
            "Encore!\n";
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private Performance performance;

    @Autowired
    private Audience audience;

    @Autowired
    private EncoreableIntroducer encoreableIntroducer;

    @Test
    public void should_OutputAspectMessages_When_PerformanceBegins() {
        log.clearLog();
        performance.perform();
        ((Encoreable) performance).performEncore();
        assertEquals("Aspect log messages were not received", PERFORMANCE_LOG_MESSAGES, log.getLog());
    }
}
