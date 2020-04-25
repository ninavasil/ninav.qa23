package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        wd=new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait=new WebDriverWait(wd,20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        loginAtlasian("lika-ki@mail.ru", "VsjoHorosho11");
    }

   // @AfterMethod
    public void tearDown(){
        wd.quit();
    }

    public void returnHome()  {
        click(By.cssSelector("[color='light']"));
        click(By.cssSelector("[color='light']"));
    }

    public void inviteTeamLater(){
        if(isElementPresent(By.cssSelector("[data-test-id='show-later-button']")).size()!=0){
            click(By.cssSelector("[data-test-id='show-later-button']"));
        }
    }

    public boolean isElementPresent(By locator){
       return wd.findElements(locator).size()>0;
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
        click(By.xpath("//span[@class='icon-add icon-sm _2aV_KY1gTq1qWc']"));
    }

    public void fillingForm(String teamName, By locatorType) throws InterruptedException {
        Thread.sleep(5000);
        type(By.cssSelector("input[class='_1CLyNodCAa-vQi']"),teamName);
       // click(By.cssSelector(".icon-sm icon-down"));
     //  click(By.cssSelector("div[data-test-id='header-create-team-type-input']"));

       click(By.cssSelector("div#teamTypeSelect"));
       // click(By.xpath("//div[text()='Education' and @class='css-1yqjdp6']"));
        click(By.cssSelector("[data-test-id='header-create-team-type-input-education']"));
     //  click(By.xpath("//*[contains=(@data-test-id, 'header-create-team-type-input'))]/li[contains=(text(), 'Education'))]"));
        //*[contains(@class, 'point_info') and contains(string(), 'Краснодар')]
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

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
     //   wd.findElement(locator).click();
    }

    public void createBoard() throws InterruptedException {
        Thread.sleep(5000);
        click(By.name("add"));
        click(By.xpath("//button[@data-test-id='header-create-board-button']//./p[@class='_2DBw9GxD3tha0R']"));
        type(By.cssSelector("input[placeholder='Add board title']"), "myFirstBoard");
        click(By.cssSelector(".W6rMLOx8U0MrPx"));

        click(By.xpath("//li[1]/button/span[@class='_1uK2vQ_aMRS2NU']"));

        click(By.xpath("//*[@data-test-id='create-board-submit-button']"));
        Thread.sleep(5000);

    }
    public void loginAtlasian(String email, String password) throws InterruptedException {
        clickLogin();
        fillLoginForm(email, password);
        confirmLogin();
    }
    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class=\"icon-lg icon-member\"]/../../../../div")).size()-1;
    }
    protected boolean isOnBoardsPage() {
        String url=wd.getCurrentUrl();
        return url.contains("boards");
    }
}


