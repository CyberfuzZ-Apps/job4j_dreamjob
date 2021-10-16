package ru.job4j.dream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Класс Config - хранит настройки из файла app.properties.
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class Config {

    private static final Properties PROPERTIES = new Properties();

    private static void init() throws IOException {
        try (InputStream in = Config.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            PROPERTIES.load(in);
        }
    }

    /**
     * Метод возвращает значение конфигурации из файла app.properties
     * соответствующее переданному ключу.
     *
     * @param key - ключ для значения в app.properties.
     * @return - String значение соответствующее ключу key.
     * @throws IOException - если файл app.properties не доступен.
     */
    public static String value(String key) throws IOException {
        init();
        return PROPERTIES.getProperty(key);
    }
}
