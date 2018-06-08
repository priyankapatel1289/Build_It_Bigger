package patel.priyanka.jokeslib;

import java.util.Random;

public class JokesTellerJava {

    private final static String[] JOKES_ARRAY = new String[]
            {
                    "How does a phone get drunk?\n\nIt takes screenshots!",
                    "I wrote a song about a tortilla. Well.. actually, it's more of a wrap",
                    "What do you get when you wake up on a workday and realize you ran out of coffe?\n\nA depresso",
                    "Why are eggs not very much into Jokes?\n\nBecause they could crack up",
                    "What happens to a frog's car when it breaks down?\n\nIt gets toad away",
                    "If you ever get cold, stand in the corner of a room for a while... they're usually 90 degrees",
                    "What did the duck say when it bought lipstick?\n\n\"Put it on my bill\""
            };

    public static String moreJokes() {
        Random random = new Random();
        return JOKES_ARRAY[random.nextInt(JOKES_ARRAY.length)];
    }
}
