package pages.common;

import constants.locators.VestaCartConstants;
import constants.locators.VestaItemConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VestaCart {
    private WebDriver driver;
    private By removeBut = By.xpath(VestaCartConstants.removeBtn);

    private By basketResults = By.className(VestaCartConstants.basketResults);


    public VestaCart(WebDriver driver){
        this.driver = driver;
    }


    public List<WebElement> getBasketResults() {
        return driver.findElements(basketResults);
    }

    public void getSearchResult(String searchValue) {
        List<WebElement> searchResults = getBasketResults();
        for (int i = 0; i < searchResults.size(); i++) {
            WebElement searchResult = searchResults.get(i);
            try {
                String attribute_value = searchResult.getAttribute("title");
                if (attribute_value.contains(searchValue)) {
                    searchResult.findElement(removeBut).click();
                     // Exit the loop after clicking the matching result
                }
            } catch (StaleElementReferenceException e) {
                searchResults = getBasketResults();
                i--;
            }
        }
    }
}
