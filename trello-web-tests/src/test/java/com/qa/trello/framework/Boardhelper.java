package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Boardhelper extends HelperBase{

    public Boardhelper(WebDriver wd) {
        super(wd);
    }

    public void createBoard() throws InterruptedException {
        Thread.sleep(5000);
        waitForElementLocatedAndClick(By.name("add"), 20);
        waitForElementLocatedAndClick(By.xpath("//button[@data-test-id='header-create-board-button']//./p[@class='_2DBw9GxD3tha0R']"), 20);
        type(By.cssSelector("input[placeholder='Add board title']"), "myFirstBoard");
        waitForElementLocatedAndClick(By.cssSelector(".W6rMLOx8U0MrPx"), 20);

        waitForElementLocatedAndClick(By.xpath("//li[1]/button/span[@class='_1uK2vQ_aMRS2NU']"), 20);

        waitForElementLocatedAndClick(By.xpath("//*[@data-test-id='create-board-submit-button']"), 20);
        Thread.sleep(5000);

    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class=\"icon-lg icon-member\"]/../../../../div")).size()-1;
    }

    public boolean isOnBoardsPage() {
        String url=wd.getCurrentUrl();
        return url.contains("boards");
    }
    public void permanentlyDeleteBoard() {
       waitForElementLocatedAndClick(By.cssSelector(".js-delete"), 20);
       confirm();
    }

    public void initBoardDeletion() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }
    public void clickCloseBoardFromMoreMenu() {
        waitForElementLocatedAndClick(By.cssSelector(".js-close-board"), 20);
    }

    public void clickMoreButton() {
        waitForElementLocatedAndClick(By.cssSelector(".js-open-more"), 20);
    }

    public void openFirstPersonalBoard() {
        waitForElementLocatedAndClick(By.xpath("//*[@class=\"icon-lg icon-member\"]/../../..//li"), 20);
    }

}
