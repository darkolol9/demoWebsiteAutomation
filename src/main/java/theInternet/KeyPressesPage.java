package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyPressesPage {
    final WebDriver driver;

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(tagName = "input")
    WebElement inputBar;

    @FindBy(id = "result")
    WebElement result;

    public void writeIntoBar(String c) {
        inputBar.sendKeys(c);
    }

    public boolean verifyResult(String c) {
        return (result.getText().substring(13).equalsIgnoreCase(c));

    }
    public String getResult() {
        return result.getText();
    }

}
