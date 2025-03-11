package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    // Static block to load properties only once
    static {
        try {
            String path = System.getProperty("user.dir") + "/src/main/resources/config/Configuration.properties";
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found: " + e.getMessage());
        }
    }

    // Method to get property values
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
