package com.qaprosoft.carina.demo.gui.pages.laba;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductSubcategoryList extends AbstractPage {

    @FindBy(xpath = "//*[@name=\"searchline\"][1]")
    private ExtendedWebElement searchWindow;

    @FindBy(id = "Acer")
    private ExtendedWebElement selectButton;

    @FindBy(xpath = "//span[contains(text(), \"Ноутбук Acer\")]")
    private ExtendedWebElement productModel;

    public ProductSubcategoryList(WebDriver driver) {
        super(driver);
    }

    public void sendKeysProduct () {
        searchWindow.click();
        searchWindow.type("Acer");
        selectButton.click();
    }

    public void ensureProductsOnPage (){
     productModel.isClickable();

    }
}
