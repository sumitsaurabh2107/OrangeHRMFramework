package com.qa.orangeHRM.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashBoardPage {

    private Page page;

    //1. String Locator

    public String xHeading = "//h6[text()='Dashboard']";
    public String xProfileName = "//p[text()='Paul Collings']";
    public String xTimeAtWork = "//p[text()='Time at Work']";
    public String xMyAction = "//p[text()='My Actions']";
    public String xQuicklaunch = "//p[text()='Quick Launch']";
    public String xBuzzLatest = "//p[text()='Buzz Latest Posts']";
    public String xEmpOnLeave = "//p[text()='Employees on Leave Today']";
    public String xEmpDistributionSubUnit = "//p[text()='Employee Distribution by Sub Unit']";
    public String xEmpDistributionByLocation = "//p[text()='Employee Distribution by Location']";
    public String xCopyrights = "//p[@class='oxd-text oxd-text--p orangehrm-copyright'][2]";

    //Locator Objects----

    public Locator oCopyrights() {return page.locator(xCopyrights);}
    public Locator oHeading() {return page.locator(xHeading);}

    //Page constructor-------

    public DashBoardPage(Page page){
        this.page=page;
    }

    //Page Actions------

    public String aVerifyHeaderFooter(String hfValue){
        switch(hfValue.toLowerCase().trim()){
            case "dashboard" :
                page.locator(xHeading).isVisible();
                String heading=page.locator(xHeading).textContent();
                System.out.println(heading);
                break;
            case "profile name" :
                page.locator(xProfileName).isVisible();
                String profileName = page.locator(xProfileName).textContent();
                System.out.println(profileName);
                break;
            case "copyrights" :
                page.locator(xCopyrights).isVisible();
                String copyrights = page.locator(xCopyrights).textContent();
                System.out.println(copyrights);
                break;
            default:
                System.out.println("Please pass correct header or footer value...!!");

        }
        return hfValue;
    }

    public void aVerifyLabelPresents(String Label){
        switch(Label.toLowerCase().trim()){
            case "time at work":
                page.locator(xTimeAtWork).isVisible();
                String label = page.locator(xTimeAtWork).textContent();
                System.out.println(label);
                break;
            case "my actions":
                page.locator(xMyAction).isVisible();
                String label1 = page.locator(xMyAction).textContent();
                System.out.println(label1);
                break;
            case "quick launch":
                page.locator(xQuicklaunch).isVisible();
                String label2 = page.locator(xQuicklaunch).textContent();
                System.out.println(label2);
                break;
            case "buzz latest posts":
                page.locator(xBuzzLatest).isVisible();
                String label3 = page.locator(xBuzzLatest).textContent();
                System.out.println(label3);
                break;
            case "employee leave today":
                page.locator(xEmpOnLeave).isVisible();
                String label4 = page.locator(xEmpOnLeave).textContent();
                System.out.println(label4);
                break;
            case "employee distribution by sub unit":
                page.locator(xEmpDistributionSubUnit).isVisible();
                String label5 = page.locator(xEmpDistributionSubUnit).textContent();
                System.out.println(label5);
                break;
            case "employee distribution by location":
                page.locator(xEmpDistributionByLocation).isVisible();
                String label6 = page.locator(xEmpDistributionByLocation).textContent();
                System.out.println(label6);
                break;
            default:
                System.out.println("please enter correct label..!!!");
        }

    }


}
