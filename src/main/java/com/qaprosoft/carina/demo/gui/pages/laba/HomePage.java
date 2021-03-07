package com.qaprosoft.carina.demo.gui.pages.laba;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.enums.ProductCategories;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    public static final Logger LOGGER = Logger.getLogger(HomePage.class);
    @FindBy(xpath = "//a[@class='menu-categories__link' and contains(text(), '%s')]")
    private ExtendedWebElement selectCategory;

    @FindBy (xpath = "//input[@name=\"search\"and contains (@placeholder, \"Я шукаю\") ]")
    private ExtendedWebElement searchWindow;

    @FindBy (className = "search-suggest__item")
    private ExtendedWebElement searchedProduct;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public ProductCategoriesPage selectCategory (ProductCategories productCategories) {
        selectCategory.format(productCategories.getValue()).click();
        return new ProductCategoriesPage(getDriver());
    }

    public ProductSubCatPage searchProduct () {
        searchWindow.click();
        searchWindow.type("вело");
        searchedProduct.click();
        return new ProductSubCatPage(getDriver());
    }




}
