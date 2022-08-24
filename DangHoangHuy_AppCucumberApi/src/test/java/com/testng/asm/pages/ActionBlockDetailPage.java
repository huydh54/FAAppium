package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ActionBlockDetailPage extends BasePage{
    public ActionBlockDetailPage(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String edtActionBlockNameId = "com.arlosoft.macrodroid:id/actionBlockNameText";
    private String edtActionBlockDescriptionId = "com.arlosoft.macrodroid:id/description";
    private String btnAddInputVariableId = "com.arlosoft.macrodroid:id/addInputVariableButton";
    private String btnAddActionId = "com.arlosoft.macrodroid:id/addActionButton";
    private String btnAddOutputVariableId = "com.arlosoft.macrodroid:id/addOutputVariableButton";
    private String btnInputCollapseExpandId = "com.arlosoft.macrodroid:id/inputCollapseExpandButton";
    private String btnOutputCollapseExpandId = "com.arlosoft.macrodroid:id/outputCollapseExpandButton";
    private String edtVariableNameId = "com.arlosoft.macrodroid:id/variable_new_variable_dialog_name";
    private String spnVariableTypeId = "com.arlosoft.macrodroid:id/variable_new_variable_type_spinner";
    private String btnOk = "com.arlosoft.macrodroid:id/okButton";
    private String rdoTrue = "com.arlosoft.macrodroid:id/trueRadio";
    private String rdoFalse = "com.arlosoft.macrodroid:id/falseRadio";
    private String edtVariableValueId = "com.arlosoft.macrodroid:id/enter_variable_dialog_value";
    private String btnAccept = "com.arlosoft.macrodroid:id/acceptButton";

    public WebElement getActionBlockNameEditText(){
        return actionKeyword.findElementCustom(By.id(edtActionBlockNameId));
    }

    public WebElement getActionBlockDescriptionEditText(){
        return actionKeyword.findElementCustom(By.id(edtActionBlockDescriptionId));
    }

    public WebElement getAddInputVariableButton(){
        return actionKeyword.findElementCustom(By.id(btnAddInputVariableId));
    }

    public WebElement getAddActionButton(){
        return actionKeyword.findElementCustom(By.id(btnAddActionId));
    }

    public WebElement getAddOutputVariableButton(){
        return actionKeyword.findElementCustom(By.id(btnAddOutputVariableId));
    }

    public WebElement getInputCollapseExpandButton(){
        return actionKeyword.findElementCustom(By.id(btnInputCollapseExpandId));
    }

    public WebElement getOutputCollapseExpandButton(){
        return actionKeyword.findElementCustom(By.id(btnOutputCollapseExpandId));
    }

    public WebElement getVariableNameEditText(){
        return actionKeyword.findElementCustom(By.id(edtVariableNameId));
    }

    public WebElement getVariableTypeSpinner(){
        return actionKeyword.findElementCustom(By.id(spnVariableTypeId));
    }

    public WebElement getOkButton(){
        return actionKeyword.findElementCustom(By.id(btnOk));
    }

    public WebElement getTrueRadioButton(){
        return actionKeyword.findElementCustom(By.id(rdoTrue));
    }

    public WebElement getFalseRadioButton(){
        return actionKeyword.findElementCustom(By.id(rdoFalse));
    }

    public WebElement getVariableValueEditText(){
        return actionKeyword.findElementCustom(By.id(edtVariableValueId));
    }

    public WebElement getAcceptButton(){
        return actionKeyword.findElementCustom(By.id(btnAccept));
    }

    public ActionBlockDetailPage enterActionBlockName(String actionBlockName){
        actionKeyword.setText(getActionBlockNameEditText(), actionBlockName);
        return this;
    }

    public ActionBlockDetailPage enterActionBlockDescription(String actionBlockDescription){
        actionKeyword.setText(getActionBlockDescriptionEditText(), actionBlockDescription);
        return this;
    }

    public ActionBlockDetailPage clickOnAddInputVariableButton(){
        actionKeyword.click(getAddInputVariableButton());
        return this;
    }

    public ActionBlockDetailPage enterVariableName(String variableName){
        actionKeyword.setText(getVariableNameEditText(), variableName);
        return this;
    }

    public ActionBlockDetailPage clickOnOkButton(){
        actionKeyword.click(getOkButton());
        return this;
    }

    public ActionBlockDetailPage clickOnInputCollapseExpandButton(){
        actionKeyword.click(getInputCollapseExpandButton());
        return this;
    }

    public ActionBlockDetailPage clickOnNewAddedVariable(String variableName){
        actionKeyword.click(getElementByName(variableName));
        return this;
    }

    public ActionBlockDetailPage setTheVariableValue(String variableValue){
        if (variableValue.equals("True")) {
            actionKeyword.click(getTrueRadioButton());
        } else if (variableValue.equals("False")) {
            actionKeyword.click(getFalseRadioButton());
        } else {
            actionKeyword.setText(getVariableValueEditText(), variableValue);
        }
        return this;
    }

    public AddActionPage clickOnAddActionButton(){
        actionKeyword.click(getAddActionButton());
        return new AddActionPage(this.driver);
    }

    public ActionBlockDetailPage clickOnAddOutputVariableButton(){
        actionKeyword.click(getAddOutputVariableButton());
        return this;
    }

    public ActionBlockDetailPage selectVariableType(String variableType){
        actionKeyword.click(getVariableTypeSpinner());
        actionKeyword.click(getElementByName(variableType));
        return this;
    }

    public ActionBlockDetailPage clickOnOutputCollapseExpandButton(){
        actionKeyword.click(getOutputCollapseExpandButton());
        return this;
    }

    public ActionBlockDetailPage enterVariableValue(String variableValue){
        actionKeyword.setText(getVariableValueEditText(), variableValue);
        return this;
    }

    public ActionBlocksPage clickOnAcceptButton(){
        actionKeyword.click(getAcceptButton());
        return new ActionBlocksPage(this.driver);
    }

    public boolean variableIsCorrect(String variableName, String variableValue) {
        try {
            return getElementByName(variableName).isDisplayed() && getElementByName("Default: " + variableValue).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean actionIsCorrect() {
        try {
            return getElementByName("Clear Log").isDisplayed() && getElementByName("System Log").isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
