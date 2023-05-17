package HomePageTest;


import BaseTest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.VestaContactUsPage;
import pages.common.VestaSearchResultsPage;

public class ContactUsTest extends BaseTest {


    @Test
    public void testContactUs(){
        SoftAssert softAssert = new SoftAssert();
        VestaContactUsPage contactUsPage = homePage.gotoContact();
        contactUsPage.sendEnquiry("Sona", "Gevorgyan@mail.ru", "hello");
        softAssert.assertEquals(contactUsPage.getCaptchaText(),"Խնդրում ենք լրացրեք անվտանգության ապահովման դաշտը" );
    }

    @Test
    public void testContactUsNameValidation(){
        SoftAssert softAssert = new SoftAssert();
        VestaContactUsPage contactUsPage = homePage.gotoContact();
        contactUsPage.sendEnquiry("", "Gevorgyan@mail.ru", "hello");
        softAssert.assertEquals(contactUsPage.getNameErrorText(),"Անունը պետք է 3 - 32 նիշ պարունակի!" );
    }


    @Test
    public void testContactUsEmailValidation(){
        SoftAssert softAssert = new SoftAssert();
        VestaContactUsPage contactUsPage = homePage.gotoContact();
        contactUsPage.sendEnquiry("Sona", "Gevorgyan", "hello");
        softAssert.assertEquals(contactUsPage.getEmailErrorText(),"Էլ․-փոստի հասցեն անվավեր է" );
    }


    @Test
    public void testHomePageLogo() {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickHomePageButton();
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl, "https://vesta.am");
    }


}

