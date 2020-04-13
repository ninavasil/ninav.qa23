package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTests {
    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        wd= new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd,20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testBoeardCreation(){
        clickLogin();
        fillLoginForm("lika-ki@mail.ru", "VsjoHorosho11");
        confirmLogin();
        CreateBoard();
        //chooseCreateBoard
        //inputNameOfBoard
        //clickButtonCreateBoard
        //returnHome
    }

    public void CreateBoard() {
        click(By.name("add"));
        click(By.xpath("//button[@data-test-id='header-create-board-button']//./p[@class='_2DBw9GxD3tha0R']"));
        type(By.cssSelector("input[placeholder='Add board title']"),"myFirstBoard");
        click(By.xpath("//*[@data-test-id='create-board-submit-button']"));
    }


    public void clickLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(String userEmail, String password) {
        type(By.name("user"), userEmail);
        click(By.cssSelector("#login.button-green"));
        type(By.cssSelector("input#password"), password);
    }

    public void confirmLogin() {
        click(By.id("login-submit"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
         wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
      // wd.findElement(locator).click();
    }

  //  @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
