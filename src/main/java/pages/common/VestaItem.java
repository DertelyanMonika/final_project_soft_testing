package pages.common;
import constants.locators.VestaCartConstants;
import constants.locators.VestaItemConstants;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.*;
import constants.locators.VestaItemConstants;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VestaItem {
    private WebDriver driver;
    private By searchedItemPrice = By.xpath(VestaItemConstants.searchedItemPrice);
    private By addToCart = By.id(VestaItemConstants.addToCart);
    private By cardMessage = By.className(VestaItemConstants.cardMessage);
    private By cardBtn = By.id(VestaItemConstants.cardBtn);
    private By goToBasket = By.id(VestaItemConstants.gotoBasket);


    public VestaItem(WebDriver driver){
        this.driver = driver;
    }


    public String getItemPrice() {
        return driver.findElement(searchedItemPrice).getText();
    }
    public void addCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds
        WebElement cardBut = wait.until(ExpectedConditions.visibilityOfElementLocated(cardBtn));
        cardBut.click();
    }



    public String getCartMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds
        WebElement cardMes = wait.until(ExpectedConditions.visibilityOfElementLocated(cardMessage));
        return cardMes.getText();
    }


    public void clickBasketNavigButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds
        WebElement cardButton = wait.until(ExpectedConditions.visibilityOfElementLocated(goToBasket));
        cardButton.click();
    }

    public VestaCart navigateBasket(){
        addCart();
        clickBasketNavigButton();
        return new VestaCart(driver);
    }



}
