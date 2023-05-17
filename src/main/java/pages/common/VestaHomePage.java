package pages.common;

import constants.locators.VestaHomePageConstants;
import constants.locators.VestaItemConstants;
import constants.locators.VestaSearchResultsPageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.*;

import java.util.List;

public class VestaHomePage {
        private WebDriver driver;
   // private By search_icon = By.className(VestaHomePageConstants.search_icon);
    private By search_field = By.id(VestaHomePageConstants.search_field);
    private By search_button = By.id(VestaHomePageConstants.search_button);
    private By pageLogo = By.id(VestaHomePageConstants.pageLogo);
    private By cartLogo = By.id(VestaHomePageConstants.cart_logo);
    private By resContainer = By.className(VestaHomePageConstants.resContainer);
    private By resName = By.className(VestaHomePageConstants.resName);

    private By contactButton = By.xpath(VestaHomePageConstants.contactButton);
    private By bask_button = By.className(VestaHomePageConstants.baskButton);
    private By cardMessage = By.className(VestaItemConstants.cardMessage);



    public VestaHomePage(WebDriver driver) {
            this.driver = driver;
        }


//    public void clickSearchField() {
//        WebElement searchIcon = driver.findElement(search_icon);
//        searchIcon.click();
//    }
        public void fillSearchField(String input) {
            WebElement field = driver.findElement(search_field);
            field.sendKeys(input);
        }

         public List<WebElement> getResults() {
            return driver.findElements(resContainer);
    }



    public void getOneResult(String searchValue) {
        Actions actions = new Actions(driver);

        List<WebElement> searchResults = getResults();

        // Iterate through the search results to find the matching result
        for (int i = 0; i < searchResults.size(); i++) {
            WebElement searchResult = searchResults.get(i);

            try {
                String resultText = searchResult.findElement(resName).getText();
                if (resultText.contains(searchValue)) {
                    actions.moveToElement(searchResult).perform();
                    break; // Exit the loop after clicking the matching result
                }
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                // Handle the stale element reference exception by re-fetching the search results
                searchResults = getResults();
                i--; // Decrement the loop counter to revisit the current index
            }
        }
    }


    public void clickSearchButton() {
            WebElement searchButton = driver.findElement(search_button);
            searchButton.click();
        }

    public String getCartMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds
        WebElement cardMes = wait.until(ExpectedConditions.visibilityOfElementLocated(cardMessage));
        return cardMes.getText();
    }

    public void clickBskButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds
        WebElement baskButton = wait.until(ExpectedConditions.visibilityOfElementLocated(bask_button));
        baskButton.click();
    }
        public void clickHomePageButton() {
            WebElement homePageButton = driver.findElement(pageLogo);
            homePageButton.click();
        }

        public VestaSearchResultsPage searchPerform(String input) {
            fillSearchField(input);
            clickSearchButton();
            return new VestaSearchResultsPage(driver);
        }


    public void clickContactButton() {
        WebElement contactBtn = driver.findElement(contactButton);
        contactBtn.click();
    }

    public void clickCartButton() {
        WebElement cart = driver.findElement(cartLogo);
        cart.click();
    }

    public void performCartButton(String name) {
       getResults();
       getOneResult(name);
       clickBskButton();
    }
    public  VestaCart gotoCart(){
        clickCartButton();
        return new VestaCart(driver);
    }
    public VestaContactUsPage gotoContact() {
        clickContactButton();
        return new VestaContactUsPage(driver);
    }

}




