package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
    final WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    //locate user login page
    @FindBy(css = "[href=\"/basic_auth\"]")
    WebElement basic_auth_href;








}
