package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestsTeamCreation {
    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        wd=new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait=new WebDriverWait(wd,20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void teamCreation() throws InterruptedException {
        clickLogin();
        fillLoginForm("lika-ki@mail.ru", "VsjoHorosho11");
        confirmLogin();
        Thread.sleep(5000);
        clickCreateTeam();
        fillingForm("My Testteam",By.cssSelector("[class='_38pq5NbRWAG39y']"));
        writeDescription("This is my first created Team");
        confirmCreation();
        inviteYourTeam();
        returnHome();
    }

    public void returnHome()  {
        click(By.cssSelector("[color='light']"));
    }

    public void inviteYourTeam() {
        type(By.cssSelector(".autocomplete-input"),"lika-ki+1@mail.ru\n");
        click(By.cssSelector(".autocomplete-btn"));
    }

    public void confirmCreation() {
        click(By.cssSelector("button[type='submit']"));
    }

    public void writeDescription(String text) {
        type(By.cssSelector("textarea._15aIJYNKhrO4vB"),text);
    }

    public void clickCreateTeam() throws InterruptedException {
        Thread.sleep(5000);
        click(By.cssSelector(".icon-add"));
    }

    public void fillingForm(String teamName, By locatorType) throws InterruptedException {
        Thread.sleep(5000);
        type(By.cssSelector("input[class='_1CLyNodCAa-vQi']"),teamName);
        click(By.cssSelector("div#teamTypeSelect"));
        Thread.sleep(5000);
        click(locatorType);
    }

    public void clickLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(String userEmail, String password) throws InterruptedException {
        Thread.sleep(5000);
        type(By.name("user"), userEmail);
        click(By.cssSelector("#login.button-green"));
        type(By.xpath("//input[@class='Input__InputElement-sc-1o6bj35-0 bfCuIo']"), password);
    }

    public void confirmLogin() {
        click(By.id("login-submit"));
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        //   wd.findElement(locator).click();
    }

    // @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}