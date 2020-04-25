package com.qa.trello;

import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() throws InterruptedException {
        int before= app.getBoardsCount();
        app.createBoard();
        app.returnHome();
        int after= app.getBoardsCount();
        System.out.println("was:"+before+ " now:"+after);
      //  Assert.assertEquals(after, before+1);
    }



}