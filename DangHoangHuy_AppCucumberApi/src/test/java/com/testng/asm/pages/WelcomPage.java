package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WelcomPage extends BasePage {
    public WelcomPage(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String btnSkipId = "com.arlosoft.macrodroid:id/button_skip";

    public WebElement getSkipButton(){
        return actionKeyword.findElementCustom(By.id(btnSkipId));
    }

    public DashboardPage navigateToDashboardPage() {
        actionKeyword.click(getSkipButton());
        return new DashboardPage(this.driver);
    }
}
