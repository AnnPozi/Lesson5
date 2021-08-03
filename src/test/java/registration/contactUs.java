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

public class contactUs {

    public WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
@Test
    public void contactUs() {

        BasicConfigurator.configure();
        File chrome = new File("./driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {

            webDriver.get("http://automationpractice.com/index.php");
            logger.info("Open URL");
        } catch (Exception e) {
            logger.error("Can not open URL");
            Assert.fail("Can not open URL");
        }

            webDriver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();
            logger.info("Click Contact Us");

        Select subject = new Select(webDriver.findElement(By.id("id_contact")));
        subject.selectByVisibleText("Webmaster");
        logger.info("Subject is selected - Webmaster");

        webDriver.findElement(By.className("icon-comment-alt")).isDisplayed();
        logger.info("IChecking informative message");

        webDriver.findElement(By.id("email")).sendKeys("pozina@anna.com");
        logger.info("Input email - pozina@anna.com");

        webDriver.findElement(By.id("id_order")).sendKeys("123455");
        logger.info("Input Order - 123455");

        webDriver.findElement(By.id("message")).sendKeys("what is the problem with website all the time");
        logger.info("Input comment about the problem");

        webDriver.findElement(By.id("submitMessage")).click();
        logger.info("Clicking send button");

   webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).isDisplayed();
    logger.info("Successful sent");

    String messageText = webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
    System.out.println(messageText.equals("Your message has been successfully sent to our team."));
    messageText.equals("Your message has been successfully sent to our team.");
    logger.info("The info message is correct");

    webDriver.quit();





    }
}
