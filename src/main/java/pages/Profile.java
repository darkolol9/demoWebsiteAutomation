package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Profile {

    final WebDriver driver;

    public Profile(WebDriver driver) {
        this.driver =  driver;
    }

    @FindBys({
            @FindBy(id = "books-wrapper"),
            @FindBy(id = "userName-value")
    })
    WebElement user;

    @CacheLookup
    @FindBy(id="submit")
    WebElement logoutBtn;

    public void verifyUser(String usrname) {
        if (user.getText().equalsIgnoreCase(usrname))
            System.out.println("Correct username, ie " + user.getText());

        else
            System.out.println("Incorrect username: " + user.getText());

    }

    //log out method
    public void logout_Action() {
        System.out.println("logging out..");
        logoutBtn.click();
    }

}
