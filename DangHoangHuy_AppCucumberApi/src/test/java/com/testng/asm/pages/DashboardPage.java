package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    public DashboardPage(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    public MacroPage navigateToMacroPage(){
        scrollToElementByVisibleText("Add Macro");
        actionKeyword.click(getElementByName("Add Macro"));
        return new MacroPage(this.driver);
    }

    public ActionBlocksPage navigateToActionBlocksPage(){
        scrollToElementByVisibleText("Action Blocks");
        actionKeyword.click(getElementByName("Action Blocks"));
        return new ActionBlocksPage(this.driver);
    }
}
