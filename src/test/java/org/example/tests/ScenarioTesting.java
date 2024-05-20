package org.example.tests;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.TestSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "testdata/scenario.csv")
public class ScenarioTesting {

    @Managed(uniqueSession = true, driver="firefox")
    public WebDriver webdriver;

    private String firstname;
    private String lastname;
    private String password;
    private String emailSuffix;
    private String street;
    private String city;
    private String state;
    private String zip,number;

    @Steps
    public TestSteps testSteps;

    @Test
    public void scenarioTest(){
        String email = UUID.randomUUID().toString().substring(0, 20) + emailSuffix;

        testSteps.createAccount(email, password, firstname, lastname);
        testSteps.clickLogo();
        testSteps.clickProductHomepage();
        testSteps.addToCart();
        testSteps.goToCart();

        testSteps.completeWithDetails(street, city, state, zip, number);
        testSteps.checkPurchase();
        testSteps.signout();
    }
}
