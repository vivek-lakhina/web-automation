package org.automation.base;

import com.aventstack.extentreports.ExtentTest;
import org.automation.utils.DriverFactory;
import org.automation.utils.LoggerUtil;
import org.automation.utils.ReportUtils;
import org.automation.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

/**
 * Base class for all test classes, handling setup/teardown and Extent Reports.
 * <p>
 * Demonstrates OOP principles: Inheritance (extends Object implicitly), Encapsulation (protected fields).
 */
public class BaseTest {
    protected WebDriver driver;
    protected ExtentTest test;

    /**
     * Initialize Extent Reports before the test suite.
     */
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        test = ReportUtils.createTest(getClass().getSimpleName());
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
    }

    /**
     * Flush Extent Reports after the test suite.
     */
    @AfterSuite
    public void tearDownReport() {
        ReportUtils.flush();
    }
}
