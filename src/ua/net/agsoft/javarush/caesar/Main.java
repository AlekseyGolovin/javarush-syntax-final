package ua.net.agsoft.javarush.caesar;

import ua.net.agsoft.javarush.crypto.Crypto;
import ua.net.agsoft.javarush.crypto.CryptoAlphabetType;
import ua.net.agsoft.javarush.crypto.CryptoFile;

import java.nio.file.Path;

public class Main {

    // @formatter:off
    private static final String BAD_COMMAND = "BAD command. Possible options: ENCRYPT, DECRYPT or BRUTE_FORCE";

    private static final String BAD_ARGUMENTS =
            "Please use the following command-line format:\n" +
            "command filePath [key] [alphabet]\n" +
            "command - a required argument that specifies the action. [ENCRYPT | DECRYPT | BRUTE_FORCE]\n" +
            "filePath - a required argument representing the absolute path to the file.\n" +
            "key - a required argument for the ENCRYPT and DECRYPT commands, integer — alphabetic offset.\n" +
            "alphabet - a list of characters for encryption/decryption. " +
            "[EN_BASIC | EN_ADVANCED | LATIN | CYRIL | LATIN_MIX | CYRIL_MIX]\n" +
            "EN_BASIC - Basic Latin Alphabet. Only lowercase and uppercase Latin letters.\n" +
            "EN_ADVANCED - Extended Latin Alphabet. Basic Latin alphabet plus common punctuation and space.\n" +
            "LATIN - Full Latin Set. Includes digits, Latin letters, and a complete set of ASCII special characters.\n" +
            "CYRIL - Full Cyrillic Set. Includes everything from LATIN plus all Cyrillic letters\n" +
            "LATIN_MIX - Mixed Latin Key. Same characters as LATIN, but randomly shuffled.\n" +
            "CYRIL_MIX - Mixed Cyrillic Key: Same characters as CYRIL, but randomly shuffled.";
    // @formatter:on

    public static void main(String[] args) {

        ProcessingOptions po = new ProcessingOptions();
        if (!controlArguments(args, po)) {
            System.out.println(BAD_ARGUMENTS);
            return;
        }

        switch (po.getCommand()) {
            case ENCRYPT -> encryptFile(po);
            case DECRYPT -> decryptFile(po);
            case BRUTE_FORCE -> bruteForceFile(po);
            case BAD_COMMAND -> System.out.println(BAD_COMMAND);
        }
    }

    private static boolean controlArguments(String[] args, ProcessingOptions po) {
        // TODO: !!! Возможно передать управление другому классу который вернет аргументы для дальнейшей работы
        // TODO: !!! Возможно стоит попросить пользователя ввести аргументы руками если в командной строке бардак
        if (args.length < 2 || args.length > 4) return false;
        po.setCommand(Command.fromCode(args[0]));
        po.setFilePath(Path.of(args[1]));
        if (args.length >= 3) po.setKey(args[2]);
        if (args.length >= 4) po.setAlphabetType(args[3]);
        System.out.println(po);
        return po.isValidOptions();
    }

    private static void encryptFile(ProcessingOptions po) {
        Path filepath = po.getFilePath();
        int offset = po.getOffset();
        CryptoAlphabetType alphabetType = po.getAlphabetType();
        Path resultFilePath = getResultFilePath(filepath, Command.ENCRYPT);
        Crypto crypto = new Crypto(alphabetType);
        crypto.setOffset(offset);
        CryptoFile.encryptFile(filepath, resultFilePath, crypto);
    }

    private static void decryptFile(ProcessingOptions po) {
        Path filepath = po.getFilePath();
        int offset = po.getOffset();
        CryptoAlphabetType alphabetType = po.getAlphabetType();
        Path resultFilePath = getResultFilePath(filepath, Command.DECRYPT);
        Crypto crypto = new Crypto(alphabetType);
        crypto.setOffset(offset);
        CryptoFile.decryptFile(filepath, resultFilePath, crypto);
    }

    private static void bruteForceFile(ProcessingOptions po) {
        Path filepath = po.getFilePath();
        CryptoAlphabetType alphabetType = po.getAlphabetType();
        Crypto crypto = new Crypto(alphabetType);
        int offset = CryptoFile.getCryptoOffset(filepath, crypto);
        ProcessingOptions poForDecrypt = new ProcessingOptions();
        poForDecrypt.setCommand(Command.DECRYPT);
        poForDecrypt.setFilePath(filepath);
        poForDecrypt.setOffset(offset);
        poForDecrypt.setAlphabetType(alphabetType);
        decryptFile(poForDecrypt);
    }

    private static Path getResultFilePath(Path filepath, Command command) {
        String added = "DECRYPTED";
        if (command == Command.ENCRYPT) added = "ENCRYPTED";
        String fileName = filepath.getFileName().toString();
        Path directory = filepath.getParent();
        int pointPos = fileName.lastIndexOf(".");
        String resultFileExt = fileName.substring(pointPos);
        String resultFileName = fileName.substring(0, pointPos) + "[" + added + "]" + resultFileExt;
        return directory.resolve(resultFileName);
    }
}
