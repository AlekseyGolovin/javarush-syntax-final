package ua.net.agsoft.javarush;

import java.io.File;
import java.nio.file.Path;

public class Util {

    protected static boolean isFileExists(Path filepath) {
        // TODO: Проверить что файл доступен и вернуть результат
        // TODO: Возможно для файла реализовать отдельный класс который будет работат с файлом и заодно проверять его наличие
        File file = filepath.toFile();

        if (file.exists() && file.isFile()) {
            return true;
        } else {
            return false;
        }
    }

    protected static int tryToInt(String str) {
        // TODO: попробовать преобразовать в int. если ошибка вернуть 0 иначе результат преобразования


        return 0;
    }

    protected static boolean isInt(String str) {
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
