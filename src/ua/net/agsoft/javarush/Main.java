package ua.net.agsoft.javarush;

import ua.net.agsoft.javarush.crypto.Crypto;

import java.nio.file.Path;

public class Main {

    // @formatter:off
    private static final String BAD_COMMAND = "BAD command. Possible options: ENCRYPT, DECRYPT or BRUTE_FORCE";

    private static final String BAD_ARGUMENTS =
            "Please use the following command-line format:\n" +
            "command filePath [key] \n" +
            "command - a required argument that specifies the action. [ENCRYPT | DECRYPT | BRUTE_FORCE]\n " +
            "filePath - a required argument representing the absolute path to the file.\n" +
            "key - a required argument for the ENCRYPT and DECRYPT commands, integer — alphabetic offset.";
    // @formatter:on




    public static void main(String[] args) {

        ProcessingOptions po = new ProcessingOptions();

        // TODO: !!! Возможно передать управление другому классу который вернет аргументы для дальнейшей работы
        if (!controlArguments(args, po)) {
            System.out.println(BAD_ARGUMENTS);
            // TODO: !!! Возможно стоит попросить пользователя ввести аргументы руками если в командной строке бардак
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
        if (args.length < 2 || args.length > 3) return false;

        po.setCommand(Command.fromCode(args[0]));
        po.setFilePath(Path.of(args[1]));
        if (args.length == 3) po.setKey(args[2]);
        System.out.println(po);

        return po.isValidOptions();
    }

    private static void encryptFile(ProcessingOptions po) {
        Path filepath = po.getFilePath();
        int offset = po.getOffset();
        // TODO: реализовать алгоритм шифрования текста в документе


    }

    private static void decryptFile(ProcessingOptions po) {
        Path filepath = po.getFilePath();
        int offset = po.getOffset();
        // TODO: реализовать алгоритм расшифровки текста в документе


    }

    private static void bruteForceFile(ProcessingOptions po) {
        Path filepath = po.getFilePath();

        Crypto crypto = new Crypto();
        crypto.setOffset(0);

        // TODO: реализовать алгоритм побора ключа для расшифровки текста
        // TODO: возможно выдать несколько вариантов ключей
        // TODO: или сохранять какждый условноправильный текст
        do {






        } while (!isValidText() && crypto.canSetNextOffset());




    }

    private static boolean isValidText() {
        // TODO: Тут необходимо организовать поиск популярных слов в тексте. Если находит, то считать что текст валидный
        // TODO: на гуглдиске топ 100 слов в языке. использовать их для анализа результата


        return true;
    }
}
