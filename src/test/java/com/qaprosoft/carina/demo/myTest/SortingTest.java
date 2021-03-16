package com.qaprosoft.carina.demo.myTest;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.gui.pages.laba.HomePage;
import com.qaprosoft.carina.demo.gui.pages.laba.ProductSubCategoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortingTest extends AbstractTest {
    @Test
    public void checkSortingProductsByPrice () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductSubCategoryPage productSubCategoryPage = homePage.searchProduct("клавиатура");
        productSubCategoryPage.isPageOpened();
        Assert.assertTrue(productSubCategoryPage.isProductsSortedByPriceCheck());
    }


}
