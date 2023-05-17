package pages.common;
import constants.locators.VestaContactUsConstants;
import constants.locators.VestaHomePageConstants;
import constants.locators.VestaItemConstants;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.*;
import constants.locators.VestaItemConstants;


public class VestaContactUsPage {
    private WebDriver driver;
    private By inputName = By.id(VestaContactUsConstants.inputName);

    private By inputEmail = By.id(VestaContactUsConstants.inputEmail);
    private By enquiry = By.name(VestaContactUsConstants.inputEnquiry);

    private By enq_button = By.xpath(VestaContactUsConstants.enq_button);

    private By captchaText = By.xpath(VestaContactUsConstants.captchaText);
    private By nameerror = By.xpath(VestaContactUsConstants.nameerror);
    private By emailerror = By.xpath(VestaContactUsConstants.emailerror);

    public VestaContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInputName(String input) {
        WebElement name = driver.findElement(inputName);
        name.sendKeys(input);
    }

    public void fillInputEmail(String input) {
        WebElement email = driver.findElement(inputEmail);
        email.sendKeys(input);
    }
    public void fillEnquiry(String input) {
        WebElement enq = driver.findElement(enquiry);
        enq.sendKeys(input);
    }

    public void clickContactButton() {
        WebElement enqButton = driver.findElement(enq_button);
        enqButton.click();
    }


    public void sendEnquiry(String name, String mail, String enq){
        fillInputName(name);
        fillInputEmail(mail);
        fillEnquiry(enq);
        clickContactButton();
    }
    public String getCaptchaText() {
        return driver.findElement(captchaText).getText();
    }
    public String getNameErrorText() {
        return driver.findElement(nameerror).getText();
    }
    public String getEmailErrorText() {
        return driver.findElement(emailerror).getText();
    }



}
