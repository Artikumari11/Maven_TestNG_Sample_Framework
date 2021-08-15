package com.businessKeeper.pages;


import com.businessKeeper.base.BaseTest;
import com.businessKeeper.util.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class BuyProductPage extends BaseTest {

    public static Logger log = LogManager.getLogger(RegistrationPage.class.getName());

    @FindBy(css = "a[title='Women']")
    private WebElement linkToWomenProducts;

    @FindBy(css = "div.cat-title + ul > li:nth-of-type(2) a[title='Dresses']")
    private WebElement linkToDressesProducts;

    @FindBy(css = "div.cat-title + ul > li:nth-of-type(3) a[title='T-shirts']")
    private WebElement linkToTshirtProducts;

    @FindBy(css = "h1.page-heading.product-listing > span:first-of-type")
    private WebElement headingCategory;

    @FindBy(css = "ul[class*='product_list'] > li:first-of-type a[class*='add_to_cart']")
    private WebElement buttonAddToCartFirstProduct;

    @FindBy(css = "div#layer_cart div[class*='layer_cart_product '] h2 ")
    private WebElement messageProductAddedToCart;

    @FindBy(css = "span.navigation_page")
    private WebElement headingNavigationPipe;

    @FindBy(css = "div.button-container a[title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "p.cart_navigation.clearfix a[title='Proceed to checkout']")
    private WebElement buttonProceedToCheckoutSummary;

    @FindBy(css = "form[method='post'] button[name='processAddress']")
    private WebElement buttonProceedToCheckAddress;

    @FindBy(css = "div.checker input[type='checkbox']")
    private WebElement checkboxTermsOfService;

    @FindBy(css = "form[method='post'] button[name='processCarrier']")
    private WebElement buttonProceedToCheckoutShipping;

    @FindBy(css = "div#HOOK_PAYMENT p.payment_module a.bankwire")
    private WebElement payByBankWire;

    @FindBy(css = "div#HOOK_PAYMENT p.payment_module a.cheque")
    private WebElement payByCheck;

    @FindBy(css = "p#cart_navigation button[type='submit']")
    private WebElement buttonConfirmOrder;

    @FindBy(css = "p.alert.alert-success")
    private WebElement orderConfirmationSuccessMessageCheck;

    @FindBy(css = "p.cheque-indent strong")
    private WebElement orderConfirmationSuccessMessageBank;

    @FindBy(css = "a.login")
    private WebElement linkSignIn;

    @FindBy(css = "input#email")
    private WebElement inputEmailId;

    @FindBy(css = "input#passwd")
    private WebElement inputPassword;

    @FindBy(css = "button#SubmitLogin")
    private WebElement buttonsignIn;

    @FindBy(css = "a.logout")
    private WebElement linkLogout;


    public BuyProductPage() {
        PageFactory.initElements(driver, this);
    }

    public void assertSignIn() {
        linkSignIn.click();
        inputEmailId.sendKeys(userForLogin);
        inputPassword.sendKeys(passwordForLogin);
        buttonsignIn.click();
        Assert.assertTrue(linkLogout.isDisplayed(), "Button Signout is not visible - Login Failed");
        log.info("Signed in to Account successfully");
    }

    public void assertWomenProductPageAppeared() throws IOException {
        linkToWomenProducts.click();
        Assert.assertEquals(headingCategory.getText().trim(), "WOMEN", "Not on Women Products page.");
        log.info("Women products page loaded successfully");
        TestUtil.takeFullPageScreenshot();
        log.info("Women products page is displayed");
    }

    public void assertDressProductPageAppeared() throws IOException {
        linkToDressesProducts.click();
        Assert.assertEquals(headingCategory.getText().trim(), "DRESSES", "Not on Dress Products page.");
        log.info("Dress products page loaded successfully");
        TestUtil.takeFullPageScreenshot();
        log.info("Dress products page is displayed");
    }

    public void assertTshirtProductPageAppeared() throws IOException {
        linkToTshirtProducts.click();
        Assert.assertEquals(headingCategory.getText().trim(), "T-SHIRTS", "Not on T-Shirt Products page.");
        log.info("T-Shirt products page loaded successfully");
        TestUtil.takeFullPageScreenshot();
        log.info("T-Shirt products page is displayed");
    }

    public void assertFirstProductAddedToCart() throws IOException {

        TestUtil.scrollThenClick(buttonAddToCartFirstProduct);
        Assert.assertEquals(TestUtil.WaitUntilElementIsVisible(messageProductAddedToCart, 5).getText().trim()
                , "Product successfully added to your shopping cart"
                , "Product not added to cart");
        TestUtil.takeFullPageScreenshot();
        log.info("Added first product to cart");
    }

    public void assertShoppingCartSummaryIsDisplayed() throws IOException {
        proceedToCheckoutButton.click();
        Assert.assertEquals(TestUtil.WaitUntilElementIsVisible(headingNavigationPipe, 5).getText().trim()
                , "Your shopping cart"
                , "Summary page not displayed");
        TestUtil.takeFullPageScreenshot();
        log.info("Shopping Cart summary page is displayed");
    }

    public void assertAddressPageIsDisplayed() throws IOException {
        buttonProceedToCheckoutSummary.click();
        Assert.assertEquals(TestUtil.WaitUntilElementIsVisible(headingNavigationPipe, 5).getText().trim()
                , "Addresses"
                , "Addresses page not displayed");
        TestUtil.takeFullPageScreenshot();
        log.info("Address page is displayed");
    }

    public void assertShippingPageIsDisplayed() throws IOException {
        buttonProceedToCheckAddress.click();
        Assert.assertEquals(TestUtil.WaitUntilElementIsVisible(headingNavigationPipe, 5).getText().trim()
                , "Shipping"
                , "Shipping page not displayed");
        TestUtil.takeFullPageScreenshot();
        log.info("Shipping page is displayed");
    }

    public void assertTermsOfServiceCheckbox() throws IOException {
        checkboxTermsOfService.click();
        Assert.assertTrue(checkboxTermsOfService.isSelected(), "Checkbox Terms of service is unchecked");
        TestUtil.takeFullPageScreenshot();
        log.info("Checked Terms of service");
    }

    public void assertPaymentPageIsDisplayed() {
        buttonProceedToCheckoutShipping.click();
        Assert.assertEquals(TestUtil.WaitUntilElementIsVisible(headingNavigationPipe, 5).getText().trim()
                , "Your payment method"
                , "Payment page not displayed");
        log.info("Payment page is displayed");
    }

    public void assertPaymentMethod() throws IOException {
        if (getPaymentMethod().equals("Bank")) {
            payByBankWire.click();
            Assert.assertEquals(TestUtil.WaitUntilElementIsVisible(headingNavigationPipe, 5).getText().trim()
                    , "Bank-wire payment."
                    , "Wrong payment method check");
        } else {
            payByCheck.click();
            Assert.assertEquals(TestUtil.WaitUntilElementIsVisible(headingNavigationPipe, 5).getText().trim()
                    , "Check payment"
                    , "Wrong payment method bank wire");

        }
        TestUtil.takeFullPageScreenshot();
        log.info("Payment method selected -"+paymentMethod);
    }

    public void assertOrderConfirmation() throws IOException {
        buttonConfirmOrder.click();
        if (paymentMethod.equals("Bank")) {
            Assert.assertTrue(orderConfirmationSuccessMessageBank.isDisplayed(), "Error in placing order.");
        } else {
            Assert.assertTrue(orderConfirmationSuccessMessageCheck.isDisplayed(), "Error in placing order.");
        }
        TestUtil.takeFullPageScreenshot();

        log.info("Order placed successfully");

    }

}

