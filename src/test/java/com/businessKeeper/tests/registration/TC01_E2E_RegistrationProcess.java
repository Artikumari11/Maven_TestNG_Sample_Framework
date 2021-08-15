package com.businessKeeper.tests.registration;


import com.businessKeeper.base.BaseTest;
import com.businessKeeper.pages.MyAccountPage;
import com.businessKeeper.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class TC01_E2E_RegistrationProcess extends BaseTest {


    RegistrationPage registrationPage;
    MyAccountPage myAccountPage;

    public TC01_E2E_RegistrationProcess() {
        super();

    }

    @BeforeTest
    private void startTest() {
        setup();
        registrationPage = new RegistrationPage();
        myAccountPage = new MyAccountPage();
        user = getEmailAddress();
       // password = getPassword();
    }


    @Test(priority = 1)
    public void verifyAuthenticationPageIsLoaded() {
        registrationPage.assertAuthenticationPageIsLoaded();
    }

   @Test(priority = 2)
    public void verifyRegistrationFormIsLoaded() {
        registrationPage.assertRegistrationPageIsLoaded();
    }

    @Test(priority = 3)
    public void verifyEmailIdOnRegistrationPage() {
        registrationPage.assertEmailIdOnRegistrationPage();
    }

    @Test(priority = 4)
    public void VerifyPersonalDetailsAreFilled() {
        Assert.assertTrue(registrationPage.assertTitleIsSelected()
                , "Title is not selected");
        Assert.assertTrue(registrationPage.assertNameIsFilled(getFirstName(), getLastName())
                , "Name is not filled");
        Assert.assertTrue(registrationPage.assertPasswordIsFilled(getPassword())
                , "Password is not filled");
    }

    @Test(priority = 5)
    public void VerifyAddressDetailsAreFilled() {
        registrationPage.assertNameDetailsInAddressData();
        Assert.assertTrue(registrationPage.assertCompanyNameIsFilled(getCompany())
                , "Company name in address data is not filled");
        Assert.assertTrue(registrationPage.assertAddressLine1IsFilled(getAddress())
                , "Address line 1 is not filled");
        Assert.assertTrue(registrationPage.assertAddressLine2IsFilled(getAddressLine1())
                , "Address line 1 is not filled");
        Assert.assertTrue(registrationPage.assertCityIsFilled(getCity())
                , "City is not filled");
        Assert.assertTrue(registrationPage.assertStateIsFilled(getState())
                , "State is not filled");
        Assert.assertTrue(registrationPage.assertPostCodeIsFilled(getPostalCode())
                , "Post code is not filled");
        Assert.assertTrue(registrationPage.assertCountryIsFilled(getCountry())
                , "Country is not filled");
        Assert.assertTrue(registrationPage.assertAdditionalInfoIsFilled(getAdditionalInfo())
                , "Additional info is not filled");
        Assert.assertTrue(registrationPage.assertMobileNoIsFilled(getPhoneNumber())
                , "Mobile number is not filled");
        Assert.assertTrue(registrationPage.assertAliasIsFilled(getAlias())
                , "Alias is not filled");

    }

    @Test(priority = 6)
    public void VerifyRegisterButtonIsEnabled() throws IOException {
        registrationPage.assertRegisterButton();
    }

    @Test(priority = 7)
    public void verifyAccountCreatedSucessfully() throws IOException {
        myAccountPage.verifyAccountCreatedSucessfully();
    }

    @AfterTest
    private void terminateTest() {
        tearDown();
    }


}
