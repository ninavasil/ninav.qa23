package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sessionhelper extends HelperBase{
    public Sessionhelper(WebDriver wd) {
        super(wd);
    }

    public void clickLogin() {
        waitForElementLocatedAndClick(By.cssSelector("[href='/login']"), 20);
    }

    public void fillLoginForm(String userEmail, String password) throws InterruptedException {
        Thread.sleep(5000);
        type(By.name("user"), userEmail);
        waitForElementLocatedAndClick(By.cssSelector("#login.button-green"), 20);
        type(By.xpath("//input[@class='Input__InputElement-sc-1o6bj35-0 bfCuIo']"), password);
    }

    public void confirmLogin() {
        waitForElementLocatedAndClick(By.id("login-submit"), 20);
    }

    public void loginAtlasian(String email, String password) throws InterruptedException {
        clickLogin();
        fillLoginForm(email, password);
        confirmLogin();
    }
}
