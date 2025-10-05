package ua.net.agsoft.javarush.crypto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CryptoFile {

    public static void encryptFile(Path srcFilePath, Path desFilePath, Crypto crypto) {
        try (BufferedReader srcReader = Files.newBufferedReader(srcFilePath);
             BufferedWriter desWriter = Files.newBufferedWriter(desFilePath)) {
            int srcInt;
            while ((srcInt = srcReader.read()) != -1) {
                char srcChar = (char) srcInt;
                char desChar = crypto.encrypt(srcChar);
                desWriter.append(desChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptFile(Path srcFilePath, Path desFilePath, Crypto crypto) {
        try (BufferedReader srcReader = Files.newBufferedReader(srcFilePath);
             BufferedWriter desWriter = Files.newBufferedWriter(desFilePath)) {
            int srcInt;
            while ((srcInt = srcReader.read()) != -1) {
                char srcChar = (char) srcInt;
                char desChar = crypto.decrypt(srcChar);
                desWriter.append(desChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getCryptoOffset(Path filepath, Crypto crypto) {

        crypto.setOffset(0);

        // TODO: реализовать алгоритм подбора ключа для расшифровки текста
        // TODO: !! ДЛя каждого смещения считать вероятность
        // TODO: возможно выдать несколько вариантов ключей
        // TODO: или сохранять какждый условноправильный текст
        do {
            // Получить часть файла для для подбора.
            // Выбрать смещение
            // Результат передать в алгоритм расшифровки
            //


        } while (!isValidText() && crypto.canSetNextOffset());

        return 0;
    }

    private static boolean isValidText() {
        // TODO: Тут необходимо организовать поиск популярных слов в тексте. Если находит, то считать что текст валидный
        // TODO: на гуглдиске топ 100 слов в языке. использовать их для анализа результата


        return true;
    }
}
