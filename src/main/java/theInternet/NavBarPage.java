package theInternet;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBarPage {

    final WebDriver driver;

    public NavBarPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css="[href=\"/\"]")
    WebElement homePage;

    @FindBy(css="[href=\"/about/\"]")
    WebElement aboutPage;

    @FindBy(css="[href=\"/contact-us/\"]")
    WebElement contactPage;

    @FindBy(css="[href=\"/portfolio/\"]")
    WebElement portfolio;

    @Step("go to home")
    public void goHome() {
        homePage.click();
    }

    @Step("go to about")
    public void goAbout() {
        aboutPage.click();
    }
    @Step("go to contact me")
    public void goContact() {
        contactPage.click();
    }
    @Step("go to porfolio")
    public void goPortfolio() {
        portfolio.click();
    }
    @Step("go back")
    public void goBack() {
        driver.navigate().back();
    }

    @Step("verify page")
    public boolean verifyPage() {
        return !(driver.findElement(By.tagName("h1")).getText().equalsIgnoreCase("Not Found"));
    }



}
