package testResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class PageResources {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    FirstLoginUserPage firstLoginUserPage;
    NewTalentPage newTalentPage;

    public PageResources (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public LoginPage getLoginPage() {
        return loginPage = new LoginPage(driver);
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage = new RegistrationPage(driver);
    }

    public FirstLoginUserPage getFirstLoginUserPage() {
        return firstLoginUserPage = new FirstLoginUserPage(driver);
    }

    public NewTalentPage getNewTalentPage() {
        return newTalentPage = new NewTalentPage(driver);
    }
}
