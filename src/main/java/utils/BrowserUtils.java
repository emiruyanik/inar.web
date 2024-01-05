package utils;

import org.openqa.selenium.JavascriptExecutor;

public class BrowserUtils {

    public static void scrollVertically(int pixelAmount) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scroll(0," + pixelAmount + ")");
    }

    public static void scrollDown() {
        scrollVertically(1000);
    }

    public static void scrollUp() {
        scrollVertically(-1000);
    }
}
