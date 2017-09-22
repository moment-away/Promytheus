package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class NewTalentPage {
    private WebDriver driver; //creating a new instance of WebDriver
    private WebDriverWait wait; //creating a new instance of WebDriverWait

    // constructor
    public NewTalentPage(WebDriver driver) {
        this.driver = driver; //creating new instance of driver
        wait = new WebDriverWait(driver, 5); //specifying for how long WebDriverWait should wait before test fails
        PageFactory.initElements(driver, this); //initializing PageFactory tools
    }

    // page elements
    @FindBy(xpath = "(//span[@class='fa fa-circle'])[2]") //specifying xpath to find an element on the page
    public WebElement radiobtnSelfTalent; //radiobutton Yourself in the popup window

    @FindBy(xpath = "(//span[@class='fa fa-circle'])[1]") //specifying xpath to find an element on the page
    public WebElement radiobtnOtherTalent; //radiobutton Other Talent in the popup window

    @FindBy(xpath = ("//button[@class='confirm']")) //specifying xpath to find an element on the page
    public WebElement confirmBtnInPopupWindow; //button Confirm in the popup window

    @FindBy(xpath = "//a[@class='btn btn-default btn-outline mr']") //specifying xpath to find an element on the page
    public WebElement newTalentButton; //button New Talent

    @FindBy(xpath = "//span[@class='btn btn-default form-control ui-select-toggle']") //specifying xpath to find an element on the page
    public WebElement selectCategoryDropdown; //arrow to open dropdown with categories

    @FindBy(xpath = "(//span[@class='ui-select-choices-row-inner'])[13]") //specifying xpath to find an element on the page
    public WebElement categoryInDropdown; //dropdown with categories of a talent

    @FindBy(id = "firstName") //specifying id to find an element on the page
    public WebElement firstNameField; // input field First name

    @FindBy(id = "middleName") //specifying id to find an element on the page
    public WebElement middleNameField; // input field Middle name

    @FindBy(id = "lastName") //specifying id to find an element on the page
    public WebElement lastNameField; // input field Last name

    @FindBy(id = "dateBirth") //specifying id to find an element on the page
    public WebElement dobField; // input field Date of birth

    @FindBy(id = "placeBirth") //specifying id to find an element on the page
    public WebElement placeOfBirthField; //input field Place of birth

    @FindBy(id = "country") //specifying id to find an element on the page
    public WebElement countryField; //input field Country

    @FindBy(id = "address") //specifying id to find an element on the page
    public WebElement addressField; //input field Address

    @FindBy(xpath = "//input[@name='location']") //specifying xpath to find an element on the page
    public List<WebElement> chooseLocations; //radiobuttons to choose Location

    @FindBy(xpath = "//input[@name='state']") //specifying xpath to find an element on the page
    public List<WebElement> chooseLocationStatusBtn; //radiobuttons to choose Status of location

    @FindBy(id = "email") //specifying id to find an element on the page
    public WebElement emailField; //input field Email

    @FindBy(id = "phone") //specifying id to find an element on the page
    public WebElement phoneField; //input field Phone

    @FindBy(xpath = "//a[@class='social-account-more ng-binding']") //specifying xpath to find an element on the page
    public WebElement socialAccountLink; //link to add social account

    @FindBy(xpath = "//span[@class='ui-select-placeholder text-muted ng-binding']") //specifying xpath to find an element on the page
    public WebElement socialAccountDropdown; //dropdown to select social network

    @FindBy(id = "ui-select-choices-row-1-0") //specifying id to find an element on the page
    public WebElement facebookOption; //line with Facebook option

    @FindBy(xpath = "//div[@class='col-lg-9']/input") //specifying xpath to find an element on the page
    public WebElement facebookAccount; //input field Social account

    @FindBy(id = "height") //specifying id to find an element on the page
    public WebElement heightField; //input field Height

    @FindBy(id = "weight") //specifying id to find an element on the page
    public WebElement weightField; //input field Weight

    @FindBy(xpath = "//button[@class='btn btn-primary ng-binding'][text()='Next']") //specifying xpath to find an element on the page
    public WebElement btnNext; //button Next

    @FindBy(name = "trainingHistory") //specifying name to find an element on the page
    public WebElement trainingHistoryOption; //dropdown to choose years of training

    @FindBy(xpath = "(//input[@name='coached'])[2]") //specifying xpath to find an element on the page
    public WebElement coachedOption; //radiobuttons to choose if talent was coached

    @FindBy(xpath = "(//input[@name='training'])[1]") //specifying xpath to find an element on the page
    public WebElement trainingOption; //choose training option

    @FindBy(name = "schoolName") //specifying name to find an element on the page
    public WebElement schoolNameField; //input field for School or college name

    @FindBy(name = "schoolSuccessLevel") //specifying name to find an element on the page
    public WebElement schoolSuccessLevelField; //input field for academic success level

    @FindBy(name = "skill") //specifying name to find an element on the page
    public List<WebElement> skills; //radiobutton to choose skills level

    @FindBy(xpath = "(//span[@class='fa fa-check'])[2]") //specifying xpath to find an element on the page
    public WebElement testimoniesList; //checkbox to choose source of testimonies (family, friends, etc.)

    @FindBy(name = "testimony0") //specifying name to find an element on the page
    public WebElement testimonyField; //input field Testimony

    @FindBy(name = "workProduct") //specifying name to find an element on the page
    public WebElement workProductField; //input field Work product

    @FindBy(xpath = "(//span[@class='fa fa-circle'])[12]") //specifying xpath to find an element on the page
    public WebElement familyIncomeLevel; //radiobutton to choose income level

    @FindBy(xpath = "//input[@placeholder='USD']") //specifying xpath to find an element on the page
    public WebElement familyIncomeField; //input field for income amount

    @FindBy(name = "headline") //specifying name to find an element on the page
    public WebElement headlineField; //input field Headline

    @FindBy(name = "discoveryYears") //specifying name to find an element on the page
    public WebElement discoveryYearsField; //input field for age, when talent was discovered

    @FindBy(name = "interestLevel") //specifying name to find an element on the page
    public WebElement interestLevelOption; //radiobutton to choose interest level

    @FindBy(id = "talentGutFeel") //specifying id to find an element on the page
    public WebElement talentGutFeelField; //input field for Gut feel

    @FindBy(id = "rationalGutFeel")  //specifying id to find an element on the page
    public WebElement talentRationaleField; //input field for Rational reason for gut feel

    @FindBy(id = "independentScore") //specifying id to find an element on the page
    public WebElement scoreField; //input field Score

    @FindBy(id = "relativeRankAmongTalents") //specifying id to find an element on the page
    public WebElement rankField; //input field Rank

    @FindBy(name = "categoryTrait0") //specifying name to find an element on the page
    public WebElement tTrait1; //input field for talent trait

    @FindBy(name = "categoryTrait2") //specifying name to find an element on the page
    public WebElement tTrait2; //input field for talent trait

    @FindBy(name = "categoryTrait3") //specifying name to find an element on the page
    public WebElement tTrait3; //input field for talent trait

    @FindBy(xpath = "(//span[@class='fa fa-check'])[5]") //specifying xpath to find an element on the page
    public WebElement personalTrait1; //checkbox for personal trait

    @FindBy(xpath = "(//span[@class='fa fa-check'])[7]") //specifying xpath to find an element on the page
    public WebElement personalTrait2; //checkbox for personal trait

    @FindBy(xpath = "(//span[@class='fa fa-check'])[8]") //specifying xpath to find an element on the page
    public WebElement personalTrait3; //checkbox for personal trait

    @FindBy(xpath = "//button[@class='btn btn-primary ng-binding'][text()='Finish']") //specifying xpath to find an element on the page
    public WebElement finishButton; //button Finish

    @FindBy(xpath = "//em[@class='icon-user']") //specifying xpath to find an element on the page
    public WebElement myProfileIcon; //icon My Profile at the top of the page

    @FindBy(xpath = "//p[@class='m0'][text()='Sign Out']") //specifying xpath to find an element on the page
    public WebElement signOutButton; //option Sign Out in the My Profile dropdown

    @FindBy(xpath = "(//a[@class='ng-binding'])[1]") //specifying xpath to find an element on the page
    public WebElement firstTalentRecordOnPage; //link to the last added talent

    //  page services
    public void selectSelfTalent() {
        radiobtnSelfTalent.click(); //choose to report talent of yourself in the popup window
    }

    public void selectOtherTalent() {
        radiobtnOtherTalent.click(); //choose to report other's talent in the popup window
    }

    public void clickConfirmButtonInPopupWindow() {
        confirmBtnInPopupWindow.click(); //click Confirm button in the popup window
    }

    public void clickNewButton() {
        newTalentButton.click(); //click button New to create new talent
    }

    public void selectCategory() {
        JavascriptExecutor ex = (JavascriptExecutor) driver; //initialize driver to execute Javascript
        ex.executeScript("arguments[0].click();", selectCategoryDropdown);
        categoryInDropdown.click();
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterMiddleName(String middleName) {
        middleNameField.sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterDOB(String dob) {
        dobField.sendKeys(dob);
    }

    public void enterPlaceOfBirth(String placeOfBirth) {
        placeOfBirthField.sendKeys(placeOfBirth);
    }

    public void enterAddress(String address) {
        addressField.sendKeys(address);
    }

    public void chooseLocation() {
        List<WebElement> locations = chooseLocations;
        Random random = new Random();
        int indexL = random.nextInt(locations.size());
        locations.get(indexL).click();
    }

    public void chooseLocationStatus() {
        List<WebElement> states = chooseLocationStatusBtn;
        Random random = new Random();
        int indexLS = random.nextInt(states.size());
        states.get(indexLS).click();
    }

    public void enterTalentEmail(String newEmail) {
        emailField.sendKeys(newEmail);
    }

    public void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public void addSocialAccount() {
        socialAccountLink.click();
    }

    public void openSocialAccsDropdown() {
        socialAccountDropdown.click();
    }

    public void addFacebookAccount() {
        facebookOption.click();
    }

    public void enterFacebookAccount(String socialAccount) {
        facebookAccount.sendKeys(socialAccount);
    }

    public void enterHeight(String height) {
        heightField.sendKeys(height);
    }

    public void enterWeight(String weight) {
        weightField.sendKeys(weight);
    }

    public void clickNextButton() {
        btnNext.click();
    }

    public void chooseTrainingHistory() {
        WebElement training = trainingHistoryOption;
        Select s = new Select(training);
        s.selectByIndex(1);
    }

    public void chooseIfCoached() {
        coachedOption.click();
    }

    public void chooseTypeOfTraining() {
        trainingOption.click();
    }

    public void enterSchoolName(String college) {
        schoolNameField.sendKeys(college);
    }

    public void enterSuccessLevel(String successLevel) {
        schoolSuccessLevelField.sendKeys(successLevel);
    }

    public void chooseSkillsLevel() {
        List<WebElement> skill = skills;
        Random random = new Random();
        int indexS = random.nextInt(skill.size());
        skill.get(indexS).click();
    }

    public void chooseTestimonies() {
        testimoniesList.click();
    }

    public void enterTestimony(String evidence) {
        testimonyField.sendKeys(evidence);
    }

    public void enterWorkProduct(String workProduct) {
        workProductField.sendKeys(workProduct);
    }

    public void chooseFamilyIncome() {
        familyIncomeLevel.click();
    }

    public void enterFamilyIncome(String income) {
        familyIncomeField.sendKeys(income);
    }

    public void enterHeadline(String headline) {
        headlineField.sendKeys(headline);
    }

    public void enterYears(String years) {
        discoveryYearsField.sendKeys(years);
    }

    public void chooseInterestLevel() {
        WebElement interestLevel = interestLevelOption;
        Select s = new Select(interestLevel);
        s.selectByIndex(1);
    }

    public void enterGutFeel(String gutFeel) {
        talentGutFeelField.sendKeys(gutFeel);
    }

    public void enterRationale(String rationale) {
        talentRationaleField.sendKeys(rationale);
    }

    public void enterScore(String score) {
        scoreField.sendKeys(score);
    }

    public void enterRank(String rank) {
        rankField.sendKeys(rank);
    }

    public void selectTalentTrait1(String talentTrait1) {
        tTrait1.sendKeys(talentTrait1);
    }

    public void selectTalentTrait2(String talentTrait2) {
        tTrait2.sendKeys(talentTrait2);
    }

    public void selectTalentTrait3(String talentTrait3) {
        tTrait3.sendKeys(talentTrait3);
    }

    public void selectPersonalityTrait1() {
        personalTrait1.click();
    }

    public void selectPersonalityTrait2() {
        personalTrait2.click();
    }

    public void selectPersonalityTrait3() {
        personalTrait3.click();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public void clickMyProfileIcon() {
        myProfileIcon.click();
    }

    public void signOut() {
        signOutButton.click();
    }

    public void selectLastTalent() {
        firstTalentRecordOnPage.click();
    }
}


//    public void uploadTalentPicture (String talentPicture) {
//    driver.findElement(By.xpath("//div[@class='file-upload']")).sendKeys(talentPicture);
//    driver.findElement(By.id("filestyle-0")).sendKeys("C:\\vodka\\Selenium.jpg");