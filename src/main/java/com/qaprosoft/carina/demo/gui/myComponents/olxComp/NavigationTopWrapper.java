package com.qaprosoft.carina.demo.gui.myComponents.olxComp;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigationWrapper extends AbstractPage {
    @FindBy (id = "headerLogo")
    private ExtendedWebElement headerLogo;

    @FindBy (id = "postNewAdLink")
    private ExtendedWebElement postNewAnnouncementButton;

    public NavigationWrapper(WebDriver driver) {
        super(driver);
    }
}
