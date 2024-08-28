package tests_ui;

import config.ApplicationManager;
import helpers.enums.HeaderMenuItemsEn;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AboutPageEn;
import pages.BasePage;
import pages.HomePageEn;

public class AboutTestEn extends ApplicationManager {

    AboutPageEn aboutPageEn;
    String expectedDonateUrl = "https://www.jgive.com/new/en/usd/donation-targets/40565/about?currency=ILS";

    @BeforeMethod
    public void goToAboutPageEn() {
        new HomePageEn(getDriver());
        aboutPageEn = BasePage.clickButtonsOnHeaderEn(HeaderMenuItemsEn.ABOUT);
    }

    @Test
    public void openAboutPageEn() {
        System.out.println("AboutPageEn");
    }

    @Test
    public void checkDonationLink() {
        aboutPageEn.clickOnDonateLink();
        String actualDonateUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(actualDonateUrl, expectedDonateUrl);
    }

}
