package com.qaprosoft.carina.demo.myTest;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.enums.LaptopPcSubcategory;
import com.qaprosoft.carina.demo.enums.ProductCategories;
import com.qaprosoft.carina.demo.gui.myComponents.SideMenuPage;
import com.qaprosoft.carina.demo.gui.pages.laba.HomePage;
import com.qaprosoft.carina.demo.gui.pages.laba.ProductCategoriesPage;
import com.qaprosoft.carina.demo.gui.pages.laba.ProductSubCategoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends AbstractTest {
    @Test
    public void verifyModelOnPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductCategoriesPage productCategoriesList = homePage.selectCategory(ProductCategories.LAPTOPS_PC);
        ProductSubCategoryPage prodSubCatPage = productCategoriesList.selectSubcategoryProduct(LaptopPcSubcategory.LAPTOPS);
        prodSubCatPage.searchBrandProduct("Acer");
        Assert.assertTrue(prodSubCatPage.readModelTitle().contains("Ноутбук Acer"),  "Invalid product");
    }

    @Test
    public void verifyProductTitlesOnProductSubCategoryPage () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductCategoriesPage productCategoriesPage=homePage.selectCategory(ProductCategories.LAPTOPS_PC);
        Assert.assertTrue(productCategoriesPage.isPageOpened());
        ProductSubCategoryPage productSubCategoryPage = productCategoriesPage.selectSubcategoryProduct(LaptopPcSubcategory.LAPTOPS);
        Assert.assertTrue(productSubCategoryPage.isPageOpened());
        Assert.assertTrue(productSubCategoryPage.isAllProductsHaveTitles());
    }

    @Test
    public void checkAllProductsHavePricesSubCatPage () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductSubCategoryPage productSubCategoryPage = homePage.searchProduct("клавиатура");
        Assert.assertTrue(productSubCategoryPage.isPageOpened());
        Assert.assertTrue(productSubCategoryPage.issAllProductsHavePricesOnSubCatPage());
    }

    @Test
    public void verifyAllProdOnInfoPagesHaveBuyButton () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductSubCategoryPage productSubCategoryPage = homePage.searchProduct("Acer");
        productSubCategoryPage.isPageOpened();
        Assert.assertTrue(productSubCategoryPage.isAllProdInfoPagesHaveBuyButton());

    }

    @Test
    public void verifyProductIdOnInfoPage () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductSubCategoryPage productSubCategoryPage=homePage.searchProduct("велосипед");
        Assert.assertTrue(productSubCategoryPage.isPageOpened());
        Assert.assertTrue(productSubCategoryPage.isAllProductHaveId());

    }

    @Test
    public void verifyOpeningSideMenu () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SideMenuPage sideMenuPage = homePage.openSideMenuPage();
        Assert.assertTrue(sideMenuPage.isSideMenuPageOpened());
    }

}
