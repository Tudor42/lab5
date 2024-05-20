package org.example.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.TestSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "testdata/data.csv")
public class MagentoTest {
    @Managed(uniqueSession = true, driver="firefox")
    public WebDriver webdriver;

    private String firstname;
    private String lastname;
    private String password;
    private String emailSuffix;
    private String errorMessage;
    @Steps
    public TestSteps testSteps;

    @Before
    public void maximise(){
        webdriver.manage().window().maximize();
    }


    @Test
    public void checkCreateAccount(){
        String email = UUID.randomUUID().toString().substring(0, 20) + emailSuffix;

        testSteps.createAccount(email, password, firstname, lastname);
        if(!errorMessage.isEmpty()) {
            testSteps.checkError(errorMessage);
        }
    }
}
