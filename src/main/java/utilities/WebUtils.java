package utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {

    protected static final int WEB_DRIVER_WAIT_DURATION = Integer.parseInt("60");
    protected static final int PAGE_LOADING_TIMEOUT = Integer.parseInt("120");

    public static WebDriver driver() {
        return WebDriverManager.getDriver();
    }

    public static JavascriptExecutor js() {
        return (JavascriptExecutor) driver();
    }

    public WebElement waitTillElementIsVisible(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver(), WEB_DRIVER_WAIT_DURATION);
        wait.until(ExpectedConditions.visibilityOf(e));
        return e;
    }

    public void enterText(WebElement e, String text, boolean clear) {
        e = waitTillElementIsClickable(e);
        if (clear) {
            e.clear();
        }
        e.sendKeys(text);
    }

    public WebElement waitTillElementIsClickable(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver(), WEB_DRIVER_WAIT_DURATION);
        wait.until(ExpectedConditions.elementToBeClickable(e));
        return e;
    }

    public void pause(final int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (final InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public static void waitUntilPageIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver(), PAGE_LOADING_TIMEOUT);
        wait.until(driver ->
                js().executeScript("return document.readyState").equals("complete"));
    }
}
