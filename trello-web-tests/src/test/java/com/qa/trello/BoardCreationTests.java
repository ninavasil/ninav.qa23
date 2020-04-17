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
    public void testBoardCreation() throws InterruptedException {
        clickLogin();
        fillLoginForm("lika-ki@mail.ru", "VsjoHorosho11");
        confirmLogin();
        CreateBoard();
        returnHome();
        returnHome();
        Thread.sleep(5000);
        clickCreateTeam();
        Thread.sleep(5000);
        fillingForm("My Testteam");
        Thread.sleep(5000);
        chooseType();
        writeDescription("This is my first created Team");
        finishCreation();
    }

 //   @Test
    public void teamCreation() throws InterruptedException {
//        BoardCreationTests bct= new BoardCreationTests();
//        bct.testBoardCreation();
        clickCreateTeam();
        fillingForm("My Testteam");
        chooseType();
        writeDescription("This is my first created Team");
        finishCreation();
    }

    private void finishCreation() {
        click(By.cssSelector("button[type='submit']"));
    }

    private void writeDescription(String text) {
        type(By.cssSelector("textarea._15aIJYNKhrO4vB"),text);
    }

    private void chooseType() throws InterruptedException {
       // click(By.cssSelector("div#teamTypeSelect"));
       // Thread.sleep(5000);
       // click(By.xpath("//input[@id='react-select-14-input']"));

        click(By.xpath("//div[@class='css-dmzcl _1T1MG_BX1zeaq8'])"));
        click(By.xpath("//div[@class='css-1wy0on6']"));
        click(By.xpath("//div[contains(text(),'Education')]"));
      //  click(By.cssSelector("div.css-1yqjdp6"));
    }

    private void clickCreateTeam() {
        click(By.cssSelector("span.icon-add"));
    }

    public void fillingForm(String teamName) throws InterruptedException {
            type(By.cssSelector("input._1CLyNodCAa-vQi"),teamName);

    }

    public void returnHome()  {
        click(By.cssSelector("[color='light']"));
    }

    public void CreateBoard() throws InterruptedException {
        Thread.sleep(5000);
        click(By.name("add"));
        click(By.xpath("//button[@data-test-id='header-create-board-button']//./p[@class='_2DBw9GxD3tha0R']"));
        type(By.cssSelector("input[placeholder='Add board title']"),"myFirstBoard");
        click(By.xpath("//*[@data-test-id='create-board-submit-button']"));
        Thread.sleep(5000);
    }


    public void clickLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(String userEmail, String password) throws InterruptedException {
        Thread.sleep(5000);
        type(By.name("user"), userEmail);
        click(By.cssSelector("#login.button-green"));
        type(By.xpath("//input[@class='Input__InputElement-sc-1o6bj35-0 bfCuIo']"), password);
        //By.xpath("//input[@id='password']"
        //By.cssSelector("input#current-password"

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
