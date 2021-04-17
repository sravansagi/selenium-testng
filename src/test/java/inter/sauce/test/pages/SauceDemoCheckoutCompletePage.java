package inter.sauce.test.pages;

import inter.sauce.test.util.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class SauceDemoCheckoutCompletePage {

    WebDriver driver;

    private static By checkOutCompletePage(){
        return By.xpath("//span[@class='title' and contains(text(),'Complete')]");
    }

    private static By checkOutCompleteSuccessText(){
        return By.xpath("//h2[@class='complete-header']");
    }

    public SauceDemoCheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateCheckout() {

        if(UtilityMethods.waitForPresenceThrowsException(driver, checkOutCompletePage())){
            Assert.assertEquals(driver.findElement(checkOutCompleteSuccessText()).getText(), "THANK YOU FOR YOUR ORDER", "The other placed successful message");
        }


    }
}
