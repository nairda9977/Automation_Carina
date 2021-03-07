package com.qaprosoft.carina.demo.gui.pages.laba;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.myComponents.BucketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductInfo extends AbstractPage {

     @FindBy (className = "product__buy")
    private ExtendedWebElement buyButton;

    @FindBy (className = "product__title")
    private ExtendedWebElement pageTitle;

    public boolean isPageOpened () {
        pageTitle.assertElementPresent();;
        return true;
    }

    public ProductInfo(WebDriver driver) {
        super(driver);
    }



    public BucketPage buyProduct () {
        buyButton.click();
        return new BucketPage(getDriver());
    }
}
