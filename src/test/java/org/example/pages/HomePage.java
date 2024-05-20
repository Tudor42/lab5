package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageObject {
    @FindBy(className = "product-item")
    public List<WebElementFacade> products;

    @FindBy(className = "logo")
    public WebElementFacade logo;

    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-166\"]")
    public WebElementFacade xs;

    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-50\"]")
    public WebElementFacade color;

    @FindBy(id = "product-addtocart-button")
    public WebElementFacade button;

    public void clickProduct(){
        waitFor(products.get(0));
        clickOn(products.get(0).findElement(By.tagName("a")));
    }

    public void clickLogo(){
        waitFor(logo);
        clickOn(logo);
    }

    public void addToCart(){
        waitFor(xs);
        clickOn(xs);
        waitFor(color);
        clickOn(color);
        waitFor(button);
        clickOn(button);
    }


    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    WebElementFacade cartIcon;
    @FindBy(id = "top-cart-btn-checkout")
    WebElementFacade proceedToCheckout;


    @FindBy(xpath = "/html/body/div[2]/main/div[1]/div[2]/div/div/div")
    WebElementFacade message_success;


    @FindBy(xpath = "/html/body/div[2]/main/div[1]/h1/span")
    WebElementFacade purchaseMessage;

    public void goToCart(){
        waitFor(message_success);

        waitFor(cartIcon);
        clickOn(cartIcon);
        waitFor(proceedToCheckout);
        clickOn(proceedToCheckout);
    }


    public void checkMessage(){
        waitFor(purchaseMessage);
        Assert.assertEquals("Thank you for your purchase!", purchaseMessage.getText());
    }

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    WebElementFacade dropdown;
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
    WebElementFacade signout;

    public void signout(){
        waitFor(dropdown);
        clickOn(dropdown);
        waitFor(signout);
        clickOn(signout);
        waitForTextToAppear("You are signed out");
        waitABit(1000);
    }
}
