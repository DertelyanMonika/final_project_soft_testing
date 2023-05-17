package BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.common.VestaHomePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BaseTest {
    protected static WebDriver driver;
    protected static VestaHomePage homePage;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
    }
    @BeforeMethod
    public void goHome() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), capabilities);
        driver.manage().window().maximize();
        homePage = new VestaHomePage(driver);
        driver.get("https://vesta.am");

    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File sc = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(sc.toPath(), new File("resources/screenshots/" + result.getName() + ".png").toPath());
            }
            catch (IOException err){
                err.printStackTrace();
            }
        }
    }
    @AfterClass
    public void tearDown(){
        // driver.quit();
    }
}
