package com.qa.trello;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() throws InterruptedException {
        int before= getBoardsCount();
        createBoard();
        returnHome();
        int after= getBoardsCount();
      //  Assert.assertEquals(after, before+1);
    }

//@Test(enabled=false) - тест не запускается

}