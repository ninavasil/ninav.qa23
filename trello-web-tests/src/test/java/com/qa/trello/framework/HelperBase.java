package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver wd;
     //  WebDriverWait wait = new WebDriverWait(wd,20); 1 вариант
    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void returnHome()  {
        waitForElementLocatedAndClick(By.cssSelector("[color='light']"), 20);
        waitForElementLocatedAndClick(By.cssSelector("[color='light']"), 20);
    }

    public boolean isElementPresent(By locator){
       return wd.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        waitForElementClickableAndClick(locator,30);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void waitForElementLocatedAndClick(By locator, int timeOutInSeconds){
     //   wait=new WebDriverWait(wd, timeOutInSeconds); 2 вариант (при этом передать в метод click значение 20 сек как 2й параметр)
        new WebDriverWait(wd,timeOutInSeconds).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
     //   wd.findElement(locator).click();
    }

    public void waitForElementClickableAndClick(By locator, int timeOutInSeconds){
        new WebDriverWait(wd,timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void confirmCreation() throws InterruptedException {
     //   Thread.sleep(3000);
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id='header-create-team-submit-button']"), 20);
    }

    public void confirm() {
        waitForElementLocatedAndClick(By.xpath("//input[@class='js-confirm full negate']"), 20);
    }

    public  void goToBoardsPageURL(String username){
        wd.navigate().to("https://trello.com/"+username+"/boards");
    }


}
