package com.businessKeeper.data;

import com.businessKeeper.base.BaseTest;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class DataProvider {

    public static Logger log= LogManager.getLogger(DataProvider.class.getName());
    public static String user;
    public static String password;
    public static String firstName;
    public static String lastName;
    public static String paymentMethod;

    Faker randomData = new Faker();

    public String getEmailAddress() {
        Date date = new Date();
        user = randomData.internet().emailAddress("sel-test" + date.getTime());
        log.info("Email Id is - "+user);
        return user;
    }

    public String getTitle() {

        String[] salutations = {
                "Mr",
                "Mrs"};

        return salutations[randomData.random().nextInt(salutations.length)];
    }

    public String getFirstName() {
        firstName = randomData.name().firstName();
        return firstName;

    }

    public String getLastName() {
        lastName = randomData.name().lastName();
        return lastName;

    }

    public String getPassword() {
        password =randomData.color().name()+randomData.code().asin();
        System.out.println("Password is : "+password);
        log.info("Password is - "+password);
        return password;
    }

    public String getAddress()
    {
        return randomData.address().streetAddressNumber();
    }

    public String getAddressLine1()
    {
        return randomData.address().secondaryAddress();
    }

    public String  getCity()
    {
        return randomData.address().cityName();
    }

    public String  getState() {

        String[] state = {
                "Alabama",
                "Alaska",
                "Georgia",
                "District of Columbia",
                "Arkansas",
                "Florida"};

        return state[randomData.random().nextInt(state.length)];
    }

    public String getPostalCode()
    {
        return randomData.number().digits(5);
    }

    public String getCountry() {

        String[] country = {
                "United States"};

        return country[randomData.random().nextInt(country.length)];
    }

    public String getPhoneNumber()
    {
        return randomData.phoneNumber().cellPhone();
    }

    public String getAlias()
    {
        return "home";
    }

    public String getCompany()
    {
        return randomData.company().name();
    }

    public String getAdditionalInfo()
    {
        return randomData.ancient().titan();
    }

    public String getPaymentMethod() {
        String[] paymentType = {
                "Bank",
                "Cheque"};

        paymentMethod = paymentType[randomData.random().nextInt(paymentType.length)];
        return paymentMethod;
    }
}

