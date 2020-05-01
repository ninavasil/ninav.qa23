package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Teamhelper extends HelperBase {
    public Teamhelper(WebDriver wd) {
        super(wd);
    }

    public void createTeamLater(){
      //  waitForElementClickableAndClick(By.cssSelector("[data-test-id='show-later-button']"),10);
        waitForElementLocatedAndClick(By.cssSelector(".eg0KI5SqghoOFd"),10);


    }

    public void inviteYourTeam() throws InterruptedException {
        type(By.cssSelector(".autocomplete-input"), "lika-ki+1@mail.ru\n");
        Thread.sleep(3000);
        waitForElementLocatedAndClick(By.cssSelector(".autocomplete-btn"), 20);
    }

    public void writeDescription(String text) throws InterruptedException {
        Thread.sleep(3000);
        waitForElementClickableAndClick(By.cssSelector("[id='1588156505311-create-team-org-description']"),20);
      //  waitForElementClickableAndClick(By.cssSelector("[data-test-id='header-create-team-name-input']"),20);
        type(By.cssSelector("[id='1588156505311-create-team-org-description']"), text);
    }

    public void clickCreateTeam() throws InterruptedException {
        Thread.sleep(5000);
        waitForElementLocatedAndClick(By.cssSelector("[name='add']"), 20);
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id='header-create-team-button']"),10);
    }

    public void fillingForm(String teamName, By locatorType) throws InterruptedException {
        Thread.sleep(5000);
        type(By.cssSelector("input[class='_1CLyNodCAa-vQi']"), teamName);
        waitForElementLocatedAndClick(By.cssSelector("div#teamTypeSelect"), 20);
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id='header-create-team-type-input-education']"), 20);
        Thread.sleep(5000);
        waitForElementLocatedAndClick(By.cssSelector("[type=submit]"), 20);
    }
}
