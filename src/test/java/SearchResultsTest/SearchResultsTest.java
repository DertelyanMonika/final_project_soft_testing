package SearchResultsTest;

import BaseTest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.VestaItem;
import pages.common.VestaSearchResultsPage;

public class SearchResultsTest extends BaseTest {

   @Test
    public void searchForItem(){
       SoftAssert softAssert = new SoftAssert();
     VestaSearchResultsPage searchResults  = homePage.searchPerform("tv");
     VestaItem searchItem = searchResults.navigateToItem("TOTAL THKTV02H111");
     softAssert.assertTrue(searchItem.getItemPrice().equals("14,200 ֏"));
   }
   

}
