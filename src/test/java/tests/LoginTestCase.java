package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login;
import pages.Profile;

import java.util.concurrent.TimeUnit;

public class LoginTestCase {
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @BeforeMethod
    public void innitDriver() {
        driver.set(new ChromeDriver());
    }

    @AfterMethod
    public void closeBroswer() { driver.get().close();}

    @Test(dependsOnMethods = ("pre_test"))
    public void loginLogoutTest() {


        driver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get().get("https://demoqa.com/login");

        Login loginPage = PageFactory.initElements(driver.get(),Login.class);
        Profile profilePage = PageFactory.initElements(driver.get(),Profile.class);

        loginPage.LogIn_Action("darkolol9","Blackbear97!");
        profilePage.verifyUser("darkolol9");
        profilePage.logout_Action();
    }

    @Test
    public void pre_test() {
        System.out.println("this a test case to be dependent on...");
        Assert.assertTrue(true);
    }

}
