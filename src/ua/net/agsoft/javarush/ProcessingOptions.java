package ua.net.agsoft.javarush;

import ua.net.agsoft.javarush.util.Util;

import java.nio.file.Path;

public class ProcessingOptions {

    private static final String BAD_FILE_PATH = "BAD file path. Ensure the file exists";

    private Command command;
    private Path filePath;
    private String key;
    private int offset;


    //--------------------------------------------------------------------------------
    //                            *** constructor ***
    //--------------------------------------------------------------------------------

    public ProcessingOptions() {
        this.offset = 0;
    }

    //--------------------------------------------------------------------------------
    //                              *** static ***
    //--------------------------------------------------------------------------------


    //--------------------------------------------------------------------------------
    //                             *** non-static ***
    //--------------------------------------------------------------------------------

    public Command getCommand() {
        return command;
    }

    public int getOffset() {
        return offset;
    }

    public Path getFilePath() {
        return filePath;
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

    public String toString() {
        return String.format("{%s \"%s\" %d}", command.toString(), filePath, offset);
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
