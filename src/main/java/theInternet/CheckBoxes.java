package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxes {
    final WebDriver driver;

    public CheckBoxes(WebDriver driver) {
        this.driver = driver;
    }


    // locate all checkboxes
    @FindBy(tagName = "input")
    List<WebElement> boxes;

    public boolean isBoxChecked(WebElement box) {
       return box.isSelected();
    }
    public void selectBox(WebElement box) {
        box.click();
    }

    public List<WebElement> getBoxes() {
        return this.boxes;
    }


}
