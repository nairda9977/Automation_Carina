package com.qaprosoft.carina.demo.myTest;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.gui.myComponents.BucketPage;
import com.qaprosoft.carina.demo.gui.pages.laba.HomePage;
import com.qaprosoft.carina.demo.gui.pages.laba.ProductInfoPage;
import com.qaprosoft.carina.demo.gui.pages.laba.ProductSubCategoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BucketTest extends AbstractTest {
    @Test
    public void addProdToBucket () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductSubCategoryPage productSubCategoryPage = homePage.searchProduct("Велосипед");
        Assert.assertTrue(productSubCategoryPage.isPageOpened(), "Product category page is not opened");
        String productTitle = productSubCategoryPage.getProductTitleValue();
        ProductInfoPage productInfoPage = productSubCategoryPage.clickOnProduct();
        Assert.assertTrue(productInfoPage.isPageOpened(), "Product info page is not opened");
        BucketPage bucketPage = productInfoPage.buyProduct();
        Assert.assertTrue(bucketPage.isPageOpened(), "Page is not opened");
        String bucketProductTitle = bucketPage.getProductTitleValue();
        Assert.assertEquals(productTitle, bucketProductTitle, "Product is not added to bucket");
    }

    @Test
    public void deleteProdFromBucket () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductSubCategoryPage productSubCategoryPage = homePage.searchProduct("ручка");
        Assert.assertTrue(productSubCategoryPage.isPageOpened(), "Product subcategory page is not opened");
        String productTitle = productSubCategoryPage.getProductTitleValue();
        ProductInfoPage productInfoPage = productSubCategoryPage.clickOnProduct();
        Assert.assertTrue(productInfoPage.isPageOpened(), "Product info is not opened");
        BucketPage bucketPage = productInfoPage.buyProduct();
        Assert.assertTrue(bucketPage.isPageOpened(), "Bucket Page is not opened");
        String productTitleInBucket = bucketPage.getProductTitleValue();
        Assert.assertEquals(productTitle, productTitleInBucket, "product is different");
        Assert.assertTrue(bucketPage.deleteProd());
    }

}
