package config;

import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static PropertiesConfiguration config;

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

    private void loadConfig(){
        try{
            String path = System.getProperty("user.dir") + "/src/main/resources/config/Configuration.properties";
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            config = new PropertiesConfiguration();
            config.load(fis);
            fis.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
