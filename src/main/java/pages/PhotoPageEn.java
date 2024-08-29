package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PhotoPageEn extends BasePage{
    public PhotoPageEn(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//button[@class='sk-facebook-photo-albums-load-more-posts']")
    WebElement downLoadMore;

    public PhotoPageEn clickDownLoadMore() {
        downLoadMore.click();
        return new PhotoPageEn(driver);
    }
}
