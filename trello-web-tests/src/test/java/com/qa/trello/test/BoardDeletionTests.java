package com.qa.trello.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if(!app.getBoard().isOnBoardsPage()){
        app.getBoard().waitForElementLocatedAndClick(By.cssSelector("[href$='boards']"), 20);
        }
        if(app.getBoard().getBoardsCount()==0){
            app.getBoard().createBoard();
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
       int before= app.getBoard().getBoardsCount();
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletion();
        app.getBoard().permanentlyDeleteBoard();
        app.getBoard().returnHome();
        int after= app.getBoard().getBoardsCount();
        System.out.println("was:"+before+ "now:"+after);
      // Assert.assertEquals(after,before-1);
    }

}
