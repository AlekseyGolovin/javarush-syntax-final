package ua.net.agsoft.javarush;

import java.nio.file.Path;

public class Util {

    protected static boolean isFileExists(Path filepath) {
        // TODO: Проверить что файл доступен и вернуть результат
        // TODO: Возможно для файла реализовать отдельный класс который будет работат с файлом и заодно проверять его наличие
        return Files.isRegularFile(filepath);
    }

    protected static int tryToInt(String key) {
        // TODO: попробовать преобразовать в int. если ошибка вернуть 0 иначе результат преобразования
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    protected static boolean isInt(String key) {
        // TODO: попробовать преобразовать в int. если ошибка вернуть false
        try {
            return true
        } catch (NumberFormatException ex) {
            return false;
        }
    }


}
