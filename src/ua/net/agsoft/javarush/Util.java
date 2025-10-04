package ua.net.agsoft.javarush;

import java.nio.file.Path;

public class Util {

    protected static boolean isFileExists(Path filepath) {
        // TODO: Проверить что файл доступен и вернуть результат
        // TODO: Возможно для файла реализовать отдельный класс который будет работат с файлом и заодно проверять его наличие
        return Files.isRegularFile(filepath);
    }

    protected static int tryToInt(String str) {
        // TODO: попробовать преобразовать в int. если ошибка вернуть 0 иначе результат преобразования
        if (str == null || str.isEmpty()) {
            return 0;
        }
        try {
            int res = Integer.parseInt(str);
            return res;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    protected static boolean isInteger(String str) {
        // TODO: попробовать преобразовать в int. если ошибка вернуть false
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
