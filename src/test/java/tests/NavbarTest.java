package tests;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.NavBarPage;

import java.util.concurrent.TimeUnit;

public class NavbarTest {

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    ChromeOptions options = new ChromeOptions();


    @BeforeMethod
    public void innit() {
        options.addArguments("--headless");
        driver.set(new ChromeDriver());
    }

    @Test
    @Description("Testing wether we get 404 in all navbar pages")
    public void test1() {
        driver.get().get("http://the-internet.herokuapp.com/disappearing_elements");
        driver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        NavBarPage nvp = PageFactory.initElements(driver.get(),NavBarPage.class);

        nvp.goHome();
        //Assert.assertTrue(nvp.verifyPage());
        nvp.goBack();

        nvp.goAbout();
        //Assert.assertTrue(nvp.verifyPage());
        nvp.goBack();

        nvp.goContact();
        //Assert.assertTrue(nvp.verifyPage());
        nvp.goBack();

        nvp.goPortfolio();
        //Assert.assertTrue(nvp.verifyPage());
        nvp.goBack();
    }

    @AfterMethod
    public void close() {
        driver.get().close();
    }

}
