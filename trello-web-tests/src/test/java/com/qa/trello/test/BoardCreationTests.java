package com.qa.trello.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if (!app.getBoard().isOnBoardsPage()) {
           app.getBoard().waitForElementLocatedAndClick(By.cssSelector("[href$='boards']"), 20);
        }
    }

    @Test
    public void testBoardCreation() throws InterruptedException {
        int before= app.getBoard().getBoardsCount();
        app.getBoard().createBoard();
      //  app.getBoard().goToBoardsPageURL("likaki");
        app.getBoard().returnHome();
        int after= app.getBoard().getBoardsCount();
        System.out.println("was:"+before+ " now:"+after);
        //Assert.assertEquals(after, before+1);
    }



}