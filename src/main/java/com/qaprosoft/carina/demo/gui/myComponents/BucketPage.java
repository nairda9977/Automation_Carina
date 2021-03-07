package com.qaprosoft.carina.demo.gui.myComponents;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BucketPage extends AbstractPage {

    @FindBy (xpath = "//*[@class=\"modal__heading\" and contains(text(), \"Кошик\") ]")
    private ExtendedWebElement pageTitle;

    public BucketPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (className = "cart-product__title")
    private ExtendedWebElement productInCart;

    @FindBy (className = "cart-product__title")
    private ExtendedWebElement cartProductTitle;

    public String getProductTitleValue () {
        return cartProductTitle.getText();
    }


    public boolean checkProductInCart () {
        productInCart.isElementPresent();
        return true;
    }

    public boolean isPageOpened () {
        pageTitle.isElementPresent();
        return true;
    }
}
