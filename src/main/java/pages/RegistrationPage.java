package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;

    //  constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    //  page elements
    @FindBy(xpath = "//span[@class='fa fa-check']")
    WebElement scoutCheckbox;

    @FindBy(id = "signUpFirstName")
    WebElement firstNameField;

    @FindBy(id = "signUpLastName")
    WebElement lastNameField;

    @FindBy(id = "signUpCounty")
    WebElement countryField;

    @FindBy(id = "signUpAddress")
    WebElement addressField;

    @FindBy(id = "signUpPhone")
    WebElement phoneField;

    @FindBy(id = "signUpRegisterEmail")
    WebElement emailField;

    @FindBy(id = "signUpRegisterPassword")
    WebElement passwordField;

    @FindBy(id = "signUpRegisterRePassword")
    WebElement repeatPasswordField;

    @FindBy(id = "createAccount")
    WebElement createAccountButton;


    //  page services
    public void checkScoutCheckbox() {
        scoutCheckbox.click();
    }

    public void enterUserFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterUserLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterCountry(String country) {
        countryField.sendKeys(country);
    }

    public void enterAddress(String address) {
        addressField.sendKeys(address);
    }

    public void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void reEnterPassword(String password) {
        repeatPasswordField.sendKeys(password);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }
}
//        public void assertions1() {
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginEmail"))).sendKeys(email);
//                driver.findElement(By.id("password")).sendKeys(password);
//                driver.findElement(By.id("login")).click();

                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*/tbody/tr/td/a)[1]"))).click();

                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
                //String errorName = driver.findElement(By.id("firstName")).getText();
                //Assert.assertEquals(errorName, firstName);
                //JavascriptExecutor js = (JavascriptExecutor) driver;
               // System.out.println(js.executeScript("firstName"));



