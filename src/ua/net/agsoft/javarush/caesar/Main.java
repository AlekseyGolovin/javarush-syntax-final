package ua.net.agsoft.javarush.caesar;

import ua.net.agsoft.javarush.crypto.Crypto;
import ua.net.agsoft.javarush.crypto.CryptoAlphabetType;
import ua.net.agsoft.javarush.crypto.CryptoFile;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        RunSettings runSettings = new RunSettings();
        SettingsController settingsController = new SettingsController();
        if (!settingsController.control(args, runSettings)) {
            System.out.println(Message.BAD_ARGUMENTS);
            return;
        }

        Runner runner = new Runner(runSettings);
        runner.run();
    }
}
