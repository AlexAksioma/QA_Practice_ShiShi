package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PhotoPageRu extends BasePage{
    public PhotoPageRu(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//button[@class='sk-facebook-photo-albums-load-more-posts']")
        public WebElement downLoadMore;

    @FindBy(xpath ="//div[@class='sk-facebook-photo-albums-post-img']")
    public WebElement photoAlbum1;
    @FindBy(xpath ="//div[@class='sk-facebook-photos-post-hover display-none']")
    public WebElement firstPhotoOfAlbum1;

    @FindBy(xpath="//button[@title='Close (Esc)']")
    public WebElement btnClosePhoto;
    @FindBy(xpath = "//button[@title='Previous (Left arrow key)']")
    public WebElement moveLeft;
    @FindBy(xpath = "//button[@title='Next (Right arrow key)']")
    public WebElement moveRight;
    @FindBy(xpath = "//a[text()='Посмотреть в фейсбуке']")
    public WebElement goToFBfromPhotoPageRu;
    @FindBy(xpath = "//*[text()='See more on Facebook']")
    public WebElement facebookPage;



    public PhotoPageRu clickDownLoadMore() {
        downLoadMore.click();
        return new PhotoPageRu(driver);
    }

    public PhotoPageRu clickPhotoAlbum() {
        photoAlbum1.click();
        return new PhotoPageRu(driver);
    }
}
