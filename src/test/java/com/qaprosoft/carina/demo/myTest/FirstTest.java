package com.qaprosoft.carina.demo.myTest;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.enums.LaptopPcSubcategory;
import com.qaprosoft.carina.demo.enums.ProductCategories;
import com.qaprosoft.carina.demo.gui.myComponents.BucketPage;
import com.qaprosoft.carina.demo.gui.myComponents.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.laba.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstTest extends AbstractTest {
   @Test
    public void isModelOnPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductCategoriesPage productCategoriesList = homePage.selectCategory(ProductCategories.LAPTOPS_PC);
        ProductSubCatPage prodSubCatPage = productCategoriesList.selectSubcategoryProduct(LaptopPcSubcategory.LAPTOPS);
        prodSubCatPage.searchBrandProduct();
        Assert.assertTrue(prodSubCatPage.readModelTitle().contains("Ноутбук Acer"),  "Invalid product");
    }

    @Test
    public void userLogin () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = new LoginPage(getDriver());
        CabinetPage cabinetPage = loginPage.loginOnPage();
        Assert.assertEquals(cabinetPage.getCabinetUserName(), "Адриан Костя", "Name is not correspond");
    }

    @Test
    public void addObjToBucket () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductSubCatPage productSubCatPage = homePage.searchProduct();
        Assert.assertTrue(productSubCatPage.isPageOpened(), "Product category page is not opened");
        String getProductTitle = productSubCatPage.getProductTitleValue();
        ProductInfo productInfo = productSubCatPage.clickOnProduct();
        Assert.assertTrue(productInfo.isPageOpened(), "Product info page is not opened");
        BucketPage bucketPage = productInfo.buyProduct();
        Assert.assertTrue(bucketPage.isPageOpened(), "Page is not opened");
        String getBucketProductTitle = bucketPage.getProductTitleValue();
        Assert.assertEquals(getProductTitle, getBucketProductTitle, "Product is not added to bucket");
    }

    @Test
    public void checkPriceFilter () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductCategoriesPage productCategoriesPage = homePage.selectCategory(ProductCategories.LAPTOPS_PC);
        Assert.assertTrue(productCategoriesPage.isPageOpened(), "Product categories page is not opened");
        ProductSubCatPage productSubCatPage = productCategoriesPage.selectSubcategoryProduct(LaptopPcSubcategory.LAPTOPS);
        Assert.assertTrue(productSubCatPage.isPageOpened(), "Product subcategory page is not opened");
        productSubCatPage.inputPrice();
        Assert.assertTrue(productSubCatPage.comparePrice(), "result is not between MinMax");
   }

   @Test
    public void fromLowToHighPriceFilterCheck () {
       HomePage homePage = new HomePage(getDriver());
       homePage.open();
       ProductSubCatPage productSubCatPage = homePage.searchProduct();
       productSubCatPage.isPageOpened();
      Assert.assertTrue(productSubCatPage.comparePricefromLowToHight(), "blablalba");
   }



}
