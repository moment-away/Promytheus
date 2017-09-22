import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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



public class NewTalent_Scout {
    String baseUrl = "http://52.53.181.39/sign-in.html"; //Promytheus home page
    private WebDriver driver; //creating new instance of driver
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
    public void newTalent_scout_reg(String firstName, String lastName, String country, String address, String phone,
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
        Thread.sleep(1000);
        pageResources.getRegistrationPage().checkScoutCheckbox();
        pageResources.getRegistrationPage().enterUserFirstName(firstName);
        pageResources.getRegistrationPage().enterUserLastName(lastName);
        pageResources.getRegistrationPage().enterCountry(country);
        pageResources.getRegistrationPage().enterAddress(address);
        pageResources.getRegistrationPage().enterPhone(phone);
        pageResources.getRegistrationPage().enterEmail(email);
        pageResources.getRegistrationPage().enterPassword(password);
        pageResources.getRegistrationPage().reEnterPassword(password);
        pageResources.getRegistrationPage().clickCreateAccountButton();
        System.out.println("Registration completed");
        try {
            pageResources.getLoginPage().enterLoginEmail(email);
        }
        catch (Exception e) {
            Thread.sleep(1000);
            pageResources.getLoginPage().killCover();
            pageResources.getLoginPage().enterLoginEmail(email);
        }
        pageResources.getLoginPage().enterPassword(password);
        pageResources.getLoginPage().clickLoginButton();
        System.out.println("User is successfully logged in");

        File writeFile = new File("C:/vodka/doc.txt");
        PrintWriter pw = new PrintWriter(writeFile);
        pw.println(email);
        pw.println(password);
        pw.close();
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "NewTalent_TestDataProvider", enabled = true, priority = 1, description = "NewTalentOther")
    public void newTalent_scout_talent(String firstName, String middleName, String lastName, String dob, String placeOfBirth,
                                          String address, String newEmail, String phone, String socialAccount, String height, String weight,
                                          String college, String successLevel, String evidence, String workProduct, String income,
                                          String headline, String years, String gutFeel, String rationale, String score, String rank,
                                          String talentTrait1, String talentTrait2, String talentTrait3) throws Exception {
        pageResources.getNewTalentPage().clickNewButton();
        pageResources.getNewTalentPage().selectCategory();
        pageResources.getNewTalentPage().clickNextButton();
        pageResources.getNewTalentPage().enterFirstName(firstName);
        pageResources.getNewTalentPage().enterMiddleName(middleName);
        pageResources.getNewTalentPage().enterLastName(lastName);
        pageResources.getNewTalentPage().enterDOB(dob);
        pageResources.getNewTalentPage().enterPlaceOfBirth(placeOfBirth);
        pageResources.getNewTalentPage().enterAddress(address);
        pageResources.getNewTalentPage().chooseLocation();
        pageResources.getNewTalentPage().chooseLocationStatus();
        pageResources.getNewTalentPage().enterTalentEmail(newEmail);
        pageResources.getNewTalentPage().enterPhone(phone);
        pageResources.getNewTalentPage().addSocialAccount();
        pageResources.getNewTalentPage().openSocialAccsDropdown();
        pageResources.getNewTalentPage().addFacebookAccount();
        pageResources.getNewTalentPage().enterFacebookAccount(socialAccount);
        pageResources.getNewTalentPage().enterHeight(height);
        pageResources.getNewTalentPage().enterWeight(weight);
        pageResources.getNewTalentPage().clickNextButton();
        pageResources.getNewTalentPage().chooseTrainingHistory();
        pageResources.getNewTalentPage().chooseIfCoached();
        pageResources.getNewTalentPage().chooseTypeOfTraining();
        pageResources.getNewTalentPage().enterSchoolName(college);
        pageResources.getNewTalentPage().enterSuccessLevel(successLevel);
        pageResources.getNewTalentPage().chooseSkillsLevel();
        pageResources.getNewTalentPage().clickNextButton();
        pageResources.getNewTalentPage().chooseTestimonies();
        pageResources.getNewTalentPage().enterTestimony(evidence);
        pageResources.getNewTalentPage().enterWorkProduct(workProduct);
        pageResources.getNewTalentPage().clickNextButton();
        pageResources.getNewTalentPage().chooseFamilyIncome();
        pageResources.getNewTalentPage().enterFamilyIncome (income);
        pageResources.getNewTalentPage().clickNextButton();
        pageResources.getNewTalentPage().enterHeadline(headline);
        pageResources.getNewTalentPage().enterYears(years);
        pageResources.getNewTalentPage().chooseInterestLevel();
        pageResources.getNewTalentPage().clickNextButton();
        pageResources.getNewTalentPage().enterGutFeel(gutFeel);
        pageResources.getNewTalentPage().enterRationale(rationale);
        Thread.sleep(1000);
        pageResources.getNewTalentPage().enterScore(score);
        Thread.sleep(1000);
        pageResources.getNewTalentPage().enterRank(rank);
        pageResources.getNewTalentPage().clickNextButton();
        Thread.sleep(1000);
        pageResources.getNewTalentPage().selectTalentTrait1(talentTrait1);
        pageResources.getNewTalentPage().selectTalentTrait2(talentTrait2);
        pageResources.getNewTalentPage().selectTalentTrait3(talentTrait3);
        pageResources.getNewTalentPage().clickNextButton();
        pageResources.getNewTalentPage().selectPersonalityTrait1();
        pageResources.getNewTalentPage().selectPersonalityTrait2();
        pageResources.getNewTalentPage().selectPersonalityTrait3();
        pageResources.getNewTalentPage().clickNextButton();
        pageResources.getNewTalentPage().clickFinishButton();
        pageResources.getNewTalentPage().clickMyProfileIcon();
        pageResources.getNewTalentPage().signOut();

        File writeFile = new File("C:/vodka/talentData.txt");
        PrintWriter pw = new PrintWriter(writeFile);
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
            s.useDelimiter("\\n"); //using delimiter to split data into separate lines
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
            s.useDelimiter("\\n"); //using delimiter to split data into separate lines
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
