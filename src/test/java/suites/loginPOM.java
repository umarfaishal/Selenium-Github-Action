package suites;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import pageObjects.loginPage;

import java.time.Duration;

public class loginPOM {
    @Test
    public void loginWithPOM(){
        //Defining and locate chrome driver location
        System.setProperty("webdriver.chrome.driver","C:\\Users\\alvin\\IdeaProjects\\BtechS9-UIAutomation\\src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        loginPage loginpage = new loginPage(driver, wait);

        //Base URL
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        //Open Chrome and set the url
        driver.get(baseUrl);

        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        //Assert title and url'
        Assertions.assertEquals("kasirAja",title);
        Assertions.assertEquals("https://kasirdemo.belajarqa.com/login",url);

        //Get Element Email & Input data
        loginpage.inputEmail("alvin@btech.com");

        //click element login button
        loginpage.clickBtnLogin();

        //get error message
        loginpage.assertErrMsgEmptyPassword();

        //close chrome
        driver.close();
    }
}