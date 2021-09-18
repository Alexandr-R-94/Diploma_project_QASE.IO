package core;

import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ReadProperties {
    private static ReadProperties instance;
     static Properties properties;
    private File file;
    private ClassLoader classLoader;



    public ReadProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }

    public String getURL() {
        return properties.getProperty("url");
    }
    public String getBrowserName() {
        return properties.getProperty("browser");
    }
    public boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public String getToken() {
        return properties.getProperty("token"); }
    public String getApiURL() {
        return properties.getProperty("api_url"); }

    public int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

//    public String pathFile() {
//        file = new File(Objects.requireNonNull(classLoader.getResource("TestRail_TestCase.xml")).getFile());
//
//        String absolutePath = file.getAbsolutePath();
//        System.out.println(absolutePath);
//        return absolutePath;
//    }



}


