package com.businessKeeper.tests.place_order;


import com.businessKeeper.base.BaseTest;
import com.businessKeeper.pages.BuyProductPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC02_BuyFirstProductForDressCategory extends BaseTest {

    BuyProductPage buyProductPage;

    public TC02_BuyFirstProductForDressCategory() {
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
    public void verifyDressProductsPageDisplayed() throws IOException {
        buyProductPage.assertDressProductPageAppeared();
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
