package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstLoginUserPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FirstLoginUserPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        driver.get("http://52.53.181.39");
    }

    public void firstLoginUserPage() throws InterruptedException {

        driver.findElement(By.id("register")).click();

        String firstName = RandomStringUtils.randomAlphabetic(5).toLowerCase();
        String lastName = RandomStringUtils.randomAlphabetic(7).toLowerCase();
        String aN = RandomStringUtils.randomNumeric(4);
        String aS = RandomStringUtils.randomAlphabetic(7);
        String aC = RandomStringUtils.randomAlphabetic(6);
        String phone = RandomStringUtils.randomNumeric(10);
        String email = firstName + "@getnada.com";
        String password = RandomStringUtils.randomAlphanumeric(6);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("address")).sendKeys(aN + " " + aS + ", " + aC);
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.findElement(By.id("registerEmail")).sendKeys(email);
        driver.findElement(By.id("registerPassword")).sendKeys(password);
        driver.findElement(By.id("registerRePassword")).sendKeys(password);
        driver.findElement(By.id("createAccount")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginEmail"))).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class='fa fa-circle'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='confirm']")).click();
    }
    public void firstLoginUserPage_OtherTalent() throws InterruptedException {

        driver.findElement(By.id("register")).click();

        String firstName = RandomStringUtils.randomAlphabetic(5).toLowerCase();
        String lastName = RandomStringUtils.randomAlphabetic(7).toLowerCase();
        String aN = RandomStringUtils.randomNumeric(4);
        String aS = RandomStringUtils.randomAlphabetic(7);
        String aC = RandomStringUtils.randomAlphabetic(6);
        String phone = RandomStringUtils.randomNumeric(10);
        String email = firstName + "@getnada.com";
        String password = RandomStringUtils.randomAlphanumeric(6);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("address")).sendKeys(aN + " " + aS + ", " + aC);
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.findElement(By.id("registerEmail")).sendKeys(email);
        driver.findElement(By.id("registerPassword")).sendKeys(password);
        driver.findElement(By.id("registerRePassword")).sendKeys(password);
        driver.findElement(By.id("createAccount")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginEmail"))).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class='fa fa-circle'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='confirm']")).click();
    }

}
