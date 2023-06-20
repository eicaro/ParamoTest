package utils;

import java.util.Random;
//Class used to generate random times in order to simulate human behaviour so the captcha does not show
public abstract class Sleeper {
    private static final int MIN_SECONDS = 1;
    private static final int MAX_SECONDS = 5;
    private static final Random RANDOM = new Random();

    public static void waitRandomInterval() {
        int randomSeconds = RANDOM.nextInt(MAX_SECONDS - MIN_SECONDS + 1) + MIN_SECONDS;
        try {
            System.out.println("Sleeping for " + randomSeconds);
            Thread.sleep(randomSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

