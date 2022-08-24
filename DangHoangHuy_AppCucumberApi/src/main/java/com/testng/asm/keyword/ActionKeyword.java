package com.testng.asm.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionKeyword {
    public WebDriver driver;
    public WebDriverWait wait;

    public ActionKeyword(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement findElementCustom(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findElementsCustom(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void click(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
        webElement.click();
    }

    public void setText(WebElement webElement, String text){
        try{
            webElement.clear();
            webElement.sendKeys(text);
        }
        catch (WebDriverException e){
            throw new WebDriverException("An error occurred while entering data!");
        }
    }

    public void select(WebElement element, SelectType type, String option) throws Exception {
        Select select = new Select(element);
        switch (type) {
            case SELECT_BY_INDEX:
                try {
                    select.selectByIndex(Integer.parseInt(option));
                } catch (Exception e) {
                    throw new Exception("SelectType.SELECT_BY_INDEX needs to enter the option as an integer!");
                }
                break;
            case SELECT_BY_TEXT:
                select.selectByVisibleText(option);
                break;
            case SELECT_BY_VALUE:
                select.selectByValue(option);
                break;
            default:
                throw new Exception("An error occurred during the selection process!");
        }
    }

    public enum SelectType {
        SELECT_BY_INDEX,
        SELECT_BY_TEXT,
        SELECT_BY_VALUE,
    }
}
