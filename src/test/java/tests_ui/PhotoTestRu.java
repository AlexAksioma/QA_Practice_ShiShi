package tests_ui;

import config.ApplicationManager;
import helpers.enums.HeaderMenuItemsEn;
import helpers.enums.HeaderMenuItemsRu;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.*;

import static pages.BasePage.*;

public class PhotoTestRu extends ApplicationManager {

    @Test
    public void startTest(){

        HomePageRu homePageRu = new HomePageRu(getDriver());
        PhotoPageRu photoPageRu = clickButtonsOnHeaderRu(HeaderMenuItemsRu.PHOTO);
    }
@Test
    public void testDownloadPhoto(){
        HomePageRu homePageRu = new HomePageRu(getDriver());
        PhotoPageRu photoPageRu = clickButtonsOnHeaderRu(HeaderMenuItemsRu.PHOTO);
        pause(5);
        photoPageRu.clickDownLoadPhoto();

    }


}
