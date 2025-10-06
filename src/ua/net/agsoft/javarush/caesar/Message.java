package ua.net.agsoft.javarush.caesar;

public class Message {

    // @formatter:off
    public static final String BAD_COMMAND = "BAD command. Possible options: ENCRYPT, DECRYPT or BRUTE_FORCE";

    public static final String BAD_ARGUMENTS =
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


}
