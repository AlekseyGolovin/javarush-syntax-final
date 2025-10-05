package ua.net.agsoft.javarush.caesar;

import ua.net.agsoft.javarush.crypto.CryptoAlphabetType;
import ua.net.agsoft.javarush.util.Util;

import java.nio.file.Path;

public class ProcessingOptions {

    private static final String BAD_FILE_PATH = "BAD file path. Ensure the file exists";

    private Command command;
    private Path filePath;
    private String key;
    private int offset;
    private CryptoAlphabetType alphabetType;

    public ProcessingOptions() {
        offset = 0;
        alphabetType = CryptoAlphabetType.EN_BASIC;
    }

    public Command getCommand() {
        return command;
    }

    public int getOffset() {
        return offset;
    }

    public Path getFilePath() {
        return filePath;
    }

    public CryptoAlphabetType getAlphabetType() {
        return alphabetType;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public void setKey(String key) {
        this.key = key;
        offset = Util.tryToInt(key);
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setAlphabetType(CryptoAlphabetType alphabetType) {
        this.alphabetType = alphabetType;
    }

    public void setAlphabetType(String alphabetTypeString) {
        switch (alphabetTypeString){
            case "EN_ADVANCED" :
                setAlphabetType(CryptoAlphabetType.EN_ADVANCED);
                break;
            case "LATIN" :
                setAlphabetType(CryptoAlphabetType.LATIN);
                break;
            case "CYRIL" :
                setAlphabetType(CryptoAlphabetType.CYRIL);
                break;
            case "LATIN_MIX" :
                setAlphabetType(CryptoAlphabetType.LATIN_MIX);
                break;
            case "CYRIL_MIX" :
                setAlphabetType(CryptoAlphabetType.CYRIL_MIX);
                break;
            case "EN_BASIC" :
            default :
                setAlphabetType(CryptoAlphabetType.EN_BASIC);
        }
    }

    public String toString() {
        return String.format("{%s \"%s\" %d %s}", command.toString(), filePath, offset, alphabetType);
    }

    private boolean isValidCommand() {
        return (command != Command.BAD_COMMAND);
    }

    private boolean isValidFilePath() {
        if (Util.isFileExists(filePath)) {
            return true;
        } else {
            System.out.println(BAD_FILE_PATH);
            return false;
        }
    }

    public boolean isValidOptions() {
        if(!isValidCommand()) return false;
        if(!isValidFilePath()) return false;
        if ((command == Command.ENCRYPT || command == Command.DECRYPT) && !Util.isInteger(key)) {
            return false;
        }
        return true;
    }
}
