package com.qaprosoft.carina.demo.gui.pages.laba;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    public static final Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(id="fat-menu")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = " //*[@class=\"menu-categories__link\"]")
    private ExtendedWebElement product;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private void selectProduct (ExtendedWebElement productOnPage) {
        productOnPage.click();
    }


}
