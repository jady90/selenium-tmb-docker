package com.tmb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class Demo {
    private static Logger log = LoggerFactory.getLogger(Demo.class);
    private static Properties properties;
    public static void main(String[] args) {

        String path = "config/default.properties";
        properties = getProperties();
        System.setProperty("selenium.grid.enabled", "true");
        System.setProperty("selenium.grid.hubHost", "10.56.98.09");
        Set<String> keys =properties.stringPropertyNames();
        for(String key : keys){
            if(System.getProperties().containsKey(key)){
                properties.setProperty(key, System.getProperty(key));
            }
        }
        properties.forEach((k, v) -> System.out.println(k + "=" + v));
        System.out.println(properties.getProperty("selenium.grid.hubHost"));
    }


    private static void initialize(){

    }

    public static Properties getProperties(){
        Properties properties = new Properties();
        try(InputStream stream = ResourceLoader.getResource("config/default.properties")){
            properties.load(stream);
        }catch (Exception e){
            log.error("unable to load properties file {}", properties, e);
        }
        return properties;
    }
}
