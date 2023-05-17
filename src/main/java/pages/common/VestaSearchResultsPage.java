package pages.common;
import constants.locators.VestaSearchResultsPageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import constants.locators.VestaSearchResultsPageConstants;

import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VestaSearchResultsPage {
    private WebDriver driver;
  //  private VestaItem sasItem;
    private WebDriverWait wait;
   // private By searchResults = By.className(VestaSearchResultsPageConstants.searchResults);
    private By searchResInput = By.id(VestaSearchResultsPageConstants.searchResInput);
    private By searchResContainer = By.className(VestaSearchResultsPageConstants.searchResContainer);
    private By searchResName = By.xpath(VestaSearchResultsPageConstants.searchResName);


    public VestaSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSearchResultsInput() {
        return driver.findElement(searchResInput).getText();

    }
    public List<WebElement> getSearchResults() {
        return driver.findElements(searchResContainer);
 }

public void getSearchResult(String searchValue) {
    List<WebElement> searchResults = getSearchResults();

    // Iterate through the search results to find the matching result
    for (int i = 0; i < searchResults.size(); i++) {
        WebElement searchResult = searchResults.get(i);

        try {
            String resultText = searchResult.findElement(searchResName).getText();
            if (resultText.contains(searchValue)) {
                searchResult.click();
                break; // Exit the loop after clicking the matching result
            }
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            // Handle the stale element reference exception by re-fetching the search results
            searchResults = getSearchResults();
            i--; // Decrement the loop counter to revisit the current index
        }
    }
}


    public VestaItem navigateToItem(String item){
        getSearchResult(item);
        return new VestaItem(driver);
    }
}