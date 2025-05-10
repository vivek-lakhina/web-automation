package org.automation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.automation.utils.DriverFactory;
import org.automation.utils.LoggerUtil;
import org.automation.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * Base class for all test classes, handling setup/teardown and Extent Reports.
 * <p>
 * Demonstrates OOP principles: Inheritance (extends Object implicitly), Encapsulation (protected fields).
 */
public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    /**
     * Initialize Extent Reports before the test suite.
     */
    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        LoggerUtil.info("Extent Reports initialized");
    }

    /**
     * Setup WebDriver before each test method.
     */
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        test = extent.createTest(getClass().getSimpleName());
        LoggerUtil.info("Test setup completed for: " + getClass().getSimpleName());
    }

    /**
     * Teardown WebDriver and capture screenshot on failure after each test method.
     *
     * @param result The TestNG test result.
     */
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = Utils.captureScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
            LoggerUtil.error("Test failed: " + result.getName(), result.getThrowable());
        }
        if (driver != null) {
            DriverFactory.quitDriver();
            LoggerUtil.info("Driver closed for test: " + getClass().getSimpleName());
        }
        extent.flush();
    }
}
