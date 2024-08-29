package tests_ui;

import config.ApplicationManager;
import helpers.enums.HeaderMenuItemsEn;
import helpers.enums.HeaderMenuItemsRu;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.List;

import static pages.BasePage.*;

public class PhotoTestRu extends ApplicationManager {

    @FindBy(xpath ="//div[@class='sk-facebook-photo-albums-post-img']")
    WebElement photoAlbum1;
    ////div[@class='sk-facebook-photo-albums-post-img']
    //div[@class='sk-ww-facebook-photo-albums-item'][1]
    @FindBy(xpath ="//div[@class='sk-facebook-photos-post-hover display-none']")
    WebElement firstPhotoOfAlbum1;
    @FindBy(xpath="//button[@title='Close (Esc)']")
    WebElement btnClosePhoto;
    @FindBy(xpath = "//button[@title='Previous (Left arrow key)']")
    WebElement moveLeft;
    @FindBy(xpath = "//button[@title='Next (Right arrow key)']")
    WebElement moveRight;
    @FindBy(xpath = "//figure")
    WebElement photoSrc;
@FindBy(xpath = "//i[@class='fa fa-facebook-official']")
WebElement openFacebookFromPhoto;
    @FindBy(xpath = "//h1[@class='star']")
    WebElement startPhotoPageRu;
    @FindBy(xpath = "//a[text()='Посмотреть в фейсбуке']\"")
    WebElement goToFBfromPhotoPageRu;




    @Test
    public void startTest(){

        HomePageRu homePageRu = new HomePageRu(getDriver());
        PhotoPageRu photoPageRu = clickButtonsOnHeaderRu(HeaderMenuItemsRu.PHOTO);
       //        Assert.assertTrue(equals(getDriver().findElements(By.xpath("//h1[@class='star']")),startPhotoPageRu));
    }



@Test
    public void testDownloadPhoto(){
        HomePageRu homePageRu = new HomePageRu(getDriver());
        PhotoPageRu photoPageRu = clickButtonsOnHeaderRu(HeaderMenuItemsRu.PHOTO);
        pause(5);
        new PhotoPageRu(getDriver()).clickDownLoadMore();
    }

    @Test
    public void testAllPhotoAlbumsOnPage()throws IOException{
        HomePageRu homePageRu = new HomePageRu(getDriver());
        PhotoPageRu photoPageRu = new PhotoPageRu(getDriver());
        int count = 0;
        do {
            List<WebElement> elements =
                    getDriver().findElements(By.xpath("//div[@class='sk-ww-facebook-photo-albums-item']"));
            int quantElements= elements.size();
            count = + quantElements;
            photoPageRu.clickDownLoadMore();
            pause(5);
        }
        while( photoPageRu.downLoadMore.isDisplayed());
        System.out.println("Total photo albums: " + count);
    }


   @Test
    public void photoAlbumsView(){
       // 1 Open PhotoPage
       // 2 Open Album[1]
       // 3 Click on first Photo of Album
       // 4 Click on moveLeft = src change, moveRight= src change, btnClosePhoto = move to the step 2
       HomePageRu homePageRu = new HomePageRu(getDriver());
       PhotoPageRu photoPageRu = clickButtonsOnHeaderRu(HeaderMenuItemsRu.PHOTO);
       pause(5);
       try{
           photoPageRu.photoAlbum1.click();
           photoPageRu.firstPhotoOfAlbum1.click();
           photoPageRu.moveLeft.click();
           ExpectedConditions.elementSelectionStateToBe(photoSrc,false);
           photoPageRu.moveRight.click();
           ExpectedConditions.elementSelectionStateToBe(photoSrc,true);
           pause(5);
           photoPageRu.btnClosePhoto.click();
         }catch (TimeoutException e){
           e.printStackTrace();
       }

   }

@Test
   public void ifFacebookOpen(){
        // 1 open PhotoPage
       // 2 open PhotoAlbum
       // 3 open firstPhotoOfAlbum
       // 4 click on facebook logo on photo=> web-site facebook open
       // 5 check if url is equal URLfacebookPage
       // OR is display Element containsText "See more on Facebook"
       // 6 close facebook window

//    Expected :facebook.com/photo/?fbid=6295195583825473&set=a.6295172883827743
//    Actual   :https://shishi.co.il/pages/2
    //???? How to switch on next page

HomePageRu homePageRu = new HomePageRu(getDriver());
PhotoPageRu photoPageRu = clickButtonsOnHeaderRu(HeaderMenuItemsRu.PHOTO);
pause(5);
try{
    photoPageRu.photoAlbum1.click();
    photoPageRu.firstPhotoOfAlbum1.click();
    photoPageRu.goToFBfromPhotoPageRu.click();
    String curURL = getDriver().getCurrentUrl();
    System.out.println(curURL);
    Assert.assertEquals(curURL,"facebook.com/photo/?fbid=6295195583825473&set=a.6295172883827743");

}catch (TimeoutException e){
    e.printStackTrace();
}

   }

}
