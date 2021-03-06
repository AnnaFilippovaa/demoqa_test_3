package filippova.anna.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import filippova.anna.config.CredentialsConfig;
import filippova.anna.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void setUp() {
//        Configuration.holdBrowserOpen = true;
       SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String browser = System.getProperty("browser","chrome");
        String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        String browserSize = System.getProperty("browserSize", "1920x1980");
        String remote = System.getProperty("remote", "@selenoid.autotests.cloud/wd/hub");
        String login = config.login();
        String password = config.password();

        Configuration.browser = browser;
        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = browserSize;
        Configuration.remote = "https://" + login + ":" + password + remote;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

}
