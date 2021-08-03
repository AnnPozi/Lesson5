package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends MainPage {

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement emailCreateInput;

    @FindBy(name = "SubmitCreate")
    public WebElement submitButtonCreate;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastName;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement LastNameInput;

    @FindBy(xpath = "//div[@class='account_creation']//p[4]//input[@type='text']")
    public WebElement streetInput;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;

    @FindBy(id = "id_state")
    public WebElement selectStateByIndex;

    @FindBy(css = "#postcode")
    public WebElement postCodeInput;

    @FindBy(id = "id_country")
    public WebElement idCountry;

    @FindBy(id = "phone_mobile")
    public WebElement phoneMobileInput;

    @FindBy(id = "alias")
    public WebElement aliasInput;

    @FindBy(xpath = "//button[@name='submitAccount']")
    public WebElement submitAccount;

    @FindBy(xpath = "//div[@id='center_column']/h1")
    public WebElement titleRegisteredAccount;


    /**
     * Method open web page
     */
    public void openWebPage() {
        openUrl("http://automationpractice.com/index.php");
    }
    /**
     * Method open SingIn page
     */
    public void openRegistrationPage() {
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
    /**
     * Method click to SingIn page
     */
    public void clickToSingIn() {
        try {
            loginInput.click();
            logger.info("Click to SingIn page");
        } catch (Exception e) {
            logger.error("Can't click to SingIn");
            Assert.fail("Can't click to SingIn");
        }
    }
    /**
     * Method input email
     * */
    public void clickCreate() {
        try {
            webDriver.findElement(By.id("SubmitCreate")).click();
            logger.info("Clicking create account " );
        } catch (Exception e) {
            logger.error("cannot Click create account");
            Assert.fail("cannot Click create account");
        }
    }
    /**
     * Method input email
     * @param email
     * */
    public void inputEmailCreate(String email) {
        try {
            emailCreateInput.sendKeys(email);
            logger.info("Input email " + email);
        } catch (Exception e) {
            logger.error("Can't input email " + email);
            Assert.fail("Can't input email " + email);
        }
    }
    /**
     * Method input email
     * @param name
     * */
    public void inputFirstName(String name) {
        try {
            webDriver.findElement(By.id("customer_firstname")).sendKeys(name);
            logger.info("Input first name " + name);
        } catch (Exception e) {
            logger.error("Can't input name " + name);
            Assert.fail("Can't input name " + name);
        }
    }
    /**
     * Method input email
     * @param surname
     * */
    public void inputSurname(String surname) {
        try {

            webDriver.findElement(By.id("customer_lastname")).sendKeys(surname);

        } catch (Exception e) {
            logger.error("Can't input surname " + surname);
            Assert.fail("Can't input surname " + surname);
        }
    }
    /**
     * Method input email
     * @param pass
     * */
    public void inputPassword(String pass) {
        try {
            webDriver.findElement(By.id("passwd")).sendKeys(pass);

        } catch (Exception e) {
            logger.error("Can't input password " + pass);
            Assert.fail("Can't input password " + pass);
        }
    }
    /**
     * Method input email
     * @param city
     * */
    public void inputCity(String city) {
        try {
            webDriver.findElement(By.xpath("//input[@id='city']"))
                    .sendKeys(city);

        } catch (Exception e) {
            logger.error("Can't input city " + city);
            Assert.fail("Can't input city " + city);
        }
    }
    /**
     * Method input email
     * @param state
     * */
    public void selectState(String state) {
        try {
            Select state1 = new Select(webDriver.findElement(By.id("id_state")));
            state1.selectByVisibleText(state);

        } catch (Exception e) {
            logger.error("Can't select state " + state);
            Assert.fail("Can't select state " + state);
        }
    }
    /**
     * Method submit button
     * */
    public void submitButtonCreate() {
        try {
            submitButtonCreate.click();
            logger.info("Click submit button");
        } catch (Exception e) {
            logger.error("Can't submit button");
            Assert.fail("Can't submit button");
        }
    }
    /**
     * Method select city by index
     * @param index
     * */
    public void selectCity(int index) {
        try {
            Select select = new Select(webDriver.findElement(By.id("id_state")));
            select.selectByIndex(index);
            logger.info("Find select city by 32");
        } catch (Exception e) {
            logger.error("Can't find select city by 32");
            Assert.fail("Can't find select city by 32");
        }
    }
    /**
     * Method select city by index
     * @param street
     * */
    public void inputStreet(String street) {
        try {
            webDriver.findElement(By.xpath("//div[@class='account_creation']//p[4]//input[@type='text']"))
                    .sendKeys(street);
        } catch (Exception e) {
            logger.error("Can't input street" + street);
            Assert.fail("Can't input street" + street);
        }
    }
    /**
     * Method
     * @param country
     * */
    public void selectCountry(String country) {
        try {
            Select select = new Select(webDriver.findElement(By.id("id_country")));
            select.selectByVisibleText(country);
            logger.info("Find select country " + country);
        } catch (Exception e) {
            logger.error("Can't find select country " + country);
            Assert.fail("Can't find select country");
        }
    }
    /**
     * Method input email
     * @param zip
     * */
    public void inputZip(String zip) {
        try {
            webDriver.findElement(By.id("postcode"))
                    .sendKeys(zip);

        } catch (Exception e) {
            logger.error("Can't input city " + zip);
            Assert.fail("Can't input city " + zip);
        }
    }
    /**
     * Method
     * @param number
     * */
    public void inputPhoneNumber(String number) {
        try {
            webDriver.findElement(By.xpath("//input[@id='phone_mobile']"))
                    .sendKeys(number);
            logger.info("Input phone" + number);
        } catch (Exception e) {
            logger.error("Can't input phone number " + number);
            Assert.fail("Can't input phone number");
        }
    }
    /**
     * Method
     * @param email
     * */
    public void inputAlias(String email) {
        try {
            webDriver.findElement(By.xpath("//input[@id='alias']")).clear();
            webDriver.findElement(By.xpath("//input[@id='alias']"))
                    .sendKeys(email);
            logger.info("Input phone" + email);
        } catch (Exception e) {
            logger.error("Can't input alias " + email);
            Assert.fail("Can't input alias");
        }
    }
    /**
     * Method
     * */
    public void clickSubmitAccount() {
        try {
            webDriver.findElement(By.id("submitAccount")).click();
            logger.info("Registered");
        } catch (Exception e) {
            logger.error("Not registered");
            Assert.fail("Not registered");
        }
    }
    /**
     * Method
     * */
    public String titleRegisteredAccount() {
       try {
           String text = webDriver.findElement(By.className("page-heading")).getText();
           logger.info("checking the right text after registration");
           return text;
       } catch (Exception e) {
           String text = "ERROR";
           logger.error("Title MY ACCOUNT is missing");
           Assert.fail("Title MY ACCOUNT is missing");
           return text;
       }
   }
    /**
     * Method
     * */
    public void cleanCountry(){

       Select country = new Select(webDriver.findElement(By.xpath("//*[@id=\"id_country\"]")));
       country.selectByVisibleText("-");
       logger.info("Country is not selected");
   }
    /**
     * Method
     * */
    public String  errorTitle(){
       try{
          String errorText = webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText();
           logger.info("Got the error title");
           return errorText;
       }catch(Exception e) {
           logger.error("There is NO  error title");
           Assert.fail("There is NO  error title");
           return "";
       }
   }
    /**
     * Method
     * */
    public String  errorTitle1(){
        try{
            String errorText1 = webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]")).getText();
            //String errorText2 = webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]/text()")).getText();
            logger.info("Got the error title 1st ERROR");
            return errorText1;
        }catch(Exception e) {
            logger.error("There is NO  error title 1st ERROR");
            Assert.fail("There is NO  error title 1st ERROR");
            return "";
        }
    }
    /**
     * Method
     * */
    public String  errorTitle2(){
       try{
          String errorText2 = webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[2]")).getText();
          //String errorText2 = webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]/text()")).getText();
           logger.info("Got the error title 2nd ERROR");
           return errorText2;
       }catch(Exception e) {
           logger.error("There is NO  error title 2nd ERROR");
           Assert.fail("There is NO  error title 2nd ERROR");
           return "";
       }
   }
    /**
     * Method
     * */
    public String  errorTitle3(){
       try{
          String errorText3 = webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[3]")).getText();
           logger.info("Got the error title 3rd ERROR");
           return errorText3;
       }catch(Exception e) {
           logger.error("There is NO  error title 3rd ERROR");
           Assert.fail("There is NO  error title 3rd ERROR");
           return "";
       }
   }

}
