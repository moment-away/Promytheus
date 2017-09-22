import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import testResources.PageResources;
import testResources.TestData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*  Test Case "Verify that user can create a talent of themselves"
Instructions:
1. Go to home page.
2. Click Register button.
3. Fill out the registration form (enter proper information into the fields First Name, Last Name, Country, Address,
Phone, Email, Password).
4. Click Create Account button.
5. In the popup window, choose option Yourself.
6. Fill out the tabs og the New Talent form.
7. On the last tab, click Finish button.
8. Click My Profile icon in the top right corner of the window and choose Sign Out.
9. Log in into the application with valid credentials.
10. On the Talents page, choose the last created talent.
11. Observe that entered information is saved and correct.
Expected result: User should be able to report a talent of themselves.
 */

public class NewTalent_RU_Self {

    String baseUrl = "http://52.53.181.39/sign-in.html";
    private WebDriver driver; //creating new instance of driver
    WebDriverWait wait;
    PageResources pageResources; //creating new instance of PageResources

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver(); //open Firefox browser
        driver.get(baseUrl); //open home page
        pageResources = new PageResources(driver); //get access to PageResources class
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait till all elements on the page are loaded
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit(); //close browser and quit driver
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "Registration_TestDataProvider", enabled = true, priority = 0, description = "NewTalentSelf")
    public void newTalent_RU_Self_reg(String firstName, String lastName, String country, String address, String phone,
                                      String email, String password) throws Exception {
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
        System.out.println("Registration completed"); //print message to the console that registration is completed
        //this block kills cover overlapping the fields and buttons if it is present on the page
        try {
            pageResources.getLoginPage().enterLoginEmail(email); //enter email
        }
        catch (Exception e) {
            Thread.sleep(1000);
            pageResources.getLoginPage().killCover(); //kill cover overlapping the fields and buttons
            pageResources.getLoginPage().enterLoginEmail(email); //enter email
        }
        pageResources.getLoginPage().enterPassword(password); //enter password
        pageResources.getLoginPage().clickLoginButton(); // click Login button
        System.out.println("User is successfully logged in"); //print message to the console if user is logged in
        //this block creates new files to store randomly generated data while executing this test case with the purpose of using them in the following test cases
        File writeFile = new File("C:/vodka/doc.txt"); //constructor, specifying the path to the directory, where file should be created
        PrintWriter pw = new PrintWriter(writeFile); //creating a new instance of PrintWriter
        pw.println(email); //writes email into the file
        pw.println(password); //writes password into the file
        pw.close(); //close PrintWriter

        File writeFile1 = new File("C:/vodka/regData.txt"); //constructor, specifying the path to the directory, where file should be created
        PrintWriter pwr = new PrintWriter(writeFile1); //creating a new instance of PrintWriter
        pwr.println(firstName); //writes first name into the file
        pwr.println(lastName); //writes last name into the file
        pwr.println(country); //writes country into the file
        pwr.println(address); //writes address into the file
        pwr.println(email); //writes email into the file
        pwr.close(); //close PrintWriter
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "NewTalentRUself_TestDataProvider", enabled = true, priority = 1, description = "NewTalentSelf")
    public void newTalent_RU_Self_talent(String dob, String placeOfBirth, String socialAccount, String height, String weight,
                         String college, String successLevel, String evidence, String workProduct, String income,
                         String headline, String years, String gutFeel, String rationale, String score, String rank,
                         String talentTrait1, String talentTrait2, String talentTrait3) throws Exception {
        pageResources.getNewTalentPage().selectSelfTalent(); //click radiobutton Yourself in the popup window if user wants to report his/her own talent
        pageResources.getNewTalentPage().clickConfirmButtonInPopupWindow(); //click Confirm button in the popup window
        pageResources.getNewTalentPage().selectCategory(); //select category of the talent
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().enterDOB(dob); //enter date of birth
        pageResources.getNewTalentPage().enterPlaceOfBirth(placeOfBirth); //enter place of birth
        pageResources.getNewTalentPage().chooseLocation(); //choose location where talent lives
        pageResources.getNewTalentPage().chooseLocationStatus(); //choose status of the location
        pageResources.getNewTalentPage().addSocialAccount(); //click link Add to add social account to the profile
        pageResources.getNewTalentPage().openSocialAccsDropdown(); //open dropdown list to select Social network
        pageResources.getNewTalentPage().addFacebookAccount(); //choose Facebook
        pageResources.getNewTalentPage().enterFacebookAccount(socialAccount); //enter Facebook account into corresponding field
        pageResources.getNewTalentPage().enterHeight(height); //enter height
        pageResources.getNewTalentPage().enterWeight(weight); //enter weight
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().chooseTrainingHistory(); //choose years of training
        pageResources.getNewTalentPage().chooseIfCoached(); //choose if talent was professionally coached
        pageResources.getNewTalentPage().chooseTypeOfTraining(); //choose type of training
        pageResources.getNewTalentPage().enterSchoolName(college); //enter name of school or college
        pageResources.getNewTalentPage().enterSuccessLevel(successLevel); //enter academic success level
        pageResources.getNewTalentPage().chooseSkillsLevel(); //choose the level of skills
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().chooseTestimonies(); //choose source of testimonies (family, friends, etc.)
        pageResources.getNewTalentPage().enterTestimony(evidence); //enter text of testimony
        pageResources.getNewTalentPage().enterWorkProduct(workProduct); //enter work product
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().chooseFamilyIncome(); //choose the level of family income
        pageResources.getNewTalentPage().enterFamilyIncome (income); //enter amount of family income
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().enterHeadline(headline); // enter headline
        pageResources.getNewTalentPage().enterYears(years); //enter age when talent was discovered
        pageResources.getNewTalentPage().chooseInterestLevel(); //choose interest level
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().enterGutFeel(gutFeel); //enter gut feel for the talent
        pageResources.getNewTalentPage().enterRationale(rationale); //enter the reason for gut feel
        pageResources.getNewTalentPage().enterScore(score); //enter score
        pageResources.getNewTalentPage().enterRank(rank); //enter relative rank among other talents
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        wait.until(ExpectedConditions.visibilityOf(pageResources.getNewTalentPage().tTrait1)); //wait till the element becomes visible
        pageResources.getNewTalentPage().selectTalentTrait1(talentTrait1); //enter score for one of the talent traits
        pageResources.getNewTalentPage().selectTalentTrait2(talentTrait2); //enter score for one of the talent traits
        pageResources.getNewTalentPage().selectTalentTrait3(talentTrait3); //enter score for one of the talent traits
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().selectPersonalityTrait1(); //select one of the personality traits
        pageResources.getNewTalentPage().selectPersonalityTrait2(); //select one of the personality traits
        pageResources.getNewTalentPage().selectPersonalityTrait3(); //select one of the personality traits
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().clickFinishButton(); //click Finish button
        pageResources.getNewTalentPage().clickMyProfileIcon(); //click My Profile icon at the top of the page
        pageResources.getNewTalentPage().signOut(); //sign out of the account
        //this block creates new files to store randomly generated data while executing this test case with the purpose of using them in the following test cases
        File writeFile = new File("C:/vodka/talentData.txt"); //constructor, specifying the path to the directory, where file should be created
        PrintWriter pw = new PrintWriter(writeFile); //creating a new instance of PrintWriter
        pw.println(socialAccount); //writes social account into the file
        pw.println(height); //writes height into the file
        pw.println(weight); //writes weight into the file
        pw.println(college); //writes college name into the file
        pw.println(evidence); //writes testimony into the file
        pw.println(income); //writes amount of income into the file
        pw.println(headline); //writes headline into the file
        pw.println(rationale); //writes rationale into the file
        pw.close(); //close PrintWriter

        File readFile = new File("C:/vodka/doc.txt"); //constructor, specifying the path to the directory, where file is stored and should be read from
        try
        {
            Scanner s = new Scanner(readFile); //creating a new instance of Scanner
            s.useDelimiter("\\n"); //using delimiter to split data into separate lines
            pageResources.getLoginPage().enterLoginEmail(s.nextLine()); //read email from the file
            pageResources.getLoginPage().enterPassword(s.nextLine()); //read password from the file
            pageResources.getLoginPage().clickLoginButton(); //click Login button
            s.close(); //close Scanner
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(pageResources.getNewTalentPage().firstTalentRecordOnPage)); //wait for visibility of the element
        pageResources.getNewTalentPage().selectLastTalent(); //select last created talent
        wait.until(ExpectedConditions.visibilityOf(pageResources.getNewTalentPage().btnNext)); //wait for visibility of the element
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        Thread.sleep(1000); //wait 1 second for page to be loaded - other types of wait do not work here
        File readFile1 = new File("C:/vodka/regData.txt"); //constructor, specifying the path to the directory, where file is stored and should be read from
        try
        {
            Scanner s = new Scanner(readFile1); //creating a new instance of Scanner
            s.useDelimiter("\\n"); //using delimiter to split data into separate lines
            Assert.assertEquals(pageResources.getNewTalentPage().firstNameField.getAttribute("value"), s.nextLine()); //assert that stored and entered first names match
            System.out.println("First name matches"); //print message to the console if first name matches
            Assert.assertEquals(pageResources.getNewTalentPage().lastNameField.getAttribute("value"), s.nextLine()); //assert that stored and entered last names match
            System.out.println("Last name matches"); //print message to the console if last name matches
            Assert.assertEquals(pageResources.getNewTalentPage().countryField.getAttribute("value"), s.nextLine()); //assert that stored and entered  countries match
            System.out.println("Country matches"); //print message to the console if country matches
            Assert.assertEquals(pageResources.getNewTalentPage().addressField.getAttribute("value"), s.nextLine()); //assert that stored and entered addresses match
            System.out.println("Address matches"); //print message to the console if address matches
            Assert.assertEquals(pageResources.getNewTalentPage().emailField.getAttribute("value"), s.nextLine()); //assert that stored and entered emails match
            System.out.println("Email matches"); //print message to the console if email matches
            s.close(); //close Scanner
        }
        catch (AssertionError e)
        {
            e.printStackTrace();
            Assert.fail("Personal info does not match!"); //print message to the console if assertion fails and some info does not match
        }
        File readFile2 = new File("C:/vodka/talentData.txt"); //constructor, specifying the path to the directory, where file is stored and should be read from
        try {
            Scanner s = new Scanner(readFile2); //creating a new instance of Scanner
            s.useDelimiter("\\n"); //using delimiter to split data into separate lines
            Assert.assertEquals(pageResources.getNewTalentPage().facebookAccount.getAttribute("value"), s.nextLine()); //assert that stored and entered Facebook accounts match
            System.out.println("Facebook account matches"); //print message to the console if account matches
            Assert.assertEquals(pageResources.getNewTalentPage().heightField.getAttribute("value"), s.nextLine()); //assert that stored and entered height matches
            System.out.println("Height matches"); //print message to the console if height matches
            Assert.assertEquals(pageResources.getNewTalentPage().weightField.getAttribute("value"), s.nextLine()); //assert that stored and entered weight matches
            System.out.println("Weight matches"); //print message to the console if weight matches
            pageResources.getNewTalentPage().clickNextButton(); //click Next button
            Assert.assertEquals(pageResources.getNewTalentPage().schoolNameField.getAttribute("value"), s.nextLine()); //assert that stored and entered school names matches
            System.out.println("School name matches"); //print message to the console if school name matches
            pageResources.getNewTalentPage().clickNextButton(); //click Next button
            Assert.assertEquals(pageResources.getNewTalentPage().testimonyField.getAttribute("value"), s.nextLine()); //assert that stored and entered testimony matches
            System.out.println("Testimony text matches"); //print message to the console if testimony matches
            pageResources.getNewTalentPage().clickNextButton(); //click Next button
            Assert.assertEquals(pageResources.getNewTalentPage().familyIncomeField.getAttribute("value"), s.nextLine()); //assert that stored and entered income amount matches
            System.out.println("Income amount matches"); //print message to the console if income amount matches
            pageResources.getNewTalentPage().clickNextButton(); //click Next button
            Assert.assertEquals(pageResources.getNewTalentPage().headlineField.getAttribute("value"), s.nextLine()); //assert that stored and entered headline matches
            System.out.println("Headline matches"); //print message to the console if headline matches
            pageResources.getNewTalentPage().clickNextButton(); //click Next button
            Assert.assertEquals(pageResources.getNewTalentPage().talentRationaleField.getAttribute("value"), s.nextLine()); //assert that stored and entered rationale for gut feel matches
            System.out.println("Rationale for gut feel matches"); //print message to the console if rationale matches
        }
        catch (AssertionError e) {
            Assert.fail("Info does not match!"); //print message to the console if assertion fails and some info does not match
        }
    }
}
