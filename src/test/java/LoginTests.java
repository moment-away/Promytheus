import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import testResources.TestData;
import testResources.PageResources;
import java.util.concurrent.TimeUnit;

/*  Test Case "Verify that user can log in into the application"
Precondition:
At least one user is registered in the system
Instructions:
1. Go to home page.
2. Enter valid/registered Email into email field.
3. Enter corresponding password into Password field.
4. Click Login button.
5. Observe Talents page after user is logged in.
Expected result: User should be logged in and redirected to the Talents page if valid credentials were entered.
 */


// Test Case 1 - Login with the valid data (registered email and corresponding login)
// Test Case 2 - Login with unregistered email and valid password
// Test Case 3 - Login with registered email and invalid password
// Test Case 4 - Login with registered email and blank password
// Test Case 5 - Login with blank email and valid password
// Test Case 6 - Login with blank email and blank password

public class LoginTests {
    private String baseUrl = "http://52.53.181.39/sign-in.html"; //open home page
    private WebDriver driver; //creating new instance of driver
    PageResources pageResources; //creating new instance of PageResources

    String expectedLoggedInUrl = "http://52.53.181.39/talents.html"; //URL of talent page, which appears after user/scout is logged in

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver(); //get driver to open the browser
        driver.get(baseUrl); //open home page
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait till all elements on the page are loaded
        pageResources = new PageResources(driver); //get access to PageResources class
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit(); //close browser
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "LoginRU_TestDataProvider", enabled = true, priority = 0, description = "Login")
    public void loginRU_validData(String email, String pass) throws Exception
    {
        try {
            pageResources.getLoginPage().enterLoginEmail(email); //enter email into the corresponding field
        }
        catch (Exception e) {
            Thread.sleep(1000); //wait 1 second for page to be loaded - other types of wait do not work here
            pageResources.getLoginPage().killCover(); //close cover, which may overlap the buttons
            pageResources.getLoginPage().enterLoginEmail(email); //enter email
        }
        pageResources.getLoginPage().enterPassword(pass); //enter password
        pageResources.getLoginPage().clickLoginButton(); //click Login button
        Thread.sleep(1000); //wait 1 second for page to be loaded - other types of wait do not work here
        try {
            Assert.assertEquals(driver.getCurrentUrl(), expectedLoggedInUrl); //assert that current URL corresponds to the Talents page URL after logging in
            System.out.println("Login with valid credentials is successful"); //print message to the console that login was successful
        }
        catch (AssertionError e) {
            Assert.fail("Login with valid credentials is unsuccessful!"); //print message to the console if user was not logged in
        }
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "LoginWithUnregisteredEmail_TestDataProvider", priority = 1, enabled = true,description = "Login")
    public void loginRU_UnregisteredEmail_ValidPass(String email, String pass) throws Exception {
        pageResources.getLoginPage().enterLoginEmail(email); //enter email
        pageResources.getLoginPage().enterPassword(pass); //enter password
        pageResources.getLoginPage().clickLoginButton(); //click Login button
        Thread.sleep(1000); //wait 1 second for page to be loaded - other types of wait do not work here
        try {
            Assert.assertEquals(driver.getCurrentUrl(), baseUrl); //assert that user is not logged in and redirected to another page
            System.out.println("Unregistered email is not accepted"); //print message to the console if unregistered email is not accepted
        }
        catch (AssertionError e) {
            Assert.fail("Logged in with unregistered email!"); //print message to the console if user is allowed to login with unregistered email
        }
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "LoginWithInvalidPass_TestDataProvider", priority = 1, enabled = true,description = "Login")
    public void loginRU_RegisteredEmail_InvalidPass(String email, String pass) throws Exception {
        pageResources.getLoginPage().enterLoginEmail(email); //enter email
        pageResources.getLoginPage().enterPassword(pass); //enter password
        pageResources.getLoginPage().clickLoginButton(); //click Login button
        Thread.sleep(1000); //wait 1 second for page to be loaded - other types of wait do not work here
        try {
            Assert.assertEquals(driver.getCurrentUrl(), baseUrl); //assert that user is not allowed to log in with invalid password, and is not redirected to another page
            System.out.println("Invalid password is not accepted"); //print message to the console if invalid password is not accepted
        }
        catch (AssertionError e) {
            Assert.fail("Logged in with invalid password!"); //print message to the console if user can log in with invalid password
        }
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "LoginWithBlankPass_TestDataProvider", priority = 1, enabled = true,description = "Login")
    public void loginRU_ValidEmail_BlankPass(String email, String pass) throws Exception {
        pageResources.getLoginPage().enterLoginEmail(email); //enter email
        pageResources.getLoginPage().enterPassword(pass); //enter password
        pageResources.getLoginPage().clickLoginButton(); //click Login button
        Thread.sleep(1000); //wait 1 second for page to be loaded - other types of wait do not work here
        try {
            Assert.assertEquals(driver.getCurrentUrl(), baseUrl); //assert that user is not allowed to log in if password field is blank, and is not redirected to another page
            System.out.println("Blank password field is not accepted"); } //print message to the console that blank password field is not accepted
        catch (AssertionError e) {
            Assert.fail("Logged in with blank password!"); //print message to the console if user can log in with blank password field
        }
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "LoginWithBlankEmail_TestDataProvider", priority = 1, enabled = true,description = "Login")
    public void loginRU_BlankEmail_ValidPass(String email, String pass) throws Exception {
        pageResources.getLoginPage().enterLoginEmail(email); //enter email
        pageResources.getLoginPage().enterPassword(pass); //enter password
        pageResources.getLoginPage().clickLoginButton(); //click Login button
        Thread.sleep(1000); //wait 1 second for page to be loaded - other types of wait do not work here
        try {
            Assert.assertEquals(driver.getCurrentUrl(), baseUrl); //assert that user is not allowed to log in if email field is blank, and is not redirected to another page
            System.out.println("Blank email field is not accepted"); } //print message to the console that blank email field is not accepted
        catch (AssertionError e) {
            Assert.fail("Logged in with blank email!"); //print message to the console if user can log in with blank email field
        }
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "LoginWithBlankEmailAndPass_TestDataProvider", priority = 2, enabled = true,description = "Login")
    public void loginRU_BlankEmail_BlankPass(String email, String pass) throws Exception {
        pageResources.getLoginPage().enterLoginEmail(email); //enter email
        pageResources.getLoginPage().enterPassword(pass); //enter password
        pageResources.getLoginPage().clickLoginButton(); //click Login button
        Thread.sleep(1000); //wait 1 second for page to be loaded - other types of wait do not work here
        try {
            Assert.assertEquals(driver.getCurrentUrl(), baseUrl); //assert that user is not allowed to log in if email and password fields are blank, and is not redirected to another page
            System.out.println("Blank email and password fields are not accepted"); } //print message to the console that blank email and password fields are not accepted
        catch (AssertionError e) {
            Assert.fail("Logged in with blank email and password fields!"); //print message to the console if user can log in with blank email and password fields
        }
    }
}
