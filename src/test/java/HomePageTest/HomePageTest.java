package HomePageTest;


import BaseTest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.VestaSearchResultsPage;

public class HomePageTest extends BaseTest {

    VestaSearchResultsPage searchResultsPage;

    @Test
    public void testSuccessfulSearch() {
        SoftAssert softAssert = new SoftAssert();
        VestaSearchResultsPage searchRes = homePage.searchPerform("tv");
        softAssert.assertTrue(searchRes.getSearchResultsInput().contains("tv"));
    }

    @Test
    public void testHomePageLogo() {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickHomePageButton();
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl, "https://vesta.am");
    }


    @Test
    public static void testCartAddClick() {
        SoftAssert softAssert = new SoftAssert();
        homePage.performCartButton("69,900 ֏");
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertTrue(homePage.getCartMessage().contains("Դուք ավելացրեցիք TESLA 32E325BH մոդելը Ձեր գնումների զամբյուղին"));
    }

}