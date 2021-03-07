package com.qaprosoft.carina.demo.gui.myComponents;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.pages.laba.CabinetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy (xpath = "//a[@class='header__button' and contains(@href, 'cabinet')]")
    private ExtendedWebElement cabinetButton;
    @FindBy (xpath = "//*[@class=\"header-actions__item header-actions__item--user\"]")
    private ExtendedWebElement userLoginButton;

    @FindBy(id = "auth_email")
    private ExtendedWebElement emailLoginField;

    @FindBy(id = "auth_pass")
    private ExtendedWebElement passLoginField;

    @FindBy (xpath = "//*[@class=\"button button--large button--green auth-modal__submit\"]")
    private ExtendedWebElement submitButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public CabinetPage loginOnPage () {
        userLoginButton.click();
        emailLoginField.type("nairda9977@gmail.com");
        passLoginField.type("visaR999");
        submitButton.click();
        pause(60);
        cabinetButtonClick();
return new CabinetPage (getDriver());
    }

    public void cabinetButtonClick () {
        cabinetButton.click();

    }
}
