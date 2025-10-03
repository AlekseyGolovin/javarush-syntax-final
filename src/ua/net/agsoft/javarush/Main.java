package ua.net.agsoft.javarush;

import java.nio.file.Path;

public class Main {

    // @formatter:off
    private static final String BAD_COMMAND = "BAD command. Possible options: ENCRYPT, DECRYPT or BRUTE_FORCE";
    private static final String BAD_FILE_PATH = "BAD file path. Ensure the file exists";
    private static final String BAD_ARGUMENTS =
            "Please use the following command-line format:\n" +
            "command filePath [key] \n" +
            "command - a required argument that specifies the action. [ENCRYPT | DECRYPT | BRUTE_FORCE]\n " +
            "filePath - a required argument representing the absolute path to the file.\n" +
            "key - a required argument for the ENCRYPT and DECRYPT commands, integer — alphabetic offset.";
    // @formatter:on

    private static Command command;
    private static Path filepath;
    private static String key;
    private static int offset;



    public static void main(String[] args) {

        // TODO: !!! Возможно передать управление другому классу который вернет аргументы для дальнейшей работы
        if (!controlArguments(args)) {
            System.out.println(BAD_ARGUMENTS);
            // TODO: !!! Возможно стоит попросить пользователя ввести аргументы руками если в командной строке бардак
            return;
        }

        switch (command) {
            case ENCRYPT -> encryptFile(filepath, key);
            case DECRYPT -> decryptFile(filepath, key);
            case BRUTE_FORCE -> bruteForceFile(filepath, key);
            case BAD_COMMAND -> System.out.println(BAD_COMMAND);
        }
    }

    private static void printArguments() {
        System.out.println("command: " + command);
        System.out.println("filepath: " + filepath);
        System.out.println("key: " + key);
    }

    private static boolean controlArguments(String[] args) {
        if (args.length < 2 || args.length > 3)  return false;

        command = Command.fromCode(args[0]);
        filepath = Path.of(args[1]);
        if (args.length == 3) key = args[2];
        offset = Util.tryToInt(key);
        printArguments();

        if (command == Command.BAD_COMMAND) return false;

        if(!Util.isFileExists(filepath)) {
            System.out.println(BAD_FILE_PATH);
            return false;
        }

        if ((command == Command.ENCRYPT || command == Command.DECRYPT) && !Util.isInt(key)) return false;

        return true;
    }

    private static void encryptFile(Path filepath, String key) {
        // TODO: реализовать алгоритм шифрования текста в документе




    }

    private static void decryptFile(Path filepath, String key) {
        // TODO: реализовать алгоритм расшифровки текста в документе



    }

    private static void bruteForceFile(Path filepath, String key) {
        // TODO: реализовать алгоритм побора ключа для расшифровки текста
        // TODO: на гуглдиске топ 100 слов в языке. использовать их для подбора ключа




    }
}
