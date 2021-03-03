package com.qaprosoft.carina.demo.gui.pages.laba;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.enums.LaptopPcSubcategory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCategoriesList extends AbstractPage {
    public static final Logger LOGGER = Logger.getLogger(ProductCategoriesList.class);

    @FindBy(xpath = "//a[@class=\"tile-cats__heading tile-cats__heading_type_center\" and @title = \"%s\"]")
   private ExtendedWebElement selectCategoryProduct;

    public ProductCategoriesList(WebDriver driver) {
        super(driver);
    }

    public ProductSubcategoryList selectSubcategoryProduct (LaptopPcSubcategory laptopPcSubcategory) {
        selectCategoryProduct.format(laptopPcSubcategory.getLaptPcSub()).click();
        return new  ProductSubcategoryList(getDriver());
    }






}
