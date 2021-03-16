package com.qaprosoft.carina.demo.gui.pages.laba;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.myComponents.BucketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductInfoPage extends AbstractPage {

     @FindBy (className = "product__buy")
    private ExtendedWebElement buyButton;

    @FindBy (className = "product__title")
    private ExtendedWebElement pageTitle;

    @FindBy (xpath = "//p[@class='product__code detail-code']")
    private ExtendedWebElement productId;


    public boolean isPageOpened () {
        return pageTitle.isElementPresent();
    }

    public ProductInfoPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getBuyButton () {
        return buyButton;
    }



    public BucketPage buyProduct () {
        buyButton.click();
        return new BucketPage(getDriver());
    }

    public ExtendedWebElement getProductId () {
        return productId;
    }


}
