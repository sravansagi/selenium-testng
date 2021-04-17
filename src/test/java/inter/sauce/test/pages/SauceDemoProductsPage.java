package inter.sauce.test.pages;

import inter.sauce.test.util.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SauceDemoProductsPage {
    WebDriver driver;


    private static By productsLabel() {
        return By.xpath("//span[@class='title' and text()='Products']");
    }

    private static By productSortFilterSelect() {
        return By.xpath("//select[@class='product_sort_container']");
    }

    private static By productSortActiveFilter() {
        return By.xpath("//span[@class='active_option']");
    }

    private static By addToCartButton(int position) {
        return By.xpath("//div[@id='inventory_container']//div[@class='inventory_item'][" + position + "]//button");
    }

    private static By shoppingCartBadge(){
        return By.xpath("//a[@class='shopping_cart_link']/span");
    }
    private static By shoppingCart(){
        return By.xpath("//a[@class='shopping_cart_link']");
    }


    public SauceDemoProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortProductsFromLowtoHigh() {
        if(UtilityMethods.waitForPresenceThrowsException(driver, productsLabel())){
            Select select = new Select(driver.findElement(productSortFilterSelect()));
            select.selectByVisibleText("Price (low to high)");
            UtilityMethods.checkIfPageLoaded(driver, 2);
            Assert.assertEquals(driver.findElement(productSortActiveFilter()).getText().toLowerCase(), "price (low to high)", "The filter sorting is expected to be from low to high");
        }
    }

    public void selectTwoItemsToCart() {
        UtilityMethods.checkIfPageLoaded(driver, 2);
        driver.findElement(addToCartButton(1)).click();
        UtilityMethods.waitForPresenceThrowsException(driver, shoppingCartBadge());
        Assert.assertEquals(driver.findElement(shoppingCartBadge()).getText(), "1", "The shopping cart badge should be equal to 1");
        driver.findElement(addToCartButton(2)).click();
        UtilityMethods.waitForPresenceThrowsException(driver, shoppingCartBadge());
        Assert.assertEquals(driver.findElement(shoppingCartBadge()).getText(), "2", "The shopping cart badge should be equal to 2");
        driver.findElement(shoppingCart()).click();
        UtilityMethods.checkIfPageLoaded(driver, 5);
    }
}
