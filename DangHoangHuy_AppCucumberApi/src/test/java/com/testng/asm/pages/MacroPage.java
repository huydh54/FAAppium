package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MacroPage extends BasePage {
    public MacroPage(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String btnAddTriggerId = "com.arlosoft.macrodroid:id/edit_macro_addTriggerButton";
    private String btnAddActionId = "com.arlosoft.macrodroid:id/edit_macro_addActionButton";
    private String btnAddConstraintId = "com.arlosoft.macrodroid:id/edit_macro_addConstraintButton";
    private String btnAddLocalVariablesId = "com.arlosoft.macrodroid:id/addVariableButton";
    private String edtVariableNameId = "com.arlosoft.macrodroid:id/variable_new_variable_dialog_name";
    private String spnVariableTypeId = "com.arlosoft.macrodroid:id/variable_new_variable_type_spinner";
    private String btnOkId = "com.arlosoft.macrodroid:id/okButton";
    private String edtVariableValueId = "com.arlosoft.macrodroid:id/enter_variable_dialog_value";

    public WebElement getAddTriggerButton(){
        return actionKeyword.findElementCustom(By.id(btnAddTriggerId));
    }

    public WebElement getAddActionButton(){
        return actionKeyword.findElementCustom(By.id(btnAddActionId));
    }

    public WebElement getAddConstraintButton(){
        return actionKeyword.findElementCustom(By.id(btnAddConstraintId));
    }

    public AddTriggerPage navigateToAddTriggerPage() {
        actionKeyword.click(getAddTriggerButton());
        return new AddTriggerPage(this.driver);
    }

    public AddActionPage navigateToAddActionPage() {
        actionKeyword.click(getAddActionButton());
        return new AddActionPage(this.driver);
    }

    public AddConstraintPage navigateToAddConstraintPage() {
        actionKeyword.click(getAddConstraintButton());
        return new AddConstraintPage(this.driver);
    }

    public WebElement getAddLocalVariablesButton(){
        return actionKeyword.findElementCustom(By.id(btnAddLocalVariablesId));
    }

    public MacroPage clickOnLocalVariablesButton(){
        scrollToElementByVisibleText("Local Variables");
        actionKeyword.click(getElementByName("Local Variables"));
        return this;
    }

    public MacroPage clickOnAddLocalVariablesButton(){
        actionKeyword.click(getAddLocalVariablesButton());
        return this;
    }

    public WebElement getVariableNameEditText(){
        return actionKeyword.findElementCustom(By.id(edtVariableNameId));
    }

    public WebElement getVariableTypeSpinner(){
        return actionKeyword.findElementCustom(By.id(spnVariableTypeId));
    }

    public MacroPage enterVariableName(String variableName){
        actionKeyword.setText(getVariableNameEditText(), variableName);
        return this;
    }

    public MacroPage selectVariableType() {
        actionKeyword.click(getVariableTypeSpinner());
        actionKeyword.click(getElementByName("Integer"));
        return this;
    }

    public WebElement getOkButton(){
        return actionKeyword.findElementCustom(By.id(btnOkId));
    }

    public MacroPage clickOkButton(){
        actionKeyword.click(getOkButton());
        return new MacroPage(this.driver);
    }

    public MacroPage clickOnNewLocalVariablesView(String variableName){
        actionKeyword.click(getElementByName(variableName));
        return this;
    }

    public WebElement getVariableValueEditText(){
        return actionKeyword.findElementCustom(By.id(edtVariableValueId));
    }

    public MacroPage enterVariableValue(String variableValue){
        actionKeyword.setText(getVariableValueEditText(), variableValue);
        return this;
    }

    public boolean newApplicationRemovedTriggerIsDisplay() {
        try {
            Thread.sleep(500);
            return driver.findElement(By.xpath(String.format(txtViewNameXpath, "Application Removed"))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean newClearLogActionIsDisplay() {
        try {
            Thread.sleep(500);
            return driver.findElement(By.xpath(String.format(txtViewNameXpath, "Clear Log"))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean newAirplaneModeDisabledConstraintIsDisplay() {
        try {
            Thread.sleep(500);
            return driver.findElement(By.xpath(String.format(txtViewNameXpath, "Airplane Mode Disabled"))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean newVariableValueIsDisplay(String variableValue) {
        try {
            Thread.sleep(500);
            return driver.findElement(By.xpath(String.format(txtViewNameXpath, variableValue))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
