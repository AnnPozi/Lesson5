package registration;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class registration {
    public WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    private String email = "annapozina@gmail.com";

@Test
public void testRegistration(){
    BasicConfigurator.configure();
    File chrome = new File("./driver/chromedriver");
    System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try{
        webDriver.get("http://automationpractice.com/index.php");
        logger.info("Open URL");
    }
    catch (Exception e) {
        logger.error("Can not open URL");
        Assert.fail("Can not open URL");
    }
    webDriver.findElement(By.className("login")).click();
    logger.info("Click Log In");

    webDriver.findElement(By.id("email_create")).sendKeys("annapozina@gmail.com");
    logger.info("CInput email -annapozina@gmail.com");

    webDriver.findElement(By.name("SubmitCreate")).click();
    logger.info("Clicking account create form");

    webDriver.findElement(By.id("customer_firstname")).sendKeys("Anna");
    logger.info("Input firstname - Anna");

    webDriver.findElement(By.id("customer_lastname")).sendKeys("Pozina");
    logger.info("Input last name - Pozina");



    webDriver.findElement(By.id("passwd")).sendKeys("1234567password");
    logger.info("Input password - 1234567password");

    webDriver.findElement(By.id("address1")).sendKeys("street New York, 18");
    webDriver.findElement(By.id("city")).sendKeys("New York");

    Select state = new Select(webDriver.findElement(By.xpath("//*[@id=\"id_state\"]")));
   // state.selectByIndex(10);
    state.selectByVisibleText("Alaska");
    //state.selectByValue("Alaska");
    logger.info("Selected by text - Alaska");

    webDriver.findElement(By.cssSelector("#postcode")).sendKeys("23950");
    logger.info("input post code - 23950");

    Select country = new Select(webDriver.findElement(By.id("id_country")));
    country.selectByVisibleText("United States");
    logger.info("Selected be text - US");

    webDriver.findElement(By.id("phone_mobile")).sendKeys("0771030446");
    logger.info("Input phone number - 0771030446");

    webDriver.findElement(By.id("alias")).sendKeys("pozinapozina@pozina.com");
    logger.info("Input alias - pozinapozina@pozina.com");

    webDriver.findElement(By.id("submitAccount")).click();
    logger.info("Registration clicked");



    webDriver.quit();


}

}
