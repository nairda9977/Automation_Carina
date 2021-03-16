package com.qaprosoft.carina.demo.myTest;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.demo.gui.myComponents.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.laba.CabinetPage;
import com.qaprosoft.carina.demo.gui.pages.laba.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutorizationTest extends AbstractTest {
    @Test
    public void verifyUserLogin () {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = new LoginPage(getDriver());
        CabinetPage cabinetPage = loginPage.loginOnPage();
        Assert.assertEquals(cabinetPage.getCabinetUserName(), "Адриан Костя", "Name is not correspond");
    }
}
