package inter.sauce.test.pages;

import inter.sauce.test.util.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SauceDemoCartPage {
    WebDriver driver;


    private static By checkOut() {
        return By.id("checkout");
    }

    private static By cartItemsList(){
        return By.xpath("//div[@class='cart_item']");
    }

    private static By cartItemsQuantity(){
        return By.xpath("//div[@class='cart_item']/div[@class='cart_quantity']");
    }

    public SauceDemoCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void continueCheckout() {
        Assert.assertEquals(driver.findElements(cartItemsList()).size(),2,"The number of items in the cart should be two");
        List<WebElement> cartElements = driver.findElements(cartItemsQuantity());
        for (WebElement cartElement : cartElements) {
            Assert.assertEquals(cartElement.getText(), "1", "The quantity in the cart should be 1");
        }
        driver.findElement(checkOut()).click();
        UtilityMethods.checkIfPageLoaded(driver, 10);
    }


}
