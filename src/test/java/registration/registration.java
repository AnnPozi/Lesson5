package registration;



import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.MainPage;

import pages.RegistrationPage;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class registration {


    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());


    public RegistrationPage registrationPage;
    public MainPage mainPage;

    private final String FIRST_NAME = "Anna";
    private final String LAST_NAME = "Pozina";
    private final String EMAIL = "16annaanna@pozina.com";
    private final String PASSWORD = "qwerty123";
    private final String STREET = "street New York, 12";
    private final String CITY = "New York";
    private final String STATE = "Alaska";
    private final int CITY_INDEX = 32;
    private final String POST_CODE = "12345";
    private final String COUNTRY = "United States";
    private final String PHONE_MOBILE = "1234567890";

    @Test
    public void testRegistrationValid() {
        BasicConfigurator.configure();
        //Setup browser
        File chrome = new File("/Users/apozina/IdeaProjects/lesson4/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            webDriver.get("http://automationpractice.com/index.php");
            logger.info("Open ulr - http://automationpractice.com/index.php");
        } catch (Exception e) {
            logger.error("Can't open url - http://automationpractice.com/index.php");
            Assert.fail("Can't open url - http://automationpractice.com/index.php");
        }

        //Your personal info
        webDriver.findElement(By.xpath("//a[@class='login']")).click();
//        webDriver.findElement(By.className("login")).click();
//        webDriver.findElement(By.cssSelector(".login")).click();
        logger.info("Click login - //a[@class='login']");
        webDriver.findElement(By.xpath("//input[@id='email_create']"))
                .sendKeys(EMAIL);
        logger.info("Input email - " + EMAIL);
        webDriver.findElement(By.name("SubmitCreate")).click();
//        webDriver.findElement(By.name("button[name$='SubmitCreate']")).click();
        logger.info("Click account create form");
        webDriver.findElement(By.id("customer_firstname"))
                .sendKeys("Anna");
        logger.info("Input customer firstname - Anna");
        webDriver.findElement(By.id("customer_lastname"))
                .sendKeys("Pozina");
        logger.info("Input customer lastname - Pozina");
        webDriver.findElement(By.id("email")).clear();
        webDriver.findElement(By.id("email")).sendKeys(EMAIL);
        logger.info("Input email - " + EMAIL);
        webDriver.findElement(By.id("passwd"))
                .sendKeys("qwerty123");
        logger.info("Input password - qwerty123");

        //your address
        webDriver.findElement(By.xpath("//input[@id='firstname']")).clear();
        webDriver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Dima");
        logger.info("Input first name - Anna");
        webDriver.findElement(By.xpath("//input[@id='lastname']")).clear();
        webDriver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Hulak");
        logger.info("input last name - Pozina");
        webDriver.findElement(By.xpath("//div[@class='account_creation']//p[4]//input[@type='text']"))
                .sendKeys("street New York, 12");
        webDriver.findElement(By.xpath("//input[@id='city']"))
                .sendKeys("New York");
        Select state = new Select(webDriver.findElement(By.id("id_state")));
        state.selectByIndex(32);
        logger.info("Select by index - 32");
        webDriver.findElement(By.cssSelector("#postcode"))
                .sendKeys("12345");
        logger.info("Input post code - 12345");
        webDriver.findElement(By.id("id_country")).isDisplayed();
        Select country = new Select(webDriver.findElement(By.id("id_country")));
        country.selectByVisibleText("United States");
        logger.info("Select by visible text - United States");
        webDriver.findElement(By.xpath("//input[@id='phone_mobile']"))
                .sendKeys("1234567890");
        logger.info("Input phone - 1234567890");
        webDriver.findElement(By.xpath("//input[@id='alias']")).clear();
        webDriver.findElement(By.xpath("//input[@id='alias']"))
                .sendKeys(EMAIL);
        logger.info("Input alias - " + EMAIL);
        webDriver.findElement(By.xpath("//button[@name='submitAccount']")).click();
        logger.info("Click button submit registration");
//        webDriver.findElement(By.xpath("//div[@id='center_column']/h1")).isDisplayed();
//        logger.info("Check h1 is displayed - //div[@id='center_column']/h1");

        //Close chromedriver
        webDriver.quit();
    }

    @Test
    public void testRegistration() {
        //Setup browser
        File chrome = new File("./Users/apozina/IdeaProjects/lesson4/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        registrationPage = new RegistrationPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Your personal info
        registrationPage.openRegistrationPage();
        registrationPage.inputEmailCreate(EMAIL);
        registrationPage.submitButtonCreate();
        //another method
        registrationPage.customerFirstName.sendKeys(FIRST_NAME);
        registrationPage.customerLastName.sendKeys(LAST_NAME);
        registrationPage.emailInput.clear();
        registrationPage.emailInput.sendKeys(EMAIL);
        registrationPage.passwordInput.sendKeys(PASSWORD);
        //your address
        registrationPage.firstNameInput.clear();
        registrationPage.firstNameInput.sendKeys(FIRST_NAME);
        registrationPage.LastNameInput.clear();
        registrationPage.LastNameInput.sendKeys(LAST_NAME);
        registrationPage.streetInput.sendKeys(STREET);
        registrationPage.cityInput.sendKeys(CITY);
        registrationPage.selectCity(CITY_INDEX);
        registrationPage.postCodeInput.sendKeys(POST_CODE);
        registrationPage.selectCountry(COUNTRY);
        registrationPage.phoneMobileInput.sendKeys(PHONE_MOBILE);
        registrationPage.aliasInput.clear();
        registrationPage.aliasInput.sendKeys(EMAIL);
        registrationPage.submitAccount.click();
        registrationPage.titleRegisteredAccount.isDisplayed();
//        Assert.assertEquals("MY ACCOUNT", registrationPage.titleRegisteredAccount);

        //Close chromedriver
        webDriver.quit();
    }
    @Test
    public void testRegistration2() {
        BasicConfigurator.configure();
        //Setup browser
        File chrome = new File("/Users/apozina/IdeaProjects/lesson4/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        registrationPage = new RegistrationPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        registrationPage.selectState(STATE);
        registrationPage.inputZip(POST_CODE);
        registrationPage.selectCountry(COUNTRY);
        registrationPage.inputPhoneNumber(PHONE_MOBILE);
        registrationPage.inputAlias(EMAIL);
        registrationPage.clickSubmitAccount();
        //another method

       Assert.assertEquals("MY ACCOUNT", registrationPage.titleRegisteredAccount());

        //Close chromedriver
        webDriver.quit();
    }

}
