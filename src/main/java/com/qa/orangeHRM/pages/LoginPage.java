package com.qa.orangeHRM.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

      private Page page;

    //1. String Locator --OR

    public String xUserName = "//input[@name='username']";
    public String xPassword= "//input[@name='password']";
    public String xLoginBtn = "//button[@type='submit']";

    //Page Constructor
    public LoginPage(Page page){
        this.page=page;
    }

    //Page actions

    public String aGetLoginTitle(){
        String Title = page.title();
        System.out.println(Title);
        return Title;
    }
    public void aLogintoApplication(String userName, String password){
        page.fill(xUserName,userName);
        page.fill(xPassword,password);
        page.click(xLoginBtn);
        System.out.println("Logged into the Application...");

    }

    public DashBoardPage aNavigateToDashBoardPage(String userName, String password){
        aLogintoApplication(userName,password);
        return new DashBoardPage(page);
    }
}

