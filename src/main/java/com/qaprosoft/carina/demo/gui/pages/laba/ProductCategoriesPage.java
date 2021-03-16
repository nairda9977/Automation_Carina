package com.qaprosoft.carina.demo.gui.pages.laba;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.enums.KidsProdSubcategory;
import com.qaprosoft.carina.demo.enums.LaptopPcSubcategory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCategoriesPage extends AbstractPage {
    public static final Logger LOGGER = Logger.getLogger(ProductCategoriesPage.class);

    @FindBy(xpath = "//a[@class=\"tile-cats__heading tile-cats__heading_type_center\" and @title = \"%s\"]")
   private ExtendedWebElement selectCategoryProduct;

    @FindBy(xpath = "//*[@class=\"portal__heading\"]")
    private ExtendedWebElement productCatPageTitle;



    public ProductCategoriesPage(WebDriver driver) {
        super(driver);
    }

    public ProductSubCategoryPage selectSubcategoryProduct (LaptopPcSubcategory laptopPcSubcategory) {
        selectCategoryProduct.format(laptopPcSubcategory.getValue()).click();
        return new ProductSubCategoryPage(getDriver());
    }
    public ProductSubCategoryPage selectSubcategoryProduct (KidsProdSubcategory kidsProdSubcategory) {
        selectCategoryProduct.format(kidsProdSubcategory.getValue()).click();
        return new ProductSubCategoryPage(getDriver());
    }

    public boolean isPageOpened () {
        return productCatPageTitle.isElementPresent();
    }






}
