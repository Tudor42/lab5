package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.example.pages.CartPage;
import org.example.pages.CreateAccountPage;
import org.example.pages.HomePage;
import org.junit.Assert;

public class TestSteps extends ScenarioSteps {
    CreateAccountPage createAccountPage;
    HomePage homePage;

    CartPage cartPage;
    @Step
    public void createAccount(String email, String password, String firstname, String lastname){
        createAccountPage.open();
        createAccountPage.setFirstname(firstname);
        createAccountPage.setLastname(lastname);
        createAccountPage.setEmailAddressField(email);
        createAccountPage.setPasswordField(password);
        createAccountPage.clickCreate();
    }

    @Step
    public void checkError(String errorMessage){
        Assert.assertEquals(errorMessage, createAccountPage.errorMessage());
    }

    @Step
    public void clickLogo(){
        homePage.clickLogo();
    }

    @Step
    public void clickProductHomepage(){
        homePage.clickProduct();
    }

    @Step
    public void addToCart(){
        homePage.addToCart();
    }

    @Step
    public void goToCart(){
        homePage.goToCart();
    }

    @Step
    public void completeWithDetails(String street, String city, String state, String zip, String number) {
        cartPage.setStreet(street);
        cartPage.setCity(city);
        cartPage.setState(state);
        cartPage.setZipCode(zip);
        cartPage.setNumber(number);
        cartPage.selectRadio();
        cartPage.clickButtons();
    }

    @Step
    public void checkPurchase(){
        homePage.checkMessage();
    }

    @Step
    public void signout(){
        homePage.signout();
    }
}
