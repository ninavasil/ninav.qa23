package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if(app.isOnBoardsPage()){
        app.click(By.cssSelector("[href$='boards']"));
        }
        if(app.getBoardsCount()==0){
            app.createBoard();
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
       int before= app.getBoardsCount();
        openFirstPersonalBoard();
        clickMoreButton();
        initBoardDeletion();
        permanentlyDeleteBoard();
        app.returnHome();
        int after= app.getBoardsCount();
        System.out.println("was:"+before+ "now:"+after);
      // Assert.assertEquals(after,before-1);
    }


    public void permanentlyDeleteBoard() {
        app.click(By.cssSelector(".js-delete"));
        confirm();
    }

    public void initBoardDeletion() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void confirm() {
        app.click(By.xpath("//input[@class='js-confirm full negate']"));
    }

    public void clickCloseBoardFromMoreMenu() {
        app.click(By.cssSelector(".js-close-board"));
    }

    public void clickMoreButton() {
        app.click(By.cssSelector(".js-open-more"));
    }

    public void openFirstPersonalBoard() {
        app.click(By.xpath("//*[@class=\"icon-lg icon-member\"]/../../..//li"));

    }
}
