package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {
    WebDriver driver;
    WebDriverWait wait;

    //Construct web driver
    public loginPage(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }

    //Locator
    By fieldEmail = By.id("email");
    By fieldPass = By.id("password");

    By btnLogin = By.xpath("//*[contains(text(),'login')]");

    By errMsgEmptyPass = By.xpath("//*[contains(text(),'is not allowed to be empty')]");

    //Method or function to do the task
    //Input email
    public void inputEmail(String email){
        driver.findElement(fieldEmail).sendKeys(email);
    }
    //Input password
    public void inputPassword(String password){
        driver.findElement(fieldPass).sendKeys(password);
    }

    //Input blank password
    public void inputBlankPassword(){
        driver.findElement(fieldPass).sendKeys("");
    }

    //click button Login
    public void clickBtnLogin(){
        driver.findElement(btnLogin).click();
    }

    //Assert err msg empty password
    public void assertErrMsgEmptyPassword(){
        //get error message
        //wait
        wait.until(ExpectedConditions.presenceOfElementLocated(errMsgEmptyPass));
        //assert element
        driver.findElement(errMsgEmptyPass).isDisplayed();
    }
}