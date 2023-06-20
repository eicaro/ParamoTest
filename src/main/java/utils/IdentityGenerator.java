package utils;
import java.util.Random;
//Class to generate random data for creating records
public abstract class IdentityGenerator {
    private static final String[] CHARACTERS = {"abcdefghijklmnopqrstuvwxyz", "123456789"};
    private static final int USERNAME_LENGTH = 10;
    private static final int NUMBER_LENGTH  = 8;

    public static String generateRandomGmail() {
        String username = generateRandomString(USERNAME_LENGTH);
        String domain = "gmail.com";
        return username + "@" + domain;
    }

    public static String generateRandomNumber() {
        String codeArea = "+598";
        return codeArea + generateRandomNumber(NUMBER_LENGTH);
    }
    private static String generateRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        String characters = CHARACTERS[0] + CHARACTERS[1];

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }
    private static String generateRandomNumber(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        String characters = CHARACTERS[1]; // Use only numbers for generating random number

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }
}
