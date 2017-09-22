package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //  constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    //  page elements
    @FindBy(name = "email")
    WebElement loginEmail;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(xpath = "//a[@class='btn btn-block btn-default']")
    WebElement registerButton;

    @FindBy(css="body>app>splash-screen>div")
    WebElement cover;

    @FindBy(xpath = "//div[@class='alert alert-danger ng-binding ng-scope']")
    WebElement errorMessage;

    //  page services
    public void enterLoginEmail(String email) {loginEmail.sendKeys(email);}

    public void enterPassword(String pass) {password.sendKeys(pass);}

    public void clickLoginButton() {loginButton.click();}

    public void clickRegisterButton() {
        registerButton.click();
    }

    public  void killCover() {
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].parentNode.removeChild(arguments[0]);",cover);
        System.out.println("Cover killed");
    }
}