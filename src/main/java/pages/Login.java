package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Login {

    final WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    //locating username

    @FindAll({
            @FindBy(id = "wrapper"),
            @FindBy(id="userName")
    })
    WebElement username;

    //locating the password

    @FindBy(id="password")
    WebElement password;

    //login button
    @FindBy(id="login")
    WebElement loginBtn;

    public void LogIn_Action(String uName,String pwd) {
        username.sendKeys(uName);
        password.sendKeys(pwd);
        loginBtn.click();
    }

}
