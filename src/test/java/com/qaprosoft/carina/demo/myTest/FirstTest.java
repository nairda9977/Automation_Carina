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
        prodSubCatPage.searchBrandProduct("Acer");
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
        ProductSubCatPage productSubCatPage = homePage.searchProduct("Велосипед");
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
    public void isProductBetweenMinAndMaxPrices () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductCategoriesPage productCategoriesPage = homePage.selectCategory(ProductCategories.LAPTOPS_PC);
        Assert.assertTrue(productCategoriesPage.isPageOpened(), "Product categories page is not opened");
        ProductSubCatPage productSubCatPage = productCategoriesPage.selectSubcategoryProduct(LaptopPcSubcategory.LAPTOPS);
        Assert.assertTrue(productSubCatPage.isPageOpened(), "Product subcategory page is not opened");
        Assert.assertTrue(productSubCatPage.isProductBetweenHightAndLowPrices("3000", "7000"), "result is not between MinMax");
   }

   @Test
   public void deleteProductFromBucket () {
       HomePage homePage = new HomePage(getDriver());
       homePage.open();
       ProductSubCatPage productSubCatPage= homePage.searchProduct("ручка");
       Assert.assertTrue(productSubCatPage.isPageOpened(), "Product subcategory page is not opened");
       String productTitle = productSubCatPage.getProductTitleValue();
       ProductInfo productInfo = productSubCatPage.clickOnProduct();
       Assert.assertTrue(productInfo.isPageOpened(), "Product info is not opened");
       BucketPage bucketPage = productInfo.buyProduct();
       Assert.assertTrue(bucketPage.isPageOpened(), "Bucket Page is not opened");
       String productTitleInBucket = bucketPage.getProductTitleValue();
       Assert.assertEquals(productTitle, productTitleInBucket, "product is different");
        Assert.assertTrue(bucketPage.deleteProd());
   }

   @Test
    public void fromLowToHighPriceProducts () {
       HomePage homePage = new HomePage(getDriver());
       homePage.open();
       ProductSubCatPage productSubCatPage = homePage.searchProduct("клавиатура");
       productSubCatPage.isPageOpened();
       Assert.assertTrue(productSubCatPage.comparePriceFromLowToHigh());
   }

   @Test
    public void productTitlesOnProductSubCategoryPage () {
       HomePage homePage = new HomePage(getDriver());
       homePage.open();
       ProductCategoriesPage productCategoriesPage=homePage.selectCategory(ProductCategories.LAPTOPS_PC);
       Assert.assertTrue(productCategoriesPage.isPageOpened());
       ProductSubCatPage productSubCatPage = productCategoriesPage.selectSubcategoryProduct(LaptopPcSubcategory.LAPTOPS);
       Assert.assertTrue(productSubCatPage.isPageOpened());
       Assert.assertTrue(productSubCatPage.productsTitlesCheck());
   }

   @Test
    public void isAllProductsHavePricesSubCatPage () {
       HomePage homePage = new HomePage(getDriver());
       homePage.open();
       ProductSubCatPage productSubCatPage= homePage.searchProduct("клавиатура");
       Assert.assertTrue(productSubCatPage.isPageOpened());
       Assert.assertTrue(productSubCatPage.productsPricesCheckOnSubCatPage());
    }

    @Test
    public void isAllProdInfoPagesHaveBuyButton () {
       HomePage homePage = new HomePage(getDriver());
       homePage.open();
       ProductSubCatPage productSubCatPage= homePage.searchProduct("Acer");
       productSubCatPage.isPageOpened();
       Assert.assertTrue(productSubCatPage.isAllProdInfoPagesHaveBuyButton());

    }






}
