import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testResources.PageResources;
import testResources.TestData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NewTalent_RU_Other {

    String baseUrl = "http://52.53.181.39/sign-in.html";
    private WebDriver driver; //creating new instance of driver
    WebDriverWait wait;
    PageResources pageResources; //creating new instance of PageResources

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver(); //open Firefox browser
        driver.get(baseUrl); //open home page
        pageResources = new PageResources(driver); //get access to PageResources data
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait till all elements on the page are loaded
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit(); //close browser and quit driver
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "Registration_TestDataProvider", enabled = true, priority = 0, description = "NewTalentOther")
    public void newTalent_RU_other_reg(String firstName, String lastName, String country, String address, String phone,
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
        System.out.println("Registration completed"); //print message to the console if registration form was submitted
        // this block kills cover if it appears on the page
        try {
            pageResources.getLoginPage().enterLoginEmail(email); //enter email
        }
        catch (Exception e) {
            Thread.sleep(1000);
            pageResources.getLoginPage().killCover(); //kill cover if it appears on the page
            pageResources.getLoginPage().enterLoginEmail(email); //enter email
        }
        pageResources.getLoginPage().enterPassword(password); //enter password
        pageResources.getLoginPage().clickLoginButton(); //click Login button
        System.out.println("User is successfully logged in"); //print message to the console if user is successfully logged in
        //this block creates new files to store randomly generated data while executing this test case with the purpose of using them in the following test cases
        File writeFile = new File("C:/vodka/doc.txt"); //constructor, specifying the path to the directory, where file should be created
        PrintWriter pw = new PrintWriter(writeFile); //creating a new instance of PrintWriter
        pw.println(email); //writes email into the file
        pw.println(password); //writes email into the file
        pw.close(); //close PrintWriter
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "NewTalent_TestDataProvider", enabled = true, priority = 1, description = "NewTalentOther")
    public void newTalent_RU_other_talent(String firstName, String middleName, String lastName, String dob, String placeOfBirth,
                                String address, String newEmail, String phone, String socialAccount, String height, String weight,
                                String college, String successLevel, String evidence, String workProduct, String income,
                                String headline, String years, String gutFeel, String rationale, String score, String rank,
                                String talentTrait1, String talentTrait2, String talentTrait3) throws Exception {
        pageResources.getNewTalentPage().selectOtherTalent(); //select Other Talent radio button in the popup window
        pageResources.getNewTalentPage().clickConfirmButtonInPopupWindow(); //click Confirm button in the popup window
        wait.until(ExpectedConditions.visibilityOf(pageResources.getNewTalentPage().newTalentButton)); //wait until New talent button becomes visible
        pageResources.getNewTalentPage().clickNewButton(); //click New talent button
        pageResources.getNewTalentPage().selectCategory(); //select category of the talent
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().enterFirstName(firstName); //enter first name
        pageResources.getNewTalentPage().enterMiddleName(middleName); //enter middle name
        pageResources.getNewTalentPage().enterLastName(lastName); //enter last name
        pageResources.getNewTalentPage().enterDOB(dob); //enter date of birth
        pageResources.getNewTalentPage().enterPlaceOfBirth(placeOfBirth); //enter place of birth
        pageResources.getNewTalentPage().enterAddress(address); //enter address
        pageResources.getNewTalentPage().chooseLocation(); //choose location of the talent
        pageResources.getNewTalentPage().chooseLocationStatus(); //choose location status
        pageResources.getNewTalentPage().enterTalentEmail(newEmail); //enter talent's email
        pageResources.getNewTalentPage().enterPhone(phone); //enter phone number
        pageResources.getNewTalentPage().addSocialAccount(); //click link to add social account
        pageResources.getNewTalentPage().openSocialAccsDropdown(); //open dropdown list with social networks
        pageResources.getNewTalentPage().addFacebookAccount(); //choose Facebook frfom the dropdown list
        pageResources.getNewTalentPage().enterFacebookAccount(socialAccount); //enter Facebook account
        pageResources.getNewTalentPage().enterHeight(height); //enter height
        pageResources.getNewTalentPage().enterWeight(weight); //enter weight
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().chooseTrainingHistory(); //choose how many years talent has been trained
        pageResources.getNewTalentPage().chooseIfCoached(); //choose if talent was coached
        pageResources.getNewTalentPage().chooseTypeOfTraining(); //choose type of training
        pageResources.getNewTalentPage().enterSchoolName(college); //enter school or college name
        pageResources.getNewTalentPage().enterSuccessLevel(successLevel); 
        pageResources.getNewTalentPage().chooseSkillsLevel();
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().chooseTestimonies();
        pageResources.getNewTalentPage().enterTestimony(evidence);
        pageResources.getNewTalentPage().enterWorkProduct(workProduct);
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().chooseFamilyIncome();
        pageResources.getNewTalentPage().enterFamilyIncome (income);
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().enterHeadline(headline);
        pageResources.getNewTalentPage().enterYears(years);
        pageResources.getNewTalentPage().chooseInterestLevel();
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().enterGutFeel(gutFeel);
        pageResources.getNewTalentPage().enterRationale(rationale);
        Thread.sleep(1000);
        pageResources.getNewTalentPage().enterScore(score);
        Thread.sleep(1000);
        pageResources.getNewTalentPage().enterRank(rank);
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        Thread.sleep(1000);
        pageResources.getNewTalentPage().selectTalentTrait1(talentTrait1);
        pageResources.getNewTalentPage().selectTalentTrait2(talentTrait2);
        pageResources.getNewTalentPage().selectTalentTrait3(talentTrait3);
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().selectPersonalityTrait1();
        pageResources.getNewTalentPage().selectPersonalityTrait2();
        pageResources.getNewTalentPage().selectPersonalityTrait3();
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().clickFinishButton(); //click Finish button
        pageResources.getNewTalentPage().clickMyProfileIcon();
        pageResources.getNewTalentPage().signOut();

        File writeFile = new File("C:/vodka/talentData.txt");
        PrintWriter pw = new PrintWriter(writeFile); //creating new instance of PrintWriter
        pw.println(firstName);
        pw.println(middleName);
        pw.println(lastName);
        pw.println(address);
        pw.println(newEmail);
        pw.println(placeOfBirth);
        pw.println(socialAccount);
        pw.println(height);
        pw.println(weight);
        pw.println(college);
        pw.println(evidence);
        pw.println(income);
        pw.println(headline);
        pw.println(rationale);
        pw.close();

        File readFile = new File("C:/vodka/doc.txt");
        try
        {
            Scanner s = new Scanner(readFile);
            s.useDelimiter("\\n");
            pageResources.getLoginPage().enterLoginEmail(s.nextLine());
            pageResources.getLoginPage().enterPassword(s.nextLine());
            pageResources.getLoginPage().clickLoginButton();
            s.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        pageResources.getNewTalentPage().selectLastTalent();
        Thread.sleep(2000);
        pageResources.getNewTalentPage().clickNextButton();
        Thread.sleep(1000);
        File readFile1 = new File("C:/vodka/talentData.txt");
        try
        {
            Scanner s = new Scanner(readFile1);
            s.useDelimiter("\\n");
            Assert.assertEquals(pageResources.getNewTalentPage().firstNameField.getAttribute("value"), s.nextLine());
            System.out.println("First name matches");
            Assert.assertEquals(pageResources.getNewTalentPage().middleNameField.getAttribute("value"), s.nextLine());
            System.out.println("Middle name matches");
            Assert.assertEquals(pageResources.getNewTalentPage().lastNameField.getAttribute("value"), s.nextLine());
            System.out.println("Last name matches");
            Assert.assertEquals(pageResources.getNewTalentPage().addressField.getAttribute("value"), s.nextLine());
            System.out.println("Address matches");
            Assert.assertEquals(pageResources.getNewTalentPage().emailField.getAttribute("value"), s.nextLine());
            System.out.println("Email matches");
            Assert.assertEquals(pageResources.getNewTalentPage().placeOfBirthField.getAttribute("value"), s.nextLine());
            System.out.println("Place of birth matches");
            Assert.assertEquals(pageResources.getNewTalentPage().facebookAccount.getAttribute("value"), s.nextLine());
            System.out.println("Facebook account matches");
            Assert.assertEquals(pageResources.getNewTalentPage().heightField.getAttribute("value"), s.nextLine());
            System.out.println("Height matches");
            Assert.assertEquals(pageResources.getNewTalentPage().weightField.getAttribute("value"), s.nextLine());
            System.out.println("Weight matches");
            pageResources.getNewTalentPage().clickNextButton();
            Assert.assertEquals(pageResources.getNewTalentPage().schoolNameField.getAttribute("value"), s.nextLine());
            System.out.println("School name matches");
            pageResources.getNewTalentPage().clickNextButton();
            Assert.assertEquals(pageResources.getNewTalentPage().testimonyField.getAttribute("value"), s.nextLine());
            System.out.println("Testimony text matches");
            pageResources.getNewTalentPage().clickNextButton();
            Assert.assertEquals(pageResources.getNewTalentPage().familyIncomeField.getAttribute("value"), s.nextLine());
            System.out.println("Income amount matches");
            pageResources.getNewTalentPage().clickNextButton();
            Assert.assertEquals(pageResources.getNewTalentPage().headlineField.getAttribute("value"), s.nextLine());
            System.out.println("Headline matches");
            pageResources.getNewTalentPage().clickNextButton();
            Assert.assertEquals(pageResources.getNewTalentPage().talentRationaleField.getAttribute("value"), s.nextLine());
            System.out.println("Rationale for gut feel matches");
            pageResources.getNewTalentPage().clickNextButton();
            s.close();
        }
        catch (AssertionError e)
        {
            e.printStackTrace();
            Assert.fail("Info does not match!");
        }
    }
}
