package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddConstraintPage extends BasePage {
    public AddConstraintPage(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String btnOkId = "android:id/button1";

    public WebElement getOkButton(){
        return actionKeyword.findElementCustom(By.id(btnOkId));
    }

    public AddConstraintPage clickOnDeviceStateView(){
        scrollToElementByVisibleText("Device State");
        actionKeyword.click(getElementByName("Device State"));
        return this;
    }

    public AddConstraintPage clickOnAirplaneModeButton(){
        scrollToElementByVisibleText("Airplane Mode");
        actionKeyword.click(getElementByName("Airplane Mode"));
        return this;
    }

    public AddConstraintPage selectAirplaneModeDisabledRadioButton(){
        actionKeyword.click(getElementByName("Airplane Mode Disabled"));
        return this;
    }

    public MacroPage clickOkButton(){
        actionKeyword.click(getOkButton());
        return new MacroPage(this.driver);
    }
}