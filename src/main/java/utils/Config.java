package utils;

import com.microsoft.playwright.*;
//Class to handle the configuration of the playwright
public class Config {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        int timeout = 15000;
        context.setDefaultTimeout(timeout);
    }

    public static void tearDown() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }

    public static Page getPage() {
        return page;
    }
}

