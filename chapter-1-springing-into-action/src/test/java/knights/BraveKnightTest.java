package knights;

import org.junit.Test;
import org.mockito.Mockito;
import quests.Quest;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        final Quest mockQuest = Mockito.mock(Quest.class);
        final BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}