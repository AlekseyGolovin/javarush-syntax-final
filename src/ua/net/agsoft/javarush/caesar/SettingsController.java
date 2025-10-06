package ua.net.agsoft.javarush.caesar;

import java.nio.file.Path;

public class SettingsController {

    public boolean control(String[] args, RunSettings runSettings) {

        if(controlArguments(args, runSettings)) return true;

        if (!requestManualInput()) return false;

        // Запросить команду

        // Запросить путь к файлу


        // если команда енкрипта или декрипта то запросить ключ


        // если подбор, то запросить файл ключевых слов


        // хотите указать алфавит





        return true;
    }

    private boolean controlArguments(String[] args, RunSettings runSettings) {
        if (args.length < 2 || args.length > 4) return false;
        runSettings.setCommand(Command.fromCode(args[0]));
        runSettings.setFilePath(Path.of(args[1]));
        if (args.length >= 3) {
            runSettings.setKey(args[2]);
            runSettings.setExternalWordlist(args[2]);
        }
        if (args.length >= 4) runSettings.setAlphabetType(args[3]);
        System.out.println(runSettings);
        return runSettings.isValidOptions();
    }

    private boolean requestManualInput() {



        return false;
    }


}
