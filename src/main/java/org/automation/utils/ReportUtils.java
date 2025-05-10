package org.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Utility class for handling Extent Reports.
 * Demonstrates OOP principles: Encapsulation (static methods), Utility pattern.
 */
public class ReportUtils {
    private static ExtentReports extent;

    static {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        LoggerUtil.info("Extent Reports initialized");
    }

    /**
     * Create a new ExtentTest for a given test name.
     *
     * @param testName The name of the test.
     * @return The ExtentTest instance.
     */
    public static ExtentTest createTest(String testName) {
        return extent.createTest(testName);
    }

    /**
     * Flush the Extent Reports to save the report.
     */
    public static void flush() {
        extent.flush();
        LoggerUtil.info("Extent Reports flushed");
    }
}
