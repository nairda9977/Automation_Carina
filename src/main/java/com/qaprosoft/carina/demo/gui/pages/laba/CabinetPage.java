package com.qaprosoft.carina.demo.gui.pages.laba;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CabinetPage extends AbstractPage {
    public CabinetPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (className = "cabinet-user__name")
    private ExtendedWebElement cabinetUserName;

    public String getCabinetUserName () {
        assertElementPresent(cabinetUserName);
       return cabinetUserName.getText();
    }

}
