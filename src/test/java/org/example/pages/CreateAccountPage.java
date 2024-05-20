package org.example.pages;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;


@DefaultUrl("https://magento.softwaretestingboard.com/customer/account/create/")
public class CreateAccountPage extends PageObject{
    @FindBy(id = "firstname")
    private WebElementFacade firstnameField;

    @FindBy(id = "lastname")
    private WebElementFacade lastnameField;

    @FindBy(id = "email_address")
    private WebElementFacade emailAddressField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "password-confirmation")
    private WebElementFacade passwordConfirmationField;

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div/form/div/div[1]/button")
    private WebElementFacade button;

    @FindBy(id = "email_address-error")
    private WebElementFacade errorMessage;

    public void setFirstname(String firstname){
        waitFor(firstnameField);
        typeInto(firstnameField, firstname);
    }

    public void setLastname(String lastname){
        waitFor(lastnameField);
        typeInto(lastnameField, lastname);
    }

    public void setEmailAddressField(String email){
        waitFor(emailAddressField);
        typeInto(emailAddressField, email);
    }

    public void setPasswordField(String password){
        waitFor(passwordField);
        typeInto(passwordField, password);
        typeInto(passwordConfirmationField, password);
    }

    public void clickCreate(){
        waitFor(button);
        clickOn(button);
    }

    public String errorMessage(){
        waitFor(errorMessage);
        return errorMessage.getText();
    }
}
