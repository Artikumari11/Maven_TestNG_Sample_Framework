package com.businessKeeper.pages;


import com.businessKeeper.base.BaseTest;
import com.businessKeeper.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

import static com.businessKeeper.base.BaseTest.driver;

public class MyAccountPage extends BaseTest {

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p.info-account")
    private WebElement myAccountDetails;

    public void verifyAccountCreatedSucessfully() throws IOException {
        Assert.assertTrue(myAccountDetails.isDisplayed(), "Login has Failed - Accounts page has not displayed");
        TestUtil.takeFullPageScreenshot();
    }
}
