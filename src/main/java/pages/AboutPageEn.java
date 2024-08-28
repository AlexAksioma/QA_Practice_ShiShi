package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AboutPageEn extends BasePage {

    @FindBy(xpath = "//a[contains(@href, 'donation-targets/40565')]")
    WebElement donateLink;

    public AboutPageEn(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void clickOnDonateLink() {
        clickWait(donateLink, 3);
    }
}
