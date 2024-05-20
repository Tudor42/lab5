package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends PageObject {

    @FindBy(name = "street[0]")
    WebElementFacade streetField;
    @FindBy(name = "city")
    WebElementFacade cityField;

    @FindBy(name = "region_id")
    WebElementFacade stateField;

    @FindBy(name = "postcode")
    WebElementFacade zipField;

    @FindBy(name = "telephone")
    WebElementFacade numberField;

    @FindBy(name = "ko_unique_1")
    WebElementFacade radio;

    public void setStreet(String street) {
        waitFor(streetField);
        typeInto(streetField, street);
    }

    public void setCity(String city) {
        waitFor(cityField);
        typeInto(cityField, city);
    }

    public void setState(String state) {
        waitFor(stateField);
        clickOn(stateField);
        Select select = new Select(stateField);
        select.selectByVisibleText(state);
    }

    public void setZipCode(String zip) {
        waitFor(zipField);
        typeInto(zipField, zip);
    }

    public void setNumber(String number) {
        waitFor(numberField);
        typeInto(numberField, number);
    }

    public void selectRadio(){
        waitFor(radio);
        clickOn(radio);
    }

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button")
    WebElementFacade buttonNext;

    @FindBy(xpath = "/html/body/div[3]/main/div[2]/div/div[2]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button")
    WebElementFacade buttonProceed;

    public void clickButtons(){
        waitFor(buttonNext);
        clickOn(buttonNext);
        waitABit(4000);
        waitFor(buttonProceed);
        buttonProceed.click();
    }
}
