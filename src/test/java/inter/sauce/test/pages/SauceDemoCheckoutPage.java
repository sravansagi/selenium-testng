package inter.sauce.test.pages;

import inter.sauce.test.util.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoCheckoutPage {
    WebDriver driver;

    private static By firstNameField() {
        return By.id("first-name");
    }

    private static By lastNameField() {
        return By.id("last-name");
    }

    private static By zipCodeField() {
        return By.id("postal-code");
    }

    private static By continueButton() {
        return By.id("continue");
    }

    private static By finishButton(){
        return By.id("finish");
    }
    public SauceDemoCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }


    public void performCheckOut() {
        if(UtilityMethods.waitForPresenceThrowsException(driver, firstNameField())){
            driver.findElement(firstNameField()).sendKeys("dummy");
            driver.findElement(lastNameField()).sendKeys("dummy");
            driver.findElement(zipCodeField()).sendKeys("dummy");
            driver.findElement(continueButton()).click();
            UtilityMethods.checkIfPageLoaded(driver, 10);
            if(UtilityMethods.waitForPresenceThrowsException(driver,finishButton())){
                driver.findElement(finishButton()).click();
            }
        }
    }
}
