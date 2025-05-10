package org.automation.config;

import org.automation.utils.LoggerUtil;
import java.io.IOException;
import java.util.Properties;

/**
 * Singleton class to load and manage configuration from properties file.
 * <p>
 * Demonstrates OOP principles: Encapsulation (private static field), Singleton pattern.
 */
public class ConfigurationManager {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(ConfigurationManager.class.getClassLoader()
                    .getResourceAsStream("config.properties"));
            LoggerUtil.info("Configuration loaded successfully");
        } catch (IOException e) {
            LoggerUtil.error("Failed to load configuration", e);
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    /**
     * Get property value by key.
     *
     * @param key The key of the property.
     * @return The value of the property.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}