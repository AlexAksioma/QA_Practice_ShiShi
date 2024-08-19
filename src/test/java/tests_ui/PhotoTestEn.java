package tests_ui;

import config.ApplicationManager;
import helpers.enums.HeaderMenuItemsEn;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePageEn;
import pages.PhotoPageEn;

import static pages.BasePage.clickButtonsOnHeaderEn;
import static pages.BasePage.pause;

public class PhotoTestEn extends ApplicationManager {

    @Test
    public void startTest(){
        HomePageEn homePageEN = new HomePageEn(getDriver());
        PhotoPageEn photoPageEn = clickButtonsOnHeaderEn(HeaderMenuItemsEn.PHOTO);
    }
@Test
public void testDownloadPhoto(){
        HomePageEn homePageEn = new HomePageEn(getDriver());
        PhotoPageEn photoPageEn = clickButtonsOnHeaderEn(HeaderMenuItemsEn.PHOTO);
        pause(5);
        photoPageEn.clickDownLoadPhoto();

}

}


