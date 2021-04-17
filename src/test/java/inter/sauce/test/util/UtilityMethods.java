package inter.sauce.test.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {


    public static void checkIfPageLoaded(WebDriver driver, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try{
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (TimeoutException ex){
            throw new TimeoutException("Test is failed while waiting for the page to load this URL -> " + driver.getCurrentUrl());
        }
    }

    public static boolean waitForPresence(WebDriver driver, String xPath) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
            return true;
        } catch (TimeoutException ex) {
            // Capturing the exception to just return failure;
            return false;
        }
    }

    public static boolean waitForPresenceThrowsException(WebDriver driver, By locator) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(locator));
        return true;
    }

}
