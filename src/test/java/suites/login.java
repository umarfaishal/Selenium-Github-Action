package suites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {

    public static void main(String[] args){
        WebDriver driver;
        //Defining and locate chrome driver location
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\alvin\\IdeaProjects\\BtechS9-UIAutomation\\src\\main\\resources\\driver\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);


        //Base URL
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        //Open Chrome and set the url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);

        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        //Assert title and url'
        Assertions.assertEquals("kasirAja",title);
        Assertions.assertEquals("https://kasirdemo.belajarqa.com/login",url);

        //Get Element Email & Input data
        driver.findElement(By.id("email")).sendKeys("contoh@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345");

        //click element
        driver.findElement(By.xpath("//*[contains(text(),'login')]")).click();

        //get error message
        //driver.findElement(By.xpath("//*[contains(text(),'\"password\" is not allowed to be empty')]")).isDisplayed();

        //close chrome
        driver.close();
    }
}