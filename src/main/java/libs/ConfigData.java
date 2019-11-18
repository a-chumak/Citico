package libs;

/*
 *  That class provides static methods for getting values from Config and UI mapping files
 */

import org.junit.jupiter.api.Assertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ConfigData {

    public static String cfgFile = "src/config.properties";    //class variable added (path to the file)

    /*
     * Return value from .properties file
     */
    public static String getValueFromFile(String key, String fileName) {

        Properties p = new Properties(); //The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream. Each key and its corresponding value in the property list is a string.

        // Create stream for reading from file
        FileInputStream cfg = null; //A FileInputStream obtains input bytes
        try {
            cfg = new FileInputStream(fileName);
            p.load(cfg);
            cfg.close();
        } catch (FileNotFoundException e) {
            Assertions.fail("File not found exception");
        } catch (IOException e) {
            Assertions.fail("IO exception");
        }
        // from a file in a file system. FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
        // Load Properties from input stream

        // Return value for the property
        String propertyValue = "";
        try {
            propertyValue = new String(p.getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }

    /*
     * Return value from config file. Note, please, that returned value is
     * String. We should take care of value's type by himself when will use
     * config data value in the test.
     */
    public static String getValue(String key) {
        //class variable added (path to the file)
        return (getValueFromFile(key, cfgFile));
    }

}
