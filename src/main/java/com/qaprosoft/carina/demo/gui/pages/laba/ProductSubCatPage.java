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

    @FindBy (xpath = "//select[@class=\"select-css ng-untouched ng-pristine ng-valid\"]")
    private ExtendedWebElement byRaitingPriceButton;

    @FindBy (xpath = "//option[@value=\"1: cheap\"]")
    private ExtendedWebElement fromLowToHeightButton;
    @FindBy(xpath = "//span[@class=\"goods-tile__price-value\"]")
    private ExtendedWebElement priceList;

    public void comparePriceFromLToH () {
        byRaitingPriceButton.click();
        fromLowToHeightButton.click();
        int priceBefore =0;
        int curentPriceInt=0;
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class=\"goods-tile__price-value\"]"));
        for (WebElement currentPrice : priceElements){
                String priceOfProdStr = StringUtils.deleteWhitespace(currentPrice.getText());
                 curentPriceInt = Integer.parseInt(priceOfProdStr);


            if (curentPriceInt>priceBefore){


            }
            priceBefore=curentPriceInt;

            }

    }




    public String readModelTitle () {
        assertElementPresent(modelTitle);
        return modelTitle.getText();

    }

    public boolean isPageOpened() {
        pageTitle.assertElementPresent();
        return true;
    }

    public ProductSubCatPage(WebDriver driver) {
        super(driver);
    }

    public LeftBarSearchResult searchBrandProduct() {
        searchTextField.type("Acer");
        selectButton.click();
        return new LeftBarSearchResult(getDriver());
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

    public LeftBarSearchResult inputPrice() {
        priceMinSearchWindow.type("3000");
        priceMaxSearchWindow.type("7000");
        priceButton.click();
        return new LeftBarSearchResult(getDriver());
    }

    int priceMin = 3000;
    int priceMax = 7000;
    public boolean comparePrice() {
        if (getPriceValue() > priceMin && getPriceValue() < priceMax) {
            LOGGER.info("value is between MinMax price");
            return true;
        }
        return false;
    }

    public boolean comparePricefromLowToHight () {
    byRaitingPriceButton.click();
    fromLowToHeightButton.click();
    int box =0;
    int priceForCompare =getPriceValue();

    for (int i=0; i<5;i++){
      priceForCompare =  getPriceValue();
        System.out.println("price is :" +priceForCompare);
        if(box<priceForCompare){

            return true;
        }
        box = priceForCompare;
    }
    return false;
    }

}
