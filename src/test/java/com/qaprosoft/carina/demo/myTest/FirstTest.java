package com.qaprosoft.carina.demo.myTest;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.enums.LaptopPcSubcategory;
import com.qaprosoft.carina.demo.gui.pages.laba.HomePage;
import com.qaprosoft.carina.demo.gui.pages.laba.ProductCategoriesList;
import com.qaprosoft.carina.demo.gui.pages.laba.ProductSubcategoryList;
import org.junit.Test;

public class FirstTest extends AbstractTest {
    @Test
    public void checkListOfProducts () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.selectCategory();
        ProductCategoriesList productCategoriesList = new ProductCategoriesList(getDriver());
        productCategoriesList.selectSubcategoryProduct(LaptopPcSubcategory.LAPTOPS);
        ProductSubcategoryList productSubcategoryList = new ProductSubcategoryList(getDriver());
        productSubcategoryList.sendKeysProduct();
        productSubcategoryList.ensureProductsOnPage();
        homePage.quitDriver();
    }


}
