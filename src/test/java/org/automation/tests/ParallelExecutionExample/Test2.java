package org.automation.tests.ParallelExecutionExample;

import org.automation.base.BaseTest;
import org.automation.utils.DriverFactory;
import org.testng.annotations.Test;

/**
 * Sample test class demonstrating flight booking automation on MakeMyTrip.
 * Demonstrates OOP principles: Inheritance (extends BaseTest), Encapsulation (private methods).
 */
public class Test2 extends BaseTest {
    @Test
    public void test1() throws InterruptedException {

        // Navigate to home page and perform search
        driver.get("http://www.amazon.com");
       Thread.sleep(10000);
        System.out.println("Thread ID: " + Thread.currentThread().getId() + ", WebDriver HashCode: " + DriverFactory.getDriver().hashCode());
    }
}
