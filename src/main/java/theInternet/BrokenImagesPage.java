package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class BrokenImagesPage {

    final WebDriver driver;

    public BrokenImagesPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(tagName = "img")
    List<WebElement> imgs;

    public boolean isImgBroken(WebElement img) {
        if (img.getAttribute("naturalWidth").isEmpty())
                return true;
        return false;
    }

    public List<WebElement> getImgs() {
        return this.imgs;
    }
}
