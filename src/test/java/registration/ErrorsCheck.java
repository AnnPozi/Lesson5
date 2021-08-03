package registration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.RegistrationPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ErrorsCheck {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    public RegistrationPage registrationPage;
    public MainPage mainPage;

    private final String FIRST_NAME = "Anna";
    private final String LAST_NAME = "Pozina";
    private final String EMAIL = "3annaann@pozina.com";
    private final String INEMAIL = "11";
    private final String PASSWORD = "qwerty123";
    private final String STREET = "street New York, 12";
    private final String CITY = "New York";
    private final String STATE = "Alaska";
    private final int CITY_INDEX = 32;
    private final String POST_CODE = "12345";
    private final String COUNTRY = "United States";
    private final String PHONE_MOBILE = "1234567890";

    @Test
    public void testErrors() {
        BasicConfigurator.configure();
        //Setup browser
        File chrome = new File("/Users/apozina/IdeaProjects/lesson4/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        registrationPage = new RegistrationPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        registrationPage.openWebPage();
        registrationPage.clickToSingIn();
        //Your personal info
        registrationPage.openRegistrationPage();
        registrationPage.inputEmailCreate(EMAIL);
        registrationPage.clickCreate();

        registrationPage.inputFirstName(FIRST_NAME);
        registrationPage.inputSurname(LAST_NAME);
        registrationPage.inputPassword(PASSWORD);
        //your address
        registrationPage.inputStreet(STREET);
        registrationPage.inputCity(CITY);
        registrationPage.inputZip(POST_CODE);
        registrationPage.cleanCountry();

        registrationPage.inputPhoneNumber(PHONE_MOBILE);
        registrationPage.inputAlias(INEMAIL);
        registrationPage.clickSubmitAccount();
        //checking errors method
        Assert.assertEquals("There are 3 errors",
                registrationPage.errorTitle());
        Assert.assertEquals("id_country is required.",
                registrationPage.errorTitle1());
        Assert.assertEquals("Country cannot be loaded with address->id_country",
                registrationPage.errorTitle2());
        Assert.assertEquals("Country is invalid",
                registrationPage.errorTitle3());
        
        //Close chromedriver
       // webDriver.quit();
    }
}
