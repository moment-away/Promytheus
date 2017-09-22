import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testResources.PageResources;
import testResources.TestData;

import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

// Test Case 1 - Registration of the Regular User
// Test Case 2 - Registration of the Scout

public class RegistrationTests {

    private String baseUrl = "http://52.53.181.39/sign-in.html";
    private WebDriver driver;
    //private WebDriverWait wait;
    PageResources pageResources;


    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver(); //get driver
        driver.get(baseUrl); //open home page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait till all elements on the page are loaded
        pageResources = new PageResources(driver); //get access to PageResources data
    }

    @AfterMethod
    public void tearDown() throws Exception {
        //driver.quit(); //close browser
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "Registration_TestDataProvider", enabled = true,description = "Registration")
    public void registrationRU(String firstName, String lastName, String country, String address, String phone, String email, String password) throws Exception {
        try {
            Thread.sleep(1000); //wait 1 second for page to be loaded - other types of wait do not work here
            pageResources.getLoginPage().clickRegisterButton(); //enter email into the corresponding field
        }
        catch (Exception e) {
            Thread.sleep(1000); //wait 1 second for page to be loaded - other types of wait do not work here
            pageResources.getLoginPage().killCover(); //close cover, which may overlap the buttons
            pageResources.getLoginPage().clickRegisterButton(); //click Register button
        }
        pageResources.getRegistrationPage().enterUserFirstName(firstName); //enter first name
        pageResources.getRegistrationPage().enterUserLastName(lastName); //enter last name
        pageResources.getRegistrationPage().enterCountry(country); //enter country
        pageResources.getRegistrationPage().enterAddress(address); //enter address
        pageResources.getRegistrationPage().enterPhone(phone); //enter phone number
        pageResources.getRegistrationPage().enterEmail(email); //enter email
        pageResources.getRegistrationPage().enterPassword(password); //enter password
        pageResources.getRegistrationPage().reEnterPassword(password); //confirm password
        pageResources.getRegistrationPage().clickCreateAccountButton(); //click Create Account button
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //wait for page to be loaded
        try {
            Assert.assertEquals(driver.getCurrentUrl(), baseUrl); //assert that current URL is the same as base URL - user is redirected to the login page
            System.out.println("Registration of user completed, user is redirected to home page"); //print message to the console if registration form was submitted
        } catch (AssertionError e) {
            Assert.fail("Registration is not completed"); //print message to console if registration form was not submitted
        }
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "Registration_TestDataProvider", enabled = true,description = "Registration")
    public void registrationScout(String firstName, String lastName, String country, String address, String phone, String email, String password) throws Exception {
        pageResources.getLoginPage().clickRegisterButton(); //click Register button
        pageResources.getRegistrationPage().checkScoutCheckbox(); //check Scout checkbox
        pageResources.getRegistrationPage().enterUserFirstName(firstName); //enter first name
        pageResources.getRegistrationPage().enterUserLastName(lastName); //enter last name
        pageResources.getRegistrationPage().enterCountry(country); //enter country
        pageResources.getRegistrationPage().enterAddress(address); //enter address
        pageResources.getRegistrationPage().enterPhone(phone); //enter phone number
        pageResources.getRegistrationPage().enterEmail(email); //enter email
        pageResources.getRegistrationPage().enterPassword(password); //enter password
        pageResources.getRegistrationPage().reEnterPassword(password); //confirm password
        pageResources.getRegistrationPage().clickCreateAccountButton(); //click Create Account button
        try {
            Assert.assertEquals(driver.getCurrentUrl(), baseUrl); //assert that after submitting registration form the current URL is the same as base URL - scout is redirected to Login page
            out.println("Registration of scout completed, user is redirected to home page"); //print message to console if registration is submitted and user is redirected to Login page
        } catch (AssertionError e) {
            Assert.fail("Registration is not completed"); //print message to console if registration form is not submitted and user is not redirected to the Login page
        }
    }
}



//
//    @Test(dataProviderClass = TestData.class, dataProvider = "NewTalent_TestDataProvider", enabled = false,description = "New Talent")
//    public void NewTalentRU(String email, String pass, String firstName, String middleName, String lastName,
//        String dob, String placeOfBirth, String address, String newEmail, String phone, String socialAccount,
//        String height, String weight, String college, String successLevel, String evidence,
//        String workProduct, String income, String headline, String years, String gutFeel, String rationale, String score,
//        String rank, String talentTrait1, String talentTrait2, String talentTrait3) throws Exception {
//        pageResources.getLoginPage().enterLoginEmail(email);
//        pageResources.getLoginPage().enterPassword(pass);
//        pageResources.getLoginPage().clickLoginButton();
//        pageResources.getNewTalentPage().newTalentUser(firstName, middleName, lastName, dob, placeOfBirth, address, newEmail,
//                phone, socialAccount, height, weight, college, successLevel, evidence, workProduct, income,
//                headline, years, gutFeel, rationale, score, rank, talentTrait1, talentTrait2, talentTrait3);
//        pageResources.getLoginPage().enterLoginEmail(email);
//        pageResources.getLoginPage().enterPassword(pass);
//        pageResources.getLoginPage().clickLoginButton();
//
//    }
