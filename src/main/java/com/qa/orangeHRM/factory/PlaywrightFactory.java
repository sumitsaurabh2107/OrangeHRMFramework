package com.qa.orangeHRM.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;
    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static Playwright getPlaywright(){
        return tlPlaywright.get();
    }
    public static Page getPage(){
        return tlPage.get();
    }
    public static BrowserContext getBrowserContext(){
        return tlBrowserContext.get();
    }
    public static Browser getBrowser(){
        return tlBrowser.get();
    }

    public Page initBrowser(Properties prop){
        String browserName=prop.getProperty("browser").trim();
        System.out.println("The browser name is: "+browserName);
        //playwright= Playwright.create();
        tlPlaywright.set(Playwright.create());

        switch(browserName.toLowerCase()){
            case "chromium":
              // browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "chrome":
               // browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;
            default:
                System.out.println("please pass the correct browser name..");
                break;
        }

        tlBrowserContext.set(getBrowser().newContext());
        tlPage.set(getBrowserContext().newPage());
        getPage().navigate(prop.getProperty("url").trim());

//        browserContext = browser.newContext();
//        page= browserContext.newPage();
//        page.navigate(prop.getProperty("url").trim());

        return getPage();
    }

    /**
     * This method is used to intialize properties from config file
     */
    public Properties init_prop() throws FileNotFoundException {
       try {
           FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
           prop = new Properties();
           prop.load(ip);
       } catch(FileNotFoundException e){
           e.printStackTrace();
           System.out.println("File not found..");
        } catch (IOException e) {
           throw new RuntimeException(e);
       }
       return prop;
    }
    /**
     * Take Screenshot
     */
     public static String takeScreenshot(){

            String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
            getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
            return path;

     }

}
