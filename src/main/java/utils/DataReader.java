package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataReader {
    public static String getValue(String key) {
        String value = null;
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/testData.properties");
            property.load(fis);

            value = property.getProperty(key);

        } catch (IOException e) {
            System.err.println(e + "property file does not exist!");
        }
        return value;
    }
}
