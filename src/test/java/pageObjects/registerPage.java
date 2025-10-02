package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPage {
    WebDriver driver;

    //Consturct webdriver
    public registerPage(WebDriver driver){
        this.driver=driver;
    }

    //Locator
    By fieldEmail = By.id("email");
    By fieldPass = By.id("password");

    By btnLogin = By.xpath("//*[contains(text(),'daftar')]");

    By errMsgEmptyPass = By.xpath("//*[contains(text(),'is not allowed to be empty')]");
}