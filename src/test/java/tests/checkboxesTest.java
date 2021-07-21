package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import theInternet.CheckBoxes;


import java.util.concurrent.TimeUnit;

public class checkboxesTest {

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    ChromeOptions options = new ChromeOptions();


    @BeforeMethod
    public void innit() {
        options.addArguments("--headless");
        driver.set(new ChromeDriver());
    }

    @Test
    public void test1 () {

        driver.get().get("http://the-internet.herokuapp.com/checkboxes");
        driver.get().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        CheckBoxes cb = PageFactory.initElements(driver.get(),CheckBoxes.class);

        for (WebElement box : cb.getBoxes()) {
            boolean state  = cb.isBoxChecked(box); //save old state
            cb.selectBox(box); // click the box
            Assert.assertTrue(state != cb.isBoxChecked(box));
        }
    }

    @AfterMethod
    public void close() {
        driver.get().close();
    }
}
