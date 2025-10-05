package ua.net.agsoft.javarush.crypto;

import java.nio.file.Path;

public class CryptoFile {

    public static void encryptFile(Path filepath, Path resultFilePath, Crypto crypto) {

        // TODO: реализовать алгоритм шифрования текста в документе

        // Подключиться к двум файлам

        // получить в буфер часть данных



        // Отправить на криптование


        // отправить буфер в результирующий файл













    }

    public static void decryptFile(Path filepath, Path resultFilePath, Crypto crypto) {

        // TODO: реализовать алгоритм расшифровки текста в документе

        // Подклчиться к двум файлам

        // получить в буфер часть данных



        // Отправить на криптование


        // отправить буфер в результирующий файл













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
