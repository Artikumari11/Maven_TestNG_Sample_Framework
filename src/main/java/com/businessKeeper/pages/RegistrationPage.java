package com.businessKeeper.pages;


import com.businessKeeper.base.BaseTest;
import com.businessKeeper.util.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class RegistrationPage extends BaseTest {

    public static Logger log = LogManager.getLogger(RegistrationPage.class.getName());

    @FindBy(css = "a.login")
    private WebElement buttonSignIn;

    @FindBy(css = "input#email_create")
    private WebElement inputEmailForRegistration;

    @FindBy(css = "input#email")
    private WebElement autoPopulatedEmail;

    @FindBy(css = "button#SubmitCreate")
    private WebElement buttonCreateAccount;

    @FindBy(css = "form#account-creation_form")
    private WebElement accontRegistrationForm;

    @FindBy(css = "input#id_gender1")
    private WebElement radioButtonMale;

    @FindBy(css = "input#id_gender2")
    private WebElement radioButtonFemale;

    @FindBy(css = "input#customer_firstname")
    private WebElement inputFirstName;

    @FindBy(css = "input#customer_lastname")
    private WebElement inputLastName;

    @FindBy(css = "input#email")
    private WebElement inputEmail;

    @FindBy(css = "input#passwd")
    private WebElement inputPassword;

    @FindBy(css = "select#days")
    private WebElement selectDobDate;

    @FindBy(css = "select#months")
    private WebElement selectDobMonth;

    @FindBy(css = "select#years")
    private WebElement selectDobYear;

    @FindBy(css = "input#firstname")
    private WebElement inputFirstNameForAddress;

    @FindBy(css = "input#lastname")
    private WebElement inputLastNameForAddress;

    @FindBy(css = "input#company")
    private WebElement inputCompanyForAddress;

    @FindBy(css = "input#address1")
    private WebElement inputAddress;

    @FindBy(css = "input#address2")
    private WebElement inputAddressLine2;

    @FindBy(css = "input#city")
    private WebElement inputCity;

    @FindBy(css = "select#id_state")
    private WebElement selectState;

    @FindBy(css = "div#uniform-id_state span")
    private WebElement containerSelectState;

    @FindBy(css = "input#postcode")
    private WebElement inputPostcode;

    @FindBy(css = "select#id_country")
    private WebElement selectCountry;

    @FindBy(css = "div#uniform-id_country span")
    private WebElement containerSelectCountry;

    @FindBy(css = "textarea#other")
    private WebElement inputAdditionalInformation;

    @FindBy(css = "input#phone")
    private WebElement inputHomePhone;

    @FindBy(css = "input#phone_mobile")
    private WebElement inputMobilePhone;

    @FindBy(css = "input#alias")
    private WebElement inputAlias;

    @FindBy(css = "button#submitAccount")
    private WebElement buttonRegister;

    @FindBy(css = "div#create_account_error")
    private WebElement errorAccountCreation;


    public RegistrationPage() {
        log.info("Initializing page objects of Registration page");
        PageFactory.initElements(driver, this);
    }

    public void assertAuthenticationPageIsLoaded() {

        buttonSignIn.click();
        Assert.assertTrue(buttonCreateAccount.isDisplayed(), "Authentication page not loaded");
        log.info("Authentication page loaded");
    }

    public void assertRegistrationPageIsLoaded() {
        inputEmailForRegistration.sendKeys(user);
        buttonCreateAccount.click();
        Assert.assertTrue(accontRegistrationForm.isDisplayed(), "Registration page not loaded");
        log.info("Registration page loaded");

    }

    public void assertEmailIdOnRegistrationPage() {

        Assert.assertEquals(TestUtil.getTextByValue(autoPopulatedEmail),user, "Wrong email address populated in registration form");
        log.info("Verified email id ");
    }

    public void openRegistrationForm(String email) {
        inputEmailForRegistration.sendKeys(email);
        buttonCreateAccount.click();
        log.info("Opened registration form");
    }

    public boolean assertTitleIsSelected() {
        String title = getTitle();
        if (title.equals("Mr")) {
            TestUtil.WaitUntilElementIsVisible(radioButtonMale,5).click();
            log.info("Title selected - "+title);
            return radioButtonMale.isSelected();
        } else {
            TestUtil.WaitUntilElementIsVisible(radioButtonFemale,5).click();
            log.info("Title selected - "+title);
            return radioButtonFemale.isSelected();
        }
    }

    public boolean assertNameIsFilled(String firstName, String lastName) {
        inputFirstName.sendKeys(firstName);
        log.info("Filled firstname - "+firstName);
        inputLastName.sendKeys(lastName);
        log.info("Filled lastname - "+lastName);
        return !TestUtil.getTextByValue(inputFirstName).isEmpty() || !TestUtil.getTextByValue(inputLastName).isEmpty();
    }

    public boolean assertPasswordIsFilled(String password) {
        inputPassword.sendKeys(password);
        log.info("Filled password - "+password);
        return !TestUtil.getTextByValue(inputPassword).isEmpty();
    }

    public boolean assertCompanyNameIsFilled(String company) {
        inputCompanyForAddress.sendKeys(company);
        log.info("Filled company for address - "+company);
        return !TestUtil.getTextByValue(inputCompanyForAddress).isEmpty();
    }

    public boolean assertAddressLine1IsFilled(String addressLine1) {
        inputAddress.sendKeys(addressLine1);
        log.info("Filled address line1 - "+addressLine1);
        return !TestUtil.getTextByValue(inputAddress).isEmpty();
    }

    public boolean assertAddressLine2IsFilled(String addressLine2) {
        inputAddressLine2.sendKeys(addressLine2);
        log.info("Filled address line2 - "+addressLine2);
        return !TestUtil.getTextByValue(inputAddressLine2).isEmpty();
    }

    public boolean assertCityIsFilled(String city) {
        inputCity.sendKeys(city);
        log.info("Filled city - "+city);
        return !TestUtil.getTextByValue(inputCity).isEmpty();
    }

    public boolean assertStateIsFilled(String state) {
        Select select = new Select(selectState);
        select.selectByVisibleText(state);
        Assert.assertEquals(containerSelectState.getText(),state,"State not matched eith what selected by user");
        log.info("Selected state - "+state);
        return !containerSelectState.getText().isEmpty();
    }

    public boolean assertCountryIsFilled(String country) {
        Select select = new Select(selectCountry);
        select.selectByVisibleText(country);
        Assert.assertEquals(containerSelectCountry.getText(),country,"Country not matched eith what selected by user");
        log.info("Selected country - "+country);
        return !containerSelectCountry.getText().isEmpty();
    }

    public boolean assertPostCodeIsFilled(String postCode) {
        inputPostcode.sendKeys(postCode);
        log.info("Filled postcode - "+postCode);
        return !TestUtil.getTextByValue(inputPostcode).isEmpty();
    }

    public boolean assertAdditionalInfoIsFilled(String additionalInfo) {
        inputAdditionalInformation.sendKeys(additionalInfo);
        log.info("Filled additional info - "+additionalInfo);
        return !TestUtil.getTextByValue(inputAdditionalInformation).isEmpty();
    }

    public boolean assertMobileNoIsFilled(String mobile) {
        inputMobilePhone.sendKeys(mobile);
        log.info("Filled Mobile no - "+mobile);
        return !TestUtil.getTextByValue(inputMobilePhone).isEmpty();
    }

    public boolean assertAliasIsFilled(String alias) {
        inputAlias.sendKeys(alias);
        log.info("Filled alias - "+alias);
        return !TestUtil.getTextByValue(inputAlias).isEmpty();
    }

    public void assertNameDetailsInAddressData() {
        Assert.assertEquals(TestUtil.getTextByValue(inputFirstNameForAddress),firstName, "First name does not matched in address data");
        Assert.assertEquals(TestUtil.getTextByValue(inputLastNameForAddress),lastName, "Last name does not matched in address data");
    }

    public void assertRegisterButton() throws IOException {
        TestUtil.takeFullPageScreenshot();
        Assert.assertTrue(buttonRegister.isEnabled(), "Button Register is not Enabled");
        buttonRegister.click();
        log.info("Clicked on Register button");
    }

    public void assertWrongEmailErrorMessage() throws IOException {
        buttonSignIn.click();
        TestUtil.WaitUntilElementIsVisible(inputEmailForRegistration,5).sendKeys("invalid.mail@testcom");
        buttonCreateAccount.click();
        Assert.assertTrue(TestUtil.WaitUntilElementIsVisible(errorAccountCreation,5).isDisplayed(), "Error message not displayed on entering wrong formatted email id");
        TestUtil.takeFullPageScreenshot();
    }

}