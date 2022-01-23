package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriver driver;

    public static WebDriver setDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                ChromeOptions cOptions = new ChromeOptions()
                        .addArguments("--start-maximized")
                        .addArguments("--incognito");
                driver = new ChromeDriver(cOptions);
                break;

            case "chrome-headless":
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions()
                        .addArguments("--window-size=1920,1080")
                        .addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;

        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        return driver;
    }

    public static void tearDown() {
        driver.quit();
        driver = null;
    }

    public static WebDriver getDriver() {
        String browser = System.getProperty("browser");
        if (driver == null) driver = setDriver(browser);
        return driver;
    }
}

