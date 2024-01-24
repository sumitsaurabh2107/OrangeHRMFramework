package com.qa.orangeHRM.base;

import com.microsoft.playwright.Page;
import com.qa.orangeHRM.factory.PlaywrightFactory;
import com.qa.orangeHRM.pages.DashBoardPage;
import com.qa.orangeHRM.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.util.Properties;

public class BaseTest {

     PlaywrightFactory pf;
     Page page;
     protected LoginPage loginPage;
     protected DashBoardPage dashBoardPage;
     protected  Properties prop;

    @BeforeTest
    public void setup() throws FileNotFoundException {
        pf = new PlaywrightFactory();
        prop=pf.init_prop();
        page= pf.initBrowser(prop);
        loginPage = new LoginPage(page);
    }

    @AfterTest
    public void teardown(){
        page.context().browser().close();
    }
}
