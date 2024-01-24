package com.qa.orangeHRM.test;

import com.microsoft.playwright.Page;
import com.qa.orangeHRM.base.BaseTest;
import com.qa.orangeHRM.constants.AppConstants;
import com.qa.orangeHRM.factory.PlaywrightFactory;
import com.qa.orangeHRM.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
    @Test
    public void LoginApplication(){
        loginPage.aLogintoApplication(prop.getProperty("username").trim(),prop.getProperty("password").trim());
    }
    @Test
    public void LoginPageTitle(){
        String ActualTitle=loginPage.aGetLoginTitle();
        Assert.assertEquals(ActualTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

}
