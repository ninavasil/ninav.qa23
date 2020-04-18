package com.qa.trello;

import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() throws InterruptedException {
        CreateBoard();
        returnHome();
    }

//@Test(enabled=false) - тест не запускается

}