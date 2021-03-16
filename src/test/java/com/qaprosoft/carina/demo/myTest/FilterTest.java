package com.qaprosoft.carina.demo.myTest;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.enums.LaptopPcSubcategory;
import com.qaprosoft.carina.demo.enums.ProductCategories;
import com.qaprosoft.carina.demo.gui.pages.laba.HomePage;
import com.qaprosoft.carina.demo.gui.pages.laba.ProductCategoriesPage;
import com.qaprosoft.carina.demo.gui.pages.laba.ProductSubCategoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTest extends AbstractTest {

    @Test
    public void verifyProductBetweenMinAndMaxPrices () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductCategoriesPage productCategoriesPage = homePage.selectCategory(ProductCategories.LAPTOPS_PC);
        Assert.assertTrue(productCategoriesPage.isPageOpened(), "Product categories page is not opened");
        ProductSubCategoryPage productSubCategoryPage = productCategoriesPage.selectSubcategoryProduct(LaptopPcSubcategory.LAPTOPS);
        Assert.assertTrue(productSubCategoryPage.isPageOpened(), "Product subcategory page is not opened");
        Assert.assertTrue(productSubCategoryPage.isProductBetweenMinAndMaxPrices("3000", "7000"), "result is not between MinMax");
    }
}
