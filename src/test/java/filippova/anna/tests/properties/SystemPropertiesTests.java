package filippova.anna.tests.properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void someTest1() {
        String browser = System.getProperty("browser", "Chrome");
        String version = System.getProperty("version", "100");
        String browserSize = System.getProperty("browserSize", "1920x1980");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }
}
