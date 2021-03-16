package com.qaprosoft.carina.demo.gui.myComponents;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SideMenuPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='side-menu__header']")
    private ExtendedWebElement sideMenuLogo;

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSideMenuPageOpened () {
       return sideMenuLogo.isElementPresent();
    }



}
