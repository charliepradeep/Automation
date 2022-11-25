package solo.charrlie;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Base {

    static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();;

    @Before
    public void setThreadLocalDriver() throws MalformedURLException {

        //System.setProperty("webdriver.chrome.driver","/Users/charrliepradeep/Documents/OldJAVA/SelenoidDemo/src/test/java/resources/chromedriver");
        FirefoxOptions chromeOptions = new FirefoxOptions();
        chromeOptions.setCapability("browserName", "firefox");
        chromeOptions.setCapability("browserVersion", "106.0");
        chromeOptions.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));;
        chromeOptions.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions);
        threadLocalDriver.set(driver);
    }

    static public WebDriver getDriver()
    {
        return threadLocalDriver.get();
    }

    @After
    public void closeDriver()
    {
        threadLocalDriver.get().close();
        threadLocalDriver.remove();
    }

}
