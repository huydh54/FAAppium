package com.testng.asm.steps;

import com.testng.asm.pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FinalSteps extends BaseSteps {
    WelcomPage welcomPage;
    DashboardPage dashboardPage;
    MacroPage macroPage;
    AddTriggerPage addTriggerPage;
    AddActionPage addActionPage;
    AddConstraintPage addConstraintPage;
    ActionBlocksPage actionBlocksPage;
    ActionBlockDetailPage actionBlockDetailPage;

    @Given("I open application")
    public void iOpenApplication() throws MalformedURLException {
        String filePath = "src/app/final.apk";
        File file = new File(filePath);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3B");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "Android 9.0");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("appPackage", "com.arlosoft.macrodroid");
        capabilities.setCapability("appWaitActivity","com.arlosoft.macrodroid.intro.IntroActivity");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @When("I tap on click Macro on Dashboard Page")
    public void iTapOnClickMacroOnDashboardPage() throws InterruptedException {
        welcomPage = new WelcomPage(driver);
        dashboardPage = welcomPage.navigateToDashboardPage();
        Thread.sleep(2000);
        driver.navigate().back();
        macroPage = dashboardPage.navigateToMacroPage();
    }

    @And("I add a Trigger")
    public void iAddATrigger() {
        addTriggerPage = macroPage.navigateToAddTriggerPage();
        addTriggerPage
                .clickOnApplicationsView()
                .clickOnAppInstallRemoveUpdateButton()
                .selectApplicationRemovedRadioButton()
                .clickOkButton()
                .selectAnyApplicationRadioButton()
                .clickOkButton();
    }

    @Then("I will see the Trigger Macro show correct added values")
    public void iWillSeeTheTriggerMacroShowCorrectAddedValues() {
        Assert.assertTrue(macroPage.newApplicationRemovedTriggerIsDisplay());
    }

    @When("I navigate to Action Page from Macro Page")
    public void iNavigateToActionPageFromMacroPage() {
        addActionPage = macroPage.navigateToAddActionPage();
    }

    @And("I add an Action")
    public void iAddAnAction() {
        addActionPage
                .clickOnLoggingView()
                .clickClearLogButton()
                .selectSystemLogRadioButton()
                .clickOkButton();
    }

    @Then("I will see the Action Macro show correct added values")
    public void iWillSeeTheActionMacroShowCorrectAddedValues() {
        Assert.assertTrue(macroPage.newClearLogActionIsDisplay());
    }

    @When("I add an Constrain")
    public void iAddAnConstrain() {
        addConstraintPage = macroPage.navigateToAddConstraintPage();
        addConstraintPage
                .clickOnDeviceStateView()
                .clickOnAirplaneModeButton()
                .selectAirplaneModeDisabledRadioButton()
                .clickOkButton();
    }

    @Then("I will see the Contrains show correct added values")
    public void iWillSeeTheContrainsShowCorrectAddedValues() {
        Assert.assertTrue(macroPage.newAirplaneModeDisabledConstraintIsDisplay());
    }

    @When("I create new Local Variable with name {string}, and input value {string}")
    public void iCreateNewLocalVariableWithNameAndInputValue(String variableName, String variableValue) {
        macroPage
                .clickOnLocalVariablesButton()
                .clickOnAddLocalVariablesButton()
                .enterVariableName(variableName)
                .selectVariableType().clickOkButton()
                .clickOnNewLocalVariablesView(variableName)
                .enterVariableValue(variableValue)
                .clickOkButton();
    }

    @Then("I will see the Local Varialbe show correct added values {string}")
    public void iWillSeeTheLocalVarialbeShowCorrectAddedValues(String variableValue) {
        Assert.assertTrue(macroPage.newVariableValueIsDisplay(variableValue));
    }

    @After
    public void endTest() {
        driver.quit();
    }

    @When("I navigate to Action Block Detail Page and enter name {string} and description {string}")
    public void iNavigateToActionBlockDetailPageAndEnterInformations(String actionBlockName, String actionBlockDescription) throws InterruptedException {
        welcomPage = new WelcomPage(driver);
        dashboardPage = welcomPage.navigateToDashboardPage();
        Thread.sleep(2000);
        driver.navigate().back();
        actionBlocksPage = dashboardPage.navigateToActionBlocksPage();
        actionBlockDetailPage = actionBlocksPage
                .clickOnAddNewActionBlock()
                .enterActionBlockName(actionBlockName)
                .enterActionBlockDescription(actionBlockDescription);
    }

    @And("I add new input variable with name {string}, type {string} and value {string}")
    public void iAddNewInputVariableWithNameTypeAndValue(String inputVariableName, String inputVariableType, String inputVariableValue) {
        actionBlockDetailPage.clickOnAddInputVariableButton();
        actionBlockDetailPage.enterVariableName(inputVariableName);
        actionBlockDetailPage
                .selectVariableType(inputVariableType)
                .clickOnOkButton();
        actionBlockDetailPage
                .clickOnInputCollapseExpandButton()
                .clickOnNewAddedVariable(inputVariableName);
        actionBlockDetailPage.setTheVariableValue(inputVariableValue).clickOnOkButton();
    }

    @When("I tap on Action to add an action on Action Blocks Detail Page")
    public void iTapOnActionToAddAnActionOnActionBlocksDetailPage() {
        addActionPage = actionBlockDetailPage.clickOnAddActionButton();
    }

    @And("I add new output variable with name {string}, type {string} and value {string}")
    public void iAddNewOutputVariableWithNameTypeAndValue(String outputVariableName, String outputVariableType, String outputVariableValue) {
        actionBlockDetailPage
                .clickOnAddOutputVariableButton()
                .enterVariableName(outputVariableName);
        actionBlockDetailPage
                .selectVariableType(outputVariableType)
                .clickOnOkButton();
        actionBlockDetailPage
                .clickOnOutputCollapseExpandButton()
                .clickOnNewAddedVariable(outputVariableName);
        actionBlockDetailPage.setTheVariableValue(outputVariableValue).clickOnOkButton();
    }

    @Then("I will see the input variable {string}:{string}, action, output variable {string}:{string} should show correctly information")
    public void iWillSeeTheInputVariableActionOutputVariableShouldShowCorrectlyInformation(String inputVariableName, String inputVariableValue, String outputVariableName, String outputVariableValue) {
        Assert.assertTrue(actionBlockDetailPage.variableIsCorrect(inputVariableName, inputVariableValue));
        Assert.assertTrue(actionBlockDetailPage.actionIsCorrect());
        Assert.assertTrue(actionBlockDetailPage.variableIsCorrect(outputVariableName, outputVariableValue));
    }

    @When("I tap on V button to add the action block")
    public void iTapOnVButtonToAddTheActionBlock() {
        actionBlocksPage = actionBlockDetailPage.clickOnAcceptButton();
    }

    @Then("I will see action Block should be added and the block name {string} and description {string} should show correctly")
    public void iWillSeeActionBlockShouldBeAddedAndTheBlockNameAndDescriptionShouldShowCorrectly(String actionBlockName, String actionBlockDescription) {
        Assert.assertTrue(actionBlocksPage.actionBlockNameIsCorrect(actionBlockName));
        Assert.assertTrue(actionBlocksPage.actionBlockDescriptionIsCorrect(actionBlockDescription));
    }
}