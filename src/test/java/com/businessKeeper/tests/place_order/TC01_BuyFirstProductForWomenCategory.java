package com.businessKeeper.tests.place_order;


import com.businessKeeper.base.BaseTest;
import com.businessKeeper.pages.BuyProductPage;
import com.businessKeeper.tests.registration.TC01_E2E_RegistrationProcess;
import org.testng.annotations.*;

import java.io.IOException;


public class TC01_BuyFirstProductForWomenCategory extends BaseTest {

    BuyProductPage buyProductPage;

    public TC01_BuyFirstProductForWomenCategory() {
        super();

    }

    @BeforeTest
    private void startTest() {
        setup();
        buyProductPage = new BuyProductPage();
    }


    @Test(priority = 1)
    public void verifySuccessfulLogin()
    {
        buyProductPage.assertSignIn();
    }

    @Test(priority = 2)
    public void verifyWomenProductsPageDisplayed() throws IOException {
        buyProductPage.assertWomenProductPageAppeared();
    }

    @Test(priority = 3)
    public void verifyFirstProductAddedToCart() throws IOException {
        buyProductPage.assertFirstProductAddedToCart();
    }

    @Test(priority = 4)
    public void verifyShoppingSummaryCartPageIsDisplayed() throws IOException {
        buyProductPage.assertShoppingCartSummaryIsDisplayed();
    }

    @Test(priority = 5)
    public void verifyAddressPageIsDisplayed() throws IOException {
        buyProductPage.assertAddressPageIsDisplayed();
    }

    @Test(priority = 6)
    public void verifyShippingPageIsDisplayed() throws IOException {
        buyProductPage.assertShippingPageIsDisplayed();
    }

    @Test(priority = 7)
    public void verifyUserAgreedToTermsOfService() throws IOException {
        buyProductPage.assertTermsOfServiceCheckbox();
    }

    @Test(priority = 8)
    public void verifyPaymentPageIsDisplayed() {
        buyProductPage.assertPaymentPageIsDisplayed();
    }

    @Test(priority = 9)
    public void verifyPaymentCorrectPaymentMethodIsPicked() throws IOException {
        buyProductPage.assertPaymentMethod();
    }

    @Test(priority = 10)
    public void verifyOrderPlacedSuccessfully() throws IOException {
        buyProductPage.assertOrderConfirmation();
    }

    @AfterTest
    private void terminateTest() {
        tearDown();
    }

}
