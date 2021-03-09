package com.qaprosoft.carina.demo.gui.pages.laba;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductSubCatPage extends AbstractPage {

    private final static Logger LOGGER = Logger.getLogger(ProductSubCatPage.class);

    @FindBy(xpath = "//*[@name=\"searchline\"][1]")
    private ExtendedWebElement searchTextField;

    @FindBy(id = "Acer")
    private ExtendedWebElement selectButton;

    @FindBy(xpath = "//span[contains(text(), \"Ноутбук Acer\")]")
    private ExtendedWebElement productModel;

    @FindBy(xpath = "//span[@class=\"goods-tile__title\"]")
    private ExtendedWebElement anyProduct;

    @FindBy(xpath = "//h1[@class=\"catalog-heading\"]")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//*[@formcontrolname=\"min\"]")
    private ExtendedWebElement priceMinSearchWindow;

    @FindBy(xpath = "//*[@formcontrolname=\"max\"]")
    private ExtendedWebElement priceMaxSearchWindow;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    private ExtendedWebElement priceButton;

    @FindBy(xpath = " //span[@class='goods-tile__title' and contains(text(), 'Ноутбук Acer')]")
    private ExtendedWebElement modelTitle;

    @FindBy(xpath = "//span[@class=\"goods-tile__price-value\"]")
    private ExtendedWebElement price;

    @FindBy (xpath = "//span[@class=\"goods-tile__price-value\"]")
    private List <ExtendedWebElement> prices;

    @FindBy (xpath = "//select[@class=\"select-css ng-untouched ng-pristine ng-valid\"]")
    private ExtendedWebElement sortProdByRatingPriceButton;

    @FindBy (xpath = "//option[@value=\"1: cheap\"]")
    private ExtendedWebElement fromLowToHeightButton;

    @FindBy(xpath = "//span[@class=\"goods-tile__price-value\"]")
    private ExtendedWebElement priceList;

    @FindBy (xpath = "//span[@class=\"goods-tile__title\"]")
    private List <ExtendedWebElement> productTitles;

    @FindBy (xpath = "//button[@type=\"button\"and contains (text(), \"Купити в кредит\")]")
    private ExtendedWebElement creditButton;

    public ProductSubCatPage(WebDriver driver) {
        super(driver);
    }

    public boolean sortProductsByPriceCheck () {
        sortProdByRatingPriceButton.click();
        fromLowToHeightButton.click();
        int priceBefore =0;
        int sizeOfEl = prices.size();
        for (ExtendedWebElement currentPrice : prices){
                String priceOfProdStr = StringUtils.deleteWhitespace(currentPrice.getText());
               int  curentPriceInt = Integer.parseInt(priceOfProdStr);
            System.out.println("current Price : "+curentPriceInt+"  priceBefore : "+priceBefore);
            for (int i = 0; i <= sizeOfEl; i++){
                if(curentPriceInt<priceBefore){
                    return false;
                }
            }
            priceBefore=curentPriceInt;
            }
        return true;
    }

    public boolean productsPricesCheckOnSubCatPage () {
      for (ExtendedWebElement productPrice : prices){
            if(productPrice.getText().isEmpty()){
                return false;
            }
          System.out.println("Product price is :"+productPrice);
        }
      return true;
    }

    public boolean productsTitlesCheck () {
        for (ExtendedWebElement productTitle : productTitles){
            String productTitleStr = productTitle.getText();
                if (productTitleStr.isEmpty()) {
                    return false;
                }
                System.out.println("Prod title is : "+ productTitleStr);
        }
        return true;
    }

    public String readModelTitle () {
        assertElementPresent(modelTitle);
        return modelTitle.getText();

    }

    public boolean isPageOpened() {
        pageTitle.assertElementPresent();
        return true;
    }


    public ProductSubCatPage searchBrandProduct(String q) {
        searchTextField.type(q);
        selectButton.click();
        return new ProductSubCatPage(getDriver());
    }

    public String getProductTitleValue() {
        return anyProduct.getText();
    }

    public ProductInfo clickOnProduct() {
        anyProduct.click();
        return new ProductInfo(getDriver());
    }

    public int getPriceValue() {
        String priceOfProdStr = StringUtils.deleteWhitespace( price.getText());
        int priceInt = Integer.parseInt(priceOfProdStr);
        return priceInt;
    }


    public boolean isProductBetweenMinAndMaxPrices(String min, String max) {
        priceMinSearchWindow.type(min);
        priceMaxSearchWindow.type(max);
        priceButton.click();
        int minPriceInt = Integer.parseInt(min);
        int maxPriceInt = Integer.parseInt(max);
        if (getPriceValue() > minPriceInt && getPriceValue() < maxPriceInt) {
            LOGGER.info("value is between MinMax price");
            return true;
        }
        return false;
    }

    public boolean isAllProdInfoPagesHaveBuyButton() {
       int countProdTitles = productTitles.size();

        for (ExtendedWebElement product : productTitles) {
            for (int i = 0; i <countProdTitles; i++) {
                ExtendedWebElement productIndex = productTitles.get(i);
                productIndex.click();
                ProductInfo productInfo = new ProductInfo(getDriver());
                if (productInfo.getBuyButton().isElementNotPresent(1)) {
                    return false;
                }
                driver.navigate().back();
            }
        }
        return true;
    }




}
