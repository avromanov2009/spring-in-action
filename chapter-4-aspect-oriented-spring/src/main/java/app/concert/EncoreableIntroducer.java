package app.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "app.concert.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}