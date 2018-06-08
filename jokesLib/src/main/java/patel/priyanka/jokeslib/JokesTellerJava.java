package patel.priyanka.jokeslib;

import java.util.Random;

public class JokesTellerJava {

    private final static String[] JOKES_ARRAY = new String[]
            {
                    "1. This is a test joke",
                    "2. Another test joke",
                    "3. Well this isn't funny anymore",
                    "4. Are you ever gonna stop?",
                    "5. Seriously don't care about this"
            };

    public static String moreJokes() {
        Random random = new Random();
        return JOKES_ARRAY[random.nextInt(JOKES_ARRAY.length)];
    }
}
