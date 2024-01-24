package com.qa.orangeHRM.test;

import com.microsoft.playwright.Page;
import com.qa.orangeHRM.base.BaseTest;
import com.qa.orangeHRM.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardPageTests extends BaseTest {
    @Test(priority = 1)
    public void headerFooterValidation(){
        dashBoardPage=loginPage.aNavigateToDashBoardPage(prop.getProperty("username"),prop.getProperty("password"));
        dashBoardPage.aVerifyHeaderFooter("dashboard");
        String ActualHeading= dashBoardPage.oHeading().textContent();
        Assert.assertEquals(ActualHeading,"Dashboard");
        dashBoardPage.aVerifyHeaderFooter("copyrights");
    }
}
