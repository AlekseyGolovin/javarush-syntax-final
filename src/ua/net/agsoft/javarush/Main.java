package ua.net.agsoft.javarush;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        String command;
        Path filepath;
        String key;

        if (args.length < 3) {
            return;
        } else {
            command = args[0];
            filepath = Path.of(args[1]);
            key = args[2];
        }

        System.out.println("command: " + command);
        System.out.println("filepath: " + filepath);
        System.out.println("key: " + key);

        switch (command) {
            case "ENCRYPT" -> encryptFile(filepath, key);
            case "DECRYPT" -> decryptFile(filepath, key);
            case "BRUTE_FORCE" -> bruteForceFile(filepath, key);
            default -> System.out.println("BAD command. Possible options: ENCRYPT, DECRYPT or BRUTE_FORCE");
        }
    }

    private static void encryptFile(Path filepath, String key) {

    }

    private static void decryptFile(Path filepath, String key) {

    }

    private static void bruteForceFile(Path filepath, String key) {

    }
}
