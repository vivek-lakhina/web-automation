package org.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Centralized logging utility using Log4j2.
 * <p>
 * Demonstrates OOP principles: Encapsulation (private static logger), Utility pattern.
 */
public class LoggerUtil {
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    /**
     * Log an info message.
     *
     * @param message The message to log.
     */
    public static void info(String message) {
        logger.info(message);
    }

    /**
     * Log an error message with throwable.
     *
     * @param message The message to log.
     * @param t       The throwable to log.
     */
    public static void error(String message, Throwable t) {
        logger.error(message, t);
    }

    /**
     * Log a debug message.
     *
     * @param message The message to log.
     */
    public static void debug(String message) {
        logger.debug(message);
    }
}
