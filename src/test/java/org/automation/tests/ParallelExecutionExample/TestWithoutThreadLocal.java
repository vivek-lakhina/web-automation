package org.automation.tests.ParallelExecutionExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWithoutThreadLocal {
    private static WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
    }

    @Test
    public void testA() throws InterruptedException {
        driver.get("https://www.apple.com");
                System.out.println("Test A: " + driver.getTitle());
        System.out.println("Thread ID: " + Thread.currentThread().getId() + ", WebDriver HashCode: " + driver.hashCode());
        Thread.sleep(5000);
    }

    @Test
    public void testB() throws InterruptedException {
        driver.get("https://www.google.com");
                System.out.println("Test B: " + driver.getTitle());
        System.out.println("Thread ID: " + Thread.currentThread().getId() + ", WebDriver HashCode: " + driver.hashCode());
        Thread.sleep(5000);
    }

    @Test
    public void testC() throws InterruptedException {
        driver.get("https://www.amazon.com");
                System.out.println("Test C: " + driver.getTitle());
        System.out.println("Thread ID: " + Thread.currentThread().getId() + ", WebDriver HashCode: " + driver.hashCode());
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
