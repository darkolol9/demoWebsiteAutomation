package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import theInternet.KeyPressesPage;

public class KeyPressesTest {
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void innit() {
        driver.set(new ChromeDriver());
        driver.get().get("http://the-internet.herokuapp.com/key_presses");
    }

    @Test(dataProvider = "getLetters",dataProviderClass = LettersProvider.class)
    public void test(String c) {

        KeyPressesPage kp = PageFactory.initElements(driver.get(),KeyPressesPage.class);
        kp.writeIntoBar(c);
        Assert.assertTrue(kp.verifyResult(c));
        //System.out.println("verification test for:"+  c + ":" + kp.getResult().substring(13) + " " + kp.verifyResult(c));

    }

    @AfterMethod
    public void close() {
        driver.get().close();
    }

}
