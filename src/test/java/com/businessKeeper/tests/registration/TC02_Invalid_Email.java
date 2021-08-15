package com.businessKeeper.tests.registration;

import com.businessKeeper.base.BaseTest;
import com.businessKeeper.pages.MyAccountPage;
import com.businessKeeper.pages.RegistrationPage;
import org.testng.annotations.*;

import java.io.IOException;

public class TC02_Invalid_Email extends BaseTest {

    RegistrationPage registrationPage;
    MyAccountPage myAccountPage;

    public TC02_Invalid_Email() {
        super();

    }

    @BeforeTest
    private void startTest() {
        setup();
        registrationPage = new RegistrationPage();
        myAccountPage = new MyAccountPage();
        user = getEmailAddress();
    }

    @Test
    public void verifyErrorMessageOnInvalidMailId() throws IOException {
            registrationPage.assertWrongEmailErrorMessage();
    }

    @AfterTest
    private void terminateTest() {
        tearDown();
    }

}
