package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ActionBlocksPage extends BasePage {
    public ActionBlocksPage(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String btnAddNewActionBlockId = "com.arlosoft.macrodroid:id/fab";
    private String txtActionBlockNameId = "com.arlosoft.macrodroid:id/name";
    private String txtActionBlockDescriptionId = "com.arlosoft.macrodroid:id/description";

    public WebElement getAddNewActionBlockButton(){
        return actionKeyword.findElementCustom(By.id(btnAddNewActionBlockId));
    }

    public WebElement getActionBlockName(){
        return actionKeyword.findElementCustom(By.id(txtActionBlockNameId));
    }

    public WebElement getActionBlockDescription() {
        return actionKeyword.findElementCustom(By.id(txtActionBlockDescriptionId));
    }

    public ActionBlockDetailPage clickOnAddNewActionBlock(){
        actionKeyword.click(getAddNewActionBlockButton());
        return new ActionBlockDetailPage(this.driver);
    }

    public boolean actionBlockNameIsCorrect(String actionBlockName) {
        return getActionBlockName().getText().equals(actionBlockName);
    }

    public boolean actionBlockDescriptionIsCorrect(String actionBlockDescription) {
        return getActionBlockDescription().getText().equals(actionBlockDescription);
    }
}
