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
        pageResources.getNewTalentPage().addFacebookAccount(); //choose Facebook from the dropdown list
        pageResources.getNewTalentPage().enterFacebookAccount(socialAccount); //enter Facebook account
        pageResources.getNewTalentPage().enterHeight(height); //enter height
        pageResources.getNewTalentPage().enterWeight(weight); //enter weight
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().chooseTrainingHistory(); //choose how many years talent has been trained
        pageResources.getNewTalentPage().chooseIfCoached(); //choose if talent was coached
        pageResources.getNewTalentPage().chooseTypeOfTraining(); //choose type of training
        pageResources.getNewTalentPage().enterSchoolName(college); //enter school or college name
        pageResources.getNewTalentPage().enterSuccessLevel(successLevel); //enter academic success level
        pageResources.getNewTalentPage().chooseSkillsLevel(); //choose skills level
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().chooseTestimonies(); //choose source of testimonies (family, friends, etc.)
        pageResources.getNewTalentPage().enterTestimony(evidence); //enter testimony 
        pageResources.getNewTalentPage().enterWorkProduct(workProduct); //enter work product 
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().chooseFamilyIncome(); //choose level of family income 
        pageResources.getNewTalentPage().enterFamilyIncome (income); //enter amount of family income 
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().enterHeadline(headline); //enter headline 
        pageResources.getNewTalentPage().enterYears(years); //enter age when talent was discovered 
        pageResources.getNewTalentPage().chooseInterestLevel();  //choose interest level 
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().enterGutFeel(gutFeel); //enter gut feel about talent 
        pageResources.getNewTalentPage().enterRationale(rationale); //enter rational reason for gut feel
        pageResources.getNewTalentPage().enterScore(score); //enter score 
        pageResources.getNewTalentPage().enterRank(rank); //enter relative rank among other talents 
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().selectTalentTrait1(talentTrait1); //enter one of talent traits
        pageResources.getNewTalentPage().selectTalentTrait2(talentTrait2); //enter one of talent traits
        pageResources.getNewTalentPage().selectTalentTrait3(talentTrait3); //enter one of talent traits
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().selectPersonalityTrait1(); //select one of personal traits
        pageResources.getNewTalentPage().selectPersonalityTrait2(); //select one of personal traits
        pageResources.getNewTalentPage().selectPersonalityTrait3(); //select one of personal traits
        pageResources.getNewTalentPage().clickNextButton(); //click Next button
        pageResources.getNewTalentPage().clickFinishButton(); //click Finish button
        pageResources.getNewTalentPage().clickMyProfileIcon(); //click My Profile icon
        pageResources.getNewTalentPage().signOut(); //sign out from the account 
        //this block creates new files to store randomly generated data while executing this test case with the purpose of using them in the following test cases
        File writeFile = new File("C:/vodka/talentData.txt"); //constructor, specifying the path to the directory, where file should be created
        PrintWriter pw = new PrintWriter(writeFile); //creating new instance of PrintWriter
        pw.println(firstName); //write first name into the file 
        pw.println(middleName); //write middle name into the file 
        pw.println(lastName);  //write last name into the file
        pw.println(address); //write address into the file 
        pw.println(newEmail); //write talent's email into the file
        pw.println(placeOfBirth); //write place of birth into the file
        pw.println(socialAccount); //write social account into the file
        pw.println(height); //write height into the file
        pw.println(weight); //write weight into the file
        pw.println(college); //write college into the file
        pw.println(evidence); //write testimony into the file
        pw.println(income); //write income into the file
        pw.println(headline); //write headline into the file
        pw.println(rationale); //write rationale into the file
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
        pageResources.getNewTalentPage().selectLastTalent(); //select last added talent 
        pageResources.getNewTalentPage().clickNextButton(); //click Next button 
        File readFile1 = new File("C:/vodka/talentData.txt"); //constructor, specifying the path to the directory, where file is stored and should be read from
        try
        {
            Scanner s = new Scanner(readFile1);  //creating a new instance of Scanner
            s.useDelimiter("\\n"); //using delimiter to split data into separate lines
            Assert.assertEquals(pageResources.getNewTalentPage().firstNameField.getAttribute("value"), s.nextLine()); //assert that stored and entered first names match
            System.out.println("First name matches"); //print message to the console if first name matches
            Assert.assertEquals(pageResources.getNewTalentPage().middleNameField.getAttribute("value"), s.nextLine()); //assert that stored and entered middle names match
            System.out.println("Middle name matches"); //print message to the console if middle name matches
            Assert.assertEquals(pageResources.getNewTalentPage().lastNameField.getAttribute("value"), s.nextLine()); //assert that stored and entered last names match
            System.out.println("Last name matches"); //print message to the console if last name matches
            Assert.assertEquals(pageResources.getNewTalentPage().addressField.getAttribute("value"), s.nextLine()); //assert that stored and entered addresses match
            System.out.println("Address matches"); //print message to the console if address matches
            Assert.assertEquals(pageResources.getNewTalentPage().emailField.getAttribute("value"), s.nextLine()); //assert that stored and entered emails match
            System.out.println("Email matches"); //print message to the console if email matches
            Assert.assertEquals(pageResources.getNewTalentPage().placeOfBirthField.getAttribute("value"), s.nextLine()); //assert that stored and entered places of birth match
            System.out.println("Place of birth matches"); //print message to the console if place of birth matches
            Assert.assertEquals(pageResources.getNewTalentPage().facebookAccount.getAttribute("value"), s.nextLine()); //assert that stored and entered Facebook accounts match
            System.out.println("Facebook account matches"); //print message to the console if Facebook account matches
            Assert.assertEquals(pageResources.getNewTalentPage().heightField.getAttribute("value"), s.nextLine()); //assert that stored and entered height matches
            System.out.println("Height matches"); //print message to the console if height matches
            Assert.assertEquals(pageResources.getNewTalentPage().weightField.getAttribute("value"), s.nextLine()); //assert that stored and entered weight matches
            System.out.println("Weight matches"); //print message to the console if weight matches
            pageResources.getNewTalentPage().clickNextButton(); //click Next button
            Assert.assertEquals(pageResources.getNewTalentPage().schoolNameField.getAttribute("value"), s.nextLine()); //assert that stored and entered school name matches
            System.out.println("School name matches"); //print message to the console if school name matches
            pageResources.getNewTalentPage().clickNextButton(); //click Next Button
            Assert.assertEquals(pageResources.getNewTalentPage().testimonyField.getAttribute("value"), s.nextLine()); //assert that stored and entered testimony matches
            System.out.println("Testimony text matches"); //print message to the console if testimony matches
            pageResources.getNewTalentPage().clickNextButton(); //click Next button
            Assert.assertEquals(pageResources.getNewTalentPage().familyIncomeField.getAttribute("value"), s.nextLine()); //assert that stored and entered income matches
            System.out.println("Income amount matches"); //print message to the console if income amount matches
            pageResources.getNewTalentPage().clickNextButton(); //click Next button
            Assert.assertEquals(pageResources.getNewTalentPage().headlineField.getAttribute("value"), s.nextLine()); //assert that stored and entered headline macthes
            System.out.println("Headline matches"); //print message to the console if headline matches
            pageResources.getNewTalentPage().clickNextButton(); //click Next button
            Assert.assertEquals(pageResources.getNewTalentPage().talentRationaleField.getAttribute("value"), s.nextLine()); //assert that stored and entered rationale matches
            System.out.println("Rationale for gut feel matches"); //print message to the console if rationale matches 
            pageResources.getNewTalentPage().clickNextButton(); //click Next button
            s.close(); //close Scanner 
        }
        catch (AssertionError e)
        {
            e.printStackTrace();
            Assert.fail("Info does not match!"); //print message to the console if assertions fail, end info does not match 
        }
    }
}
