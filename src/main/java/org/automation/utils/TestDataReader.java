package org.automation.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Utility to read test data from JSON file.
 * <p>
 * Demonstrates OOP principles: Encapsulation (private static mapper), Utility pattern.
 */
public class TestDataReader {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Read test data from JSON file.
     *
     * @param testCaseId The ID of the test case.
     * @return A map containing the test data.
     */
    public static Map<String, Object> getTestData(String testCaseId) {
        try {
            Map<String, Map<String, Object>> data = mapper.readValue(TestDataReader.class.getClassLoader().getResourceAsStream("testdata/testdata.json"), Map.class);
            LoggerUtil.info("Loaded test data for test case: " + testCaseId);
            return data.get(testCaseId);
        } catch (IOException e) {
            LoggerUtil.error("Failed to read test data", e);
            throw new RuntimeException("Failed to read test data", e);
        }
    }
}
