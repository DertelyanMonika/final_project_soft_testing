package CartTest;

import BaseTest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.VestaCart;
import pages.common.VestaContactUsPage;
import pages.common.VestaItem;
import pages.common.VestaSearchResultsPage;



    public class CartTest extends BaseTest {
        VestaItem item;

        @Test
        public void testAddToCart() {
            SoftAssert softAssert = new SoftAssert();
            VestaSearchResultsPage searchRes = homePage.searchPerform("tv");
            VestaItem searchItem = searchRes.navigateToItem("TOTAL THKTV02H111");
            searchItem.addCart();
            softAssert.assertTrue(searchItem.getCartMessage().contains("Դուք ավելացրեցիք TOTAL THKTV02H111 մոդելը Ձեր գնումների զամբյուղին"));
        }
        @Test
        public void testRemoveFromCart() {
            SoftAssert softAssert = new SoftAssert();
            VestaSearchResultsPage searchRes = homePage.searchPerform("tv");
            VestaItem searchItem = searchRes.navigateToItem("TOTAL THKTV02H111");
            VestaCart cart = searchItem.navigateBasket();
            String previousUrl = driver.getCurrentUrl();
            cart.getSearchResult("TOTAL THKTV02H111");
            String newUrl = driver.getCurrentUrl();
            softAssert.assertNotEquals(newUrl, previousUrl, "Page did not reload");
        }
    }



