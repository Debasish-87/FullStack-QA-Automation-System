package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    static Properties prop = new Properties();

    public static void load(){
        try {
            FileInputStream fis = new FileInputStream("config/config.properties");
            prop.load(fis);
        }
        catch (IOException e) {
            System.out.println("config file load Failed" + e.getMessage());
        }
    }

    public static String get(String key){
        return prop.getProperty(key);
    }

}
