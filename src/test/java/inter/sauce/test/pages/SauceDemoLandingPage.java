package inter.sauce.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import inter.sauce.test.util.UtilityMethods;

public class SauceDemoLandingPage {
    WebDriver driver;

    private static By userNameField() {
        return By.id("user-name");
    }

    private static By passwordField() {
        return By.id("password");
    }

    private static By loginButton() {
        return By.id("login-button");
    }


    public SauceDemoLandingPage(WebDriver driver) {
        this.driver = driver;
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Landing Page title Verification");
    }

    public void performLogin() {
        if(UtilityMethods.waitForPresenceThrowsException(driver, userNameField())){
            driver.findElement(userNameField()).sendKeys("standard_user");
        }
        driver.findElement(passwordField()).sendKeys("secret_sauce");
        driver.findElement(loginButton()).click();
        UtilityMethods.checkIfPageLoaded(driver, 10);
    }
}
